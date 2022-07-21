package com.swp.swp.controller;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.swp.swp.model.*;
import com.swp.swp.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import com.swp.swp.repositories.PositionRepositories;

import java.sql.Date;
import java.util.Calendar;

@Controller
@RequestMapping(path = "/company")
public class CompanyController {
    @Autowired
    private PositionService positionService;
    @Autowired
    private CompanyService companyService;
    @Autowired private JobService jobService;
    @Autowired private StudentApplyJobsService studentApplyJobsService;
    @Autowired AccountService accountService;

    @Autowired private OjtProcessService ojtProcessService;
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String managePage(ModelMap modelMap, HttpServletRequest request){
        if(accountService.checkRole("COMPANY", request)==false)
            return "test";
        return "company";
    }

    @RequestMapping(value = "/candidates", method = RequestMethod.GET)
    public String candidates(ModelMap modelMap, HttpServletRequest request){
        if(accountService.checkRole("COMPANY", request)==false)
            return "test";
        Company company = companyService.findByAccount(accountService.currentAccount(request));
        Iterable<StudentApplyJob> candidateList = studentApplyJobsService.findApplyByCompany(company);
        modelMap.addAttribute("candidateList", candidateList);
        return "companyCandidates";
    }

    @RequestMapping(value = "/verifyApplication/{id}/{status}", method = RequestMethod.GET)
    public String verifyApplication(@PathVariable("id") int id, @PathVariable("status") String status,
                                    HttpServletRequest request){
        if(accountService.checkRole("COMPANY", request)==false)
            return "test";
        HttpSession session = request.getSession();
        StudentApplyJob x = studentApplyJobsService.findById(id);
        Company company = companyService.findByAccount(accountService.currentAccount(request));
        if (x.getJob().getCompany().equals(company) == false) {
            session.setAttribute("dangerMessage", "You have no permission!");
        } else {
            if (x.getStatus().equalsIgnoreCase("Processing") || x.getStatus().equalsIgnoreCase("Interviewing")) {
                if (status.equalsIgnoreCase("nextStep")) {
                    if (x.getStatus().equalsIgnoreCase("Processing")) {
                        x.setStatus("Interviewing");
                    } else if (x.getStatus().equalsIgnoreCase("Interviewing")) {
                        x.setStatus("Passed Interview");
                    }
                } else {
                    x.setStatus(status);
                }
                studentApplyJobsService.save(x);
                session.setAttribute("successMessage", "Successfully!");
            } else {
                session.setAttribute("dangerMessage", "Failed!");
            }
        }
        return "redirect:/company/candidates";
    }

    @RequestMapping(value = "/internships", method = RequestMethod.GET)
    public String internsList(ModelMap modelMap, HttpServletRequest request){
        if(accountService.checkRole("COMPANY", request)==false)
            return "test";
        Iterable <OjtProcess> processList = ojtProcessService.findByCompany(companyService.findByAccount(accountService.currentAccount(request)));
        modelMap.addAttribute("processList", processList);
        return "companyInternships";
    }

    @RequestMapping(value = "/evaluate/{id}", method = RequestMethod.GET)
    public String evaluate(ModelMap modelMap, HttpServletRequest request, @PathVariable("id") int id){
        if(accountService.checkRole("COMPANY", request)==false)
            return "test";
        OjtProcess process = ojtProcessService.findById(id);
        modelMap.addAttribute("process", process);
        return "companyEvaluate";
    }

    @RequestMapping(value = "/updateEvaluate/{id}", method = RequestMethod.GET)
    public String updateEvaluate(ModelMap modelMap, HttpServletRequest request, @PathVariable("id") int id,
                                 @RequestParam("jobDescription") String jobDescription, @RequestParam("knowledge") String knowledge,
                                 @RequestParam("softSkill") String softSkill, @RequestParam("attitude") String attitude,
                                 @RequestParam("point1") int point1, @RequestParam("point2") int point2, @RequestParam("point3") int point3) {
        if(accountService.checkRole("COMPANY", request)==false)
            return "test";
        HttpSession session = request.getSession();
        OjtProcess process = ojtProcessService.findById(id);
        Company company = companyService.findByAccount(accountService.currentAccount(request));
        if (process.getApplication().getJob().getCompany().equals(company) == false) {
            session.setAttribute("dangerMessage", "You have no permission!");
        } else {
            if (process.getStatus().equalsIgnoreCase("Passed") == false
                    && process.getStatus().equalsIgnoreCase("Not Passed") == false) {
                process.setAttitude(attitude);
                process.setKnowledge(knowledge);
                process.setSoftSkill(softSkill);
                process.setDescription(jobDescription);
                process.setGrade(1.0 * (point1 + point2 + point3) / 3.0);
                process.setAttitudePoint(point3);
                process.setSoftSkillPoint(point2);
                process.setKnowledgePoint(point1);
                java.util.Date date = new java.util.Date();
                java.sql.Date currentDate = new Date(date.getTime());
                if (process.getEndDate() != null && process.getEndDate().compareTo(currentDate) <= 0) {
                    process.setStatus("Completed");
                }
                ojtProcessService.save(process);
                session.setAttribute("successMessage", "Successfully!");
            } else {
                session.setAttribute("dangerMessage", "Failed!");
            }
        }
        modelMap.addAttribute("process", process);
        return "redirect:/company/internships";
    }

    @RequestMapping(value = "/requirements", method = RequestMethod.GET)
    public String internshipRequirement(ModelMap modelMap, HttpServletRequest request){
        if(accountService.checkRole("COMPANY", request)==false)
            return "test";
        Iterable<Job> jobList = jobService.findAllActiveByCompany(companyService.findByAccount(accountService.currentAccount(request)));
        modelMap.addAttribute("jobList", jobList);
        Iterable<Position> positionList = positionService.findAll();
        modelMap.addAttribute("positionList", positionList);
        return "companyRequirements";
    }

    @RequestMapping(value = "/uploadRequirement", method = RequestMethod.POST)
    public String uploadRequirement(ModelMap modelMap, HttpServletRequest request, @RequestParam("position") int positionId,
                                    @RequestParam("description") String description, @RequestParam("requirement") String requirement,
                                    @RequestParam("benefit") String benefit, @RequestParam("startDate") Date startDate, @RequestParam("endDate") Date endDate,
                                    @RequestParam("slot") int slot){
        if(accountService.checkRole("COMPANY", request)==false)
            return "test";
        HttpSession session = request.getSession();
        if (endDate.compareTo(startDate) < 0) {
            session.setAttribute("dangerMessage", "Start date must before end date");
        } else if (startDate.compareTo(new java.sql.Date(Calendar.getInstance().getTimeInMillis())) < 0) {
            session.setAttribute("dangerMessage", "Start date can not before current date");
        } else {
            Position position = positionService.findById(positionId);
            Job newJob = new Job();
            newJob.setPosition(position);
            newJob.setCompany(companyService.findByAccount(accountService.currentAccount(request)));
            newJob.setStatus("Waiting");
            newJob.setRequirement(requirement);
            newJob.setBenefit(benefit);
            newJob.setDescription(description);
            newJob.setStartDate(startDate);
            newJob.setEndDate(endDate);
            newJob.setSlot(slot);
            jobService.save(newJob);
            session.setAttribute("successMessage", "Successfully!");
        } /*else {
            session.setAttribute("dangerMessage", "Failed!");
        }*/
        return "redirect:/company/requirements";
    }

    @RequestMapping(value = "/updateRequirement/{id}", method = RequestMethod.POST)
    public String updateRequirement(ModelMap modelMap, HttpServletRequest request, @RequestParam("position") int positionId,
                                    @RequestParam("description") String description, @RequestParam("requirement") String requirement,
                                    @RequestParam("benefit") String benefit, @RequestParam("startDate") Date startDate, @RequestParam("endDate") Date endDate,
                                    @RequestParam("slot") int slot, @PathVariable("id") int id){
        if(accountService.checkRole("COMPANY", request)==false)
            return "test";
        HttpSession session = request.getSession();
        if (endDate.compareTo(startDate) > 0) {
            Position position = positionService.findById(positionId);
            Job newJob = jobService.findById(id);
            newJob.setPosition(position);
            //newJob.setCompany(companyService.findByAccount(accountService.currentAccount(request)));
            //newJob.setStatus("Waiting");
            newJob.setRequirement(requirement);
            newJob.setBenefit(benefit);
            newJob.setDescription(description);
            newJob.setStartDate(startDate);
            newJob.setEndDate(endDate);
            newJob.setSlot(slot);
            jobService.save(newJob);
            session.setAttribute("successMessage", "Successfully!");
        } else {
            session.setAttribute("dangerMessage", "Failed!");
        }
        return "redirect:/company/requirements";
    }

    @PostMapping(value = "removeRequirement/{id}")
    public String removeRequirement(HttpServletRequest request, @PathVariable("id") int id) {
        if(accountService.checkRole("COMPANY", request)==false)
            return "test";
        HttpSession session = request.getSession();
        Job job = jobService.findById(id);
        Company company = companyService.findByAccount(accountService.currentAccount(request));
        if (job.getCompany().equals(company) == false) {
            session.setAttribute("dangerMessage", "You have no permission!");
        } else {
            job.setStatus("Inactive");
            jobService.save(job);
            session.setAttribute("successMessage", "Successfully!");
        }
        return "redirect:/company/requirements";
    }

    @RequestMapping(value = "/updateProcess/{id}", method = RequestMethod.POST)
    public String updateProcess(ModelMap modelMap, HttpServletRequest request,
                                @RequestParam("startDate") Date startDate,
                                @RequestParam("endDate") Date endDate,
                                @PathVariable("id") int id){
        if(accountService.checkRole("COMPANY", request)==false)
            return "test";
        HttpSession session = request.getSession();

        if (endDate.compareTo(startDate) < 0) {
            session.setAttribute("dangerMessage", "Start date can not be after End date");
        } else if (((endDate.getTime() - startDate.getTime()) / (1000 * 60 * 60 * 24) ) % 365 < 84) {
            session.setAttribute("dangerMessage", "The process time was not enough 12 weeks.");
        }
        else {
            OjtProcess process = ojtProcessService.findById(id);
            if (process.getStatus().equalsIgnoreCase("Passed") == false &&
                    process.getStatus().equalsIgnoreCase("Not Passed") == false) {
                process.setStartDate(startDate);
                process.setEndDate(endDate);
                java.util.Date date = new java.util.Date();
                java.sql.Date currentDate = new Date(date.getTime());
                if (process.getEndDate().compareTo(currentDate) <= 0) {
                    process.setStatus("Completed");
                }
                ojtProcessService.save(process);
            }
            session.setAttribute("successMessage", "Successfully!");
        }
        return "redirect:/company/internships";
    }
}

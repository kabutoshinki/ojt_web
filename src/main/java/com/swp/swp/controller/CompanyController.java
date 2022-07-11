package com.swp.swp.controller;



import javax.servlet.http.HttpServletRequest;

import com.swp.swp.model.*;
import com.swp.swp.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import com.swp.swp.repositories.PositionRepositories;

import java.sql.Date;

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
    @RequestMapping(value = "/insertPage", method = RequestMethod.GET)
    public String insertPage(ModelMap modelMap, HttpServletRequest request){
        if(accountService.checkRole("COMPANY", request)==false)
            return "test";
        Iterable<Position> positions = positionService.findAll();
        for (Position position : positions) {
            System.out.println("position: " + position.getPosition());
        }
        modelMap.addAttribute("positionList", positions);
        return "insertJob";
    }

    

    @PostMapping(value = "/insertJob")
    
    public String insertJob(ModelMap modelMap, HttpServletRequest request,
    @ModelAttribute("Job") Job job){
            //Insert code get account id here
            if(accountService.checkRole("COMPANY", request)==false)
                return "test";
            boolean insert =  jobService.insertJob(job, 1, job.getPositionId());
            if(insert==true)
                return "redirect:/view/display";
            else{
                modelMap.addAttribute("mess", "Insert fail");
                return "redirect:/company/insertPage";
            }
        
    }
    @RequestMapping(value = "/candidates", method = RequestMethod.GET)
    public String candidates(ModelMap modelMap, HttpServletRequest request){
        if(accountService.checkRole("COMPANY", request)==false)
            return "test";
        Company company = companyService.findByAccount(accountService.currentAccount(request));
        Iterable<StudentApplyJob> candidateList = studentApplyJobsService.findApplyByCompany(company);
        modelMap.addAttribute("candidateList", candidateList);
        return "candidates";
    }

    @RequestMapping(value = "/verifyApplication/{id}/{status}", method = RequestMethod.GET)
    public String verifyApplication(@PathVariable("id") int id, @PathVariable("status") String status,
                                    HttpServletRequest request){
        if(accountService.checkRole("COMPANY", request)==false)
            return "test";
        StudentApplyJob x = studentApplyJobsService.findById(id);
        if (status.equalsIgnoreCase("nextStep")) {
            if (x.getStatus().equalsIgnoreCase("Processing")) {
                x.setStatus("Interviewing");
            } else if (x.getStatus().equalsIgnoreCase("Interviewing")) {
                x.setStatus("Passed");
            }
        } else {
            x.setStatus(status);
        }
        studentApplyJobsService.save(x);
        return "redirect:/company/candidates";
    }
    
    @RequestMapping(value = "/verify/{id}/{status}", method = RequestMethod.GET)
    public String verify(@PathVariable("id") int id, @PathVariable("status") int status,
        HttpServletRequest request){
        if(accountService.checkRole("COMPANY", request)==false)
            return "test";
        if(status==1){
            studentApplyJobsService.updateStatus(id, "accepted");
        }
        else{
            studentApplyJobsService.updateStatus(id, "denied");
        }
        return "redirect:/company/candidatesList";

    }

    @RequestMapping(value = "/internships", method = RequestMethod.GET)
    public String internsList(ModelMap modelMap, HttpServletRequest request){
        if(accountService.checkRole("COMPANY", request)==false)
            return "test";
        Iterable <OjtProcess> processList = ojtProcessService.findByCompany(companyService.findByAccount(accountService.currentAccount(request)));
        modelMap.addAttribute("processList", processList);
        return "companyInternships";
    }

    @RequestMapping(value = "/evaluate", method = RequestMethod.GET)
    public String internEvaluate(ModelMap modelMap, HttpServletRequest request){
        if(accountService.checkRole("COMPANY", request)==false)
            return "test";
        //Iterable<StudentApplyJob> candidates = studentApplyJobsService.getApplyByCompanyId(1);
        // modelMap.addAttribute("candidates", candidates);
        return "evaluate_By_Company";
    }

    @RequestMapping(value = "/requirements", method = RequestMethod.GET)
    public String internshipRequirement(ModelMap modelMap, HttpServletRequest request){
        if(accountService.checkRole("COMPANY", request)==false)
            return "test";
        Iterable<Job> jobList = jobService.findByCompany(companyService.findByAccount(accountService.currentAccount(request)));
        modelMap.addAttribute("jobList", jobList);
        Iterable<Position> positionList = positionService.findAll();
        modelMap.addAttribute("positionList", positionList);
        return "companyRequirements";
    }

    @RequestMapping(value = "/uploadRequirement", method = RequestMethod.POST)
    public String uploadRequirement(ModelMap modelMap, HttpServletRequest request, @RequestParam("position") int positionId,
                                    @RequestParam("description") String description, @RequestParam("requirement") String requirement,
                                    @RequestParam("startDate") Date startDate, @RequestParam("endDate") Date endDate,
                                    @RequestParam("slot") int slot){
        if(accountService.checkRole("COMPANY", request)==false)
            return "test";
        Position position = positionService.findById(positionId);
        Job newJob = new Job();
        newJob.setPosition(position);
        newJob.setCompany(companyService.findByAccount(accountService.currentAccount(request)));
        newJob.setStatus("Waiting");
        newJob.setRequirement(requirement);
        newJob.setDescription(description);
        newJob.setStartDate(startDate);
        newJob.setEndDate(endDate);
        newJob.setSlot(slot);
        jobService.save(newJob);
        return "redirect:/company/requirements";
    }
}

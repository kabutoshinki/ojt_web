package com.swp.swp.controller;



import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.swp.swp.model.Job;
import com.swp.swp.model.Position;
import com.swp.swp.model.StudentApplyJobs;
import com.swp.swp.repositories.PositionRepositories;
import com.swp.swp.service.AccountService;
import com.swp.swp.service.JobService;
import com.swp.swp.service.StudentApplyJobsService;

@Controller
@RequestMapping(path = "/companyController")
public class CompanyController {
    @Autowired PositionRepositories positionRepositories;
    @Autowired private JobService jobService;
    @Autowired private StudentApplyJobsService studentApplyJobsService;
    @Autowired AccountService accountService;
    
    @RequestMapping(value = "/managePage", method = RequestMethod.GET)
    public String managePage(ModelMap modelMap, HttpServletRequest request){
        if(accountService.checkRole("COMPANY", request)==false)
            return "test";
        return "companyPage";
    }
    @RequestMapping(value = "/insertPage", method = RequestMethod.GET)
    public String insertPage(ModelMap modelMap, HttpServletRequest request){
        if(accountService.checkRole("COMPANY", request)==false)
            return "test";
        Iterable<Position> positions = positionRepositories.findAll();
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
                return "redirect:/companyController/insertPage";
            }
        
    }
    @RequestMapping(value = "/candidatesList", method = RequestMethod.GET)
    public String candidatesList(ModelMap modelMap, HttpServletRequest request){
        if(accountService.checkRole("COMPANY", request)==false)
            return "test";
        Iterable<StudentApplyJobs> candidates = studentApplyJobsService.getApplyByCompanyId(1);
        modelMap.addAttribute("candidates", candidates);
        return "candidateList";
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
        return "redirect:/companyController/candidatesList";

    }
}

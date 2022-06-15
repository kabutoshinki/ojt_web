package com.swp.swp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.swp.swp.model.Job;
import com.swp.swp.model.StudentApplyJobs;
import com.swp.swp.repositories.PositionRepositories;
import com.swp.swp.service.JobService;
import com.swp.swp.service.StudentApplyJobsService;

@Controller
@RequestMapping(path = "/employeeController")
public class employeeController {

    @Autowired PositionRepositories positionRepositories;
    private JobService jobService;
    private StudentApplyJobsService studentApplyJobsService;
    
    @RequestMapping(value = "/verifyPage", method = RequestMethod.GET)
    public String verifyCompanyPage(ModelMap modelMap){
        Iterable<Job> jobs =jobService.getAll();
        modelMap.addAttribute("jobList", jobs);
        return "verifyJob";
    }

    @RequestMapping(value = "/updateStatus/{idJob}/{status}", method = RequestMethod.GET)
    public String verifyPage(ModelMap modelMap, @PathVariable("idJob") int id, @PathVariable("status") int status){
       if(status==1){
           jobService.updateStatus(id, "waiting");
       }
       else if(status==2)
            jobService.updateStatus(id, "Cancel");
        return "redirect:/jobController/verifyPage";
    }
    @RequestMapping(value = "/candidatesList", method = RequestMethod.GET)
    public String candidatesList(ModelMap modelMap){
        Iterable<StudentApplyJobs> candidates = studentApplyJobsService.getApplyByCompanyId(1);
        modelMap.addAttribute("candidates", candidates);
        return "candidateList";
    }
    @RequestMapping(value = "/verify/{id}/{status}", method = RequestMethod.GET)
    public String verify(@PathVariable("id") int id, @PathVariable("status") int status){
        if(status==1){
            studentApplyJobsService.updateStatus(id, "waiting");
            return "redirect:/companyManage/candidatesList";
        }
        else{
            studentApplyJobsService.updateStatus(id, "not-accept");
            return "redirect:/companyManage/candidatesList";
        }
        
    }


}

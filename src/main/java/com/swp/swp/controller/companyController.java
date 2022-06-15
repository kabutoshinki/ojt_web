package com.swp.swp.controller;



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
import com.swp.swp.service.JobService;
import com.swp.swp.service.StudentApplyJobsService;

@Controller
@RequestMapping(path = "/companyController")
public class companyController {
    @Autowired PositionRepositories positionRepositories;
    private JobService jobService;
    private StudentApplyJobsService studentApplyJobsService;
    
    public companyController(JobService jobService, StudentApplyJobsService studentApplyJobsService) {
        this.jobService = jobService;
        this.studentApplyJobsService = studentApplyJobsService;
    }
    @RequestMapping(value = "/managePage", method = RequestMethod.GET)
    public String managePage(ModelMap modelMap){
        return "companyPage";
    }
    @RequestMapping(value = "/insertPage", method = RequestMethod.GET)
    public String insertPage(ModelMap modelMap){
        Iterable<Position> positions = positionRepositories.findAll();
        for (Position position : positions) {
            System.out.println("position: " + position.getPositon());
        }
        modelMap.addAttribute("positionList", positions);
        return "insertJob";
    }

    

    @PostMapping(value = "/insertJob")
    public String insertJob(ModelMap modelMap,
    @ModelAttribute("Job") Job job){
            //Insert code get account id here
            
            boolean insert =  jobService.insertJob(job, 1, job.getPositionId());
            if(insert==true)
                return "redirect:/view/display";
            else{
                modelMap.addAttribute("mess", "Insert fail");
                return "redirect:/companyController/insertPage";
            }
        
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
            studentApplyJobsService.updateStatus(id, "accepted");
            return "redirect:/companyController/candidatesList";
        }
        else{
            studentApplyJobsService.updateStatus(id, "denied");
            return "redirect:/companyController/candidatesList";
        }
        
    }
}

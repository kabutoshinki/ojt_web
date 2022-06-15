package com.swp.swp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.swp.swp.model.Job;
import com.swp.swp.repositories.JobRepositories;
import com.swp.swp.service.JobService;

@Controller
@RequestMapping(path = "/view")
public class viewController {
    private JobService jobService;

    
    public viewController(JobService jobService) {
        this.jobService = jobService;
    }

    @RequestMapping(value = "/display", method = RequestMethod.GET)
    public String displayJobDetail(ModelMap modelMap){
        Iterable<Job> jobList = jobService.getAll();

        //Pagination 
        // Pageable page = PageRequest.of(1, 4);
        // Page<Job> job = repositories.findAll(page);
        // Iterable<Job> list = job.getContent();
        modelMap.addAttribute("jobList",jobList);
        return "companyList";
    }

    @RequestMapping(value = "/jobDetail/{id}", method = RequestMethod.GET)
    public String jobDetail(ModelMap modelMap, @PathVariable("id") int id ){
        Job jobdetail = jobService.getById(id);
        String[] jobDes= jobService.getJobDescription(id);
        String[] companyDes=jobService.getCompanyDescription(id);
        String[] jobRe=jobService.getJobRequiment(id);
        modelMap.addAttribute("jobDes", jobDes);
        modelMap.addAttribute("companyDes", companyDes);
        modelMap.addAttribute("jobRe", jobRe);
        modelMap.addAttribute("jobDetail", jobdetail);
        return "jobDetail";
    }
}

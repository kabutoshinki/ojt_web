package com.swp.swp.controller;

import java.util.ArrayList;
import java.util.Optional;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.swp.swp.model.CompanyDetail;
import com.swp.swp.model.Job;
import com.swp.swp.model.Major;
import com.swp.swp.model.Position;
import com.swp.swp.model.ResponseObject;
import com.swp.swp.repositories.CompanyDetailRepositories;
import com.swp.swp.repositories.JobRepositories;
import com.swp.swp.repositories.MajorRepositories;
import com.swp.swp.repositories.PositionRepositories;
import com.swp.swp.service.JobService;

import org.apache.taglibs.standard.lang.jstl.test.beans.PublicInterface2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import antlr.collections.List;

@Controller
@RequestMapping(path = "/jobController")
public class jobController {
    // @Autowired JobRepositories repositories;
    // @Autowired CompanyDetailRepositories companyDetailRepositories;
    // @Autowired MajorRepositories majorRepositories;
    @Autowired PositionRepositories positionRepositories;
    private JobService jobService;
    


    public jobController(CompanyDetailRepositories companyDetailRepositories, MajorRepositories majorRepositories,
            PositionRepositories positionRepositories, JobService jobService) {
        // this.companyDetailRepositories = companyDetailRepositories;
        // this.majorRepositories = majorRepositories;
        // this.positionRepositories = positionRepositories;
        this.jobService = jobService;
    }

    @RequestMapping(value = "/display", method = RequestMethod.GET)
    public String displayJobDetail(ModelMap modelMap){
        Iterable<Job> jobList = jobService.getAllJobs();

        //Pagination 
        // Pageable page = PageRequest.of(1, 4);
        // Page<Job> job = repositories.findAll(page);
        // Iterable<Job> list = job.getContent();
        modelMap.addAttribute("jobList",jobList);
        return "companyList";
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
        
            boolean insert =  jobService.insertJob(job, 1, job.getPositionId());
            if(insert==true)
                return "redirect:/jobController/display";
            else{
                modelMap.addAttribute("mess", "Insert fail");
                return "redirect:/jobController/insertJob";
            }
        
    }
    @RequestMapping(value = "/jobDetail/{id}", method = RequestMethod.GET)
    public String jobDetail(ModelMap modelMap, @PathVariable("id") int id ){
        Job jobdetail = jobService.getJob(id);
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

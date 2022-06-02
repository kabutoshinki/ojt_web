package com.swp.swp.controller;

import java.util.ArrayList;
import java.util.Optional;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.swp.swp.model.CompanyDetail;
import com.swp.swp.model.Job;
import com.swp.swp.model.ResponseObject;
import com.swp.swp.repositories.CompanyDetailRepositories;
import com.swp.swp.repositories.JobRepositories;

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

import antlr.collections.List;

@Controller
@RequestMapping(path = "/jobController")
public class jobController {
    @Autowired JobRepositories repositories;
    @Autowired CompanyDetailRepositories companyDetailRepositories;

    @RequestMapping(value = "/display", method = RequestMethod.GET)
    public String displayJobDetail(ModelMap modelMap){
        Iterable<Job> jobList = repositories.findAll();
        //Pagination 
        // Pageable page = PageRequest.of(1, 4);
        // Page<Job> job = repositories.findAll(page);
        // Iterable<Job> list = job.getContent();
        modelMap.addAttribute("jobList",jobList);
        return "companyList";
    }
    // @RequestMapping(value = "/insertPage", method = RequestMethod.GET)
    // public String insertPage(ModelMap modelMap){
    //     Iterable<Major> majorList = majorReposiyories.findAll();
    //     modelMap.addAttribute("majorList", majorList);
    //     ArrayList<String> majorName = new ArrayList<>();
    //     for (Major major : majorList) {
    //         majorName.add(major.getMajor());
    //         System.out.println("Major: " + major.getId());
    //     }
    //     for (String string : majorName) {
    //         System.out.println("majorName: "+ string);
    //     }
    //     // modelMap.addAttribute("majorList", majorName);
    //     return "insertJob";
    // }
    @PostMapping(value = "/insertJob")
    public String insertJob(ModelMap modelMap,
    @ModelAttribute("job") Job job, @ModelAttribute("major") int major){
        try {
            System.out.println("insert");
            CompanyDetail companyDetail = companyDetailRepositories.findById(1);
            System.out.println("MajorId: "+ major);
            repositories.save(job);
            modelMap.addAttribute("mess", "insert job successful");
            return "companyList";
        } catch (Exception e) {
            
            return "insertJob";
    }
    }
    @RequestMapping(value = "/jobDetail/{id}", method = RequestMethod.GET)
    public String jobDetail(ModelMap modelMap, @PathVariable("id") int id ){
        Job jobdetail = repositories.findById(id);
        String[] jobDes={} ;
        String[] companyDes={};
        String[] jobRe={};
        if(jobdetail.getDescription()!=null
        &&jobdetail.getRequirement()!=null){
            jobDes = jobdetail.getDescription().split("\n");
            jobRe = jobdetail.getRequirement().split("\n");
        }
        companyDes= jobdetail.getCompanyDetail().getCompanyDescription().split("\n");
        modelMap.addAttribute("jobDes", jobDes);
        modelMap.addAttribute("companyDes", companyDes);
        modelMap.addAttribute("jobRe", jobRe);
        modelMap.addAttribute("jobDetail", jobdetail);
        return "jobDetail";
    }


}

package com.swp.swp.controller;

import com.swp.swp.model.Job;
import com.swp.swp.repositories.JobRepositories;

import org.apache.taglibs.standard.lang.jstl.test.beans.PublicInterface2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(path = "/jobController")
public class jobController {
    @Autowired JobRepositories repositories;

    @RequestMapping(value = "/display", method = RequestMethod.GET)
    public String displayJobDetail(ModelMap modelMap){
        Iterable<Job> jobList = repositories.findAll();
        modelMap.addAttribute("jobList",jobList);
        return "companyList";
    }
    // @RequestMapping(value = "/insertJobs", method = RequestMethod.POST)
    // public String insertJobDetail(ModelMap modelMap){

    // }

}

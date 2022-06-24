package com.swp.swp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.swp.swp.model.Job;
import com.swp.swp.service.JobService;

@Controller
@RequestMapping(path = "/view")
public class ViewController {
    @Autowired
    private JobService jobService;

    @RequestMapping(value = "/recruitment/{id}", method = RequestMethod.GET)
    public String jobDetail(ModelMap modelMap, @PathVariable("id") int id ){
        Job jobDetail = jobService.getById(id);
        String[] jobDes = jobService.getJobDescription(id);
        String[] companyDes = jobService.getCompanyDescription(id);
        String[] jobRe = jobService.getJobRequirement(id);
        modelMap.addAttribute("jobDes", jobDes);
        modelMap.addAttribute("companyDes", companyDes);
        modelMap.addAttribute("jobRe", jobRe);
        modelMap.addAttribute("jobDetail", jobDetail);
        return "recruitment";
    }

    @RequestMapping(value = "/view1")
    public String view1(){
        return "studentinfo";
    }
    @RequestMapping(value = "/view2")
    public String view2(){
        return "listofstudent";
    }
    @RequestMapping(value = "/view3")
    public String view3(){
        return "applylist";
    }
}

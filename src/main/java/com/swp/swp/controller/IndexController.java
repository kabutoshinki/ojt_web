package com.swp.swp.controller;

import com.swp.swp.model.Job;
import com.swp.swp.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
class IndexController {
    @Autowired
    private JobService jobService;

    @RequestMapping("/")
    public String index() {
        return "forward:/home";
    }

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String home(ModelMap modelMap, HttpServletRequest request){
        HttpSession session = request.getSession();
        Iterable<Job> jobList = jobService.getAll();
        modelMap.addAttribute("jobList",jobList);
        String messTrue = (String)session.getAttribute("true");
        if(messTrue!=null){
            session.removeAttribute("true");

            request.setAttribute("mess", "Login Successfully");
        }
        else
            request.setAttribute("mess", "Login Fail");

        return "home";
    }
}
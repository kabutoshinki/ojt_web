package com.swp.swp.controller;

import com.swp.swp.model.Account;
import com.swp.swp.model.CV;
import com.swp.swp.model.Job;
import com.swp.swp.service.AccountService;
import com.swp.swp.service.JobService;
import com.swp.swp.service.StudentService;
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
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
class IndexController {
    @Autowired
    private JobService jobService;
    @Autowired
    private AccountService accountService;

    @Autowired
    private StudentService studentService;

    @RequestMapping("/")
    public String index() {
        return "forward:/home";
    }

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String home(ModelMap modelMap, HttpServletRequest request){
        String currentWorkingDir = Paths.get("").toAbsolutePath().normalize().toString() + "\\target\\classes\\static\\";
        System.out.println(currentWorkingDir);
        HttpSession session = request.getSession();
        session.setAttribute("currentPath", currentWorkingDir);
        Iterable<Job> jobList = jobService.findAllAvailable();
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
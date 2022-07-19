package com.swp.swp.controller;

import com.swp.swp.model.*;
import com.swp.swp.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

@Controller
class IndexController {
    @Autowired
    private JobService jobService;
    @Autowired
    private AccountService accountService;

    @Autowired
    private StudentService studentService;
    @Autowired
    private SemesterService semesterService;
    @Autowired
    private MajorService majorService;
    @Autowired
    private PositionService positionService;

    @RequestMapping("/")
    public String index() {
        return "forward:/home";
    }

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String home(ModelMap modelMap, HttpServletRequest request){
        /*String currentWorkingDir = Paths.get("").toAbsolutePath().normalize().toString() + "\\target\\classes\\static\\";
        System.out.println(currentWorkingDir);*/
        HttpSession session = request.getSession();
        /*session.setAttribute("currentPath", currentWorkingDir);*/
        Iterable<Job> jobList = jobService.findAllAvailable();
        if (accountService.currentAccount(request) != null) {
            Student student = studentService.findByAccount(accountService.currentAccount(request));
            for (Job x : jobList) {
                for (CV y: student.getCvList()) {
                    System.out.println(jobService.match(x, y));
                    if (jobService.match(x, y) > 50) {
                        x.setRecommend("Recommend");
                    }
                }
            }
        }
        modelMap.addAttribute("jobList",jobList);
        Iterable<Major> majorsList = majorService.findAll();
        modelMap.addAttribute("majorsList", majorsList);
        Iterable<Position> positionList = positionService.findAll();
        modelMap.addAttribute("positionList", positionList);


        modelMap.addAttribute("currentSemester", semesterService.currentSemester());

        String messTrue = (String)session.getAttribute("true");
        if(messTrue!=null){
            if(messTrue.equals("true")){
                session.removeAttribute("true");
                request.setAttribute("mess", "Login Successfully");
            }
            else
                request.setAttribute("mess", "Login Fail");
        }

        return "home";
    }

    @RequestMapping(value = "/home/filter", method = RequestMethod.GET)
    public String homeFilter(ModelMap modelMap, HttpServletRequest request,
                             /*@RequestParam("major") int major,*/
                             @RequestParam("position") int position,
                             @RequestParam("sort") int sort) {
        ArrayList<Job> jobList = (ArrayList<Job>) jobService.findAllAvailable();
        Iterable<Major> majorsList = majorService.findAll();
        modelMap.addAttribute("majorsList", majorsList);
        Iterable<Position> positionList = positionService.findAll();
        modelMap.addAttribute("positionList", positionList);

        modelMap.addAttribute("currentSemester", semesterService.currentSemester());

        modelMap.addAttribute("positionID", position);
        modelMap.addAttribute("sortID", sort);
        System.out.println(position);
        System.out.println(sort);
        if (position != -1) {
            Position temp = positionService.findById(position);
            jobList = temp.getAvailableJobList();
        }
        if (sort != -1) {
            switch (sort) {
                case 1:
                    jobList.sort((o1, o2) -> o1.getEndDate().compareTo(o2.getEndDate()));
                    break;

                case 2:
                    jobList.sort((o1, o2) -> o2.getEndDate().compareTo(o1.getEndDate()));
                    break;

                case 3:
                    jobList.sort((o1, o2) -> Integer.valueOf(o1.getSlot()).compareTo(Integer.valueOf(o2.getSlot())));
                    break;

                case 4:
                    jobList.sort((o1, o2) -> Integer.valueOf(o2.getSlot()).compareTo(Integer.valueOf(o1.getSlot())));
                    break;
            }
        }
        modelMap.addAttribute("jobList",jobList);
        return "home";
    }
}
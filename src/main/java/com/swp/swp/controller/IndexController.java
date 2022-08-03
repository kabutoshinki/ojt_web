package com.swp.swp.controller;

import com.swp.swp.model.*;
import com.swp.swp.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
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

    @RequestMapping("/manualLogout")
    public String manualLogout(HttpServletRequest request, HttpServletResponse response) throws IOException {
        /*HttpSession session = request.getSession();
        System.out.println(session.getAttribute("warningMessage"));
        Cookie[] cookies = request.getCookies();
        if(cookies!=null)
            for (int i = 0; i < cookies.length; i++) {
                cookies[i].setMaxAge(0);
            }

        System.out.println(session.getAttribute("warningMessage"));*/
        response.sendRedirect("/logout");
        return "forward:/logout";
    }

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String home(ModelMap modelMap, HttpServletRequest request){

        HttpSession session = request.getSession();
        int position = -1, sort = -1, recommend = -1;
        if (request.getParameter("position") != null) {
            position = Integer.parseInt(request.getParameter("position"));
        }
        if (request.getParameter("sort") != null) {
            sort = Integer.parseInt(request.getParameter("sort"));
        }
        if (request.getParameter("recommend") != null) {
            recommend = Integer.parseInt(request.getParameter("recommend"));
        }
        ArrayList<Job> jobList = (ArrayList<Job>) jobService.findAllAvailable();
        Iterable<Major> majorsList = majorService.findAll();
        modelMap.addAttribute("majorsList", majorsList);
        System.out.println("Number of job: "+ jobList.size());
        for(Job job : jobList){
            System.out.println("Job: " + job.getId());
        }
        Iterable<Position> positionList = positionService.findAll();
        modelMap.addAttribute("positionList", positionList);

        modelMap.addAttribute("currentSemester", semesterService.currentSemester());

        modelMap.addAttribute("positionID", position);
        modelMap.addAttribute("sortID", sort);
        modelMap.addAttribute("recommendID", recommend);


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
        if (accountService.checkRole("STUDENT", request) == true) {
            Student student = studentService.findByAccount(accountService.currentAccount(request));
            for (Job x : jobList) {
                for (CV y: student.getCvList()) {
                    //System.out.println(jobService.match(x, y));
                    if (jobService.match(x, y) > 50) {
                        x.setRecommend("Recommend");
                        break;
                    }
                }
            }
            if (recommend == 1) {
                ArrayList <Job> temp = (ArrayList<Job>) jobList.clone();
                jobList.clear();
                for (Job x: temp) {
                    //System.out.println(x.getRequirement());
                    if (x.getRecommend() != null && x.getRecommend().equalsIgnoreCase("Recommend"))
                        jobList.add(x);
                }
            }
        }

        int page = 1;
        if (session.getAttribute("page") != null) {
            page = (int) session.getAttribute("page");
        }
        int totalPage = jobList.size() / 6;
        if (jobList.size() % 6 != 0) {
            totalPage += 1;
        }

        String cmd = "";
        if (request.getParameter("op") != null) {
            cmd = request.getParameter("op");
        }
        if (cmd.equalsIgnoreCase("FirstPage")) {
            page = 1;
        } else if (cmd.equalsIgnoreCase("PreviousPage")) {
            page -= 1;
        } else if (cmd.equalsIgnoreCase("NextPage")) {
            page += 1;
        } else if (cmd.equalsIgnoreCase("LastPage")) {
            page = totalPage;
        } else if (cmd.equalsIgnoreCase("GotoPage")) {
            if (request.getParameter("gotoPage") != null) {
                page = Integer.parseInt(request.getParameter("gotoPage"));
            }
        }
        page = Math.min(page, totalPage);
        page = Math.max(page, 1);
        session.setAttribute("totalPage", totalPage);
        session.setAttribute("page", page);
        int start = (page - 1) * 6;
        int end = (page * 6);
        ArrayList <Job> temp = (ArrayList<Job>) jobList.clone();
        jobList.clear();
        for (int i = start; i < Math.min(end, temp.size()); i++) {
            jobList.add(temp.get(i));
        }
        modelMap.addAttribute("jobList",jobList);

        return "home";
    }
}
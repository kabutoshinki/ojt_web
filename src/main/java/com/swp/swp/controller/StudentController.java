package com.swp.swp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.swp.swp.model.Account;
import com.swp.swp.service.AccountService;
import com.swp.swp.service.StudentApplyJobsService;

@Controller
@RequestMapping(path = "student")
public class StudentController {
    @Autowired AccountService accountService;
    @Autowired StudentApplyJobsService studentApplyJobs;

    @RequestMapping(value = "viewApply", method = RequestMethod.GET)
    public String viewApply(ModelMap modelMap, HttpServletRequest request){
        HttpSession session = request.getSession();
        if(accountService.checkRole("STUDENT", request)==false)
            return "test";
        Account account = accountService.getByString((String)session.getAttribute("email"));
        /*Iterable<StudentApplyJob> apply = studentApplyJobs.getApplyByAccount(account);
        modelMap.addAttribute("apply", apply);*/
        return "applylist";
    }
}

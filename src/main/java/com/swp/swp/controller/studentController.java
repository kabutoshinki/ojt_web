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

@Controller
@RequestMapping(path = "studentController")
public class studentController {
    @Autowired AccountService accountService;

    @RequestMapping(value = "insertPage", method = RequestMethod.GET)
    public String insertPage(ModelMap modelMap, HttpServletRequest request){
        HttpSession session = request.getSession();
        if(accountService.checkRole("STUDENT", request)==false)
            return "test";
        Account account = accountService.getByString((String)session.getAttribute("email"));
        modelMap.addAttribute("account", account);
        return "studentInformation";
    }
}

package com.swp.swp.controller;

import java.net.http.HttpRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(path = "homePage")
public class homePageController {
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String homePage( HttpServletRequest request){
        HttpSession session = request.getSession();
        String messTrue = (String)session.getAttribute("true");
        if(messTrue!=null){
            session.removeAttribute("true");
            request.setAttribute("mess", "Loign Sucessfully");    
        }
        else
            request.setAttribute("mess", "Loign Fail");  
        
        return "homePage";
    }
}

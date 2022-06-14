package com.swp.swp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(path = "/studentController")
public class studentApplyJobController {
    @RequestMapping(value = "/insertPage", method = RequestMethod.GET)
    public String insertPage(ModelMap modelMap){
        System.out.println("student controller");
        return "applyJob";
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.swp.swp.controller;

import com.swp.swp.repositories.AccountRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ADMIN
 */
@Controller
@RequestMapping(path = "account")
public class accountController {
    @Autowired
    private AccountRepositories repositories;
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String getAllAccounts(ModelMap modelMap){
        System.out.println("test login page");
        modelMap.addAttribute("fullName", repositories.getById(1).getEmail() );
        modelMap.addAttribute("email", repositories.getById(1).getFullName());
        return "login";
    }
    
}

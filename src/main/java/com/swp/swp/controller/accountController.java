/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.swp.swp.controller;

import com.swp.swp.model.Account;
import com.swp.swp.model.ResponseObject;
import com.swp.swp.repositories.AccountRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    @RequestMapping(value = "/loginPage", method = RequestMethod.GET)
    public String getAllAccounts(ModelMap modelMap){
        System.out.println("test login page");
        modelMap.addAttribute("email", repositories.getById(1).getEmail() );
        modelMap.addAttribute("password", repositories.getById(1).getPassword());
        System.out.println("email: "+repositories.getById(1).getEmail());
        System.out.println("password: "+repositories.getById(1).getPassword());
        return "login";
    }
    
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(ModelMap modelMap, @ModelAttribute("account") Account account){
        
        String email = account.getEmail();
        String password = account.getPassword();
        Account acc = repositories.findByEmailAndPassword(email,password);
        if(acc!=null){
            modelMap.addAttribute("email", acc.getEmail());
            modelMap.addAttribute("password", acc.getPassword());
            return "test";
        }else{
            ResponseEntity.status(HttpStatus.NOT_FOUND).body(
            new ResponseObject("Not Found", "cannot found account", acc)
            );
            modelMap.addAttribute("mess", "wrong email or password");
            return "login";
        }
        
        
    }
    
}

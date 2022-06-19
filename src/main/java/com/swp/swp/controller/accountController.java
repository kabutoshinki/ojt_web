/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.swp.swp.controller;

import com.swp.swp.model.Account;
import com.swp.swp.model.ResponseObject;
import com.swp.swp.repositories.AccountRepositories;
import com.swp.swp.service.AccountService;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aspectj.weaver.ast.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author ADMIN
 */
@Controller
@RequestMapping(path = "/accountController")
public class accountController {
    @Autowired
    private AccountRepositories repositories;
    @Autowired
    private AccountService accountService;

    @RequestMapping(value = "/insertPage", method = RequestMethod.GET)
    public String getAllAccounts(ModelMap modelMap, HttpServletRequest request){
        System.out.println("insert information page");
        HttpSession session = request.getSession();
        Account account = accountService.getByString((String) session.getAttribute("email"));
        modelMap.addAttribute("user", account);
        System.out.println("Account: " + account.getEmail());
        return "studentInformation";
    }

    @PostMapping(value = "/insert")
    public String insert(@ModelAttribute("information") Account infor, RedirectAttributes ra,
    @RequestParam("imgavatar") MultipartFile img, HttpServletRequest request) throws IOException{
        HttpSession session = request.getSession();
        String email = (String) session.getAttribute("email");
        String fileName = StringUtils.cleanPath(img.getOriginalFilename());
        Account account = accountService.getByString(email);
        String uploadDir = "D:/swp_project/src/main/resources/static/img/"+ account.getAccountId();

        Path uploadPath = Paths.get(uploadDir);
        if(!Files.exists(uploadPath)){
            Files.createDirectories(uploadPath);
        }
        try(InputStream inputStream = img.getInputStream()) {
            System.out.println("filePath.toFile().getAbsolutePath()");
            Path filePath = uploadPath.resolve(fileName);
            Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);

            System.out.println(filePath.toFile().getAbsolutePath());
        } catch (IOException e) {
            System.out.println("ERROS: "+e.getStackTrace());
            throw new IOException("Could not save uploaded file: " + fileName);
        }
        if(!accountService.insertInfor(email, infor.getFullName(), infor.getAddress(), 
        infor.getDateOfBirth(), infor.getPhone(), fileName)){
            System.out.println("Insert Faild");
        }
        ra.addFlashAttribute("mess", "Insert completed");
        return "test";
    }
    
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(ModelMap modelMap, @ModelAttribute("account") Account account){
        
        String email = account.getEmail();
        Account acc = repositories.findByEmail(email);
        if(acc!=null){
            modelMap.addAttribute("email", acc.getEmail());
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

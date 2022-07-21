/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.swp.swp.controller;

import com.swp.swp.model.Account;
import com.swp.swp.model.Company;
import com.swp.swp.model.ResponseObject;
import com.swp.swp.model.Student;
import com.swp.swp.repositories.AccountRepositories;
import com.swp.swp.service.AccountService;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.swp.swp.service.CompanyService;
import com.swp.swp.service.FileService;
import com.swp.swp.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author ADMIN
 */
@Controller
@RequestMapping(path = "/account")
public class AccountController {
    @Autowired
    private AccountRepositories repositories;
    @Autowired
    private AccountService accountService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private CompanyService companyService;
    @Autowired
    private FileService fileService;


    @PostMapping(value = "/updateInformation")
    public String updateInformation(ModelMap modelMap, HttpServletRequest request,
                                    @RequestParam("avatar") MultipartFile file) {
        HttpSession session = request.getSession();
        Account account = accountService.currentAccount(request);
        if (request.getParameter("address") != null) {
            account.setAddress(request.getParameter("address"));
        }
        if (request.getParameter("phone") != null) {
            account.setPhone(request.getParameter("phone"));
        }
        /*if (request.getParameter("file") != null) {
            Part file = request.getPart("avatar");
            Path currentWorkingDir = Path.of(Paths.get("").toAbsolutePath() + "\\src\\main\\resources\\static\\avatar\\");
            String path = currentWorkingDir.normalize().toString();
            fileService.saveFile(file, account.getId() + "", path);
        }*/
        if (account.getRole().equals("STUDENT")) {
            Student student = studentService.findByAccount(accountService.currentAccount(request));
            if (request.getParameter("studentId") != null) {
                student.setStudentId(request.getParameter("studentId"));
            }
            /*System.out.println("kadjnwdjkhadkwa" + request.getParameter("dateOfBirth"));
            System.out.println("ccccccccc" + request.getParameter("dateOfBirth").toString());*/

            if (request.getParameter("dateOfBirth") != null && request.getParameter("dateOfBirth").isEmpty() == false) {
                student.setDateOfBirth(Date.valueOf(request.getParameter("dateOfBirth")));
            }
            if (request.getParameter("gender") != null) {
                student.setGender(request.getParameter("gender"));
            }
            student.setAccount(account);
            studentService.save(student);
            modelMap.addAttribute("student", student);
        }
        if (account.getRole().equals("COMPANY")) {
            Company company = companyService.findByAccount(accountService.currentAccount(request));
            if (request.getParameter("description") != null) {
                company.setDescription(request.getParameter("description"));
            }
            company.setAccount(account);
            companyService.save(company);
            modelMap.addAttribute("company", company);
        }
        accountService.save(account);

        if (file.isEmpty() == false) {
            // Path currentWorkingDir = Path.of(Paths.get("").toAbsolutePath() + "\\target\\classes\\static\\avatar");
            //Path currentWorkingDir = Path.of(Paths.get("").toAbsolutePath() + "/src/main/resources/static/Avatar");
            //String path = currentWorkingDir.normalize().toString();
            String filename = file.getOriginalFilename();
            int index = filename.indexOf('.');
            String extension = filename.substring(index+1, filename.length()).toUpperCase();
            //path += File.separator + String.valueOf(account.getId()) + "." + extension;
            account.setAvatar("/avatar/" + String.valueOf(account.getId()) + "." + extension);
            //fileService.saveFile(file, path);
            fileService.saveFile(file, Path.of(Paths.get("").toAbsolutePath() + "/src/main/resources/static/avatar").toString() + File.separator + String.valueOf(account.getId()) + "." + extension);
            fileService.saveFile(file, Path.of(Paths.get("").toAbsolutePath() + "/target/classes/static/avatar").toString() + File.separator + String.valueOf(account.getId()) + "." + extension);
            accountService.save(account);
        }
        session.setAttribute("account", account);
        session.setAttribute("successMessage", "Update successfully!");
        return "redirect:/view/user";
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

package com.swp.swp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.swp.swp.model.Account;
import com.swp.swp.model.Company;
import com.swp.swp.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import com.swp.swp.model.StudentApplyJobs;
import com.swp.swp.repositories.PositionRepositories;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
@RequestMapping(path = "/employee")
public class EmployeeController {

    @Autowired PositionRepositories positionRepositories;
    @Autowired private JobService jobService;
    @Autowired private EmailService emailService;
    @Autowired private StudentApplyJobsService studentApplyJobsService;
    @Autowired private AccountService accountService;
    @Autowired private CompanyService companyService;


    @RequestMapping(value = "", method = RequestMethod.GET)
    public String managePage(ModelMap modelMap, HttpServletRequest request){
        if(accountService.checkRole("EMPLOYEE", request)==false)
            return "test";
        return "employee";
    }
    @RequestMapping(value = "/companies", method = RequestMethod.GET)
    public String verifyCompanyPage(ModelMap modelMap, HttpServletRequest request){
        if(accountService.checkRole("EMPLOYEE", request)==false)
            return "test";
        HttpSession session = request.getSession();
        Iterable<Company> companyList = companyService.getAll();
        modelMap.addAttribute("companyList",companyList);
        return "companies";
    }
    @RequestMapping(value = "/students", method = RequestMethod.GET)
    public String importPage(ModelMap modelMap, HttpServletRequest request){
        if(accountService.checkRole("EMPLOYEE", request)==false)
            return "test";
        HttpSession session = request.getSession();
        Iterable<Account> studentList = accountService.findByRole("STUDENT");
        modelMap.addAttribute("studentList",studentList);
        return "students";
    }

    @RequestMapping(value = "/updateStatus/{idJob}/{status}", method = RequestMethod.GET)
    public String verifyPage(ModelMap modelMap, @PathVariable("idJob") int id,
     @PathVariable("status") int status, HttpServletRequest request){
        if(accountService.checkRole("EMPLOYEE", request)==false)
            return "test";
       if(status==1){
           jobService.updateStatus(id, "waiting");
       }
       else if(status==2)
            jobService.updateStatus(id, "Cancel");
        return "redirect:/employeeController/verifyPage";
    }
    @RequestMapping(value = "/candidatesList", method = RequestMethod.GET)
    public String candidatesList(ModelMap modelMap, HttpServletRequest request){
        if(accountService.checkRole("EMPLOYEE", request)==false)
            return "test";
        Iterable<StudentApplyJobs> candidates = studentApplyJobsService.getApplyByCompanyId(1);
        modelMap.addAttribute("candidates", candidates);
        return "candidateList";
    }
    @RequestMapping(value = "/verify/{id}/{status}", method = RequestMethod.GET)
    public String verify(@PathVariable("id") int id, @PathVariable("status") int status,
    HttpServletRequest request){
        if(accountService.checkRole("EMPLOYEE", request)==false)
            return "test";
        if(status==1){
            studentApplyJobsService.updateStatus(id, "waiting");
            return "redirect:/employeeController/candidatesList";
        }
        else{
            studentApplyJobsService.updateStatus(id, "not-accept");
            return "redirect:/employeeController/candidatesList";
        }
        
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String upload(@RequestParam("file") MultipartFile file, @RequestParam("role") String role, @RequestParam("redirect") String redirect) throws Exception{
        List<Account> accountList = FileService.upload(file);
        String body = "Welcome to OJT website. Please use this email to login to the website";
        String subject = "Account for ojt";
        for (Account account: accountList) {
            account.setRole(role);
            accountService.insertAccount(account);
            if (role.equalsIgnoreCase("COMPANY")) {
                Company newCompany = new Company();
                newCompany.setName(account.getFullName());
                newCompany.setAccountId(account);
                companyService.insertCompany(newCompany);
            }
            emailService.sendEmail(account.getEmail(), body, subject);
            System.out.println(account);
        }

        return "redirect:/employee/" + redirect;
    }


}

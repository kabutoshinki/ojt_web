package com.swp.swp.controller;

import com.swp.swp.model.*;
import com.swp.swp.service.CompanyService;
import com.swp.swp.service.EmployeeService;
import com.swp.swp.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.swp.swp.service.JobService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(path = "/view")
public class ViewController {

    @Autowired
    private JobService jobService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private CompanyService companyService;

    @RequestMapping(value = "/recruitment/{id}", method = RequestMethod.GET)
    public String jobDetail(ModelMap modelMap, @PathVariable("id") int id ){
        Job jobDetail = jobService.getById(id);
        String[] jobDes = jobService.getJobDescription(id);
        String[] companyDes = jobService.getCompanyDescription(id);
        String[] jobRe = jobService.getJobRequirement(id);
        modelMap.addAttribute("jobDes", jobDes);
        modelMap.addAttribute("companyDes", companyDes);
        modelMap.addAttribute("jobRe", jobRe);
        modelMap.addAttribute("jobDetail", jobDetail);
        return "recruitment";
    }

    @RequestMapping(value = "/user")
    public String viewUserInformation(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response){
        HttpSession session = request.getSession();
        Account account = (Account) session.getAttribute("account");
        session.setAttribute("user", account);
        //System.out.println(account.getFullName());
        if (account.getRole().equals("STUDENT")) {
            Student student = studentService.findByAccount(account);
            session.setAttribute("student", student);
        }
        if (account.getRole().equals("EMPLOYEE")) {
            Employee employee = employeeService.findByAccount(account);
            session.setAttribute("employee", employee);
        }
        if (account.getRole().equals("COMPANY")) {
            Company company = companyService.findByAccount(account);
            session.setAttribute("company", company);
        }


        return "userInformation";
    }
    @RequestMapping(value = "/view2")
    public String view2(){
        return "listofstudent";
    }
    @RequestMapping(value = "/view3")
    public String view3(){
        return "applylist";
    }
}

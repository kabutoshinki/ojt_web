package com.swp.swp.controller;

import com.swp.swp.model.*;
import com.swp.swp.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
    private AccountService accountService;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private CompanyService companyService;

    @Autowired private OjtProcessService ojtProcessService;
    @Autowired private CVService cvService;

    @RequestMapping(value = "/recruitment/{id}", method = RequestMethod.GET)
    public String jobDetail(ModelMap modelMap, @PathVariable("id") int id, HttpServletRequest request){
        Job jobDetail = jobService.findById(id);
        String[] jobDes = jobService.getJobDescription(id);
        String[] companyDes = jobService.getCompanyDescription(id);
        String[] jobRe = jobService.getJobRequirement(id);
        if (accountService.checkRole("STUDENT", request) == true) {
            Student student = studentService.findByAccount(accountService.currentAccount(request));
            Iterable<CV> cvList = cvService.findAllAvailable(student);
            modelMap.addAttribute("cvList", cvList);
            modelMap.addAttribute("student", student);
            for (CV cv: cvList) {
                System.out.println(cv.getName());
            }
            System.out.println("kjdbwakdwa");
        }
        modelMap.addAttribute("jobDes", jobDes);
        modelMap.addAttribute("companyDes", companyDes);
        modelMap.addAttribute("jobRe", jobRe);
        modelMap.addAttribute("jobDetail", jobDetail);
        return "viewRecruitment";
    }

    @RequestMapping(value = "/user")
    public String viewUserInformation(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response){
        Account account = accountService.currentAccount(request);
        modelMap.addAttribute("user", account);
        //System.out.println(account.getFullName());
        if (account.getRole().equals("STUDENT")) {
            Student student = studentService.findByAccount(account);
            modelMap.addAttribute("student", student);
        }
        if (account.getRole().equals("EMPLOYEE")) {
            Employee employee = employeeService.findByAccount(account);
            modelMap.addAttribute("employee", employee);
        }
        if (account.getRole().equals("COMPANY")) {
            Company company = companyService.findByAccount(account);
            modelMap.addAttribute("company", company);
        }


        return "viewUserInformation";
    }

    @RequestMapping(value = "/evaluate/{id}", method = RequestMethod.GET)
    public String evaluate(ModelMap modelMap, HttpServletRequest request, @PathVariable("id") int id){
        /*if(accountService.checkRole("COMPANY", request)==false)
            return "test";*/
        if (accountService.currentAccount(request) == null) {
            return "test";
        }
        OjtProcess process = ojtProcessService.findById(id);
        modelMap.addAttribute("process", process);
        return "viewEvaluate";
    }
}

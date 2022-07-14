package com.swp.swp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.swp.swp.model.*;
import com.swp.swp.repositories.SemesterRepositories;
import com.swp.swp.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import com.swp.swp.repositories.PositionRepositories;
import org.springframework.web.multipart.MultipartFile;

import java.sql.Date;
import java.util.List;

@Controller
@RequestMapping(path = "/employee")
public class EmployeeController {

    @Autowired PositionService positionService;
    @Autowired
    SemesterService semesterService;
    @Autowired private JobService jobService;
    @Autowired private OjtProcessService ojtProcessService;
    @Autowired private EmployeeService employeeService;
    @Autowired private EmailService emailService;
    @Autowired private StudentApplyJobsService studentApplyJobsService;
    @Autowired private AccountService accountService;
    @Autowired private CompanyService companyService;
    @Autowired private StudentService studentService;
    @Autowired private ExternalRequestService externalRequestService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String managePage(ModelMap modelMap, HttpServletRequest request){
        if(accountService.checkRole("EMPLOYEE", request)==false && accountService.checkRole("ADMIN", request)==false)
            return "test";
        return "employee";
    }
    @RequestMapping(value = "/companies", method = RequestMethod.GET)
    public String verifyCompanyPage(ModelMap modelMap, HttpServletRequest request){
        if(accountService.checkRole("EMPLOYEE", request)==false && accountService.checkRole("ADMIN", request)==false)
            return "test";
        HttpSession session = request.getSession();
        Iterable<Company> companyList = companyService.findAllActive();
        modelMap.addAttribute("companyList",companyList);
        return "companies";
    }
    @PostMapping(value = "removeCompany/{id}")
    public String removeCompany(HttpServletRequest request, @PathVariable("id") int id) {
        if(accountService.checkRole("EMPLOYEE", request)==false && accountService.checkRole("ADMIN", request)==false)
            return "test";
        Company company = companyService.findById(id);
        company.getAccount().setStatus("Inactive");
        companyService.save(company);
        return "redirect:/employee/companies";
    }

    @RequestMapping(value = "/students", method = RequestMethod.GET)
    public String importPage(ModelMap modelMap, HttpServletRequest request){
        if(accountService.checkRole("EMPLOYEE", request)==false && accountService.checkRole("ADMIN", request)==false)
            return "test";
        Iterable<Student> studentList = studentService.findAllActive();
        modelMap.addAttribute("studentList", studentList);
        return "students";
    }

    @PostMapping(value = "removeStudent/{id}")
    public String removeStudent(HttpServletRequest request, @PathVariable("id") int id) {
        if(accountService.checkRole("EMPLOYEE", request)==false && accountService.checkRole("ADMIN", request)==false)
            return "test";
        Student student = studentService.findById(id);
        student.getAccount().setStatus("Inactive");
        studentService.save(student);
        return "redirect:/employee/students";
    }

    @RequestMapping(value = "/applications", method = RequestMethod.GET)
    public String verifyApplication(ModelMap modelMap, HttpServletRequest request){
        if(accountService.checkRole("EMPLOYEE", request)==false && accountService.checkRole("ADMIN", request)==false)
            return "test";
        Iterable<StudentApplyJob> applyList = studentApplyJobsService.findAll();
        modelMap.addAttribute("applyList", applyList);
        return "applications";
    }

    @RequestMapping(value = "/externalApplications", method = RequestMethod.GET)
    public String externalApplications(ModelMap modelMap, HttpServletRequest request){
        if(accountService.checkRole("EMPLOYEE", request)==false && accountService.checkRole("ADMIN", request)==false)
            return "test";
        Iterable<ExternalRequest> applyList = externalRequestService.findAll();
        modelMap.addAttribute("applyList", applyList);
        return "externalApplications";
    }


    @RequestMapping(value = "/verifyApplication/{id}/{status}", method = RequestMethod.GET)
    public String verifyApplication(@PathVariable("id") int id, @PathVariable("status") String status,
                         HttpServletRequest request){
        if(accountService.checkRole("EMPLOYEE", request)==false && accountService.checkRole("ADMIN", request)==false)
            return "test";
        Employee employee = employeeService.findByAccount(accountService.currentAccount(request));
        StudentApplyJob x = studentApplyJobsService.findById(id);
        if (x.getStatus().equalsIgnoreCase("Waiting") ||
                x.getStatus().equalsIgnoreCase("Processing") ||
                x.getStatus().equalsIgnoreCase("Denied")) {
            x.setStatus(status);
            x.setEmployee(employee);
            studentApplyJobsService.save(x);
        }
        return "redirect:/employee/applications";
    }

    @RequestMapping(value = "/verifyExternalApplication/{id}/{status}", method = RequestMethod.GET)
    public String verifyExternalApplication(@PathVariable("id") int id, @PathVariable("status") String status,
                                    HttpServletRequest request){
        if(accountService.checkRole("EMPLOYEE", request)==false && accountService.checkRole("ADMIN", request)==false)
            return "test";
        Employee employee = employeeService.findByAccount(accountService.currentAccount(request));
        ExternalRequest x = externalRequestService.findById(id);
        StudentApplyJob application = x.getApplication();
        if (application.getStatus().equalsIgnoreCase("Waiting") ||
                application.getStatus().equalsIgnoreCase("Processing") ||
                application.getStatus().equalsIgnoreCase("Denied")) {
            application.setStatus(status);
            application.setEmployee(employee);
            studentApplyJobsService.save(application);
            externalRequestService.save(x);
        }
        return "redirect:/employee/externalApplications";
    }

    @RequestMapping(value = "/internships", method = RequestMethod.GET)
    public String studentInternshipResult(ModelMap modelMap, HttpServletRequest request){
        if(accountService.checkRole("EMPLOYEE", request)==false && accountService.checkRole("ADMIN", request)==false)
            return "test";
        Iterable <OjtProcess> processList = ojtProcessService.findAll();
        modelMap.addAttribute("processList", processList);
        return "internships";
    }

    @RequestMapping(value = "/evaluate", method = RequestMethod.GET)
    public String evaluate(ModelMap modelMap, HttpServletRequest request){
        if(accountService.checkRole("EMPLOYEE", request)==false && accountService.checkRole("ADMIN", request)==false)
            return "test";
        return "evaluate";
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
        return "redirect:/employee/verifyPage";
    }
    /*@RequestMapping(value = "/candidatesList", method = RequestMethod.GET)
    public String candidatesList(ModelMap modelMap, HttpServletRequest request){
        if(accountService.checkRole("EMPLOYEE", request)==false)
            return "test";
        Iterable<StudentApplyJob> candidates = studentApplyJobsService.getApplyByCompanyId(1);
        modelMap.addAttribute("candidates", candidates);
        return "candidateList";
    }*/
    @RequestMapping(value = "/verifyRequirement/{id}/{status}", method = RequestMethod.GET)
    public String verify(@PathVariable("id") int id, @PathVariable("status") String status,
    HttpServletRequest request){
        if(accountService.checkRole("EMPLOYEE", request)==false && accountService.checkRole("ADMIN", request)==false)
            return "test";
        jobService.updateStatus(id, status);
        Employee employee = employeeService.findByAccount(accountService.currentAccount(request));
        Job job = jobService.findById(id);
        job.setStatus(status);
        job.setEmployee(employee);
        jobService.save(job);
        return "redirect:/employee/requirements";
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String upload(@RequestParam("file") MultipartFile file, @RequestParam("role") String role, @RequestParam("redirect") String redirect, HttpServletRequest request) throws Exception{
        if(accountService.checkRole("EMPLOYEE", request)==false && accountService.checkRole("ADMIN", request)==false)
            return "test";
        List<Account> accountList = FileService.upload(file);
        String body = "Welcome to OJT website. Please use this email to login to the website";
        String subject = "Account for ojt";
        for (Account account: accountList) {
            account.setRole(role);
            account.setEmail(account.getEmail().toLowerCase());
            if (role.equalsIgnoreCase("COMPANY")) {
                Company newCompany = new Company();
                newCompany.setAccount(account);
                accountService.save(account);
                companyService.save(newCompany);
            } else if (role.equalsIgnoreCase("STUDENT")) {
                Student newStudent = new Student();
                newStudent.setAccount(account);
                newStudent.setStudentId(account.getEmail().substring(account.getEmail().lastIndexOf("se"), account.getEmail().indexOf("@fpt")).toUpperCase());
                if (accountService.isExist(account.getEmail())) {
                    account = accountService.findByEmail(account.getEmail());
                    newStudent = studentService.findByAccount(account);
                }
                newStudent.setSemester(semesterService.currentSemester());
                accountService.save(account);
                studentService.save(newStudent);
            }
            //emailService.sendEmail(account.getEmail(), body, subject);
            System.out.println(account);
        }

        return "redirect:/employee/" + redirect;
    }

    @RequestMapping(value = "/requirements")
    public String requirements(ModelMap modelMap, HttpServletRequest request) {
        if(accountService.checkRole("EMPLOYEE", request)==false && accountService.checkRole("ADMIN", request)==false)
            return "test";
        Iterable<Job> jobList = jobService.findAll();
        modelMap.addAttribute("jobList",jobList);
        return "requirements";
    }

    @RequestMapping(value = "/semester")
    public String semester(ModelMap modelMap, HttpServletRequest request) {
        if(accountService.checkRole("ADMIN", request)==false)
            return "test";
        Iterable<Semester> semesterList = semesterService.findAll();
        modelMap.addAttribute("semesterList", semesterList);
        modelMap.addAttribute("currentSemester", semesterService.currentSemester());
        return "semester";
    }

    @RequestMapping(value = "/newSemester")
    public String newSemester(ModelMap modelMap, HttpServletRequest request, @RequestParam("startDate")Date startDate, @RequestParam("endDate")Date endDate) {
        if(accountService.checkRole("ADMIN", request)==false)
            return "test";
        Semester newSemester = semesterService.currentSemester().getNextSemester();
        newSemester.setStartDate(startDate);
        newSemester.setEndDate(endDate);
        semesterService.save(newSemester);
        return "redirect:/employee/semester";
    }

}

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
import java.util.ArrayList;
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
    public String companies(ModelMap modelMap, HttpServletRequest request){
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
    public String students(ModelMap modelMap, HttpServletRequest request){
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

    @RequestMapping(value = "/employees", method = RequestMethod.GET)
    public String employees(ModelMap modelMap, HttpServletRequest request){
        if(accountService.checkRole("ADMIN", request)==false)
            return "test";
        Iterable<Employee> employeeList = employeeService.findAllActive();
        modelMap.addAttribute("employeeList", employeeList);
        return "employees";
    }

    @PostMapping(value = "removeEmployee/{id}")
    public String removeEmployee(HttpServletRequest request, @PathVariable("id") int id) {
        if(accountService.checkRole("EMPLOYEE", request)==false && accountService.checkRole("ADMIN", request)==false)
            return "test";
        Employee employee = employeeService.findById(id);
        employee.getAccount().setStatus("Inactive");
        employeeService.save(employee);
        return "redirect:/employee/employees";
    }


    @RequestMapping(value = "/applications", method = RequestMethod.GET)
    public String applications(ModelMap modelMap, HttpServletRequest request){
        if(accountService.checkRole("EMPLOYEE", request)==false && accountService.checkRole("ADMIN", request)==false)
            return "test";
        Iterable<StudentApplyJob> applyList = studentApplyJobsService.findAllApplications();
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
                application.getStatus().equalsIgnoreCase("Passed") ||
                application.getStatus().equalsIgnoreCase("Denied")) {
            application.setStatus(status);
            application.setEmployee(employee);
            x.setEmployee(employee);
            System.out.println(employee.getAccount().getFullName());
            System.out.println(employee.getAccount().getFullName());
            System.out.println(x.getEmployee().getAccount().getFullName());
            studentApplyJobsService.save(application);
            externalRequestService.save(x);
        }
        return "redirect:/employee/externalApplications";
    }


    @RequestMapping(value = "/verifyProcess/{id}/{status}", method = RequestMethod.GET)
    public String verifyProcess(@PathVariable("id") int id, @PathVariable("status") String status,
                                    HttpServletRequest request){
        if(accountService.checkRole("EMPLOYEE", request)==false && accountService.checkRole("ADMIN", request)==false)
            return "test";
        Employee employee = employeeService.findByAccount(accountService.currentAccount(request));
        OjtProcess x = ojtProcessService.findById(id);
        if (x.getStatus().equalsIgnoreCase("Completed")) {
            x.setStatus(status);
            if (x.getStatus().equalsIgnoreCase("Accepted")) {
                if (x.getGrade() >= 5.0) {
                    x.setStatus("Passed");
                } else {
                    x.setStatus("Not Passed");
                }
            }
            x.setEmployee(employee);
            ojtProcessService.save(x);
        }
        return "redirect:/employee/internships";
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

    @RequestMapping(value = "/uploadStudent", method = RequestMethod.POST)
    public String uploadStudent(@RequestParam("file") MultipartFile file, HttpServletRequest request) throws Exception{
        if(accountService.checkRole("EMPLOYEE", request)==false && accountService.checkRole("ADMIN", request)==false)
            return "test";
        ArrayList <ArrayList> accountList = FileService.upload(file);
        String body = "Welcome to OJT website. Please use this email to login to the website";
        String subject = "Account for ojt";
        for (ArrayList x: accountList) {
            if (x.size() != 7) continue;
            Account account = new Account();
            account.setRole("STUDENT");
            account.setFullName((String)x.get(2));
            account.setEmail((String)x.get(3));
            account.setPhone((String)x.get(5));
            account.setAddress((String)x.get(6));
            account.setEmail(account.getEmail().toLowerCase());
            Student newStudent = new Student();
            newStudent.setAccount(account);
            if (accountService.isExist(account.getEmail())) {
                account = accountService.findByEmail(account.getEmail());
                newStudent = studentService.findByAccount(account);
            }
            newStudent.setSemester(semesterService.currentSemester());
            newStudent.setStudentId((String)x.get(1));
            newStudent.setGender((String)x.get(4));
            accountService.save(account);
            studentService.save(newStudent);
            //emailService.sendEmail(account.getEmail(), body, subject);
            System.out.println(account);
        }

        return "redirect:/employee/students";
    }


    @RequestMapping(value = "/uploadEmployee", method = RequestMethod.POST)
    public String uploadEmployee(@RequestParam("file") MultipartFile file, HttpServletRequest request) throws Exception{
        if(accountService.checkRole("ADMIN", request)==false)
            return "test";
        ArrayList <ArrayList> accountList = FileService.upload(file);
        String body = "Welcome to OJT website. Please use this email to login to the website";
        String subject = "Account for ojt";
        for (ArrayList x: accountList) {
            if (x.size() != 5) continue;
            Account account = new Account();
            account.setRole("EMPLOYEE");
            account.setFullName((String)x.get(1));
            account.setEmail((String)x.get(2));
            account.setPhone((String)x.get(3));
            account.setAddress((String)x.get(4));
            account.setEmail(account.getEmail().toLowerCase());
            Employee newEmployee = new Employee();
            if (accountService.isExist(account.getEmail())) {
                account = accountService.findByEmail(account.getEmail());
                newEmployee = employeeService.findByAccount(account);
            }
            newEmployee.setAccount(account);
            accountService.save(account);
            employeeService.save(newEmployee);
            //emailService.sendEmail(account.getEmail(), body, subject);
            System.out.println(account);
        }

        return "redirect:/employee/employees";
    }

    @RequestMapping(value = "/uploadCompany", method = RequestMethod.POST)
    public String uploadCompany(@RequestParam("file") MultipartFile file, HttpServletRequest request) throws Exception{
        if(accountService.checkRole("EMPLOYEE", request)==false && accountService.checkRole("ADMIN", request)==false)
            return "test";
        ArrayList <ArrayList> accountList = FileService.upload(file);
        String body = "Welcome to OJT website. Please use this email to login to the website";
        String subject = "Account for ojt";
        for (ArrayList x: accountList) {
            if (x.size() != 3) continue;
            Account account = new Account();
            account.setRole("COMPANY");
            account.setFullName((String)x.get(1));
            account.setEmail((String)x.get(2));
            account.setEmail(account.getEmail().toLowerCase());
            Company newCompany = new Company();
            if (accountService.isExist(account.getEmail())) {
                account = accountService.findByEmail(account.getEmail());
                newCompany = companyService.findByAccount(account);
            }
            newCompany.setAccount(account);
            accountService.save(account);
            companyService.save(newCompany);
            /*if (role.equalsIgnoreCase("COMPANY")) {
                Company newCompany = new Company();
                newCompany.setAccount(account);
                accountService.save(account);
                companyService.save(newCompany);
            } else if (role.equalsIgnoreCase("STUDENT")) {*/
            //emailService.sendEmail(account.getEmail(), body, subject);
            System.out.println(account);
        }

        return "redirect:/employee/companies";
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
        modelMap.addAttribute("currentSemester", semesterService.currentSemester());
        return "redirect:/employee/semester";
    }

}

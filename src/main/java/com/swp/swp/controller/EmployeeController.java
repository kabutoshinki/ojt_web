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
    @Autowired FileService fileService;
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
        fileService.exportCompanyList(companyList);
        modelMap.addAttribute("companyList",companyList);
        return "employeeCompanies";
    }
    @PostMapping(value = "removeCompany/{id}")
    public String removeCompany(HttpServletRequest request, @PathVariable("id") int id) {
        if(accountService.checkRole("EMPLOYEE", request)==false && accountService.checkRole("ADMIN", request)==false)
            return "test";
        HttpSession session = request.getSession();
        Company company = companyService.findById(id);
        company.getAccount().setStatus("Inactive");
        companyService.save(company);
        session.setAttribute("successMessage", "Removed!");
        return "redirect:/employee/companies";
    }

    @RequestMapping(value = "/students", method = RequestMethod.GET)
    public String students(ModelMap modelMap, HttpServletRequest request){
        if(accountService.checkRole("EMPLOYEE", request)==false && accountService.checkRole("ADMIN", request)==false)
            return "test";
        Iterable<Student> studentList = studentService.findAllActive();
        fileService.exportStudentList(studentList);
        modelMap.addAttribute("studentList", studentList);
        return "employeeStudents";
    }

    @PostMapping(value = "removeStudent/{id}")
    public String removeStudent(HttpServletRequest request, @PathVariable("id") int id) {
        if(accountService.checkRole("EMPLOYEE", request)==false && accountService.checkRole("ADMIN", request)==false)
            return "test";
        HttpSession session = request.getSession();
        Student student = studentService.findById(id);
        student.getAccount().setStatus("Inactive");
        studentService.save(student);
        session.setAttribute("successMessage", "Removed!");
        return "redirect:/employee/students";
    }

    @RequestMapping(value = "/employees", method = RequestMethod.GET)
    public String employees(ModelMap modelMap, HttpServletRequest request){
        if(accountService.checkRole("ADMIN", request)==false)
            return "test";
        Iterable<Employee> employeeList = employeeService.findAllActive();
        modelMap.addAttribute("employeeList", employeeList);
        return "adminEmployees";
    }

    @PostMapping(value = "removeEmployee/{id}")
    public String removeEmployee(HttpServletRequest request, @PathVariable("id") int id) {
        if(accountService.checkRole("ADMIN", request)==false)
            return "test";
        HttpSession session = request.getSession();
        Employee employee = employeeService.findById(id);
        employee.getAccount().setStatus("Inactive");
        employeeService.save(employee);
        session.setAttribute("successMessage", "Removed!");
        return "redirect:/employee/employees";
    }


    @RequestMapping(value = "/applications", method = RequestMethod.GET)
    public String applications(ModelMap modelMap, HttpServletRequest request){
        if(accountService.checkRole("EMPLOYEE", request)==false && accountService.checkRole("ADMIN", request)==false)
            return "test";
        Iterable<StudentApplyJob> applyList = studentApplyJobsService.findAllApplications();
        modelMap.addAttribute("applyList", applyList);
        fileService.exportApplyList(applyList);
        return "employeeApplications";
    }

    @RequestMapping(value = "/externalApplications", method = RequestMethod.GET)
    public String externalApplications(ModelMap modelMap, HttpServletRequest request){
        if(accountService.checkRole("EMPLOYEE", request)==false && accountService.checkRole("ADMIN", request)==false)
            return "test";
        Iterable<ExternalRequest> applyList = externalRequestService.findAll();
        modelMap.addAttribute("applyList", applyList);
        fileService.exportExternalApplyList(applyList);
        return "employeeExternalApplications";
    }


    @RequestMapping(value = "/verifyApplication/{id}/{status}", method = RequestMethod.GET)
    public String verifyApplication(@PathVariable("id") int id, @PathVariable("status") String status,
                         HttpServletRequest request){
        if(accountService.checkRole("EMPLOYEE", request)==false && accountService.checkRole("ADMIN", request)==false)
            return "test";
        HttpSession session = request.getSession();
        Employee employee = employeeService.findByAccount(accountService.currentAccount(request));
        StudentApplyJob x = studentApplyJobsService.findById(id);
        if (x.getStatus().equalsIgnoreCase("Waiting") ||
                x.getStatus().equalsIgnoreCase("Processing") ||
                x.getStatus().equalsIgnoreCase("Denied")) {
            x.setStatus(status);
            x.setEmployee(employee);
            studentApplyJobsService.save(x);
            session.setAttribute("successMessage", "Successfully!");
        }
        return "redirect:/employee/applications";
    }

    @RequestMapping(value = "/verifyExternalApplication/{id}/{status}", method = RequestMethod.GET)
    public String verifyExternalApplication(@PathVariable("id") int id, @PathVariable("status") String status,
                                    HttpServletRequest request){
        if(accountService.checkRole("EMPLOYEE", request)==false && accountService.checkRole("ADMIN", request)==false)
            return "test";
        HttpSession session = request.getSession();
        Employee employee = employeeService.findByAccount(accountService.currentAccount(request));
        ExternalRequest x = externalRequestService.findById(id);
        StudentApplyJob application = x.getApplication();
        if (application.getStatus().equalsIgnoreCase("Waiting") ||
                application.getStatus().equalsIgnoreCase("Accepted") ||
                application.getStatus().equalsIgnoreCase("Denied")) {
            application.setStatus(status);
            application.setEmployee(employee);
            x.setEmployee(employee);
            System.out.println(employee.getAccount().getFullName());
            System.out.println(employee.getAccount().getFullName());
            System.out.println(x.getEmployee().getAccount().getFullName());
            studentApplyJobsService.save(application);
            externalRequestService.save(x);
            session.setAttribute("successMessage", "Successfully!");
        } else {
            session.setAttribute("dangerMessage", "Failed!");
        }
        return "redirect:/employee/externalApplications";
    }


    @RequestMapping(value = "/verifyProcess/{id}/{status}", method = RequestMethod.GET)
    public String verifyProcess(@PathVariable("id") int id, @PathVariable("status") String status,
                                    HttpServletRequest request){
        if(accountService.checkRole("EMPLOYEE", request)==false && accountService.checkRole("ADMIN", request)==false)
            return "test";
        HttpSession session = request.getSession();
        Employee employee = employeeService.findByAccount(accountService.currentAccount(request));
        OjtProcess x = ojtProcessService.findById(id);
        if (x.getStatus().equalsIgnoreCase("Completed")) {
            StudentApplyJob application = x.getApplication();
            x.setStatus(status);
            if (x.getStatus().equalsIgnoreCase("Accepted")) {
                if (x.getGrade() >= 5.0) {
                    x.setStatus("Passed");
                    application.setStatus("Passed");
                } else {
                    x.setStatus("Not Passed");
                    application.setStatus("Not Passed");
                }
            }
            x.setEmployee(employee);
            ojtProcessService.save(x);
            studentApplyJobsService.save(application);
            session.setAttribute("successMessage", "Successfully!");
        } else {
            session.setAttribute("dangerMessage", "Failed!");
        }
        return "redirect:/employee/internships";
    }
    @RequestMapping(value = "/internships", method = RequestMethod.GET)
    public String studentInternshipResult(ModelMap modelMap, HttpServletRequest request){
        if(accountService.checkRole("EMPLOYEE", request)==false && accountService.checkRole("ADMIN", request)==false)
            return "test";
        Iterable <OjtProcess> processList = ojtProcessService.findAll();
        modelMap.addAttribute("processList", processList);
        fileService.exportProcessList(processList);
        return "employeeInternships";
    }


    @RequestMapping(value = "/verifyRequirement/{id}/{status}", method = RequestMethod.GET)
    public String verify(@PathVariable("id") int id, @PathVariable("status") String status,
    HttpServletRequest request){
        if(accountService.checkRole("EMPLOYEE", request)==false && accountService.checkRole("ADMIN", request)==false)
            return "test";
        HttpSession session = request.getSession();
        jobService.updateStatus(id, status);
        Employee employee = employeeService.findByAccount(accountService.currentAccount(request));
        Job job = jobService.findById(id);
        job.setStatus(status);
        job.setEmployee(employee);
        jobService.save(job);
        session.setAttribute("successMessage", "Successfully!");
        return "redirect:/employee/requirements";
    }

    @RequestMapping(value = "/uploadStudent", method = RequestMethod.POST)
    public String uploadStudent(@RequestParam("file") MultipartFile file, HttpServletRequest request) throws Exception{
        if(accountService.checkRole("EMPLOYEE", request)==false && accountService.checkRole("ADMIN", request)==false)
            return "test";
        HttpSession session = request.getSession();
        ArrayList <ArrayList> accountList = FileService.upload(file);
        String body = "Welcome to OJT website. Please use this email to login to the website";
        String subject = "Account for ojt";
        int countSuccess = 0;
        ArrayList <String> exist = new ArrayList<>();
        ArrayList <String> conflict = new ArrayList<>();

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
                Student oldStudent = studentService.findByAccount(account);
                if (oldStudent.getStudentId() != (String)x.get(1)) {
                    conflict.add(account.getEmail());
                    continue;
                } else {
                    exist.add(account.getEmail());
                }
            } else {
                if (studentService.findByStudentId((String)x.get(1)) != null) {
                    conflict.add(account.getEmail());
                } else {
                    countSuccess += 1;
                }
            }
            newStudent.setSemester(semesterService.currentSemester());
            newStudent.setStudentId((String)x.get(1));
            newStudent.setGender((String)x.get(4));
            accountService.save(account);
            studentService.save(newStudent);
            emailService.sendEmail(account.getEmail(), body, subject);
            System.out.println(account);
        }
        if (countSuccess > 0)
            session.setAttribute("successMessage", "Successfully added " + countSuccess + " accounts");
        if (exist.isEmpty() == false) {
            String s = String.valueOf(exist.size()) + " accounts ";
            for (String x: exist) {
                s += x + " ";
            }
            s += " already exist. They will be change to current semester.";
            session.setAttribute("warningMessage", s);
        }
        if (conflict.isEmpty() == false) {
            String s = String.valueOf(conflict.size()) + " accounts ";
            for (String x: conflict) {
                s += x + " ";
            }
            s += " were conflicted. Can not be added.";
            session.setAttribute("dangerMessage", s);
        }
        return "redirect:/employee/students";
    }


    @RequestMapping(value = "/uploadEmployee", method = RequestMethod.POST)
    public String uploadEmployee(@RequestParam("file") MultipartFile file, HttpServletRequest request) throws Exception{
        if(accountService.checkRole("ADMIN", request)==false)
            return "test";
        HttpSession session = request.getSession();
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
        HttpSession session = request.getSession();
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
            emailService.sendEmail(account.getEmail(), body, subject);
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
        return "employeeRequirements";
    }

    @RequestMapping(value = "/semester")
    public String semester(ModelMap modelMap, HttpServletRequest request) {
        if(accountService.checkRole("ADMIN", request)==false)
            return "test";
        Iterable<Semester> semesterList = semesterService.findAll();
        modelMap.addAttribute("semesterList", semesterList);
        modelMap.addAttribute("currentSemester", semesterService.currentSemester());
        return "adminSemester";
    }

    @RequestMapping(value = "/newSemester")
    public String newSemester(ModelMap modelMap, HttpServletRequest request, @RequestParam("startDate")Date startDate, @RequestParam("endDate")Date endDate) {
        if(accountService.checkRole("ADMIN", request)==false)
            return "test";
        HttpSession session = request.getSession();
        Semester newSemester = semesterService.currentSemester().getNextSemester();
        if (startDate.compareTo(endDate) <= 0) {
            newSemester.setStartDate(startDate);
            newSemester.setEndDate(endDate);
            semesterService.save(newSemester);
            modelMap.addAttribute("currentSemester", semesterService.currentSemester());
            session.setAttribute("successMessage", "Successfully!");
        } else {
            session.setAttribute("dangerMessage", "Create failed. Start date must before end date.");
        }
        return "redirect:/employee/semester";
    }

    @RequestMapping(value = "/evaluate/{id}", method = RequestMethod.GET)
    public String evaluate(ModelMap modelMap, HttpServletRequest request, @PathVariable("id") int id){
        if(accountService.checkRole("EMPLOYEE", request)==false)
            return "test";
        OjtProcess process = ojtProcessService.findByApplication(studentApplyJobsService.findById(id));
        modelMap.addAttribute("process", process);
        return "employeeEvaluate";
    }

    @RequestMapping(value = "/updateEvaluate/{id}", method = RequestMethod.GET)
    public String updateEvaluate(ModelMap modelMap, HttpServletRequest request, @PathVariable("id") int id,
                                 @RequestParam("jobDescription") String jobDescription, @RequestParam("knowledge") String knowledge,
                                 @RequestParam("softSkill") String softSkill, @RequestParam("attitude") String attitude,
                                 @RequestParam("point1") int point1, @RequestParam("point2") int point2, @RequestParam("point3") int point3) {
        if(accountService.checkRole("EMPLOYEE", request)==false)
            return "test";
        HttpSession session = request.getSession();
        OjtProcess process = ojtProcessService.findById(id);

        if (process.getStatus().equalsIgnoreCase("Passed") == false
                && process.getStatus().equalsIgnoreCase("Not Passed") == false) {
            process.setAttitude(attitude);
            process.setKnowledge(knowledge);
            process.setSoftSkill(softSkill);
            process.setDescription(jobDescription);
            process.setGrade(1.0 * (point1 + point2 + point3) / 3.0);
            System.out.println(point1);
            System.out.println(point2);
            System.out.println(point3);
            process.setAttitudePoint(point3);
            process.setSoftSkillPoint(point2);
            process.setKnowledgePoint(point1);
            /*java.util.Date date = new java.util.Date();
            java.sql.Date currentDate = new Date(date.getTime());
            if (process.getEndDate() != null && process.getEndDate().compareTo(currentDate) <= 0) {
                process.setStatus("Completed");
            }*/
            System.out.println(jobDescription);
            StudentApplyJob application = process.getApplication();
            process.setStatus("Completed");
            if (process.getStatus().equalsIgnoreCase("Completed")) {

                if (process.getGrade() >= 5.0) {
                    process.setStatus("Passed");
                    application.setStatus("Passed");
                } else {
                    process.setStatus("Not Passed");
                    application.setStatus("Not Passed");
                }

                process.setEmployee(employeeService.findByAccount(accountService.currentAccount(request)));
            }
            ojtProcessService.save(process);
            studentApplyJobsService.save(application);
            session.setAttribute("successMessage", "Successfully!");
        } else {
            session.setAttribute("dangerMessage", "Failed!");
        }
        modelMap.addAttribute("process", process);
        return "redirect:/employee/externalApplications";
    }
}

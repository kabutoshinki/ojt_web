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

import java.sql.Array;
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
        /*fileService.exportCompanyList(companyList);
        modelMap.addAttribute("companyList",companyList);*/
        //modelMap.addAttribute("studentList", studentList);
        session.setAttribute("companyList", companyList);
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

        ArrayList<Student> lst = (ArrayList<Student>) studentService.findAllActive();
        HttpSession session = request.getSession();
        //modelMap.addAttribute("studentList", studentList);
        ArrayList <Student> studentList = new ArrayList<>();
        int semesterId = -1;
        //System.out.println(request.getParameter("semesterId"));
        if (request.getParameter("semesterId") != null) {
            semesterId = Integer.parseInt(request.getParameter("semesterId"));
        }
        String statusValue = "all";
        //System.out.println(request.getParameter("statusValue"));
        if (request.getParameter("statusValue") != null) {
            statusValue = (String) request.getParameter("statusValue");
        }
        for (Student x: lst) {
            boolean flag = true;
            if (semesterId != -1 && x.getSemester().getId() != semesterId) {
                flag = false;
            }
            if (statusValue != null && statusValue.equals("all") == false
                    && x.getAccount().getStatus() != null &&x.getAccount().getStatus().equalsIgnoreCase(statusValue) == false) {
                flag = false;
            }
            if (flag)
                studentList.add(x);
         }
        System.out.println(semesterId);
        System.out.println(statusValue);
        session.setAttribute("semesterId", semesterId);
        session.setAttribute("statusValue", statusValue);
        session.setAttribute("studentList", studentList);
        session.setAttribute("semesterList", semesterService.findAll());
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
        Iterable<StudentApplyJob> lst = studentApplyJobsService.findAllApplications();
        ArrayList <StudentApplyJob> applyList = new ArrayList<>();
        HttpSession session = request.getSession();
        int semesterId = -1;
        //System.out.println(request.getParameter("semesterId"));
        if (request.getParameter("semesterId") != null) {
            semesterId = Integer.parseInt(request.getParameter("semesterId"));
        }
        String statusValue = "all";
        //System.out.println(request.getParameter("statusValue"));
        if (request.getParameter("statusValue") != null) {
            statusValue = (String) request.getParameter("statusValue");
        }
        for (StudentApplyJob x: lst) {
            boolean flag = true;
            if (semesterId != -1 && x.getSemester().getId() != semesterId) {
                flag = false;
            }
            if (statusValue != null && statusValue.equals("all") == false
                    && x.getStatus() != null &&x.getStatus().equalsIgnoreCase(statusValue) == false) {
                flag = false;
            }
            if (flag)
                applyList.add(x);
        }
        System.out.println(semesterId);
        System.out.println(statusValue);
        session.setAttribute("semesterId", semesterId);
        session.setAttribute("statusValue", statusValue);
        session.setAttribute("semesterList", semesterService.findAll());
        session.setAttribute("applyList", applyList);
        /*modelMap.addAttribute("applyList", applyList);
        fileService.exportApplyList(applyList);*/

        return "employeeApplications";
    }

    @RequestMapping(value = "/externalApplications", method = RequestMethod.GET)
    public String externalApplications(ModelMap modelMap, HttpServletRequest request){
        if(accountService.checkRole("EMPLOYEE", request)==false && accountService.checkRole("ADMIN", request)==false)
            return "test";
        Iterable<ExternalRequest> lst = externalRequestService.findAll();
        ArrayList<Pair> applyList = new ArrayList<>();

        HttpSession session = request.getSession();
        int semesterId = -1;
        //System.out.println(request.getParameter("semesterId"));
        if (request.getParameter("semesterId") != null) {
            semesterId = Integer.parseInt(request.getParameter("semesterId"));
        }
        String statusValue = "all";
        //System.out.println(request.getParameter("statusValue"));
        if (request.getParameter("statusValue") != null) {
            statusValue = (String) request.getParameter("statusValue");
        }
        for (ExternalRequest x: lst) {
            boolean flag = true;
            System.out.println(x.getApplication().getSemester().getSemester());
            System.out.println(x.getApplication().getSemester().getId());
            if (semesterId != -1 && x.getApplication().getSemester().getId() != semesterId) {
                System.out.println(x.getApplication().getSemester().getSemester());
                System.out.println(x.getApplication().getSemester().getId());
                flag = false;
            }
            if (statusValue.equals("all") == false && x.getApplication().getStatus().equalsIgnoreCase(statusValue) == false) {
                flag = false;
            }
            if (flag)
                applyList.add(new Pair(x, ojtProcessService.findByApplication(x.getApplication())));
        }
        System.out.println(semesterId);
        System.out.println(statusValue);
        session.setAttribute("semesterId", semesterId);
        session.setAttribute("statusValue", statusValue);
        session.setAttribute("semesterList", semesterService.findAll());
        session.setAttribute("applyList", applyList);
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
        if (x.getStatus().equalsIgnoreCase("Waiting")) {
            x.setStatus(status);
            x.setEmployee(employee);
            if (status.equalsIgnoreCase("Denied")) {
                x.setMessage(request.getParameter("message"));
                emailService.sendEmail(x.getStudent().getAccount().getEmail(), "Your application have been denied by " + employee.getAccount().getFullName() + " with reason " + x.getMessage(), "Application Updated");
            } else {
                emailService.sendEmail(x.getStudent().getAccount().getEmail(), "Your application was sent to " + x.getJob().getCompany().getAccount().getFullName(), "Application Updated");
            }
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
        if (application.getStatus().equalsIgnoreCase("Waiting")) {
            application.setStatus(status);
            application.setEmployee(employee);
            x.setEmployee(employee);
            System.out.println(employee.getAccount().getFullName());
            System.out.println(employee.getAccount().getFullName());
            System.out.println(x.getEmployee().getAccount().getFullName());
            if (status.equalsIgnoreCase("Denied")) {
                application.setMessage(request.getParameter("message"));
                emailService.sendEmail(x.getStudent().getAccount().getEmail(), "Your application was denied by " + employee.getAccount().getFullName() + " with reason " + application.getMessage(), "Application Updated");
            } else {
                for (StudentApplyJob app : application.getStudent().getApplyList()) {
                    if (app.getStatus().equalsIgnoreCase("Interning") == false
                            && app.getStatus().equalsIgnoreCase("Denied") == false
                            && app.getStatus().equalsIgnoreCase("Rejected") == false) {
                        app.setStatus("Refused");
                        studentApplyJobsService.save(app);
                    }
                }
                emailService.sendEmail(x.getStudent().getAccount().getEmail(), "Your application was accepted.", "Application Updated");
            }
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
                    application.getStudent().getAccount().setStatus("Passed");
                } else {
                    x.setStatus("Not Passed");
                    application.setStatus("Not Passed");
                    application.getStudent().getAccount().setStatus("Not Passed");
                }
                emailService.sendEmail(x.getStudent().getAccount().getEmail(), "Your internship report was updated.", "Internship Report");
            } else {
                x.setMessage(request.getParameter("message"));
            }
            x.setEmployee(employee);
            accountService.save(application.getStudent().getAccount());
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
        Iterable <OjtProcess> lst = ojtProcessService.findAll();
        ArrayList <OjtProcess> processList = new ArrayList<>();
        HttpSession session = request.getSession();
        int semesterId = -1;
        //System.out.println(request.getParameter("semesterId"));
        if (request.getParameter("semesterId") != null) {
            semesterId = Integer.parseInt(request.getParameter("semesterId"));
        }
        String statusValue = "all";
        //System.out.println(request.getParameter("statusValue"));
        if (request.getParameter("statusValue") != null) {
            statusValue = (String) request.getParameter("statusValue");
        }
        for (OjtProcess x: lst) {
            boolean flag = true;
            System.out.println(x.getApplication().getSemester().getSemester());
            System.out.println(x.getApplication().getSemester().getId());
            if (semesterId != -1 && x.getApplication().getSemester().getId() != semesterId) {
                System.out.println(x.getApplication().getSemester().getSemester());
                System.out.println(x.getApplication().getSemester().getId());
                flag = false;
            }
            if (statusValue.equals("all") == false && x.getApplication().getStatus().equalsIgnoreCase(statusValue) == false) {
                flag = false;
            }
            if (flag)
                processList.add(x);
        }
        System.out.println(semesterId);
        System.out.println(statusValue);
        session.setAttribute("semesterId", semesterId);
        session.setAttribute("statusValue", statusValue);
        session.setAttribute("semesterList", semesterService.findAll());
        session.setAttribute("processList", processList);
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
        if (status.equalsIgnoreCase("Denied")) {
            job.setMessage(request.getParameter("message"));
            emailService.sendEmail(job.getCompany().getAccount().getEmail(), "Your recruitment was denied by " + employee.getAccount().getFullName() + " with reason " + job.getMessage(), "Recruitment Updated");
        } else {
            emailService.sendEmail(job.getCompany().getAccount().getEmail(), "Your recruitment was accepted.", "Recruitment Updated");
        }
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
            account.setStatus("Enable");
            Student newStudent = new Student();
            newStudent.setAccount(account);
            if (accountService.isExist(account.getEmail())) {
                account = accountService.findByEmail(account.getEmail());
                if (account.getStatus().equalsIgnoreCase("Passed") == false) {
                    account.setStatus("Enable");
                }
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
            if (account.getStatus() != null && account.getStatus().equalsIgnoreCase("Passed") == false) {
                accountService.save(account);
                studentService.save(newStudent);
                emailService.sendEmail(account.getEmail(), body, subject);
                System.out.println(account);
            }
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
        HttpSession session = request.getSession();
        ArrayList<Job> lst = (ArrayList<Job>) jobService.findAll();
        String statusValue = "all";
        //System.out.println(request.getParameter("statusValue"));
        if (request.getParameter("statusValue") != null) {
            statusValue = (String) request.getParameter("statusValue");
        }
        ArrayList <Job> jobList = new ArrayList<>();
        for (Job job: lst) {
            boolean flag = true;
            //System.out.println(job.getStatus());
            System.out.println(statusValue);
            if (statusValue.equals("all") == false && job.getStatus().equalsIgnoreCase(statusValue) == false) {
                System.out.println(job.getStatus());
                flag = false;
            }
            if (flag == true) {
                jobList.add(job);
            }
        }
        session.setAttribute("statusValue", statusValue);
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

    @RequestMapping(value = "/updateExternalEvaluate/{id}", method = RequestMethod.GET)
    public String updateEvaluate(ModelMap modelMap, HttpServletRequest request, @PathVariable("id") int id,
                                 @RequestParam("startDate") Date startDate,
                                 @RequestParam("endDate") Date endDate,
                                 @RequestParam("jobDescription") String jobDescription, @RequestParam("knowledge") String knowledge,
                                 @RequestParam("softSkill") String softSkill, @RequestParam("attitude") String attitude,
                                 @RequestParam("point1") int point1, @RequestParam("point2") int point2, @RequestParam("point3") int point3) {
        if(accountService.checkRole("EMPLOYEE", request)==false && accountService.checkRole("ADMIN", request)==false)
            return "test";
        HttpSession session = request.getSession();
        ExternalRequest request1 = externalRequestService.findById(id);
        StudentApplyJob application = request1.getApplication();
        OjtProcess process = ojtProcessService.findByApplication(application);
        System.out.println(startDate);
        System.out.println(endDate);
        System.out.println(((endDate.getTime() - startDate.getTime()) / (1000 * 60 * 60 * 24) ) % 365);
        if (endDate.compareTo(startDate) < 0) {
            session.setAttribute("dangerMessage", "Start date can not be after End date");
        } else if (((endDate.getTime() - startDate.getTime()) / (1000 * 60 * 60 * 24) ) % 365 < 84) {
            session.setAttribute("dangerMessage", "The process time was not enough 12 weeks.");
        }
        else if (process.getStatus().equalsIgnoreCase("Passed") == false
                && process.getStatus().equalsIgnoreCase("Not Passed") == false) {
            process.setStartDate(startDate);
            process.setEndDate(endDate);
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
            process.setStatus("Completed");
            if (process.getStatus().equalsIgnoreCase("Completed")) {

                if (process.getGrade() >= 5.0) {
                    process.setStatus("Passed");
                    application.setStatus("Passed");
                    application.getStudent().getAccount().setStatus("Passed");
                } else {
                    process.setStatus("Not Passed");
                    application.setStatus("Not Passed");
                    application.getStudent().getAccount().setStatus("Not Passed");
                }
                emailService.sendEmail(process.getStudent().getAccount().getEmail(), "Your internship report was updated.", "Internship Report");
                process.setEmployee(employeeService.findByAccount(accountService.currentAccount(request)));
            }
            accountService.save(application.getStudent().getAccount());
            ojtProcessService.save(process);
            studentApplyJobsService.save(application);
            session.setAttribute("successMessage", "Successfully!");
        } else {
            session.setAttribute("dangerMessage", "Failed!");
        }
        modelMap.addAttribute("process", process);
        return "redirect:/employee/externalApplications";
    }

    @RequestMapping("/writeStudentFile")
    public String writeStudentFile(ModelMap modelMap, HttpServletRequest request) {
        if(accountService.checkRole("EMPLOYEE", request)==false && accountService.checkRole("ADMIN", request)==false)
            return "test";
        HttpSession session = request.getSession();
        ArrayList<Student> studentList = (ArrayList<Student>) session.getAttribute("studentList");
        System.out.println(studentList);
        fileService.exportStudentList(studentList);
        return "redirect:/file.xls";
    }

    @RequestMapping("/writeEmployeeFile")
    public String writeEmployeeFile(ModelMap modelMap, HttpServletRequest request) {
        if(accountService.checkRole("ADMIN", request)==false)
            return "test";
        HttpSession session = request.getSession();
        ArrayList<Employee> employeeList = (ArrayList<Employee>) session.getAttribute("employeeList");
        System.out.println(employeeList);
        fileService.exportEmployeeList(employeeList);
        return "redirect:/file.xls";
    }

    @RequestMapping("/writeCompanyFile")
    public String writeCompanyFile(ModelMap modelMap, HttpServletRequest request) {
        if(accountService.checkRole("EMPLOYEE", request)==false && accountService.checkRole("ADMIN", request)==false)
            return "test";
        HttpSession session = request.getSession();
        ArrayList<Company> companyList = (ArrayList<Company>) session.getAttribute("companyList");
        System.out.println(companyList);
        fileService.exportCompanyList(companyList);
        return "redirect:/file.xls";
    }

    @RequestMapping("/writeApplicationFile")
    public String writeApplyFile(ModelMap modelMap, HttpServletRequest request) {
        if(accountService.checkRole("EMPLOYEE", request)==false && accountService.checkRole("ADMIN", request)==false)
            return "test";
        HttpSession session = request.getSession();
        ArrayList<StudentApplyJob> applyList = (ArrayList<StudentApplyJob>) session.getAttribute("applyList");
        System.out.println(applyList);
        fileService.exportApplyList(applyList);
        return "redirect:/file.xls";
    }

    @RequestMapping("/writeExternalApplicationFile")
    public String writeExternalApplicationFile(ModelMap modelMap, HttpServletRequest request) {
        if(accountService.checkRole("EMPLOYEE", request)==false && accountService.checkRole("ADMIN", request)==false)
            return "test";
        HttpSession session = request.getSession();
        ArrayList<Pair> applyList = (ArrayList<Pair>) session.getAttribute("applyList");
        ArrayList<ExternalRequest> lst = new ArrayList<>();
        for (Pair x: applyList) {
            lst.add((ExternalRequest) x.getKey());
        }
        System.out.println(lst);
        fileService.exportExternalApplyList(lst);
        return "redirect:/file.xls";
    }

    @RequestMapping("/writeProcessFile")
    public String writeProcessFile(ModelMap modelMap, HttpServletRequest request) {
        if(accountService.checkRole("EMPLOYEE", request)==false && accountService.checkRole("ADMIN", request)==false)
            return "test";
        HttpSession session = request.getSession();
        ArrayList<OjtProcess> processList = (ArrayList<OjtProcess>) session.getAttribute("processList");
        System.out.println(processList);
        fileService.exportProcessList(processList);
        return "redirect:/file.xls";
    }
}

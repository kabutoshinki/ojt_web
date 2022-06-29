package com.swp.swp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.swp.swp.model.Student;
import com.swp.swp.model.StudentApplyJob;
import com.swp.swp.service.JobService;
import com.swp.swp.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.swp.swp.model.Account;
import com.swp.swp.service.AccountService;
import com.swp.swp.service.StudentApplyJobsService;

@Controller
@RequestMapping(path = "student")
public class StudentController {
    @Autowired AccountService accountService;
    @Autowired
    JobService jobService;
    @Autowired
    StudentService studentService;
    @Autowired StudentApplyJobsService studentApplyJobsService;

    @RequestMapping(value = "applications", method = RequestMethod.GET)
    public String viewApply(ModelMap modelMap, HttpServletRequest request){
        HttpSession session = request.getSession();
        if(accountService.checkRole("STUDENT", request)==false)
            return "test";
        Account account = accountService.getByString((String)session.getAttribute("email"));
        Student student = studentService.findByAccount(account);
        Iterable<StudentApplyJob> apply = studentApplyJobsService.getApplyByStudent(student);
        modelMap.addAttribute("applyList", apply);
        return "studentApplications";
    }

    @RequestMapping(value = "applyForm/{id}", method = RequestMethod.GET)
    public String applyForm(ModelMap modelMap, @PathVariable int id, HttpServletRequest request) {
        HttpSession session = request.getSession();
        String email = (String) session.getAttribute("email");
        Account account = accountService.findByEmail(email);
        Student student = studentService.findByAccount(account);
        System.out.println(account.getEmail());
        StudentApplyJob newStudentApplyJob = new StudentApplyJob(jobService.findById(id), student, "waiting", "Fall");
        System.out.println(newStudentApplyJob.getStudent().getStudentId());
        studentApplyJobsService.save(newStudentApplyJob);
        return "redirect:/student/applications";
    }
}

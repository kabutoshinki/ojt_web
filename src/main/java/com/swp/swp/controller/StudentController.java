package com.swp.swp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.swp.swp.model.*;
import com.swp.swp.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
@RequestMapping(path = "student")
public class StudentController {
    @Autowired AccountService accountService;
    @Autowired OjtProcessService ojtProcessService;
    @Autowired
    JobService jobService;
    @Autowired
    StudentService studentService;
    @Autowired FileService fileService;
    @Autowired SemesterService semesterService;
    @Autowired
    CVService cvService;
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
    public String applyForm(ModelMap modelMap, @PathVariable int id, HttpServletRequest request, @RequestParam("cvId") int cvId) {
        if(accountService.checkRole("STUDENT", request)==false)
            return "test";
        HttpSession session = request.getSession();
        String email = (String) session.getAttribute("email");
        Account account = accountService.findByEmail(email);
        Student student = studentService.findByAccount(account);
        System.out.println(email);
        System.out.println(account.getFullName());
        System.out.println(id);
        System.out.println(cvId);
        //int cvId = (int) modelMap.getAttribute("cvId");
        //int cvId = Integer.parseInt(request.getParameter("cvId"));
        System.out.println(account.getEmail());
        StudentApplyJob newStudentApplyJob = new StudentApplyJob(jobService.findById(id), student, "waiting", semesterService.findById(1), cvService.findById(cvId));
        System.out.println(newStudentApplyJob.getStudent().getStudentId());
        studentApplyJobsService.save(newStudentApplyJob);
        return "redirect:/student/applications";
    }

    @RequestMapping(value = "/verifyIntern/{id}/{status}", method = RequestMethod.GET)
    public String verifyApplication(@PathVariable("id") int id, @PathVariable("status") String status,
                                    HttpServletRequest request){
        if(accountService.checkRole("STUDENT", request)==false)
            return "test";
        Iterable <StudentApplyJob> applyList = studentService.findByAccount(accountService.currentAccount(request)).getApplyList();
        for (StudentApplyJob x: applyList) {
            if (x.getId() == id) {
                x.setStatus(status);
            } else if (status.equalsIgnoreCase("Interning")) {
                x.setStatus("Refused");
            }
            studentApplyJobsService.save(x);
            if (x.getStatus().equalsIgnoreCase("Interning")) {
                OjtProcess newProcess = new OjtProcess();
                newProcess.setApplication(x);
                newProcess.setStatus("Interning");
                newProcess.setStudent(x.getStudent());
                newProcess.setCompany(x.getJob().getCompany());
                ojtProcessService.save(newProcess);
            }
        }
        return "redirect:/student/applications";
    }

    @PostMapping(value = "uploadCV")
    public String uploadCV(HttpServletRequest request, @RequestParam("file") MultipartFile file, @RequestParam("name") String name, @RequestParam("description") String description) {
        if(accountService.checkRole("STUDENT", request)==false)
            return "test";
        Student student = studentService.findByAccount(accountService.currentAccount(request));
        Path currentWorkingDir = Path.of(Paths.get("").toAbsolutePath() + "\\src\\main\\resources\\static\\students");
        String path = currentWorkingDir.normalize().toString() + "\\" + student.getId() + "\\CV\\";
        CV newCV = new CV();
        newCV.setName(name);
        newCV.setStudent(student);
        newCV.setDescription(description);
        cvService.save(newCV);
        fileService.saveFile(file, name, path);
        return "redirect:/student/CVs";
    }

    @GetMapping(value = "CVs")
    public String viewCV(ModelMap modelMap, HttpServletRequest request) {
        if(accountService.checkRole("STUDENT", request)==false)
            return "test";
        Iterable<CV> cvList = studentService.findByAccount(accountService.currentAccount(request)).getCvList();
        modelMap.addAttribute("cvList", cvList);
        return "CV";
    }
    @GetMapping(value = "report")
    public String studentReport(ModelMap modelMap, HttpServletRequest request) {
        if(accountService.checkRole("STUDENT", request)==false)
            return "test";
        Iterable <OjtProcess> processList = ojtProcessService.findByStudent(studentService.findByAccount(accountService.currentAccount(request)));
        modelMap.addAttribute("processList", processList);
        return "internshipReport";
    }

    @GetMapping(value = "evaluate")
    public String evaluate(ModelMap modelMap, HttpServletRequest request) {
        if(accountService.checkRole("STUDENT", request)==false)
            return "test";
        return "evaluate";
    }

}

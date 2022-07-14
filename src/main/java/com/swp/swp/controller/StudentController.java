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
import java.util.ArrayList;

@Controller
@RequestMapping(path = "student")
public class StudentController {
    @Autowired AccountService accountService;
    @Autowired ExternalRequestService externalRequestService;
    @Autowired OjtProcessService ojtProcessService;
    @Autowired
    JobService jobService;
    @Autowired
    StudentService studentService;
    @Autowired FileService fileService;
    @Autowired SemesterService semesterService;
    @Autowired PositionService positionService;
    @Autowired CompanyService companyService;
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
        Iterable<StudentApplyJob> applyList = studentApplyJobsService.findApplyByStudent(student);
        modelMap.addAttribute("applyList", applyList);
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
        StudentApplyJob application = studentApplyJobsService.findById(id);
        if (application.getJob().getSlot() > 0) {
            application.getJob().setSlot(application.getJob().getSlot() - 1);
            jobService.save(application.getJob());
            for (StudentApplyJob x : applyList) {
                if (x.getId() == id) {
                    x.setStatus(status);
                } else if (status.equalsIgnoreCase("Interning")
                        && x.getStatus().equalsIgnoreCase("Denied") == false
                        && x.getStatus().equalsIgnoreCase("Rejected") == false) {
                    x.setStatus("Refused");
                }
                studentApplyJobsService.save(x);
                if (x.getStatus().equalsIgnoreCase("Interning")) {
                    //System.out.println(x.getStudent().getAccount().get);
                    OjtProcess newProcess = new OjtProcess();
                    newProcess.setApplication(x);
                    newProcess.setStatus("Interning");
                    newProcess.setStudent(x.getStudent());
                    newProcess.setCompany(x.getJob().getCompany());
                    ojtProcessService.save(newProcess);
                }
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
        newCV.setStatus("Active");
        cvService.save(newCV);
        name = newCV.getId() + name;

        /*newCV.setPath("\\src\\main\\resources\\static\\students\\" + String.valueOf(student.getId()) + "\\CV\\" + name + ".pdf");*/
        newCV.setPath("\\students\\" + String.valueOf(student.getId()) + "\\CV\\" + name + ".pdf");
        cvService.save(newCV);
        fileService.saveFile(file, name, path);
        return "redirect:/student/CVs";
    }

    @PostMapping(value = "updateCV/{cvId}")
    public String updateCV(HttpServletRequest request, @RequestParam("file") MultipartFile file, @RequestParam("description") String description, @PathVariable("cvId") int cvId) {
        if(accountService.checkRole("STUDENT", request)==false)
            return "test";
        Student student = studentService.findByAccount(accountService.currentAccount(request));
        Path currentWorkingDir = Path.of(Paths.get("").toAbsolutePath() + "\\src\\main\\resources\\static\\students");
        String path = currentWorkingDir.normalize().toString() + "\\" + student.getId() + "\\CV\\";
        CV cv = cvService.findById(cvId);
        cv.setDescription(description);
        cvService.save(cv);
        fileService.saveFile(file, cv.getId() + cv.getName(), path);
        return "redirect:/student/CVs";
    }

    @PostMapping(value = "removeCV/{cvId}")
    public String removeCV(HttpServletRequest request, @PathVariable("cvId") int cvId) {
        if(accountService.checkRole("STUDENT", request)==false)
            return "test";
        Student student = studentService.findByAccount(accountService.currentAccount(request));
        CV cv = cvService.findById(cvId);
        cv.setStatus("Inactive");
        cvService.save(cv);
        return "redirect:/student/CVs";
    }

    @GetMapping(value = "CVs")
    public String viewCV(ModelMap modelMap, HttpServletRequest request) {
        if(accountService.checkRole("STUDENT", request)==false)
            return "test";
        Iterable<CV> lst = studentService.findByAccount(accountService.currentAccount(request)).getCvList();
        ArrayList<CV> cvList = new ArrayList<>();
        for (CV cv: lst) {
            if (cv.getStatus().equalsIgnoreCase("Inactive") == false)
                cvList.add(cv);
        }
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

    @GetMapping(value = "externalApply")
    public String externalApply(ModelMap modelMap, HttpServletRequest request) {
        if(accountService.checkRole("STUDENT", request)==false)
            return "test";
        Iterable<Position> positionList = positionService.findAll();
        modelMap.addAttribute("positionList", positionList);
        return "externalApply";
    }

    @PostMapping(value = "applyAnExternal")
    public String applyAnExternal(ModelMap modelMap, HttpServletRequest request,/* @RequestParam("position") int id,*/
                                  @RequestParam("contract") MultipartFile contract,
                                  @RequestParam("letter") MultipartFile letter) {
        if(accountService.checkRole("STUDENT", request)==false)
            return "test";
        Student student = studentService.findByAccount(accountService.currentAccount(request));
        /*Position position = positionService.findById(id);*/
        ExternalRequest newRequest = new ExternalRequest();
        newRequest.setStudent(student);
        StudentApplyJob apply = new StudentApplyJob();
        apply.setStatus("Waiting");
        apply.setStudent(student);
        apply.setSemester(student.getSemester());
        apply.setJob(jobService.firstOfCompany(companyService.findByAccount(accountService.findByEmail(""))));
        Path currentWorkingDir = Path.of(Paths.get("").toAbsolutePath() + "\\src\\main\\resources\\static\\students");
        String path = currentWorkingDir.normalize().toString() + "\\" + student.getId() + "\\Request\\" + newRequest.getId() + "\\";
        File requestFolder = new File(currentWorkingDir + "\\" + student.getId() + "\\Request\\" + newRequest.getId());
        requestFolder.mkdirs();
        fileService.saveFile(contract, "contract", path);
        fileService.saveFile(letter, "letter", path);
        newRequest.setApplication(apply);
        studentApplyJobsService.save(apply);
        externalRequestService.save(newRequest);
        return "redirect:/student/applications";
    }

}

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
    public String applications(ModelMap modelMap, HttpServletRequest request){
        HttpSession session = request.getSession();
        if(accountService.checkRole("STUDENT", request)==false)
            return "test";
        Account account = accountService.currentAccount(request);
        Student student = studentService.findByAccount(account);
        /*System.out.println(student.getAccount().getFullName());*/
        Iterable<StudentApplyJob> applyList = studentApplyJobsService.findApplyByStudent(student);
        /*for (StudentApplyJob x: applyList) {
            System.out.println(x.getId() + " " + x.getStudent().getAccount().getFullName() + " " + x.getStatus());
        }
        System.out.println();
        System.out.println();*/
        modelMap.addAttribute("applyList", applyList);
        return "studentApplications";
    }

    @RequestMapping(value = "externalApplications", method = RequestMethod.GET)
    public String externalApplications(ModelMap modelMap, HttpServletRequest request){
        HttpSession session = request.getSession();
        if(accountService.checkRole("STUDENT", request)==false)
            return "test";
        Account account = accountService.currentAccount(request);
        Student student = studentService.findByAccount(account);
        /*System.out.println(student.getAccount().getFullName());*/

        Iterable<ExternalRequest> requestList = externalRequestService.findRequestByStudent(student);
        /*for (ExternalRequest x: requestList) {
            System.out.println(x.getId() + " " + x.getStudent().getAccount().getFullName() + " " + x.getCompanyName());
        }
        System.out.println();
        System.out.println();*/
        modelMap.addAttribute("requestList", requestList);
        return "studentExternalApplications";
    }
    @RequestMapping(value = "applyForm/{id}", method = RequestMethod.GET)
    public String applyForm(ModelMap modelMap, @PathVariable int id, HttpServletRequest request, @RequestParam("cvId") int cvId) {
        if(accountService.checkRole("STUDENT", request)==false)
            return "test";
        HttpSession session = request.getSession();
        Student student = studentService.findByAccount(accountService.currentAccount(request));
        if (!studentService.alreadyApplied(student, jobService.findById(id).getCompany())) {
            session.setAttribute("dangerMessage", "You can not apply for this company more this semester.");
            return "redirect:/student/applications";
        }
        if (student.getApplicationStatus() == false) {
            /*System.out.println(email);
            System.out.println(account.getFullName());
            System.out.println(id);
            System.out.println(cvId);
            //int cvId = (int) modelMap.getAttribute("cvId");
            //int cvId = Integer.parseInt(request.getParameter("cvId"));
            System.out.println(account.getEmail());*/
            StudentApplyJob newStudentApplyJob = new StudentApplyJob(jobService.findById(id), student, "Waiting", student.getSemester(), cvService.findById(cvId));
            System.out.println(newStudentApplyJob.getStudent().getStudentId());
            studentApplyJobsService.save(newStudentApplyJob);
            session.setAttribute("successMessage", "Apply successfully!");
        } else {
            session.setAttribute("dangerMessage", "You can not apply more this semester.");
        }
        return "redirect:/student/applications";
    }

    @RequestMapping(value = "/verifyIntern/{id}/{status}/{redirect}", method = RequestMethod.GET)
    public String verifyApplication(@PathVariable("id") int id, @PathVariable("status") String status, @PathVariable("redirect") String redirect,
                                    HttpServletRequest request){
        if(accountService.checkRole("STUDENT", request)==false)
            return "test";
        HttpSession session = request.getSession();
        Iterable <StudentApplyJob> applyList = studentService.findByAccount(accountService.currentAccount(request)).getApplyList();
        StudentApplyJob application = studentApplyJobsService.findById(id);
        if (application.getJob().getSlot() > 0 && studentService.findByAccount(accountService.currentAccount(request)).getApplicationStatus() == false) {
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
                System.out.println(x.getId() + " " + x.getJob().getCompany().getAccount().getFullName() + " " + x.getStatus());
                if (x.getStatus().equalsIgnoreCase("Interning")) {
                    //System.out.println(x.getStudent().getAccount().get);
                    OjtProcess newProcess = new OjtProcess();
                    newProcess.setApplication(x);
                    newProcess.setStatus("Interning");
                    newProcess.setStudent(x.getStudent());
                    newProcess.setCompany(x.getJob().getCompany());
                    System.out.println(x.getId() + " " + x.getJob().getCompany().getAccount().getFullName() + " " + x.getStatus());
                    System.out.println(newProcess.getCompany().getAccount().getFullName() + " " + newProcess.getStudent().getAccount().getFullName());
                    ojtProcessService.save(newProcess);
                }
            }
            session.setAttribute("succesMessage", "Congratulation! You are hired!!!");
        } else {
            session.setAttribute("dangerMessage", "Action failed.");
        }
        return "redirect:/student/" + redirect;
    }

    @PostMapping(value = "uploadCV")
    public String uploadCV(HttpServletRequest request, @RequestParam("file") MultipartFile file, @RequestParam("name") String name, @RequestParam("description") String description) {
        if(accountService.checkRole("STUDENT", request)==false)
            return "test";
        HttpSession session = request.getSession();
        Student student = studentService.findByAccount(accountService.currentAccount(request));
        if (cvService.countAllAvailable(student) < 10) {
            //Path currentWorkingDir = Path.of(Paths.get("").toAbsolutePath() + "\\src\\main\\resources\\static\\students");
            Path currentWorkingDir = Path.of(Paths.get("").toAbsolutePath() + "\\target\\classes\\static\\students");
            String path = currentWorkingDir.normalize().toString() + "\\" + student.getId() + "\\CV\\";
            CV newCV = new CV();


            newCV.setStudent(student);
            newCV.setDescription(description);
            newCV.setStatus("Active");
            cvService.save(newCV);

            String filename = file.getOriginalFilename();
            int index = filename.indexOf('.');
            String extension = filename.substring(index + 1, filename.length()).toUpperCase();
            newCV.setName(name + "." + extension);
            name = newCV.getId() + " - " + name + "." + extension;
            /*newCV.setPath("\\src\\main\\resources\\static\\students\\" + String.valueOf(student.getId()) + "\\CV\\" + name + ".pdf");*/
            newCV.setPath("\\students\\" + String.valueOf(student.getId()) + "\\CV\\" + name);
            path += name;

            cvService.save(newCV);
            fileService.saveFile(file, path);
            session.setAttribute("successMessage", "Upload successfully!");
        } else {
            session.setAttribute("dangerMessage", "You are have more than 10 CV. Can not upload any else");
        }
        return "redirect:/student/CVs";
    }

    @PostMapping(value = "updateCV/{cvId}")
    public String updateCV(HttpServletRequest request, @RequestParam("file") MultipartFile file, @RequestParam("description") String description, @PathVariable("cvId") int cvId) {
        if(accountService.checkRole("STUDENT", request)==false)
            return "test";

        HttpSession session = request.getSession();
        Student student = studentService.findByAccount(accountService.currentAccount(request));
        //Path currentWorkingDir = Path.of(Paths.get("").toAbsolutePath() + "\\src\\main\\resources\\static\\students");
        Path currentWorkingDir = Path.of(Paths.get("").toAbsolutePath() + "\\target\\classes\\static\\students");
        String path = currentWorkingDir.normalize().toString() + "\\" + student.getId() + "\\CV\\";
        CV cv = cvService.findById(cvId);
        cv.setDescription(description);
        path += cv.getId() + " - " + cv.getName();
        cvService.save(cv);
        if (file != null && file.isEmpty() == false) {
            fileService.saveFile(file, path);
        }
        session.setAttribute("successMessage", "Update successfully!");
        return "redirect:/student/CVs";
    }

    @PostMapping(value = "removeCV/{cvId}")
    public String removeCV(HttpServletRequest request, @PathVariable("cvId") int cvId) {
        if(accountService.checkRole("STUDENT", request)==false)
            return "test";
        HttpSession session = request.getSession();
        Student student = studentService.findByAccount(accountService.currentAccount(request));
        CV cv = cvService.findById(cvId);
        cv.setStatus("Inactive");
        cvService.save(cv);
        session.setAttribute("successMessage", "Remove successfully!");
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
        return "studentCV";
    }
    @GetMapping(value = "report")
    public String studentReport(ModelMap modelMap, HttpServletRequest request) {
        if(accountService.checkRole("STUDENT", request)==false)
            return "test";
        Iterable <OjtProcess> processList = ojtProcessService.findByStudent(studentService.findByAccount(accountService.currentAccount(request)));
        modelMap.addAttribute("processList", processList);
        return "studentInternshipReport";
    }

    @GetMapping(value = "externalApply")
    public String externalApply(ModelMap modelMap, HttpServletRequest request) {
        if(accountService.checkRole("STUDENT", request)==false)
            return "test";
        Iterable<Position> positionList = positionService.findAll();
        modelMap.addAttribute("positionList", positionList);
        return "studentExternalApply";
    }

    @PostMapping(value = "applyAnExternal")
    public String applyAnExternal(ModelMap modelMap, HttpServletRequest request,
                                  @RequestParam("companyName") String companyName,
                                  @RequestParam("companyEmail") String companyEmail,
                                  @RequestParam("companyPhone") String companyPhone,
                                  @RequestParam("contract") MultipartFile contract,
                                  @RequestParam("letter") MultipartFile letter) {
        if(accountService.checkRole("STUDENT", request)==false)
            return "test";
        HttpSession session = request.getSession();
        Student student = studentService.findByAccount(accountService.currentAccount(request));
        /*Position position = positionService.findById(id);*/
        if (student.getApplicationStatus() == false) {
            ExternalRequest newRequest = new ExternalRequest();
            newRequest.setStudent(student);
            newRequest.setCompanyName(companyName);
            newRequest.setCompanyPhone(companyPhone);
            newRequest.setCompanyEmail(companyEmail);
            StudentApplyJob apply = new StudentApplyJob();
            apply.setStatus("Waiting");
            apply.setStudent(student);
            apply.setSemester(student.getSemester());
            apply.setJob(jobService.firstOfCompany(companyService.findByAccount(accountService.findByEmail(""))));
            Path currentWorkingDir = Path.of(Paths.get("").toAbsolutePath() + "\\target\\classes\\static\\students");
            String path = currentWorkingDir.normalize().toString() + "\\" + student.getId() + "\\Request\\" + newRequest.getId() + "\\";
            File requestFolder = new File(currentWorkingDir + "\\" + student.getId() + "\\Request\\" + newRequest.getId());
            requestFolder.mkdirs();
            String filename = contract.getOriginalFilename();
            int index = filename.indexOf('.');
            String extension = filename.substring(index + 1, filename.length()).toUpperCase();
            fileService.saveFile(contract, path + "contract" + "." + extension);
            newRequest.setContractPath("\\students\\" + student.getId() + "\\Request\\" + newRequest.getId() + "\\" + "contract" + "." + extension);
            filename = letter.getOriginalFilename();
            index = filename.indexOf('.');
            extension = filename.substring(index + 1, filename.length()).toUpperCase();
            fileService.saveFile(letter, path + "letter" + "." + extension);
            newRequest.setLetterPath("\\students\\" + student.getId() + "\\Request\\" + newRequest.getId() + "\\" + "letter" + "." + extension);
            newRequest.setApplication(apply);

            studentApplyJobsService.save(apply);
            externalRequestService.save(newRequest);
            session.setAttribute("successMessage", "Apply successfully!");
        } else {
            session.setAttribute("dangerMessage", "Apply failed. You cannot apply any other job.");
        }
        return "redirect:/student/externalApplications";
    }

    @RequestMapping(value = "/evaluate/{id}", method = RequestMethod.GET)
    public String evaluate(ModelMap modelMap, HttpServletRequest request, @PathVariable("id") int id){
        if(accountService.checkRole("STUDENT", request)==false)
            return "test";
        OjtProcess process = ojtProcessService.findByApplication(studentApplyJobsService.findById(id));
        modelMap.addAttribute("process", process);
        return "viewEvaluate";
    }

}

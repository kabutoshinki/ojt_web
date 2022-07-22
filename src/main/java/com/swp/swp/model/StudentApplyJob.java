package com.swp.swp.model;

import javax.persistence.*;

@Entity
@Table(name="Student_Apply_Job")
public class StudentApplyJob {
    @Id
//    @GeneratedValue( strategy = GenerationType.AUTO)
    @SequenceGenerator(
            name = "saj_sequence",
            sequenceName = "saj_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.AUTO,
            generator = "saj_sequence"
    )
    private int id;
    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "Job_id")
    private Job job;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @Column(name = "status", unique = false, length = 300)
    private String status;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "cv_id")
    private CV cv;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "semester_id")
    private Semester semester;

    @OneToOne(mappedBy = "application")
    private OjtProcess process;

    @OneToOne(mappedBy = "application")
    private ExternalRequest request;

    @Column( unique = false)
    @Lob
    private String message;
    public StudentApplyJob() {
    }

    public StudentApplyJob(Job job, Student student, String status, Semester semester, CV cv) {
        this.job = job;
        this.student = student;
        this.status = status;
        this.semester = semester;
        this.cv = cv;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public CV getCv() {
        return cv;
    }

    public void setCv(CV cv) {
        this.cv = cv;
    }

    public Semester getSemester() {
        return semester;
    }

    public void setSemester(Semester semester) {
        this.semester = semester;
    }

    public OjtProcess getProcess() {
        return process;
    }

    public void setProcess(OjtProcess process) {
        this.process = process;
    }

    public ExternalRequest getRequest() {
        return request;
    }

    public void setRequest(ExternalRequest request) {
        this.request = request;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

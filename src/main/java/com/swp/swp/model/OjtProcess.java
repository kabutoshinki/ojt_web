package com.swp.swp.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "OJT_Process")
public class OjtProcess {
    @Id
    @SequenceGenerator(
        name = "OJT_Process_sequence",
        sequenceName = "OJT_Process_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.AUTO,
        generator = "OJT_Process_sequence"
    )
    private int id; 
    @Column(unique = false, nullable = true)
    private Date startTime;

    @Column(unique = false, nullable = true)
    private Date endTime;
    @Lob
    @Column(unique = false, nullable = true, length = 300)
    private String detail;
    @Column(unique = false, nullable = true)
    private int grade;
    @Column(unique = false, nullable = true)
    private String status;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "application_id")
    private StudentApplyJob application;

    @ManyToOne(fetch = FetchType.LAZY, optional = true, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "company_id")
    private Company company;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "student_id")
    private Student student;
    public OjtProcess() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public StudentApplyJob getApplication() {
        return application;
    }

    public void setApplication(StudentApplyJob application) {
        this.application = application;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}

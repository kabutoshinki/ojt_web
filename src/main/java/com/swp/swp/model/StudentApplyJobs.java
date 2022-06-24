package com.swp.swp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="Student_Apply_Job")
public class StudentApplyJobs {
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
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Job_id")
    private Job job;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "student_id")
    private Account account;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "employee_id")
    private Account employeeAccount;

    @Column(name = "status", unique = false, length = 300)
    private String status;
    @Column(name = "semester", unique = false, length = 30)
    private String semester;

    
    public StudentApplyJobs() {
    }

    
    public StudentApplyJobs(Job job, Account account, Account employeeAccount, String status, String semester) {
        this.job = job;
        this.account = account;
        this.employeeAccount = employeeAccount;
        this.status = status;
        this.semester = semester;
    }


    public StudentApplyJobs(Job job, Account account, String status) {
        this.job = job;
        this.account = account;
        this.status = status;
    }


    public StudentApplyJobs(Job job, Account account, Account employeeAccount, String status) {
        this.job = job;
        this.account = account;
        this.employeeAccount = employeeAccount;
        this.status = status;
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


    public Account getAccount() {
        return account;
    }


    public void setAccount(Account account) {
        this.account = account;
    }


    public Account getEmployeeAccount() {
        return employeeAccount;
    }


    public void setEmployeeAccount(Account employeeAccount) {
        this.employeeAccount = employeeAccount;
    }


    public String getStatus() {
        return status;
    }


    public void setStatus(String status) {
        this.status = status;
    }


    public String getSemester() {
        return semester;
    }


    public void setSemester(String semester) {
        this.semester = semester;
    }


    @Override
    public String toString() {
        return "StudentApplyJobs [account=" + account + ", employeeAccount=" + employeeAccount + ", id=" + id + ", job="
                + job + ", semester=" + semester + ", status=" + status + "]";
    }
    
    

    
}

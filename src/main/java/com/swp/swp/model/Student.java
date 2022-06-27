package com.swp.swp.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "Student")

public class Student {
    @Id
//    @GeneratedValue( strategy = GenerationType.AUTO)
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.AUTO,
            generator = "student_sequence"
    )

    private int id;
    @Column(nullable = true, unique = true, length = 300)
    private String studentId;
    @Column(nullable = true, unique = false)
    private Date dateOfBirth;

    @OneToMany(mappedBy = "student", cascade = CascadeType.PERSIST)
    private Set<StudentApplyJob> jobs = new HashSet<>();

    @OneToMany(mappedBy = "student" ,cascade = CascadeType.PERSIST)
    private Set<CV> cv = new HashSet<>();

    @OneToMany(mappedBy = "student",cascade = CascadeType.REFRESH)
    private Set<OjtProcess> ojt = new HashSet<>();

    @OneToMany(mappedBy = "student",cascade = CascadeType.REFRESH)
    private Set<ExternalRequest> request = new HashSet<>();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id")
    private Account account;


    public Student() {

    }

    public Student(String studentId, Date dateOfBirth, Account account) {
        this.studentId = studentId;
        this.dateOfBirth = dateOfBirth;
        this.account = account;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Set<StudentApplyJob> getJobs() {
        return jobs;
    }

    public void setJobs(Set<StudentApplyJob> jobs) {
        this.jobs = jobs;
    }

    public Set<CV> getCv() {
        return cv;
    }

    public void setCv(Set<CV> cv) {
        this.cv = cv;
    }

    public Set<OjtProcess> getOjt() {
        return ojt;
    }

    public void setOjt(Set<OjtProcess> ojt) {
        this.ojt = ojt;
    }

    public Set<ExternalRequest> getRequest() {
        return request;
    }

    public void setRequest(Set<ExternalRequest> request) {
        this.request = request;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}

package com.swp.swp.model;

import com.swp.swp.service.StudentService;

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
    @Column(nullable = false, unique = true, length = 300)
    private String studentId;
    @Column(nullable = true, unique = false)
    private Date dateOfBirth;

    @Column(nullable = true, unique = false)
    private String gender;

    @OneToMany(mappedBy = "student", cascade = CascadeType.PERSIST)
    private Set<StudentApplyJob> applyList = new HashSet<>();

    @OneToMany(mappedBy = "student" ,cascade = CascadeType.PERSIST)
    private Set<CV> cvList = new HashSet<>();

    @OneToMany(mappedBy = "student",cascade = CascadeType.REFRESH)
    private Set<OjtProcess> processList = new HashSet<>();

    @OneToMany(mappedBy = "student",cascade = CascadeType.REFRESH)
    private Set<ExternalRequest> requestList = new HashSet<>();

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "semester_id")
    private Semester semester;
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

    public boolean getApplicationStatus() {
        for (StudentApplyJob x: this.getApplyList()) {
            if (x.getSemester().equals(this.semester) && (x.getStatus().equalsIgnoreCase("Interning")
                    || x.getStatus().equalsIgnoreCase("Passed")
                    || x.getStatus().equalsIgnoreCase("Not Passed")
                    || x.getStatus().equalsIgnoreCase("Completed")))
                return true;
        }
        return false;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Set<StudentApplyJob> getApplyList() {
        return applyList;
    }

    public void setApplyList(Set<StudentApplyJob> applyList) {
        this.applyList = applyList;
    }

    public Set<CV> getCvList() {
        return cvList;
    }

    public void setCvList(Set<CV> cvList) {
        this.cvList = cvList;
    }

    public Set<OjtProcess> getProcessList() {
        return processList;
    }

    public void setProcessList(Set<OjtProcess> processList) {
        this.processList = processList;
    }

    public Set<ExternalRequest> getRequestList() {
        return requestList;
    }

    public void setRequestList(Set<ExternalRequest> requestList) {
        this.requestList = requestList;
    }

    public Semester getSemester() {
        return semester;
    }

    public void setSemester(Semester semester) {
        this.semester = semester;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

   
}

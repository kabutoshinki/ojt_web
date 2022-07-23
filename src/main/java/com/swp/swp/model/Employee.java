package com.swp.swp.model;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Employee")
public class Employee {
    @Id
    //    @GeneratedValue( strategy = GenerationType.AUTO)
    @SequenceGenerator(
            name = "employee_sequence",
            sequenceName = "employee_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.AUTO,
            generator = "employee_sequence"
    )
    @Column(name = "id")
    private int id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id")
    private Account account;

    @OneToMany(mappedBy = "employee",cascade = CascadeType.REFRESH)
    private Set<ExternalRequest> requestList = new HashSet<>();

    @OneToMany(mappedBy = "employee",cascade = CascadeType.REFRESH)
    private Set<StudentApplyJob> studentApplyList = new HashSet<>();

    @OneToMany(mappedBy = "employee",cascade = CascadeType.REFRESH)
    private Set<Job> jobList = new HashSet<>();

    @OneToMany(mappedBy = "employee",cascade = CascadeType.REFRESH)
    private Set<OjtProcess> processList = new HashSet<>();
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Set<ExternalRequest> getRequestList() {
        return requestList;
    }

    public void setRequestList(Set<ExternalRequest> requestList) {
        this.requestList = requestList;
    }

    public Set<StudentApplyJob> getStudentApplyList() {
        return studentApplyList;
    }

    public void setStudentApplyList(Set<StudentApplyJob> studentApplyList) {
        this.studentApplyList = studentApplyList;
    }

    public Set<Job> getJobList() {
        return jobList;
    }

    public void setJobList(Set<Job> jobList) {
        this.jobList = jobList;
    }

    @Override
    public String toString() {
        return "Employee [account=" + account + ", id=" + id + ", jobList=" + jobList + ", processList=" + processList
                + ", requestList=" + requestList + ", studentApplyList=" + studentApplyList + "]";
    }
    
}

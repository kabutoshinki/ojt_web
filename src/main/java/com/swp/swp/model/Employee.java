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
    private Set<ExternalRequest> requests = new HashSet<>();

    @OneToMany(mappedBy = "employee",cascade = CascadeType.REFRESH)
    private Set<StudentApplyJob> studentApplies = new HashSet<>();

    @OneToMany(mappedBy = "employee",cascade = CascadeType.REFRESH)
    private Set<Job> jobs = new HashSet<>();

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

    public Set<ExternalRequest> getRequests() {
        return requests;
    }

    public void setRequests(Set<ExternalRequest> requests) {
        this.requests = requests;
    }

    public Set<StudentApplyJob> getStudentApplies() {
        return studentApplies;
    }

    public void setStudentApplies(Set<StudentApplyJob> studentApplies) {
        this.studentApplies = studentApplies;
    }

    public Set<Job> getJobs() {
        return jobs;
    }

    public void setJobs(Set<Job> jobs) {
        this.jobs = jobs;
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.swp.swp.model;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;

/**
 *
 * @author ADMIN
 */
@Entity
@Table(name = "Account")

public class Account {
    @Id
//    @GeneratedValue( strategy = GenerationType.AUTO)
    @SequenceGenerator(
            name = "account_sequense",
            sequenceName = "account_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.AUTO,
            generator = "account_sequense"
    )
    
    private int id;
    @Column(nullable = true, unique = false, length = 300)
    private String fullName;
    @Column(nullable = true, unique = true, length = 300)
    private String email;
    @Column(nullable = true, unique = false)
    private Date dateOfBirth;
    @Column(nullable = true, unique = false)
    private String avatar;
    @Column(nullable = true, unique = false, length = 12)
    private String phone;
    @Column(nullable = true, unique = false, length = 300)
    private String address;
    @Column(nullable = true, unique = false, length = 300)
    private String status;
    @Column(nullable = true, unique = false, length = 3)
    private int role;

    @OneToMany(mappedBy = "account", cascade = CascadeType.PERSIST)
    private Set<StudentApplyJobs> jobs = new HashSet<>();

    @OneToMany(mappedBy = "student" ,cascade = CascadeType.PERSIST)
    private Set<CV> cv = new HashSet<>();

    @OneToMany(mappedBy = "student",cascade = CascadeType.REFRESH)
    private Set<OjtProcess> ojt = new HashSet<>();


    public Account(String fullName, String email) {
        this.fullName = fullName;
        this.email = email;
    }
    

    public Account() {
    }


    public Account(int accountId, String fullName, String email, Date dateOfBirth, String phone, String address,
             String status, int role) {
        this.id = accountId;
        this.fullName = fullName;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.phone = phone;
        this.address = address;
        this.status = status;
        this.role = role;
    }

    
    // public Set<Job> getJobs() {
    //     return jobs;
    // }


    // public void setJobs(Set<Job> jobs) {
    //     this.jobs = jobs;
    // }

    

    
    public int getAccountId() {
        return id;
    }

    public String getAvatar() {
        return avatar;
    }


    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }


    public void setAccountId(int accountId) {
        this.id = accountId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Account [accountId=" + id + ", address=" + address + ", dateOfBirth=" + dateOfBirth + ", email="
                + email + ", fullName=" + fullName  + ", phone=" + phone + ", role=" + role
                + ", status=" + status + "]";
    }
    
    
}

package com.swp.swp.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Company")
public class Company implements Serializable{
    @Id
    //    @GeneratedValue( strategy = GenerationType.AUTO)
        @SequenceGenerator(
                name = "company_sequence",
                sequenceName = "company_sequence",
                allocationSize = 1
        )
        @GeneratedValue(
                strategy = GenerationType.AUTO,
                generator = "company_sequence"
        )
    @Column(name = "id")
    private int id;
    @Column(nullable = true, unique = false, length = 1000)
    @Lob
    private String description;

    @OneToMany(mappedBy = "company", cascade = CascadeType.PERSIST)
    private Set<Job> jobList = new HashSet<>();

    @OneToMany(mappedBy = "company", cascade = CascadeType.PERSIST)
    private Set<OjtProcess> processList = new HashSet<>();
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id")
    private Account account;

    public Company() {
    }

    public Company(String description, Account account) {
        this.description = description;
        this.account = account;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return "Company [account=" + account + ", description=" + description + ", id=" + id + ", jobList=" + jobList
                + ", processList=" + processList + "]";
    }
    
}

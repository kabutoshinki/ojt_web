package com.swp.swp.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

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
}

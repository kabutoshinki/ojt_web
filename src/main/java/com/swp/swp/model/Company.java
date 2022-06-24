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
    @Column(nullable = true, unique = false, length = 50)
    private String name;
    @Column(nullable = true, unique = false, length = 1000)
    @Lob
    private String description;
    @Column(nullable = true, unique = false, length = 1000)
    private String address;
    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY,
    cascade = CascadeType.REFRESH)
    @JoinColumn(name = "account_Id", referencedColumnName = "id" ,nullable = true)
    private Account accountId;


    public Company() {
    }

    
    
    



    public Company(String name, String description, String address, Account accountId) {
        this.name = name;
        this.description = description;
        this.address = address;
        this.accountId = accountId;
    }






    public Company(int id, String name, String description, String adress, Account accountId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.address = adress;
        this.accountId = accountId;
    }



    public Company(int companyId, String companyName, String companyDescription, String companyAdress) {
        this.id = companyId;
        this.name = companyName;
        this.description = companyDescription;
        this.address = companyAdress;
    }
    public Company(String companyName, String companyDescription, String companyAdress) {
        this.name = companyName;
        this.description = companyDescription;
        this.address = companyAdress;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Account getAccountId() {
        return accountId;
    }

    public void setAccountId(Account accountId) {
        this.accountId = accountId;
    }

    @Override
    public String toString() {
        return "Company [accountId=" + accountId + ", address=" + address + ", description=" + description + ", id="
                + id + ", name=" + name + "]";
    }


    
    

  

    

}

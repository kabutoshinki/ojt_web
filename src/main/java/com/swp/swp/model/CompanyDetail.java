package com.swp.swp.model;

import java.io.Serializable;
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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.hibernate.annotations.ManyToAny;

@Entity
@Table(name = "Company_Detail")
public class CompanyDetail implements Serializable{
    @Id
    //    @GeneratedValue( strategy = GenerationType.AUTO)
        @SequenceGenerator(
                name = "company_sequense",
                sequenceName = "company_sequence",
                allocationSize = 1
        )
        @GeneratedValue(
                strategy = GenerationType.AUTO,
                generator = "company_sequense"
        )
    @Column(name = "id")
    private int id;
    @Column(nullable = true, unique = false, length = 50)
    private String name;
    @Column(nullable = true, unique = false, length = 1000)
    private String description;
    @Column(nullable = true, unique = false, length = 1000)
    private String adress;
    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY,
    cascade = CascadeType.REFRESH)
    @JoinColumn(name = "account_Id", referencedColumnName = "id" ,nullable = true)
    private Account accountId;


    public CompanyDetail() {
    }

    
    
    



    public CompanyDetail(String name, String description, String adress, Account accountId) {
        this.name = name;
        this.description = description;
        this.adress = adress;
        this.accountId = accountId;
    }






    public CompanyDetail(int id, String name, String description, String adress, Account accountId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.adress = adress;
        this.accountId = accountId;
    }



    public CompanyDetail(int companyDetailId, String companyName, String companyDescription, String companyAdress) {
        this.id = companyDetailId;
        this.name = companyName;
        this.description = companyDescription;
        this.adress = companyAdress;
    }
    public CompanyDetail( String companyName, String companyDescription, String companyAdress) {
        this.name = companyName;
        this.description = companyDescription;
        this.adress = companyAdress;
    }


    public int getCompanyDetailId() {
        return id;
    }


    public void setCompanyDetailId(int companyDetailId) {
        this.id = companyDetailId;
    }


    public String getCompanyName() {
        return name;
    }


    public void setCompanyName(String companyName) {
        this.name = companyName;
    }


    public String getCompanyDescription() {
        return description;
    }


    public void setCompanyDescription(String companyDescription) {
        this.description = companyDescription;
    }


    public String getCompanyAdress() {
        return adress;
    }


    public void setCompanyAdress(String companyAdress) {
        this.adress = companyAdress;
    }

    
    public Account getAccountId() {
        return accountId;
    }


    public void setAccountId(Account accountId) {
        this.accountId = accountId;
    }


    @Override
    public String toString() {
        return "CompanyDetail [accountId=" + accountId + ", adress=" + adress + ", description=" + description + ", id="
                + id + ", name=" + name + "]";
    }


    
    

  

    

}

package com.swp.swp.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

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
    @Column(nullable = true, unique = false, length = 300)
    private String description;
    @Column(nullable = true, unique = false, length = 200)
    private String adress;

    
    public CompanyDetail() {
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


    @Override
    public String toString() {
        return "CompanyDetail [companyAdress=" + adress + ", companyDescription=" + description
                + ", companyDetailId=" + id + ", companyName=" + name + "]";
    }
    

  

    

}

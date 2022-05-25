package com.swp.swp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Company_Detail")
public class CompanyDetail {
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
    private int companyDetailId;
    @Column(nullable = true, unique = false, length = 50)
    private String companyName;
    @Column(nullable = true, unique = false, length = 300)
    private String companyDescription;
    @Column(nullable = true, unique = false, length = 200)
    private String companyAdress;

    
    public CompanyDetail() {
    }


    public CompanyDetail(int companyDetailId, String companyName, String companyDescription, String companyAdress) {
        this.companyDetailId = companyDetailId;
        this.companyName = companyName;
        this.companyDescription = companyDescription;
        this.companyAdress = companyAdress;
    }


    public int getCompanyDetailId() {
        return companyDetailId;
    }


    public void setCompanyDetailId(int companyDetailId) {
        this.companyDetailId = companyDetailId;
    }


    public String getCompanyName() {
        return companyName;
    }


    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }


    public String getCompanyDescription() {
        return companyDescription;
    }


    public void setCompanyDescription(String companyDescription) {
        this.companyDescription = companyDescription;
    }


    public String getCompanyAdress() {
        return companyAdress;
    }


    public void setCompanyAdress(String companyAdress) {
        this.companyAdress = companyAdress;
    }


    @Override
    public String toString() {
        return "CompanyDetail [companyAdress=" + companyAdress + ", companyDescription=" + companyDescription
                + ", companyDetailId=" + companyDetailId + ", companyName=" + companyName + "]";
    }
    

  

    

}

package com.swp.swp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table
public class CompanyDetail {
    @Id
    //    @GeneratedValue( strategy = GenerationType.AUTO)
        @SequenceGenerator(
                name = "company_sequense",
                sequenceName = "account_sequence",
                allocationSize = 1
        )
        @GeneratedValue(
                strategy = GenerationType.AUTO,
                generator = "company_sequense"
        )
    private int companyDetailId;
    
    @Column(nullable = true, unique = false, length = 100)
    private int slot;
    @Column(nullable = true, unique = false, length = 50)
    private String companyName;
    @Column(nullable = true, unique = false, length = 300)
    private String companyDescription;
    @Column(nullable = true, unique = false, length = 200)
    private String companyAdress;
    @Column(nullable = true, unique = false, length = 100)
    private String img;
    @Column(nullable = true, unique = false, length = 100)
    private String jobDescription;
    @Column(nullable = true, unique = false, length = 100)
    private String jobRequirements;

    public CompanyDetail() {
    }

   

    public CompanyDetail( int slot, String companyName, String companyDescription,
            String companyAdress, String img, String jobDescription, String jobRequirements) {
        this.slot = slot;
        this.companyName = companyName;
        this.companyDescription = companyDescription;
        this.companyAdress = companyAdress;
        this.img = img;
        this.jobDescription = jobDescription;
        this.jobRequirements = jobRequirements;
    }



    public int getCompanyDetailId() {
        return companyDetailId;
    }

    public void setCompanyDetailId(int companyDetailId) {
        this.companyDetailId = companyDetailId;
    }

    public int getSlot() {
        return slot;
    }

    public void setSlot(int slot) {
        this.slot = slot;
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

    

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public String getJobRequirements() {
        return jobRequirements;
    }

    public void setJobRequirements(String jobRequirements) {
        this.jobRequirements = jobRequirements;
    }

    @Override
    public String toString() {
        return "CompanyDetail [companyAdress=" + companyAdress + ", companyDescription=" + companyDescription
                + ", companyDetailId=" + companyDetailId + ", companyName=" + companyName + ", img=" + img
                + ", jobDescription=" + jobDescription + ", jobRequirements=" + jobRequirements + ", slot=" + slot
                + "]";
    }


    

}

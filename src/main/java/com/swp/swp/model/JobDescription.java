package com.swp.swp.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Job_Description")
public class JobDescription {
    @Id
    @SequenceGenerator(
            name = "account_sequense",
            sequenceName = "account_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.AUTO,
            generator = "account_sequense"
    )
    private int jobId;
    @Column(nullable = true, unique = false, length = 100)
    private int slot;
    @Column(nullable = true, unique = false, length = 100)
    private String jobDescription;
    @Column(nullable = true, unique = false, length = 100)
    private String jobRequirements;
    @OneToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "companyId", referencedColumnName = "companyDetailId")
    private CompanyDetail companyId;

    
    public JobDescription() {
    }


    public JobDescription(int jobId, int slot, String jobDescription, String jobRequirements, CompanyDetail companyId) {
        this.jobId = jobId;
        this.slot = slot;
        this.jobDescription = jobDescription;
        this.jobRequirements = jobRequirements;
        this.companyId = companyId;
    }


    public int getJobId() {
        return jobId;
    }


    public void setJobId(int jobId) {
        this.jobId = jobId;
    }


    public int getSlot() {
        return slot;
    }


    public void setSlot(int slot) {
        this.slot = slot;
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


    public CompanyDetail getCompanyId() {
        return companyId;
    }


    public void setCompanyId(CompanyDetail companyId) {
        this.companyId = companyId;
    }


    @Override
    public String toString() {
        return "JobDescription [companyId=" + companyId + ", jobDescription=" + jobDescription + ", jobId=" + jobId
                + ", jobRequirements=" + jobRequirements + ", slot=" + slot + "]";
    }
    
}

package com.swp.swp.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Job")
public class Job {
    @Id
    @SequenceGenerator(
        name = "job_sequense",
        sequenceName = "job_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.AUTO,
        generator = "job_sequense"
    )
    @Column(name = "idJob")
    private int idJob;
    @Column(nullable = true, unique = false, length = 100)
    private int slot;
    @Column(nullable = true, unique = false, length = 300)
    private String description;
    @Column(nullable = true, unique = false, length = 300)
    private String requirement;
    @Column(nullable = true, unique = false, length = 2)
    private int status;
    @OneToOne(fetch = FetchType.LAZY,
    cascade = CascadeType.REFRESH)
    @JoinColumn(name = "company_Id", referencedColumnName = "id" ,nullable = false)
    private CompanyDetail companyDetail;

    
    public Job() {
    }


    public Job(CompanyDetail companyDetail) {
        this.companyDetail = companyDetail;
    }

    

    public Job(int slot, String description, String requirement, int status, CompanyDetail companyDetail) {
        this.slot = slot;
        this.description = description;
        this.requirement = requirement;
        this.status = status;
        this.companyDetail = companyDetail;
    }


    public int getIdJob() {
        return idJob;
    }


    public void setIdJob(int idJob) {
        this.idJob = idJob;
    }


    public int getSlot() {
        return slot;
    }


    public void setSlot(int slot) {
        this.slot = slot;
    }


    public String getDescription() {
        return description;
    }


    public void setDescription(String description) {
        this.description = description;
    }


    public String getRequirement() {
        return requirement;
    }


    public void setRequirement(String requirement) {
        this.requirement = requirement;
    }


    public int getStatus() {
        return status;
    }


    public void setStatus(int status) {
        this.status = status;
    }


    public CompanyDetail getCompanyDetail() {
        return companyDetail;
    }


    public void setCompanyDetail(CompanyDetail companyDetail) {
        this.companyDetail = companyDetail;
    }


    @Override
    public String toString() {
        return "Job [companyDetail=" + companyDetail + ", description=" + description + ", idJob=" + idJob
                + ", requirement=" + requirement + ", slot=" + slot + ", status=" + status + "]";
    }

    

    

    
}

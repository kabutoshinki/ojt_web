package com.swp.swp.model;

import java.util.Date;
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
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.sym.Name;

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
    public int idJob;
    @Column(unique = false, length = 100)
    private int slot;
    @Column( unique = false, length = 10000)
    @Lob
    private String description;
    @Column( unique = false, length = 1000)
    @Lob
    private String requirement;
    @Column(unique = false, length = 300)
    private String status;
    @Column(unique = false)
    private String startDate;
    @Column( unique = false)
    private String endDate;
    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY,
    cascade = CascadeType.REFRESH)
    @JoinColumn(name = "company_Id", referencedColumnName = "id" ,nullable = false)
    private CompanyDetail companyDetail;
    
    @OneToMany(mappedBy = "job", cascade = CascadeType.PERSIST)
    private Set<StudentApplyJobs> account = new HashSet<>();

    @ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "position_id")
    private Position position;

    @Transient
    private int positionId;

    
    public Job(int slot, String description, String requirement, String status, String startDate, String endDate,
            CompanyDetail companyDetail, Position position2) {
        this.slot = slot;
        this.description = description;
        this.requirement = requirement;
        this.status = status;
        this.startDate = startDate;
        this.endDate = endDate;
        this.companyDetail = companyDetail;
        this.position = position2;
    }





    public Position getPosition() {
        return position;
    }





    public void setPosition(Position position) {
        this.position = position;
    }





    public int getPositionId() {
        return positionId;
    }


    public void setPositionId(int positionId) {
        this.positionId = positionId;
    }


    public Job() {
    }


    public Job(CompanyDetail companyDetail) {
        this.companyDetail = companyDetail;
    }

    
    
    public Job(int slot, String description, String requirement, String status, String startDate, String endDate,
            CompanyDetail companyDetail) {
        this.slot = slot;
        this.description = description;
        this.requirement = requirement;
        this.status = status;
        this.startDate = startDate;
        this.endDate = endDate;
        this.companyDetail = companyDetail;
    }


    public Job(int slot, String description, String requirement, String status, CompanyDetail companyDetail) {
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

    
    // public Set<Account> getAccount() {
    //     return account;
    // }


    // public void setAccount(Set<Account> account) {
    //     this.account = account;
    // }


    public int getSlot() {
        return slot;
    }



    public String getStartDate() {
        return startDate;
    }


    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }


    public String getEndDate() {
        return endDate;
    }


    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }




    public void setSlot(int slot) {
        this.slot = slot;
    }
    public int getCompanyDetailId(){
        return companyDetail.getCompanyDetailId();
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


    public String getStatus() {
        return status;
    }


    public void setStatus(String status) {
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

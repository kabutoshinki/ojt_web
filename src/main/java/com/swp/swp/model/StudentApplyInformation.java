package com.swp.swp.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Student_Apply_Information")
public class StudentApplyInformation {
    @Id
    @SequenceGenerator(
        name = "student_apply_information_sequence",
        sequenceName = "student_apply_information_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.AUTO,
        generator = "student_apply_information_sequence"
    )
    private int IdSAI;
    @OneToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "account_ID", referencedColumnName = "accountId")
  
    private Account accountId;
    @Column(nullable = true, unique = false,length = 300)
    private String cv;
    @OneToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "comapnyID", referencedColumnName = "companyDetailId")
  
    private CompanyDetail companyId;
    @Column(nullable = true, unique = false,length = 3)
    private int status;

    
    public StudentApplyInformation() {
    }


    public StudentApplyInformation(int idSAI, Account accountId, String cv, CompanyDetail companyId, int status) {
        IdSAI = idSAI;
        this.accountId = accountId;
        this.cv = cv;
        this.companyId = companyId;
        this.status = status;
    }


    public int getIdSAI() {
        return IdSAI;
    }


    public void setIdSAI(int idSAI) {
        IdSAI = idSAI;
    }


    public Account getAccountId() {
        return accountId;
    }


    public void setAccountId(Account accountId) {
        this.accountId = accountId;
    }


    public String getCv() {
        return cv;
    }


    public void setCv(String cv) {
        this.cv = cv;
    }


    public CompanyDetail getCompanyId() {
        return companyId;
    }


    public void setCompanyId(CompanyDetail companyId) {
        this.companyId = companyId;
    }


    public int getStatus() {
        return status;
    }


    public void setStatus(int status) {
        this.status = status;
    }


    @Override
    public String toString() {
        return "StudentApplyInformation [IdSAI=" + IdSAI + ", accountId=" + accountId + ", companyId=" + companyId
                + ", cv=" + cv + ", status=" + status + "]";
    }

    


}

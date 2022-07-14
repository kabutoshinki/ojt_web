package com.swp.swp.model;

import java.sql.Date;
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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Job")
public class Job {
    @Id
    @SequenceGenerator(
        name = "job_sequence",
        sequenceName = "job_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.AUTO,
        generator = "job_sequence"
    )
    @Column(name = "id")
    public int id;
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
    private Date startDate;
    @Column(unique = false)
    private Date endDate;

    @ManyToOne(fetch = FetchType.LAZY, optional = true, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "company_Id")
    private Company company;


    @OneToMany(mappedBy = "job", cascade = CascadeType.PERSIST)
    private Set<StudentApplyJob> applyList = new HashSet<>();

    @ManyToOne(fetch = FetchType.LAZY, optional = true, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "position_id")
    private Position position;

    @ManyToOne(fetch = FetchType.LAZY, optional = true, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "employee_id")
    private Employee employee;
    @Transient
    private int positionId;

    public Job(int slot, String description, String requirement, String status, Date startDate, Date endDate,
               Company company, Position position2, Employee employee) {
        this.slot = slot;
        this.description = description;
        this.requirement = requirement;
        this.status = status;
        this.startDate = startDate;
        this.endDate = endDate;
        this.company = company;
        this.position = position2;
        this.employee = employee;
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


    public Job(Company company) {
        this.company = company;
    }

    
    
    public Job(int slot, String description, String requirement, String status, Date startDate, Date endDate,
            Company company) {
        this.slot = slot;
        this.description = description;
        this.requirement = requirement;
        this.status = status;
        this.startDate = startDate;
        this.endDate = endDate;
        this.company = company;
    }


    public Job(int slot, String description, String requirement, String status, Company company) {
        this.slot = slot;
        this.description = description;
        this.requirement = requirement;
        this.status = status;
        this.company = company;
    }


    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }

    public Set<StudentApplyJob> getApplyList() {
        return applyList;
    }

    public void setApplyList(Set<StudentApplyJob> applyList) {
        this.applyList = applyList;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public int getSlot() {
        return slot;
    }



    public Date getStartDate() {
        return startDate;
    }


    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }


    public Date getEndDate() {
        return endDate;
    }


    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }




    public void setSlot(int slot) {
        this.slot = slot;
    }
    public int getCompanyId(){
        return company.getId();
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


    public Company getCompany() {
        return company;
    }


    public void setCompany(Company company) {
        this.company = company;
    }


    @Override
    public String toString() {
        return "Job [company=" + company + ", description=" + description + ", idJob=" + id
                + ", requirement=" + requirement + ", slot=" + slot + ", status=" + status + "]";
    }
}

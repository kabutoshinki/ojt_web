package com.swp.swp.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "OJT_Process")
public class OjtProcess {
    @Id
    @SequenceGenerator(
        name = "OJT_Process_sequence",
        sequenceName = "OJT_Process_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.AUTO,
        generator = "OJT_Process_sequence"
    )
    private int id; 
    @Column(unique = false, nullable = true)
    private Date startDate;

    @Column(unique = false, nullable = true)
    private Date endDate;
    @Lob
    @Column(unique = false, nullable = true)
    private String detail;
    @Column(unique = false, nullable = true)
    private Double grade;
    @Column(unique = false, nullable = true)
    private String status;

    @Column(unique = false, nullable = true)
    private String description;

    @Column(unique = false, nullable = true)
    private String knowledge;

    @Column(unique = false, nullable = true)
    private int knowledgePoint;
    @Column(unique = false, nullable = true)
    private String softSkill;
    @Column(unique = false, nullable = true)
    private int softSkillPoint;
    @Column(unique = false, nullable = true)
    private String attitude;
    @Column(unique = false, nullable = true)
    private int attitudePoint;

    @Column(unique = false, nullable = true)
    private String message;



    @OneToOne(cascade = CascadeType.ALL, optional = true)
    @JoinColumn(name = "application_id")
    private StudentApplyJob application;

    @ManyToOne(fetch = FetchType.LAZY, optional = true, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "student_id")
    private Student student;
    public OjtProcess() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Double getGrade() {
        return grade;
    }

    public void setGrade(Double grade) {
        this.grade = grade;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getKnowledge() {
        return knowledge;
    }

    public void setKnowledge(String knowledge) {
        this.knowledge = knowledge;
    }

    public int getKnowledgePoint() {
        return knowledgePoint;
    }

    public void setKnowledgePoint(int knowledgePoint) {
        this.knowledgePoint = knowledgePoint;
    }

    public String getSoftSkill() {
        return softSkill;
    }

    public void setSoftSkill(String softSkill) {
        this.softSkill = softSkill;
    }

    public int getSoftSkillPoint() {
        return softSkillPoint;
    }

    public void setSoftSkillPoint(int softSkillPoint) {
        this.softSkillPoint = softSkillPoint;
    }

    public String getAttitude() {
        return attitude;
    }

    public void setAttitude(String attitude) {
        this.attitude = attitude;
    }

    public int getAttitudePoint() {
        return attitudePoint;
    }

    public void setAttitudePoint(int attitudePoint) {
        this.attitudePoint = attitudePoint;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public StudentApplyJob getApplication() {
        return application;
    }

    public void setApplication(StudentApplyJob application) {
        this.application = application;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    /*@Override
    public String toString() {
        return "OjtProcess{" +
                "id=" + id +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", detail='" + detail + '\'' +
                ", grade=" + grade +
                ", status='" + status + '\'' +
                ", description='" + description + '\'' +
                ", knowledge='" + knowledge + '\'' +
                ", knowledgePoint=" + knowledgePoint +
                ", softSkill='" + softSkill + '\'' +
                ", softSkillPoint=" + softSkillPoint +
                ", attitude='" + attitude + '\'' +
                ", attitudePoint=" + attitudePoint +
                ", message='" + message + '\'' +
                ", application=" + application +
                ", employee=" + employee +
                ", student=" + student +
                '}';
    }*/
}

package com.swp.swp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

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
    @Column(unique = false, nullable = false, length = 300)
    private int week;
    @Lob
    @Column(unique = false, nullable = false, length = 300)
    private String detail;
    @Column(unique = false, nullable = false, length = 300)
    private int grade;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "student_id")
    private Student student;

    public OjtProcess() {
    }

    public OjtProcess(int week, String detail, int grade) {
        this.week = week;
        this.detail = detail;
        this.grade = grade;
    }

    public OjtProcess(int week, String detail, int grade, Student student) {
        this.week = week;
        this.detail = detail;
        this.grade = grade;
        this.student = student;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getWeek() {
        return week;
    }

    public void setWeek(int week) {
        this.week = week;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}

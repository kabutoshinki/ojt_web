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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "CV")
public class CV {
    @Id
    @SequenceGenerator(
        name = "cv_sequence",
        sequenceName = "cv_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.AUTO,
        generator = "cv_sequence"
    )
    private int id;
    
    @Column(nullable = true, unique = false, length = 300)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "student_id")
    private Student student;
    
    
    public CV() {
    }



    public CV(String name) {
        this.name = name;
    }
    

    public CV(String name, Student student) {
        this.name = name;
        this.student = student;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}

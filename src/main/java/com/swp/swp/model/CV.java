package com.swp.swp.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

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

    @Column(nullable = true, unique = false, length = 300)
    private String desciption;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "student_id")
    private Student student;

    @OneToMany(mappedBy = "cv", cascade = CascadeType.PERSIST)
    private Set<StudentApplyJob> jobs = new HashSet<>();
    
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

package com.swp.swp.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="Semester")
public class Semester {
    @Id
    //    @GeneratedValue( strategy = GenerationType.AUTO)
    @SequenceGenerator(
            name = "semester_sequence",
            sequenceName = "semester_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.AUTO,
            generator = "semester_sequence"
    )
    private int id;

    @Column( unique = false, length = 300)
    private String semester;

    @Column( unique = false)
    private int year;
    @OneToMany(mappedBy = "semester", cascade = CascadeType.REFRESH)
    private Set<Student> studentList = new HashSet<>();
    @OneToMany(mappedBy = "semester", cascade = CascadeType.REFRESH)
    private Set<StudentApplyJob> applyList = new HashSet<>();

    public Semester() {
    }


    public Semester(String semester, int year) {
        this.semester = semester;
        this.year = year;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSemester() {
        return semester + " - " + year;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Set<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(Set<Student> studentList) {
        this.studentList = studentList;
    }

    public Set<StudentApplyJob> getApplyList() {
        return applyList;
    }

    public void setApplyList(Set<StudentApplyJob> applyList) {
        this.applyList = applyList;
    }
}

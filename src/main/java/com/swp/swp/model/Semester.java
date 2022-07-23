package com.swp.swp.model;

import javax.persistence.*;
import java.sql.Date;
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

    @Column(unique = false, nullable = true)
    private Date startDate;

    @Column(unique = false, nullable = true)
    private Date endDate;
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

    public Semester getNextSemester() {
        Semester nextSemester = new Semester();
        nextSemester.setYear(this.year);
        if (this.semester.equals("Spring")) {
            nextSemester.setSemester("Summer");
        }
        if (this.semester.equals("Summer")) {
            nextSemester.setSemester("Fall");
        }
        if (this.semester.equals("Fall")) {
            nextSemester.setSemester("Spring");
            nextSemester.setYear(this.year + 1);
        }
        return nextSemester;
    }


    @Override
    public String toString() {
        return "Semester [applyList=" + applyList + ", endDate=" + endDate + ", id=" + id + ", semester=" + semester
                + ", startDate=" + startDate + ", studentList=" + studentList + ", year=" + year + "]";
    }

    

}

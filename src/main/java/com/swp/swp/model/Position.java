package com.swp.swp.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="Position")
public class Position {
    @Id
    //    @GeneratedValue( strategy = GenerationType.AUTO)
    @SequenceGenerator(
            name = "position_sequence",
            sequenceName = "position_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.AUTO,
            generator = "position_sequence"
    )
    private int id;

    @Column( unique = true, length = 300)
    private String position;
    @OneToMany(mappedBy = "position", cascade = CascadeType.REFRESH)
    private Set<Job> jobList = new HashSet<>();

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "major_id")
    private Major major;

    public Position() {
    }


    public Position(String position) {
        this.position = position;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Set<Job> getJobList() {
        return jobList;
    }

    public ArrayList<Job> getAvailableJobList() {
        ArrayList<Job> jobs = new ArrayList<>();
        java.util.Date date = new java.util.Date();
        java.sql.Date currentDate = new Date(date.getTime());

        for (Job x: jobList) {
            if (x.getStatus().equals("Accepted") == true &&
                    x.getEndDate().compareTo(currentDate) >= 0 &&
                    x.getStartDate().compareTo(currentDate) <= 0) {
                jobs.add(x);
            }
        }
        return jobs;
    }



    public void setJobList(Set<Job> jobList) {
        this.jobList = jobList;
    }

    public Major getMajor() {
        return major;
    }

    public void setMajor(Major major) {
        this.major = major;
    }
}

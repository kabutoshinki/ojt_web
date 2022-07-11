package com.swp.swp.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Major")
public class Major {
    @Id
    //    @GeneratedValue( strategy = GenerationType.AUTO)
        @SequenceGenerator(
                name = "major_sequence",
                sequenceName = "major_sequence",
                allocationSize = 1
        )
        @GeneratedValue(
                strategy = GenerationType.AUTO,
                generator = "major_sequence"
        )
    private int id;

    @Column(nullable = true ,unique = false, length = 300)
    private String major;

    @OneToMany(cascade = CascadeType.PERSIST)
    private Set<Position> positionList = new HashSet<>();

    
    public Major() {
    }


    public Major(String major) {
        this.major = major;
    }


    public String getMajor() {
        return major;
    }


    public void setMajor(String major) {
        this.major = major;
    }


    public Set<Position> getPositionList() {
        return positionList;
    }


    public void setPositionList(Set<Position> positionList) {
        this.positionList = positionList;
    }


    
}

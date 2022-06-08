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
@Table(name = "Major_Table")
public class Major {
    @Id
    //    @GeneratedValue( strategy = GenerationType.AUTO)
        @SequenceGenerator(
                name = "major_sequense",
                sequenceName = "major_sequence",
                allocationSize = 1
        )
        @GeneratedValue(
                strategy = GenerationType.AUTO,
                generator = "major_sequense"
        )
    private int id;

    @Column(nullable = true ,unique = false, length = 300)
    private String major;

    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "position_id",referencedColumnName = "id")
    private Set<Position> position = new HashSet<>();

    
    public Major() {
    }


    public Major(String major) {
        this.major = major;
    }


    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }


    public String getMajor() {
        return major;
    }


    public void setMajor(String major) {
        this.major = major;
    }


    public Set<Position> getPosition() {
        return position;
    }


    public void setPosition(Set<Position> position) {
        this.position = position;
    }
    

    
}
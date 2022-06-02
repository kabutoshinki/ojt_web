package com.swp.swp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "CV")
public class CV {
    @Id
    @SequenceGenerator(
        name = "cv_sequense",
        sequenceName = "cv_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.AUTO,
        generator = "cv_sequense"
    )
    private int id;
    
    @Column(nullable = true, unique = false, length = 300)
    private String name;
    
    
    public CV() {
    }


    public CV(String name) {
        this.name = name;
    }
    
}

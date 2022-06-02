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
@Table(name="position_table")
public class Position {
    @Id
    //    @GeneratedValue( strategy = GenerationType.AUTO)
        @SequenceGenerator(
                name = "position_sequense",
                sequenceName = "position_sequence",
                allocationSize = 1
        )
        @GeneratedValue(
                strategy = GenerationType.AUTO,
                generator = "position_sequense"
        )
        private int id;
        
        @Column(nullable = true, unique = false, length = 300)
        private String positon;
        @OneToMany(cascade = CascadeType.PERSIST)
        @JoinColumn(name = "position_id",referencedColumnName = "id")
        private Set<Job> jobs = new HashSet<>();
        
        public Position() {
        }


        public Position(String positon) {
            this.positon = positon;
        }


        public int getId() {
            return id;
        }


        public void setId(int id) {
            this.id = id;
        }


        public String getPositon() {
            return positon;
        }


        public void setPositon(String positon) {
            this.positon = positon;
        }


        public Set<Job> getJobs() {
            return jobs;
        }


        public void setJobs(Set<Job> jobs) {
            this.jobs = jobs;
        }

        
}

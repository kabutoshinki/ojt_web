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
                name = "position_sequence",
                sequenceName = "position_sequence",
                allocationSize = 1
        )
        @GeneratedValue(
                strategy = GenerationType.AUTO,
                generator = "position_sequence"
        )
        private int id;
        
        @Column( unique = false, length = 300)
        private String position;
        @OneToMany(mappedBy = "position", cascade = CascadeType.REFRESH)
        private Set<Job> job = new HashSet<>();
        
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



        
}

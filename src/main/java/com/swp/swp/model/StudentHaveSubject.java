package com.swp.swp.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "student_have_subject")
public class StudentHaveSubject {
    @Id
    //    @GeneratedValue( strategy = GenerationType.AUTO)
        @SequenceGenerator(
                name = "subject_sequense",
                sequenceName = "subject_sequence",
                allocationSize = 1
        )
        @GeneratedValue(
                strategy = GenerationType.AUTO,
                generator = "subject_sequense"
        )
    private int ssId;
    @OneToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "accountId", referencedColumnName = "accountId")
    private Account accountId;
    @OneToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name="subjectId",referencedColumnName = "subjectId")
    private Subject subjectId;
    @Column(nullable = true, unique = false, length = 4)
    private int status;
    @Column(nullable = true, unique = false,length = 2)
    private int mainSubject;

    
}

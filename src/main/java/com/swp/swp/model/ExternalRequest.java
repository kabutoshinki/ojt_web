package com.swp.swp.model;


import javax.persistence.*;

@Entity
@Table(name = "ExternalRequest")
public class ExternalRequest {
    @Id
//    @GeneratedValue( strategy = GenerationType.AUTO)
    @SequenceGenerator(
            name = "external_request_sequence",
            sequenceName = "external_request_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.AUTO,
            generator = "external_request_sequence"
    )

    private int id;

    @Column(nullable = true ,unique = false, length = 300)
    private String companyName;

    @Column(nullable = true ,unique = false, length = 300)
    private String companyEmail;

    @Column(nullable = true ,unique = false, length = 300)
    private String companyPhone;

    @Column(nullable = true ,unique = false, length = 300)
    private String contractPath;

    @Column(nullable = true ,unique = false, length = 300)
    private String letterPath;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @OneToOne(cascade = CascadeType.ALL, optional = true)
    @JoinColumn(name = "application_id")
    private StudentApplyJob application;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public StudentApplyJob getApplication() {
        return application;
    }

    public void setApplication(StudentApplyJob application) {
        this.application = application;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyEmail() {
        return companyEmail;
    }

    public void setCompanyEmail(String companyEmail) {
        this.companyEmail = companyEmail;
    }

    public String getCompanyPhone() {
        return companyPhone;
    }

    public void setCompanyPhone(String companyPhone) {
        this.companyPhone = companyPhone;
    }

    public String getContractPath() {
        return contractPath;
    }

    public void setContractPath(String contractPath) {
        this.contractPath = contractPath;
    }

    public String getLetterPath() {
        return letterPath;
    }

    public void setLetterPath(String letterPath) {
        this.letterPath = letterPath;
    }

    @Override
    public String toString() {
        return "ExternalRequest [application=" + application + ", companyEmail=" + companyEmail + ", companyName="
                + companyName + ", companyPhone=" + companyPhone + ", contractPath=" + contractPath + ", employee="
                + employee + ", id=" + id + ", letterPath=" + letterPath + ", student=" + student + "]";
    }
    

}

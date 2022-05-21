/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.swp.swp.model;

import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author ADMIN
 */
@Entity
@Table
public class Account {
    @Id
//    @GeneratedValue( strategy = GenerationType.AUTO)
    @SequenceGenerator(
            name = "account_sequense",
            sequenceName = "account_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.AUTO,
            generator = "account_sequense"
    )
    
    private int accountId;
    @Column(nullable = false, unique = false, length = 300)
    private String fullName;
    @Column(nullable = true, unique = true, length = 300)
    private String email;
    @Column(nullable = true, unique = false, length = 300)
    private String password;
    @Column(nullable = true, unique = false)
    private Date dateOfBirth;
    @Column(nullable = true, unique = false, length = 12)
    private String phone;
    @Column(nullable = true, unique = false, length = 300)
    private String street;
    @Column(nullable = true, unique = false, length = 300)
    private String city;
    @Column(nullable = true, unique = false, length = 300)
    private String district;
    @Column(nullable = true, unique = false, length = 300)
    private String province;
    @Column(nullable = true, unique = false, length = 3)
    private int status;
    @Column(nullable = true, unique = false, length = 3)
    private int role;

    public Account(String fullName, String email, String password) {
        this.fullName = fullName;
        this.email = email;
        this.password = password;
    }
    public Account(String fullName, String email, String password, Date dateOfBirth, String phone, String street, String city, String district, String province, int status, int role) {
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.dateOfBirth = dateOfBirth;
        this.phone = phone;
        this.street = street;
        this.city = city;
        this.district = district;
        this.province = province;
        this.status = status;
        this.role = role;
    }

    public Account() {
    }

    public Account(int accountId, String fullName, String email, String password, Date dateOfBirth, String phone, String street, String city, String district, String province, int status, int role) {
        this.accountId = accountId;
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.dateOfBirth = dateOfBirth;
        this.phone = phone;
        this.street = street;
        this.city = city;
        this.district = district;
        this.province = province;
        this.status = status;
        this.role = role;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Account{" + "accountId=" + accountId + ", fullName=" + fullName + ", email=" + email + ", password=" + password + ", dateOfBirth=" + dateOfBirth + ", phone=" + phone + ", street=" + street + ", city=" + city + ", district=" + district + ", province=" + province + ", status=" + status + ", role=" + role + '}';
    }
    
}

package com.swp.swp.model;

import java.sql.Date;
import java.util.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Builder;


/**
 *
 * @author ADMIN
 */
@Entity
@Builder
@Table(name = "Account")

public class Account implements UserDetails {
    @Id
//    @GeneratedValue( strategy = GenerationType.AUTO)
    @SequenceGenerator(
            name = "account_sequence",
            sequenceName = "account_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.AUTO,
            generator = "account_sequence"
    )
    
    private int id;
    @Column(nullable = true, unique = false, length = 300)
    private String fullName;
    @Column(nullable = true, unique = true, length = 300)
    private String email;
    @Column(nullable = true, unique = false, length = 12)
    private String phone;
    @Column(nullable = true, unique = false, length = 300)
    private String address;

    @Column(nullable = true, unique = false, length = 300)
    private String status;

    @Column(nullable = true, unique = false, length = 300)
    private String role;

    @OneToOne(mappedBy = "account")
    private Company company;

    @OneToOne(mappedBy = "account")
    private Employee employee;
    public Account() {
    }

    public Account(int id, String fullName, String email, String phone, String address, String status, String role) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.status = status;
        this.role = role;
    }

    public Account(String fullName, String email, String role) {
        this.fullName = fullName;
        this.email = email;
        this.role = role;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
 
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
 
 
        authorities.add(new SimpleGrantedAuthority(role));
 
 
        return authorities;
    }


    @Override
    public String getPassword() {
        return null;
    }


    @Override
    public String getUsername() {
        return this.fullName;
    }


    @Override
    public boolean isAccountNonExpired() {
        return true;
    }


    @Override
    public boolean isAccountNonLocked() {
        return true;
    }


    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }


    @Override
    public boolean isEnabled() {
        return true;
    }
    
    
}

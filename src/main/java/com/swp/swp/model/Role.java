package com.swp.swp.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Role")
public class Role {
    @Id
    //    @GeneratedValue( strategy = GenerationType.AUTO)
    @SequenceGenerator(
            name = "role_sequence",
            sequenceName = "role_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.AUTO,
            generator = "role_sequence"
    )
    @Column(name = "id")
    private int id;
    @Column(nullable = true, unique = false, length = 1000)
    private String roleName;

    @OneToMany(mappedBy = "role" ,cascade = CascadeType.PERSIST)
    private Set<Account> accounts = new HashSet<>();

    public Role() {
    }

    public Role(String name) {
        this.roleName = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Set<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(Set<Account> accounts) {
        this.accounts = accounts;
    }
}

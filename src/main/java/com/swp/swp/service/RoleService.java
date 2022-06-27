package com.swp.swp.service;


import com.swp.swp.model.Account;
import com.swp.swp.model.Role;
import com.swp.swp.repositories.RoleRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class RoleService {
    @Autowired
    private RoleRepositories roleRepositories;

    public Role getRole(String roleName) {
        return roleRepositories.findByRoleName(roleName);
    }
    public Iterable<Account> findByRoleName(String roleName) {
        return roleRepositories.findByRoleName(roleName).getAccounts();
    }
}

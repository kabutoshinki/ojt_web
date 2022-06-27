package com.swp.swp.repositories;

import com.swp.swp.model.Company;
import com.swp.swp.model.Job;
import com.swp.swp.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepositories extends JpaRepository<Role,Integer> {
    Role findByRoleName(String roleName);

}

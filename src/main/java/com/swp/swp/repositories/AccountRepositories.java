/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.swp.swp.repositories;

import com.swp.swp.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author ADMIN
 */
public interface AccountRepositories extends JpaRepository<Account,Integer>{
    Account findByEmailAndPassword(String email, String password);
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demoMVC.repository;

import com.example.demoMVC.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Tesla
 */
public interface UserRepository extends JpaRepository<User, Long> {
    // Consultas personalizadas opcionales
    User findByEmail(String email);
}

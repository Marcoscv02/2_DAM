/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demoMVC.controllers;

import com.example.demoMVC.model.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Tesla
 */
@RestController
public class ApiController {

    @PostMapping("/api/userdemo")
    public String createUser(@RequestBody User user) {
        return "Usuario creado: " + user.getUsername() + ", Email: " + user.getEmail();
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demoMVC.controllers;

import com.example.demoMVC.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Tesla
 */
@Controller
public class FormController {

    @PostMapping("/submitForm")
    public String handleForm(@RequestParam("username") String username,
            @RequestParam("email") String email, Model model) {
        model.addAttribute("message", "Usuario: " + username + ", Email: " + email);
        return "formResponse"; // Vista que mostrará los datos enviados
    }

    @PostMapping("/submitFormConClass")
    public String handleForm(User user, Model model) {
        model.addAttribute("message", "Usuario: " + user.getUsername() + ", Email: " + user.getEmail());
        return "formResponse";
    }
}

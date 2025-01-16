/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demoMVC.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Tesla
 */
@RestController
public class TestController {

    @GetMapping("/public/hello")
    public String publicEndpoint() {
        return "¡Este es un endpoint público!";
    }

    @GetMapping("/private/hello")
    public String privateEndpoint() {
        return "¡Este es un endpoint privado, necesitas autenticación!";
    }

    @GetMapping("/admin/hello")
    public String adminEndpoint() {
        return "¡Este es un endpoint privado, solo accesible para administradores!";
    }
}
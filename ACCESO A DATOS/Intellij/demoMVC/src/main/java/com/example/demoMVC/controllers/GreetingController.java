/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demoMVC.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Tesla
 */
@Controller
public class GreetingController {
    
    @RequestMapping("/greeting")
    public String greeting(Model model) {
        model.addAttribute("message", "¡Hola desde Spring MVC!");
        return "greeting"; // Nombre de la vista que se renderiza
    }
    
    @GetMapping("/greetingName")
    public String greeting(@RequestParam(name = "name", defaultValue = "Mundo") String name, Model model) {
        model.addAttribute("message", "¡Hola, " + name + "!");
        return "greeting"; // Vista que se mostrará
    }
}

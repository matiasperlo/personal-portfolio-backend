/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.matiasperlo.portfolio.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


/**
 *
 * @author matia
 */
@Controller //Se debe usar Controller en vez de RestController para las views
public class AppController {
    
    @GetMapping("/") // puede usarse cualquier annotation de mapping
    public String app(){
        return "index.html"; //  html en static/ o public/
    }
    
    @GetMapping("/pruebaget") 
    public String prueba_get(){
        return "getme.html"; 
    }
}

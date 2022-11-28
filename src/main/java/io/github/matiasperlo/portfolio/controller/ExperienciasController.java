/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.matiasperlo.portfolio.controller;

import io.github.matiasperlo.portfolio.dto.ResponseMessage;
import io.github.matiasperlo.portfolio.model.Experiencia;
import io.github.matiasperlo.portfolio.service.ExperienciaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author matia
 */
@RestController
@RequestMapping("/api/experiencias")
public class ExperienciasController {
    
    @Autowired
    private ExperienciaService experienciaService;
            
    @GetMapping("/all")
    public List<Experiencia> getAllExperiencias(){
        return experienciaService.getExperiencias();
    }
    
    @GetMapping("/{id}")
    public Experiencia getExperienciaById(@PathVariable int id){
        return experienciaService.getExperienciaById(id);
    }
    
    @PostMapping("/register")
    public ResponseEntity<?> registrarExperiencia(@RequestBody Experiencia exp){
        experienciaService.registrarExperiencia(exp);
        return ResponseEntity.ok(new ResponseMessage("alta realizada con exito"));
    }
    
    @PutMapping("/edit/{id}")
    public ResponseEntity<?> modificarExperiencia(
            @PathVariable int id, 
            @RequestBody Experiencia exp){
        
        if(id != exp.getId() || experienciaService.getExperienciaById(id) == null){
            return ResponseEntity.ok(new ResponseMessage("experiencia no existe"));
        }
        
        experienciaService.registrarExperiencia(exp);
        return ResponseEntity.ok(new ResponseMessage("modificacion realizada con exito"));

    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> eliminarExperiencia(@PathVariable int id){
        //TODO: completar
        return ResponseEntity.ok(new ResponseMessage("baja realizada con exito"));

    }
    
}

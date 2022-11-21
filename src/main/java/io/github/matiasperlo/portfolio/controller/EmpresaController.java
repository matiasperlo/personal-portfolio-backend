/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.matiasperlo.portfolio.controller;

import io.github.matiasperlo.portfolio.model.Empresa;
import io.github.matiasperlo.portfolio.service.EmpresaService;
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
@RequestMapping("/api/empresa")
public class EmpresaController {
    
    @Autowired
    private EmpresaService currentService;
    
    @GetMapping("/all")
    public List<Empresa> getAll(){
        return currentService.getAll();
    }
    
    @GetMapping("/{id}")
    public Empresa getOne(@PathVariable Integer id){
        return currentService.findOne(id);
    }
    
    @PostMapping("/register")
    public ResponseEntity<?> create(@RequestBody Empresa user){
        currentService.save(user);
        return ResponseEntity.ok("el usuario fue creado satisfactoriamente");
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){
        currentService.delete(id);
        return ResponseEntity.ok("la persona fue eliminada con exito");
    }
    
    @PutMapping("/edit/{id}")
    public ResponseEntity<?> modificar(
            @PathVariable int id, 
            @RequestBody Empresa exp){
        
        if(id != exp.getId() || currentService.findOne(id) == null){
            return ResponseEntity.ok("experiencia no existe");
        }
        
        currentService.save(exp);
        return ResponseEntity.ok("modificacion realizada con exito");

    }
}

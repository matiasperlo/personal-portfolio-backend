/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.matiasperlo.portfolio.controller;

import io.github.matiasperlo.portfolio.dto.ResponseMessage;
import io.github.matiasperlo.portfolio.model.Proyecto;
import io.github.matiasperlo.portfolio.service.ProyectoService;
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
@RequestMapping("/api/proyecto")
public class ProyectoController {
    
    @Autowired
    private ProyectoService currentService;
    
    @GetMapping("/all")
    public List<Proyecto> getAll(){
        return currentService.getAll();
    }
    
    @GetMapping("/{id}")
    public Proyecto getOne(@PathVariable Integer id){
        return currentService.findOne(id);
    }
    
    @PostMapping("/register")
    public ResponseEntity<?> create(@RequestBody Proyecto user){
        currentService.save(user);
        return ResponseEntity.ok(new ResponseMessage("el Proyecto fue creado satisfactoriamente"));
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){
        currentService.delete(id);
        return ResponseEntity.ok(new ResponseMessage("el Proyecto fue eliminado con exito"));
    }
    
    @PutMapping("/edit/{id}")
    public ResponseEntity<?> modificar(
            @PathVariable int id, 
            @RequestBody Proyecto exp){
        
        if(id != exp.getId() || currentService.findOne(id) == null){
            return ResponseEntity.ok(new ResponseMessage("Proyecto no existe"));
        }
        
        currentService.save(exp);
        return ResponseEntity.ok(new ResponseMessage("modificacion realizada con exito"));

    }
}

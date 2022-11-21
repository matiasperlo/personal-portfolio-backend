/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.matiasperlo.portfolio.controller;

import io.github.matiasperlo.portfolio.model.Rol;
import io.github.matiasperlo.portfolio.service.RolService;
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
@RequestMapping("/api/rol")
public class RolController {
    
    @Autowired
    private RolService rolService;
    
    @GetMapping("/all")
    public List<Rol> getRoles(){
        return rolService.getRoles();
    }
    
    @GetMapping("/{id}")
    public Rol getRol(@PathVariable Integer id){
        return rolService.findRol(id);
    }
    
    @PostMapping("/register")
    public ResponseEntity<?> createRol(@RequestBody Rol user){
        rolService.saveRol(user);
        return ResponseEntity.ok("el usuario fue creado satisfactoriamente");
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteRol(@PathVariable Integer id){
        rolService.deleteRol(id);
        return ResponseEntity.ok("la persona fue eliminada con exito");
    }
    
    @PutMapping("/edit/{id}")
    public ResponseEntity<?> modificarRol(
            @PathVariable int id, 
            @RequestBody Rol exp){
        
        if(id != exp.getId() || rolService.findRol(id) == null){
            return ResponseEntity.ok("experiencia no existe");
        }
        
        rolService.saveRol(exp);
        return ResponseEntity.ok("modificacion realizada con exito");

    }
}

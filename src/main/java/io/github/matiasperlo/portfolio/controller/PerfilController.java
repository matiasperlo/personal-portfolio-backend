/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.matiasperlo.portfolio.controller;


import io.github.matiasperlo.portfolio.dto.ResponseMessage;
import io.github.matiasperlo.portfolio.model.Perfil;
import io.github.matiasperlo.portfolio.service.PerfilService;
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
@RequestMapping("/api/perfil")
public class PerfilController {
    
    @Autowired
    private PerfilService currentService;
    
    @GetMapping("/all")
    public List<Perfil> getAll(){
        return currentService.getAll();
    }
    
    @GetMapping("/{id}")
    public Perfil getOne(@PathVariable Integer id){
        return currentService.findOne(id);
    }
    
    @PostMapping("/register")
    public ResponseEntity<?> create(@RequestBody Perfil user){
        currentService.save(user);
        return ResponseEntity.ok(new ResponseMessage("el usuario fue creado satisfactoriamente"));
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){
        currentService.delete(id);
        return ResponseEntity.ok(new ResponseMessage("la persona fue eliminada con exito"));
    }
    
    @PutMapping("/edit/{id}")
    public ResponseEntity<?> modificar(
            @PathVariable int id, 
            @RequestBody Perfil exp){
        
        if(id != exp.getId() || currentService.findOne(id) == null){
            return ResponseEntity.ok(new ResponseMessage("experiencia no existe"));
        }
        
        currentService.save(exp);
        return ResponseEntity.ok(new ResponseMessage("modificacion realizada con exito"));

    }
}

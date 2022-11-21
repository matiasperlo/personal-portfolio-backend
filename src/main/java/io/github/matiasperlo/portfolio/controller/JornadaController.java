/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.matiasperlo.portfolio.controller;

import io.github.matiasperlo.portfolio.model.Jornada;
import io.github.matiasperlo.portfolio.service.JornadaService;
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
@RequestMapping("/api/jornadas")
public class JornadaController {
    
    @Autowired
    private JornadaService jornadaService;
            
    @GetMapping("/all")
    public List<Jornada> getAllJornadas(){
        return jornadaService.getJornadas();
    }
    
    @GetMapping("/{id}")
    public Jornada getJornadaById(@PathVariable int id){
        return jornadaService.findJornada(id);
    }
    
    @PostMapping("/register")
    public ResponseEntity<?> registrarJornada(@RequestBody Jornada jorn){
        jornadaService.saveJornada(jorn);
        return ResponseEntity.ok("alta realizada con exito");
    }
    
    @PutMapping("/edit/{id}")
    public ResponseEntity<?> modificarJornada(
            @PathVariable int id, 
            @RequestBody Jornada jorn){
        
        if(id != jorn.getId() || jornadaService.findJornada(id) == null){
            return ResponseEntity.ok("experiencia no existe");
        }
        
        jornadaService.saveJornada(jorn);
        return ResponseEntity.ok("modificacion realizada con exito");

    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> eliminarJornada(@PathVariable int id){
        return ResponseEntity.ok("baja realizada con exito");

    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.matiasperlo.portfolio.Controller;

import java.util.List;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import io.github.matiasperlo.portfolio.Service.IInstitucionService;
import io.github.matiasperlo.portfolio.Model.Institucion;
/**
 *
 * @author matia
 */

@RestController
public class InstitucionController {
    
    @Autowired
    private IInstitucionService interInstitucion;
    
    @GetMapping("/institucion/all")
    public List<Institucion> getInstituciones(){
        return interInstitucion.getInstituciones();
    }
    
    @PutMapping("/institucion/edit/{id}")
    public String editInstitucion(@PathVariable Long id){
        // TODO: leer los campos editados
        return "alta facha";
    }
}

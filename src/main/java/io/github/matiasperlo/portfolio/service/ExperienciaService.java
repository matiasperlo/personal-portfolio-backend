/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.matiasperlo.portfolio.service;

import io.github.matiasperlo.portfolio.dao.ExperienciaDAO;
import io.github.matiasperlo.portfolio.model.Experiencia;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author matia
 */
@Service
public class ExperienciaService {
    
    @Autowired
    private ExperienciaDAO experienciaDAO;
    
    public List<Experiencia> getExperiencias(){
       return experienciaDAO.findAll();
    }

    public Experiencia getExperienciaById(int id) {
       return experienciaDAO.findById(id).orElse(null);
    }

    public void registrarExperiencia(Experiencia exp) {
       experienciaDAO.save(exp);
    }
    
    public void deleteExperiencia(Integer id){
       experienciaDAO.deleteById(id);
    }
}

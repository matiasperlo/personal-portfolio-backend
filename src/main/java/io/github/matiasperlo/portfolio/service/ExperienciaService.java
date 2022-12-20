/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.matiasperlo.portfolio.service;

import io.github.matiasperlo.portfolio.dao.EmpresaDAO;
import io.github.matiasperlo.portfolio.dao.ExperienciaDAO;
import io.github.matiasperlo.portfolio.dao.JornadaDAO;
import io.github.matiasperlo.portfolio.dao.PuestoDAO;
import io.github.matiasperlo.portfolio.dao.RolDAO;
import io.github.matiasperlo.portfolio.model.Empresa;
import io.github.matiasperlo.portfolio.model.Experiencia;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
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
    
    @Autowired 
    private EmpresaDAO empresaDAO;
    
    @Autowired
    private PuestoDAO puestoDAO;
    
    @Autowired 
    private JornadaDAO jornadaDAO;
    
    public List<Experiencia> getExperiencias(){
       return experienciaDAO.findAll();
    }

    public Experiencia getExperienciaById(int id) {
       return experienciaDAO.findById(id).orElse(null);
    }
    
    @Transactional
    public void registrarExperiencia(Experiencia exp) {
  
        // guardar la empresa primero
        if(exp.getEmpresa().getId() == 0){
            empresaDAO.save(exp.getEmpresa());
        }
        
        // guardar el rol primero
        if(exp.getPuesto().getId() == 0){
            puestoDAO.save(exp.getPuesto());
        }
        
        // guardar la jornada primero
        if(exp.getJornada().getId() == 0){
            jornadaDAO.save(exp.getJornada());
        }
        
        experienciaDAO.save(exp);
    }
    
    public void deleteExperiencia(Integer id){
       experienciaDAO.deleteById(id);
    }
}

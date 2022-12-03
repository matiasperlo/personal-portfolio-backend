/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.matiasperlo.portfolio.service;

import io.github.matiasperlo.portfolio.dao.EducacionDAO;
import io.github.matiasperlo.portfolio.dao.InstitutoDAO;
import io.github.matiasperlo.portfolio.model.Educacion;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author matia
 */
@Service
public class EducacionService {
    
    @Autowired
    private EducacionDAO currentDAO;
    
    @Autowired
    private InstitutoDAO institutoDAO;
    
    public List<Educacion> getAll(){
        List<Educacion> lista = currentDAO.findAll();
        return lista;
    }
    
    public Educacion findOne(Integer id){
        Educacion resp = currentDAO.findById(id).orElse(null);
        return resp;
    }
    
    @Transactional
    public void save(Educacion edu){
        
        // guarda primero el instituto
        if(edu.getInstituto().getId() == 0){
            institutoDAO.save(edu.getInstituto());
        }
        
        currentDAO.save(edu);
    }
    
    public void delete(Integer id){
        currentDAO.deleteById(id);
    }
}

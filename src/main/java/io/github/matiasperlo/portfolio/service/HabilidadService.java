/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.matiasperlo.portfolio.service;

import io.github.matiasperlo.portfolio.dao.HabilidadDAO;
import io.github.matiasperlo.portfolio.model.Habilidad;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author matia
 */
@Service
public class HabilidadService {
    
    @Autowired
    private HabilidadDAO currentDAO;
    
    public List<Habilidad> getAll(){
        List<Habilidad> lista = currentDAO.findAll();
        return lista;
    }
    
    public Habilidad findOne(Integer id){
        Habilidad resp = currentDAO.findById(id).orElse(null);
        return resp;
    }
    
    public void save(Habilidad user){
        currentDAO.save(user);
    }
    
    public void delete(Integer id){
        currentDAO.deleteById(id);
    }
}

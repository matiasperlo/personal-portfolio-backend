/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.matiasperlo.portfolio.service;

import io.github.matiasperlo.portfolio.dao.ProyectoDAO;
import io.github.matiasperlo.portfolio.model.Proyecto;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author matia
 */
@Service
public class ProyectoService {
    
    @Autowired
    private ProyectoDAO currentDAO;
    
    public List<Proyecto> getAll(){
        List<Proyecto> lista = currentDAO.findAll();
        return lista;
    }
    
    public Proyecto findOne(Integer id){
        Proyecto resp = currentDAO.findById(id).orElse(null);
        return resp;
    }
    
    public void save(Proyecto user){
        currentDAO.save(user);
    }
    
    public void delete(Integer id){
        currentDAO.deleteById(id);
    }
}

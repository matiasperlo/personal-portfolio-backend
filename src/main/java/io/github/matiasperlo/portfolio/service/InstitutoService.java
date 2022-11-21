/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.matiasperlo.portfolio.service;

import io.github.matiasperlo.portfolio.dao.InstitutoDAO;
import io.github.matiasperlo.portfolio.model.Instituto;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author matia
 */
@Service
public class InstitutoService {
    
    @Autowired
    private InstitutoDAO currentDAO;
    
    public List<Instituto> getAll(){
        List<Instituto> lista = currentDAO.findAll();
        return lista;
    }
    
    public Instituto findOne(Integer id){
        Instituto resp = currentDAO.findById(id).orElse(null);
        return resp;
    }
    
    public void save(Instituto user){
        currentDAO.save(user);
    }
    
    public void delete(Integer id){
        currentDAO.deleteById(id);
    }
}

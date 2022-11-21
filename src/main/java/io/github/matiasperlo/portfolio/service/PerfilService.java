/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.matiasperlo.portfolio.service;

import io.github.matiasperlo.portfolio.dao.PerfilDAO;
import io.github.matiasperlo.portfolio.model.Perfil;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author matia
 */
@Service
public class PerfilService {
    @Autowired
    private PerfilDAO currentDAO;
    
    public List<Perfil> getAll(){
        List<Perfil> lista = currentDAO.findAll();
        return lista;
    }
    
    public Perfil findOne(Integer id){
        Perfil resp = currentDAO.findById(id).orElse(null);
        return resp;
    }
    
    public void save(Perfil user){
        currentDAO.save(user);
    }
    
    public void delete(Integer id){
        currentDAO.deleteById(id);
    }
}

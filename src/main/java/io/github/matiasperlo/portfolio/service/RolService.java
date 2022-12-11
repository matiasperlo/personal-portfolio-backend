/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.matiasperlo.portfolio.service;

import io.github.matiasperlo.portfolio.dao.RolDAO;
import io.github.matiasperlo.portfolio.model.Rol;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author matia
 */

@Service
public class RolService {
    
    @Autowired
    private RolDAO rolDAO;
    
    public List<Rol> getRoles(){
        List<Rol> lista = rolDAO.findAll();
        return lista;
    }
    
    public Rol findRol(Integer id){
        Rol resp = rolDAO.findById(id).orElse(null);
        return resp;
    }
    
    public void saveRol(Rol user){
        rolDAO.save(user);
    }
    
    public void deleteRol(Integer id){
        rolDAO.deleteById(id);
    }
    
    public Rol findByRolName(String name){
        return rolDAO.findByRol(name).orElse(null);
    }
    
    public Rol getUserRol(){
        return this.findByRolName("ROLE_USER");
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.matiasperlo.portfolio.service;

import io.github.matiasperlo.portfolio.dao.JornadaDAO;
import io.github.matiasperlo.portfolio.model.Jornada;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author matia
 */

@Service
public class JornadaService {
    
    @Autowired
    private JornadaDAO jornadaDAO;
    
    public List<Jornada> getJornadas(){
        List<Jornada> listaJornadas = jornadaDAO.findAll();
        return listaJornadas;
    }
    
    public Jornada findJornada(Integer id){
        Jornada jorn = jornadaDAO.findById(id).orElse(null);
        return jorn;
    }
    
    public void saveJornada(Jornada user){
        jornadaDAO.save(user);
    }
    
    public void deleteJornada(Integer id){
        jornadaDAO.deleteById(id);
    }
    
    
}

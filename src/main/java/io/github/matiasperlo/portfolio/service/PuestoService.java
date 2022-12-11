/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.matiasperlo.portfolio.service;

import io.github.matiasperlo.portfolio.dao.PuestoDAO;
import io.github.matiasperlo.portfolio.model.Puesto;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author matia
 */
@Service
public class PuestoService {
    
    @Autowired
    private PuestoDAO puestoDao;
    
    public List<Puesto> getAll(){
        return puestoDao.findAll();
    }
}

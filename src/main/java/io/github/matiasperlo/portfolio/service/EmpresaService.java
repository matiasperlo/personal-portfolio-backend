/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.matiasperlo.portfolio.service;

import io.github.matiasperlo.portfolio.dao.EmpresaDAO;
import io.github.matiasperlo.portfolio.model.Empresa;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author matia
 */
@Service
public class EmpresaService {
    
    @Autowired
    private EmpresaDAO currentDAO;
    
    public List<Empresa> getAll(){
        List<Empresa> lista = currentDAO.findAll();
        return lista;
    }
    
    public Empresa findOne(Integer id){
        Empresa resp = currentDAO.findById(id).orElse(null);
        return resp;
    }
    
    public void save(Empresa user){
        currentDAO.save(user);
    }
    
    public void delete(Integer id){
        currentDAO.deleteById(id);
    }
    
}

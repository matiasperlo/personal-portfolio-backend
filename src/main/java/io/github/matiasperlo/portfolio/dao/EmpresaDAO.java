/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package io.github.matiasperlo.portfolio.dao;

import io.github.matiasperlo.portfolio.model.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author matia
 */
public interface EmpresaDAO extends JpaRepository<Empresa, Integer>{
    
}

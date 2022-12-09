/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.matiasperlo.portfolio.dao;

import io.github.matiasperlo.portfolio.model.Puesto;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author matias
 */
public interface PuestoDAO extends JpaRepository<Puesto, Integer> {
    
}

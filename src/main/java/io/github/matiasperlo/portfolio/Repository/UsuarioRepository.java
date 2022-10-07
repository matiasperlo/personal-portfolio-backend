/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package io.github.matiasperlo.portfolio.Repository;

import io.github.matiasperlo.portfolio.Model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author matia
 */
@Repository
public interface UsuarioRepository extends JpaRepository <Usuario, String> {
    
}

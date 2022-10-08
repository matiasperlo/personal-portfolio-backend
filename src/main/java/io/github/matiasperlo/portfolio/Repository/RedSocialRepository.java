/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package io.github.matiasperlo.portfolio.Repository;

import io.github.matiasperlo.portfolio.Model.RedSocial;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author matia
 */
public interface RedSocialRepository extends JpaRepository <RedSocial, Long> {
    
}

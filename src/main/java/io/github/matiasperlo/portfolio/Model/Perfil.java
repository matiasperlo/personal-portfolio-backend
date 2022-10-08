/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.matiasperlo.portfolio.Model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author matia
 */
@Getter
@Setter
@Entity
@Table(name="perfil")
public class Perfil implements Serializable {


    @Id
    @Column(name = "id", nullable = false, length = 25)
    private String id;
    
    @Column(name = "nombre", nullable = false, length = 32)   
    private String nombre;
    
    @Column(name = "rol", nullable = false, length = 32)   
    private String rol;

    @Column(name = "foto_perfil", nullable = false, length = 32)   
    private String foto_perfil;
    
    @Column(name = "foto_portada", nullable = false, length = 32)   
    private String foto_portada;
    
    @Column(name = "desc_sobremi", nullable = false, length = 32)   
    private String desc_sobremi;
    
    @Column(name = "email", nullable = false, length = 32)   
    private String email;

    
    public Perfil(){}
    
    // TODO

}

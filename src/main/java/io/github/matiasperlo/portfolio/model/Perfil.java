/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.matiasperlo.portfolio.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author matia
 */
@Entity
@Table(name = "perfil")
public class Perfil {
    
    @Id
    private int id;
    
    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;
    
    @Column(name = "rol", nullable = false, length = 20)
    private String progreso;
    
    @Column(name = "foto_perfil", nullable = false, length = 100)
    private String foto_perfil;
    
    @Column(name = "foto_portada", nullable = false, length = 100)
    private String foto_portada;
    
    @Column(name = "desc_sobremi", nullable = false, length = 420)
    private String desc_sobremi;
    
    @Column(name = "email", nullable = false, length = 100)
    private String email;

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getProgreso() {
        return progreso;
    }

    public String getFoto_perfil() {
        return foto_perfil;
    }

    public String getFoto_portada() {
        return foto_portada;
    }

    public String getDesc_sobremi() {
        return desc_sobremi;
    }

    public String getEmail() {
        return email;
    }
    
    
}

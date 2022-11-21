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
@Table(name = "habilidades")
public class Habilidad {
    
    @Id
    private int id;
    
    @Column(name = "nombre", nullable = false, length = 20)
    private String nombre;
    
    @Column(name = "progreso", nullable = false)
    private String progreso;

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getProgreso() {
        return progreso;
    }
    
    
    
}

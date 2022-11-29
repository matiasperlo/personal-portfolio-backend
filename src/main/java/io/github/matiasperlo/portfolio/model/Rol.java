/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.matiasperlo.portfolio.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author matia
 */
@Entity
@Table(name = "roles")
public class Rol implements Serializable{
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private int id;
    
    @Column(name = "rol", nullable = false, length = 25)
    private String rol;
    
    @Column(name = "descripcion", nullable = true, length = 200)
    private String descripcion;
    
    
    public int getId(){
        return id;
    }
    
    public String getRol(){
        return rol;
    }
    
    public String getDescripcion(){
        return descripcion;
    }
    
    
}

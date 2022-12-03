/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.matiasperlo.portfolio.model;

import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author matia
 */
@Entity
@Table(name = "instituciones")
public class Instituto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private int id;
    
    @Column(name = "nombre", nullable = false, length = 20)
    private String nombre;
    
    @Column(name = "logo", nullable = false, length = 50)
    private String logo;  
    
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getLogo() {
        return logo;
    }
    
    
}

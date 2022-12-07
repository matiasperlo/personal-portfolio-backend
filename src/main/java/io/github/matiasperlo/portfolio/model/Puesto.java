/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.matiasperlo.portfolio.model;

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
@Table(name = "puestos")
public class Puesto {
    
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column( name = "id", unique = true, nullable = false)
    private int id;
    
    @Column(name = "puesto", nullable = false)
    private String puesto;
    
    @Column(name = "descripcion", nullable = true)
    private String descripcion;

    public int getId() {
        return id;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
    
}

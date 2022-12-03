/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.matiasperlo.portfolio.model;

import java.io.Serializable;
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
@Table(name="experiencias")
public class Experiencia implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private int id;
    
    // Relaciones con otras tablas
    @ManyToOne
    @JoinColumn(name="rol", nullable = false)
    private Rol rol;
    
    @ManyToOne
    @JoinColumn(name="empresa", nullable = false)
    private Empresa empresa;
    
    @ManyToOne
    @JoinColumn(name="jornada", nullable = false)
    private Jornada jornada;
    
    // fechas
    @Column(name="fechainicio", nullable = false)
    private Date fechainicio;
    
    @Column(name="fechafin", nullable = false)
    private Date fechafin;
    
    public int getId(){
        return id;
    }
    
    public Rol getRol(){
        return rol;
    }
    
    public Empresa getEmpresa(){
        return empresa;
    }
    
    public Jornada getJornada(){
        return jornada;
    }
    
    public Date getFechainicio(){
        return fechainicio;
    }
    
    public Date getFechafin(){
        return fechafin;
    }
    
    
    public void setRol(Rol rol){
        this.rol = rol;
    }
    
    public void setEmpresa(Empresa empresa){
        this.empresa = empresa;
    }
    
    public void setJornada(Jornada jornada){
        this.jornada = jornada;
    }
    
    public void setFechainicio(Date fechainicio){
        this.fechainicio = fechainicio;
    }
    
    public void setFechafin(Date fechafin){
        this.fechafin = fechafin;
    }
    
}

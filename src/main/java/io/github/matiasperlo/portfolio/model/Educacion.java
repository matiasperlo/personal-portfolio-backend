/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.matiasperlo.portfolio.model;

import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author matia
 */
@Entity
@Table(name = "educaciones")
public class Educacion {

    @Id
    private int id;
    
    @Column(name = "titulo", nullable = false, length = 20)
    private String titulo;
    
    @ManyToOne
    @JoinColumn(name = "instituto", nullable = false)
    private Instituto instituto;
    
    @Column(name = "inicio", nullable = false)
    private Date fechainicio;
    
    @Column(name = "fin", nullable = false)
    private Date fechafin;
    
    
    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public Instituto getInstituto() {
        return instituto;
    }

    public Date getFechainicio() {
        return fechainicio;
    }

    public Date getFechafin() {
        return fechafin;
    }
}

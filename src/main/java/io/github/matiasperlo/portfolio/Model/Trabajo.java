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
@Table(name="trabajos")
public class Trabajo implements Serializable {

    @Id
    @Column(name = "id", nullable = false, length = 25)
    private String id;
    
    @Column(name = "puesto", nullable = false, length = 32)   
    private String puesto;
    
    @Column(name = "empresa", nullable = false, length = 32)   
    private String empresa;
    
    @Column(name = "jornada", nullable = false, length = 32)   
    private String jornada;
    
    @Column(name = "inicio", nullable = false, length = 32)   
    private String inicio;
    
    @Column(name = "fin", nullable = false, length = 32)   
    private String fin;
    
    public Trabajo(){}
    
    public Trabajo(String id,
            String puesto,
            String empresa,
            String jornada,
            String inicio,
            String fin){
        
        this.id = id;
        this.puesto = puesto;
        this.empresa = empresa;
        this.jornada = jornada;
        this.inicio = inicio;
        this.fin = fin;
    }
}

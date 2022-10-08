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
@Table(name="instituciones")
public class Institucion implements Serializable {

    @Id
    @Column(name = "id", nullable = false, length = 25)
    private String id;
    
    @Column(name = "nombre", nullable = false, length = 32)   
    private String nombre;
    
    @Column(name = "logo", nullable = false, length = 32)   
    private String logo;
    
    public Institucion(){}
    
    public Institucion(String id, String nombre, String logo){
        this.id = id;
        this.nombre = nombre;
        this.logo = logo;

    }
}

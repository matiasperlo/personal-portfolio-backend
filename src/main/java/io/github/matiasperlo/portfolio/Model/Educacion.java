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
@Table(name="educaciones")
public class Educacion implements Serializable {
    
    @Id
    @Column(name = "id", nullable = false, length = 25)
    private String id;
    
    @Column(name = "titulo", nullable = false, length = 32)   
    private String titulo;
    
    @Column(name = "instituto", nullable = false, length = 25)
    private String instituto;
    
    @Column(name = "inicio", nullable = false, length = 32)   
    private String inicio;
    
    @Column(name = "fin", nullable = false, length = 32)   
    private String fin;
    
    public Educacion(){}
    
    public Educacion(String titulo,
            String instituto,
            String inicio,
            String fin){
        //this.username = username;
        //this.password = password;
    }
}

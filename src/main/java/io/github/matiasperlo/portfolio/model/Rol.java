/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.matiasperlo.portfolio.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
    
    @Column(name = "rol", nullable = false, length = 100)
    private String rol;
    
    @Column(name = "descripcion", nullable = true, length = 420)
    private String descripcion;
    
    @ManyToMany
    @JoinTable( name = "roles_privilegios", 
            joinColumns = @JoinColumn(
                    name = "rol_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn( 
                    name="privilegio_id", referencedColumnName = "id"))
    private Collection<Privilegio> privilegios;
    
    public int getId(){
        return id;
    }
    
    public String getRol(){
        return rol;
    }
    
    public String getDescripcion(){
        return descripcion;
    }

    public Collection<Privilegio> getPrivilegios() {
        return privilegios;
    }

    public void setPrivilegios(Collection<Privilegio> privilegios) {
        this.privilegios = privilegios;
    }
    
    
    
    
}

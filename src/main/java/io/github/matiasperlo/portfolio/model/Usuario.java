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
@Table(name="users")
public class Usuario implements Serializable {
    
    @Id
    private int id;
    
    @Column(name = "username", nullable = false, length = 25)
    private String username;
    
    @Column(name = "password", nullable = false, length = 32)   
    private String password;
    
    public Usuario(){}
    
    public Usuario(String username, String password){
        this.username = username;
        this.password = password;
    }
    
    public String getUsername(){
        return username;
    }
    
    public void setUsername(String username){
        this.username = username;
    }

    public String getPassword(){
        return password;
    }       

    public void setPassword(String passwd){
        this.password = passwd;
    }
}


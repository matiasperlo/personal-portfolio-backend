/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.matiasperlo.portfolio.dto;

import java.io.Serializable;

/**
 *
 * @author matia
 */
public class AuthenticationErrorResponse implements Serializable {
    
    private String descripcion;
    private boolean userAlreadyExists;
    private boolean userNotExists;
    private boolean badPassword;

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isUserAlreadyExists() {
        return userAlreadyExists;
    }

    public void setUserAlreadyExists(boolean userAlreadyExists) {
        this.userAlreadyExists = userAlreadyExists;
    }

    public boolean isBadPassword() {
        return badPassword;
    }

    public void setBadPassword(boolean badPassword) {
        this.badPassword = badPassword;
    }

    public boolean isUserNotExists() {
        return userNotExists;
    }

    public void setUserNotExists(boolean userNotExists) {
        this.userNotExists = userNotExists;
    }
    
    
    
    
    
}

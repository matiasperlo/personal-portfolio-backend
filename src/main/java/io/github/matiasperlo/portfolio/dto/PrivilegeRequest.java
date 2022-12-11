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
public class PrivilegeRequest implements Serializable{
    
    private String jwt;
    
    public PrivilegeRequest(){}
    
    public PrivilegeRequest(String jwt) {
        this.jwt = jwt;
    }
    
    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }
    
    
    
}

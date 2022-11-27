/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.matiasperlo.portfolio.dto;

import java.io.Serializable;

/**
 * Representa el cuerpo para EntityResponse con un mensaje (application/json)
 * @author matia
 */
public class ResponseMessage implements Serializable {
    
    private String message;
    
    public ResponseMessage(){}
    
    public ResponseMessage(String mesg){
        this.message = mesg;
    }

    public String getMessage() {
        return message;
    }
    
    
}

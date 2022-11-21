/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package io.github.matiasperlo.portfolio.service;

import io.github.matiasperlo.portfolio.model.Usuario;
import java.util.List;

/**
 *
 * @author matia
 */
public interface IUserService {
    public List<Usuario> getUsuarios();
    public void saveUsuario(Usuario user);
    public void deleteUsuario(Integer username);
    public Usuario findUsuario(Integer username);
} 

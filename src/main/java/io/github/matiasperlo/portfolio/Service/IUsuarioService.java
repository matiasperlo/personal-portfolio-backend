/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package io.github.matiasperlo.portfolio.Service;

import java.util.List;
import io.github.matiasperlo.portfolio.Model.Usuario;
/**
 *
 * @author matia
 */
public interface IUsuarioService {
    public List<Usuario> getUsuarios();
    public void saveUsuario(Usuario user);
    public void deleteUsuario(String username);
    public Usuario findUsuario(String username);
}  

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.matiasperlo.portfolio.service;

import io.github.matiasperlo.portfolio.dao.UserDAO;
import io.github.matiasperlo.portfolio.model.Usuario;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author matia
 */
@Service
public class UserService implements IUserService {
    
    @Autowired
    private UserDAO userDAO;
    
    @Override
    public List<Usuario> getUsuarios(){
        List<Usuario> listaUsuarios = userDAO.findAll();
        return listaUsuarios;
    }
    
    @Override
    public void saveUsuario(Usuario user){
        userDAO.save(user);
    }
    
    @Override
    public void deleteUsuario(String username){
        userDAO.deleteById(username);
    }
    
    @Override
    public Usuario findUsuario(String username){
        Usuario user = userDAO.findById(username).orElse(null);
        return user;
    }
}

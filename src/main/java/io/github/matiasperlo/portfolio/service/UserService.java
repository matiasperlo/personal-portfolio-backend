/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.matiasperlo.portfolio.service;

import io.github.matiasperlo.portfolio.dao.UserDAO;
import io.github.matiasperlo.portfolio.model.Usuario;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author matia
 */
@Service
public class UserService implements IUserService {
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Autowired
    private UserDAO userDAO;
    
    @Override
    public List<Usuario> getUsuarios(){
        List<Usuario> listaUsuarios = userDAO.findAll();
        return listaUsuarios;
    }
    
    @Override
    public void saveUsuario(Usuario user){
        Usuario usuario = new Usuario();
        usuario.setUsername(user.getUsername());
        usuario.setPassword(passwordEncoder.encode(user.getPassword()));

        userDAO.save(usuario);
    }
    
    @Override
    public void deleteUsuario(Integer id){
        userDAO.deleteById(id);
    }
    
    @Override
    public Usuario findUsuario(Integer id){
        Usuario user = userDAO.findById(id).orElse(null);
        return user;
    }
}

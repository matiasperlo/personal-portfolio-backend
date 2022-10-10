/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.matiasperlo.portfolio.controller;

import io.github.matiasperlo.portfolio.model.Usuario;
import io.github.matiasperlo.portfolio.service.IUserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author matia
 */
@RestController
@RequestMapping("api/users")
public class UserController {
    
    @Autowired
    private IUserService interUsuario;
    
    @GetMapping("/prueba")
    public String getPrueba(){
        return "algo";
    }
    
    @GetMapping("/all")
    public List<Usuario> getUsuarios(){
        return interUsuario.getUsuarios();
    }
    
    @PostMapping("/create")
    public String createUsuario(@RequestBody Usuario user){
        interUsuario.saveUsuario(user);
        return "el usuario fue creado satisfactoriamente";
    }
    
    @DeleteMapping("/delete/{username}")
    public String deleteUsuario(@PathVariable String username){
        interUsuario.deleteUsuario(username);
        return "la persona fue eliminada con exito";
    }
    
    @PutMapping("/edit/{username}")
    public Usuario editUsuario(@PathVariable String username,
            @RequestParam ("username") String nombre,
            @RequestParam ("password") String pwd){
        
        Usuario user = interUsuario.findUsuario(username);
        
        user.setUsername(nombre);
        user.setPassword(pwd);
        
        interUsuario.saveUsuario(user);
        
        return user;
    }
}
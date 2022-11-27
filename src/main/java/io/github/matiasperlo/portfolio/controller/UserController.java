/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.matiasperlo.portfolio.controller;

import io.github.matiasperlo.portfolio.dto.ResponseMessage;
import io.github.matiasperlo.portfolio.model.Usuario;
import io.github.matiasperlo.portfolio.service.IUserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    private IUserService userService;
    
    @GetMapping("/all")
    public List<Usuario> getUsuarios(){
        return userService.getUsuarios();
    }
    
    @GetMapping("/user/{id}")
    public Usuario getUsuario(@PathVariable Integer id){
        return userService.findUsuario(id);
    }
    
    @PostMapping("/register")
    public ResponseEntity<?> createUsuario(@RequestBody Usuario user){
        userService.saveUsuario(user);
        return ResponseEntity.ok(new ResponseMessage("el usuario fue creado satisfactoriamente"));
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteUsuario(@PathVariable Integer id){
        userService.deleteUsuario(id);
        return ResponseEntity.ok(new ResponseMessage("la persona fue eliminada con exito"));
    }
    
    @PutMapping("/edit/{id}")
    public Usuario editUsuario(@PathVariable Integer id,
            @RequestParam ("username") String nombre,
            @RequestParam ("password") String pwd){
        
        Usuario user = userService.findUsuario(id);
        
        user.setUsername(nombre);
        user.setPassword(pwd);
        
        userService.saveUsuario(user);
        
        return user;
    }
}

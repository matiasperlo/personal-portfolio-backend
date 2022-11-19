/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.matiasperlo.portfolio.controller;

import io.github.matiasperlo.portfolio.model.Image;
import io.github.matiasperlo.portfolio.service.ImageService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author matia
 */
@RestController
@RequestMapping("api/img")
public class ImageController {
    
    @Autowired
    ImageService imageService;
    
    @GetMapping("/all")
    public List<Image> getAllImages(){
        return imageService.getImages(); // Implementar
    }
    
    @GetMapping("/{id}")
    public Image getById(@PathVariable Integer id){
        return imageService.getImageById(id);
    }
    
    @GetMapping("/{name}")
    public Image getByName(@PathVariable String name){
        return imageService.getImageByName(name);
    }
}

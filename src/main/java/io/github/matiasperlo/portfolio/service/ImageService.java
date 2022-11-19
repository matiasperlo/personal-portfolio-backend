/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.matiasperlo.portfolio.service;

import io.github.matiasperlo.portfolio.dao.ImageDAO;
import io.github.matiasperlo.portfolio.model.Image;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author matia
 */

@Service
public class ImageService {
    
    @Autowired
    ImageDAO imageDAO;
    
    public List<Image> getImages(){
        return imageDAO.findAll();
    }
    
    public Image getImageById(Integer id){
        Image img = imageDAO.findById(id).orElse(null);
        return img;
    }

    public Image getImageByName(String name) {
        Image img = imageDAO.findByName(name).orElse(null);
        return img;
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.matiasperlo.portfolio.service;

import io.github.matiasperlo.portfolio.dto.FeedResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author matia
 */
@Service
public class FeedService {
    
    @Autowired
    private PerfilService perfilService;
    
    @Autowired
    private ExperienciaService experienciaService;
    
    @Autowired
    private ProyectoService proyectoService;
    
    @Autowired
    private HabilidadService habilidadService;
    
    @Autowired
    private EducacionService educacionService;
            
            
    public FeedResponse getFeed(){
        FeedResponse resp = new FeedResponse();
        resp.setPerfil(perfilService.getAll().get(0));
        resp.setExperiencias(experienciaService.getExperiencias());
        resp.setEducaciones(educacionService.getAll());
        resp.setProyectos(proyectoService.getAll());
        resp.setHabilidades(habilidadService.getAll());
        
        return resp;
    }
}

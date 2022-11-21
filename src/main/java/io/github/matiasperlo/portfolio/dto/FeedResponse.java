/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.matiasperlo.portfolio.dto;

import io.github.matiasperlo.portfolio.model.Educacion;
import io.github.matiasperlo.portfolio.model.Experiencia;
import io.github.matiasperlo.portfolio.model.Habilidad;
import io.github.matiasperlo.portfolio.model.Perfil;
import io.github.matiasperlo.portfolio.model.Proyecto;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author matia
 */
public class FeedResponse implements Serializable{
    
    private Perfil perfil;
    private List<Experiencia> experiencias;
    private List<Proyecto> proyectos;
    private List<Habilidad> habilidades;
    private List<Educacion> educaciones;

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    public List<Experiencia> getExperiencias() {
        return experiencias;
    }

    public void setExperiencias(List<Experiencia> experiencias) {
        this.experiencias = experiencias;
    }

    public List<Proyecto> getProyectos() {
        return proyectos;
    }

    public void setProyectos(List<Proyecto> proyectos) {
        this.proyectos = proyectos;
    }

    public List<Habilidad> getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(List<Habilidad> habilidades) {
        this.habilidades = habilidades;
    }

    public List<Educacion> getEducaciones() {
        return educaciones;
    }

    public void setEducaciones(List<Educacion> educaciones) {
        this.educaciones = educaciones;
    }
    
    

    
}

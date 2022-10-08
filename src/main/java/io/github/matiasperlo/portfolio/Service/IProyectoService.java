/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package io.github.matiasperlo.portfolio.Service;

import io.github.matiasperlo.portfolio.Model.Proyecto;
import java.util.List;

/**
 *
 * @author matia
 */
public interface IProyectoService {
    public List<Proyecto> getProyectos();
    public void saveProyecto(Proyecto user);
    public void deleteProyecto(String username);
    public Proyecto findProyecto(String username);
}

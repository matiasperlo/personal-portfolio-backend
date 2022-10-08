/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package io.github.matiasperlo.portfolio.Service;

import io.github.matiasperlo.portfolio.Model.Trabajo;
import java.util.List;

/**
 *
 * @author matia
 */
public interface ITrabajoService {
    public List<Trabajo> getTrabajos();
    public void saveTrabajo(Trabajo user);
    public void deleteTrabajo(String username);
    public Trabajo findTrabajo(String username);
}

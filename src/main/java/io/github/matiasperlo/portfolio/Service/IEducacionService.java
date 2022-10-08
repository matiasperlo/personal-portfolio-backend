/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package io.github.matiasperlo.portfolio.Service;

import io.github.matiasperlo.portfolio.Model.Educacion;
import java.util.List;

/**
 *
 * @author matia
 */
public interface IEducacionService {
    public List<Educacion> getEducaciones();
    public void saveEducacion(Educacion user);
    public void deleteEducacion(String username);
    public Educacion findEducacion(String username);
}

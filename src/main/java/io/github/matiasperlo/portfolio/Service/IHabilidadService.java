/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package io.github.matiasperlo.portfolio.Service;

import io.github.matiasperlo.portfolio.Model.Habilidad;
import java.util.List;

/**
 *
 * @author matia
 */
public interface IHabilidadService {
    public List<Habilidad> getHabilidades();
    public void saveHabilidad(Habilidad user);
    public void deleteHabilidad(String username);
    public Habilidad findHabilidad(String username);
}

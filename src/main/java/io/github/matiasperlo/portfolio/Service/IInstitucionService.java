/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package io.github.matiasperlo.portfolio.Service;

import java.util.List;
import io.github.matiasperlo.portfolio.Model.Institucion;

/**
 *
 * @author matia
 */
public interface IInstitucionService {
    public List<Institucion> getInstituciones();
    public void saveInstitucion(Institucion user);
    public void deleteInstitucion(String username);
    public Institucion findInstitucion(String username);
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package io.github.matiasperlo.portfolio.Service;

import io.github.matiasperlo.portfolio.Model.Perfil;
import java.util.List;

/**
 *
 * @author matia
 */
public interface IPerfilService {
    public List<Perfil> getPerfiles();
    public void savePerfil(Perfil user);
    public void deletePerfil(String username);
    public Perfil findPerfil(String username);
}

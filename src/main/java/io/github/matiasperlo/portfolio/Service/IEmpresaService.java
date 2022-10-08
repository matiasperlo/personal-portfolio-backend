/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package io.github.matiasperlo.portfolio.Service;

import io.github.matiasperlo.portfolio.Model.Empresa;
import java.util.List;

/**
 *
 * @author matia
 */
public interface IEmpresaService {
    public List<Empresa> getEmpresa();
    public void saveEmpresa(Empresa user);
    public void deleteEmpresa(String username);
    public Empresa findEmpresa(String username);
}

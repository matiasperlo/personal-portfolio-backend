/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package io.github.matiasperlo.portfolio.Service;

import io.github.matiasperlo.portfolio.Model.RedSocial;
import java.util.List;

/**
 *
 * @author matia
 */
public interface IRedSocialService {
    public List<RedSocial> getRedesSociales();
    public void saveRedSocial(RedSocial user);
    public void deleteRedSocial(String username);
    public RedSocial findRedSocial(String username);
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.matiasperlo.portfolio.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 *
 * @author matia
 */
public class MyUserDetails implements UserDetails {
    
    public class Authority implements GrantedAuthority{
        
        private String auth;

        public Authority(String auth) {
            this.auth = auth;
        }        
        
        @Override
        public String getAuthority() {
            return this.auth;
        }
    }
    
    private String userName;
    private String password;
    private Rol rol;

    public MyUserDetails(Usuario user) {
        this.userName = user.getUsername();
        this.password = user.getPassword();
        this.rol = user.getRol();
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<Authority> auths = new ArrayList();
        auths.add(new Authority(this.rol.getRol()));
        return auths;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}

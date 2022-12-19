/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.matiasperlo.portfolio.config;

import io.github.matiasperlo.portfolio.model.MyUserDetails;
import io.github.matiasperlo.portfolio.service.MyUserDetailsService;
import java.io.IOException;
import java.util.List;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

/**
 *
 * @author matia
 */
@Component
public class JwtRequestFilter extends OncePerRequestFilter {

    @Autowired
    private MyUserDetailsService userDetailsService;

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws ServletException, IOException {
        
        // es un request de CORS y debemos dejarlo pasar
        if(request.getHeader("Access-Control-Request-Method") != null){
            chain.doFilter(request, response);
            return;
        }
        
        // control de acceso
        final String authorizationHeader = request.getHeader("Authorization");
        
        String jwt = null;
        String username = null;
        
        if(authorizationHeader != null && authorizationHeader.startsWith("Bearer ")){
            jwt = authorizationHeader.substring(7);
            username = jwtUtil.extractUsername(jwt);
        }

        String rolname = null;
                
        if(username != null){
            List<MyUserDetails.Authority> auths = (List<MyUserDetails.Authority>)
                    ((MyUserDetails)userDetailsService.loadUserByUsername(username))
                            .getAuthorities();
            rolname = auths.get(0).getAuthority();
        }
        
        // no tiene privilegios de administrador
        if(rolname == null || !rolname.equals("ROLE_ADMIN")){
            response.setStatus(403);
            response.getOutputStream().write(("Forbidden \nNo posee permisos suficientes.").getBytes());
            return;
        }
        
        // todo ok, proceder
        chain.doFilter(request, response);
    }

}


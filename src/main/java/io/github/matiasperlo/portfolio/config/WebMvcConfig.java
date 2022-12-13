/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.matiasperlo.portfolio.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 *
 * @author matia
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer{
    
    @Override
    public void addCorsMappings(CorsRegistry registry){
        registry.addMapping("/**");
                //.allowedMethods("*")
                //.allowedOrigins("http://localhost:4200")
                //.allowedHeaders("*")
                //.allowCredentials(false)
                //.maxAge(-1);
    }
}

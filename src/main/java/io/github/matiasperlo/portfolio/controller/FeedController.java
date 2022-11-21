/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.matiasperlo.portfolio.controller;

import io.github.matiasperlo.portfolio.dto.FeedResponse;
import io.github.matiasperlo.portfolio.service.FeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author matia
 */
@RestController
public class FeedController {
    
    @Autowired
    private FeedService feedService;
    
    @GetMapping("/api/feed") 
    public FeedResponse getFeed(){
        return feedService.getFeed();
    }
    
}

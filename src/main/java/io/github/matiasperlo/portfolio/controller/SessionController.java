/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.matiasperlo.portfolio.controller;

import io.github.matiasperlo.portfolio.config.JwtUtil;
import io.github.matiasperlo.portfolio.dto.AuthenticationRequest;
import io.github.matiasperlo.portfolio.dto.AuthenticationResponse;
import io.github.matiasperlo.portfolio.service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author matia
 */
@RestController
@RequestMapping("api")
public class SessionController {
    	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtUtil jwtTokenUtil;

	@Autowired
	private MyUserDetailsService userDetailsService;
          
        // URL abierto que devuelve la JWT para las credenciales dadas.
	@RequestMapping(value = "/auth", method = RequestMethod.POST, consumes = {"application/json; charset=utf-8"})
	public ResponseEntity<?> crearAuthToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {

		try {
                        // El manager comienza la autenticacion.
			authenticationManager.authenticate(
                            
                            // Authentication con formato Username-Password
                            new UsernamePasswordAuthenticationToken(
                                    authenticationRequest.getUsername(), 
                                    authenticationRequest.getPassword()
                            )
			);
		}
		catch (BadCredentialsException e) {
                    
                    //Error 403 - Forbidden + Debug
                    throw new Exception(
                            "Incorrect username or password",
                            e);
		}

                // La autenticacion salio bien y se crea el token.
		final UserDetails userDetails = userDetailsService
				.loadUserByUsername(
                                        authenticationRequest
                                                .getUsername()
                                );
		final String jwt = jwtTokenUtil.generateToken(userDetails);

		return ResponseEntity.ok(new AuthenticationResponse(jwt));
	}
}

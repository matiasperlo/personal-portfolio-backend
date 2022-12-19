/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.matiasperlo.portfolio.controller;

import io.github.matiasperlo.portfolio.config.JwtUtil;
import io.github.matiasperlo.portfolio.dto.AuthenticationErrorResponse;
import io.github.matiasperlo.portfolio.dto.AuthenticationRequest;
import io.github.matiasperlo.portfolio.dto.AuthenticationResponse;
import io.github.matiasperlo.portfolio.dto.PrivilegeRequest;
import io.github.matiasperlo.portfolio.model.Usuario;
import io.github.matiasperlo.portfolio.service.MyUserDetailsService;
import io.github.matiasperlo.portfolio.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
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
        
        @Autowired 
        private UserService userService;
          
        // URL abierto que devuelve la JWT para las credenciales dadas.
	@RequestMapping(value = "/auth", method = RequestMethod.POST, consumes = {"application/json; charset=utf-8"})
	public ResponseEntity<?> crearAuthToken(@RequestBody AuthenticationRequest request) throws Exception {
            
            // Usuario inexistente
            if (!userService.exists(request.getUsername())){
                AuthenticationErrorResponse authError = new AuthenticationErrorResponse();
                authError.setUserNotExists(true);
                authError.setDescripcion("User Don't Exist");
                return new ResponseEntity(
                        authError, null, HttpStatus.OK);
            }
            
            try {

                // El manager comienza la autenticacion.
                authenticationManager.authenticate(// Authentication con formato Username-Password
                    new UsernamePasswordAuthenticationToken(
                            request.getUsername(), 
                            request.getPassword()
                    )
                );
            }
            catch (BadCredentialsException e) {

                AuthenticationErrorResponse authError = new AuthenticationErrorResponse();
                authError.setBadPassword(true);
                authError.setDescripcion("Bad Password");
                return new ResponseEntity(
                        authError, null, HttpStatus.OK);
            }

            // La autenticacion salio bien y se crea el token.
            final UserDetails userDetails = userDetailsService
                            .loadUserByUsername(request
                                            .getUsername()
                            );
            final String jwt = jwtTokenUtil.generateToken(userDetails);

            return ResponseEntity.ok(new AuthenticationResponse(jwt, request.getUsername()));
	}
        
        @PostMapping("/user-roles")
        public ResponseEntity<?> consultarPrivilegios(@RequestBody PrivilegeRequest prq){
            if( prq.getJwt() == null || prq.getJwt() == "" ){
                return ResponseEntity.ok("");
            }
            
            String username = jwtTokenUtil.extractUsername(prq.getJwt());
            Usuario user = userService.findUsuarioByUsername(username);
            return ResponseEntity.ok(user.getRol());
        }
        
        @PostMapping("/signup")
        public ResponseEntity<?> createUsuario(@RequestBody Usuario user){
            
            // el usuario intentando registrar ya existe
            if (userService.exists(user.getUsername())){
                AuthenticationErrorResponse authError = new AuthenticationErrorResponse();
                authError.setUserAlreadyExists(true);
                authError.setDescripcion("User Already Exists");
                return new ResponseEntity(
                        authError, null, HttpStatus.CONFLICT);
            }
            
            userService.saveUsuario(user);
        
            final UserDetails userDetails = userDetailsService.loadUserByUsername(user.getUsername());
            final String jwt = jwtTokenUtil.generateToken(userDetails);

            return ResponseEntity.ok(new AuthenticationResponse(jwt, user.getUsername()));
        }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.matiasperlo.portfolio.controller;

import io.github.matiasperlo.portfolio.config.JwtUtil;
import io.github.matiasperlo.portfolio.dto.AuthenticationRequest;
import io.github.matiasperlo.portfolio.dto.AuthenticationResponse;
import io.github.matiasperlo.portfolio.model.Usuario;
import io.github.matiasperlo.portfolio.service.IAuthorizationService;
import io.github.matiasperlo.portfolio.service.IUserService;
import io.github.matiasperlo.portfolio.service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
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
public class SessionController {
    	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtUtil jwtTokenUtil;

	@Autowired
	private MyUserDetailsService userDetailsService;

	@RequestMapping(value = "/auth", method = RequestMethod.POST)
	public ResponseEntity<?> crearAuthToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {

		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
			);
		}
		catch (BadCredentialsException e) {
			throw new Exception("Incorrect username or password", e);
		}


		final UserDetails userDetails = userDetailsService
				.loadUserByUsername(authenticationRequest.getUsername());

		final String jwt = jwtTokenUtil.generateToken(userDetails);

		return ResponseEntity.ok(new AuthenticationResponse(jwt));
	}
        
//    @Autowired
//    private AuthenticationManager authenticationManager;
    
//     @Autowired
//     private IAuthorizationService authService;
    
//     @Autowired
//     private IUserService userService;
    
//     @PostMapping("/login")
//     public ResponseEntity<?> login(@RequestBody Usuario request) throws Exception{
//         HttpStatus status = HttpStatus.CREATED;
//         String msg = "";
        
//         switch(authenticate(request.getUsername(), request.getPassword())){
//             case 0 -> {
//                 // return ResponseEntity.ok("Autenticado correctamente");
//                 status = HttpStatus.OK;
//                 msg = "Login exitoso";
//                 break;
//            }
//             case 1 -> {
//                 //return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
//                 status = HttpStatus.UNAUTHORIZED;
//                 msg = "Usuario Incorrecto";
//                 break;

//            }
//             case 2 -> {
//                 //return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
//                 status = HttpStatus.UNAUTHORIZED;
//                 msg = "Password Incorrecto";
//                 break;

//            }
//             default -> {
//                 // ResponseEntity.ok("Error desconocido al autenticar");
//                  status = HttpStatus.INTERNAL_SERVER_ERROR;
//                  msg = "Error desconocido en el servidor";
//                  break;
//            }
//         }
//         return ResponseEntity.status(status).body(msg);

//     }
    
//     @PostMapping("/logout")
//     public ResponseEntity<?> logout(){
//         // expira el token
//         // si no se puede expirar no hace nada
//         return ResponseEntity.ok("Sesion cerrada correctamente");
//     }
    
    
//     private int authenticate(String username, String password) {
//         // 0 -> autenticado exitosamente
//         // 1 -> nombre de usuario incorrecto
//         // 2 -> password de usuario incorrecto
//         try {
//                 Usuario user = userService.findUsuario(username);
//                 if(user == null){
//                     return 1;
//                 }
                
//                 if(!user.getPassword().contentEquals(password)){
//                     return 2;
//                 }
                
//                 return 0;
//         } catch (Exception e) {
//             return 3;
//         }
//     }
}

package com.uax.spring.listacompra.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uax.spring.listacompra.dto.UsuarioDTO;
import com.uax.spring.listacompra.services.UserService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class UsuarioController {

	@Autowired
	UserService userservice;

	@PostMapping(value = "/registrarUsuario")
	public ResponseEntity<String> register(@RequestBody UsuarioDTO usuario) {
		userservice.registerUserDB(usuario);

		return new ResponseEntity<>("OK", HttpStatus.OK);
	}
}

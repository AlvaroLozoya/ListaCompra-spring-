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

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class UsuarioController {

	@Autowired
	private JdbcUserDetailsManager jdbcUserDetailsManager;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@PostMapping(value = "/registrarUsuario")
	public ResponseEntity<String> register(@RequestBody UsuarioDTO myUser) {
		List<GrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority(myUser.getRoles()));

		String encodededPassword = bCryptPasswordEncoder.encode(myUser.getPassword());

		User user = new User(myUser.getUserName(), encodededPassword, authorities);

		jdbcUserDetailsManager.createUser(user);

		return new ResponseEntity<>("OK", HttpStatus.OK);
	}
}

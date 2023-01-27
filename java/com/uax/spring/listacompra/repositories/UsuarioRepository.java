package com.uax.spring.listacompra.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.uax.spring.listacompra.dto.UsuarioDTO;
import com.uax.spring.listacompra.mappers.UsuarioRowMapper;

@Repository
public class UsuarioRepository implements IUsuarioRepository{

	@Autowired
	@Qualifier("jdbcTemplateDB1")
	JdbcTemplate jdbctemplate;
	
	public UsuarioDTO findByUsername(String username) {
		String sql = String.format("SELECT username, password FROM users WHERE username='%s'", username);
		return jdbctemplate.queryForObject(sql,new UsuarioRowMapper());
	}

}

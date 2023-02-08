package com.uax.spring.listacompra.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.uax.spring.listacompra.dto.UsuarioDTO;

public class UsuarioRowMapper implements RowMapper<UsuarioDTO> {
	
	public UsuarioDTO mapRow(ResultSet rs, int rowNum) throws SQLException { // crea objetos a partir de resultados
		UsuarioDTO user = new UsuarioDTO();

		user.setUserName(rs.getString(1));
		user.setPassword(rs.getString(2));
		user.setRoles(rs.getString(3));
		return user;
	}
}

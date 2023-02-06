package com.uax.spring.listacompra.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.uax.spring.listacompra.dto.CategoriaDTO;
import com.uax.spring.listacompra.dto.CompraDTO;

public class CategoriaRowMapper implements RowMapper<CategoriaDTO> {

	public CategoriaDTO mapRow(ResultSet rs, int rowNum) throws SQLException { // crea objetos a partir de resultados
		CategoriaDTO categoria = new CategoriaDTO();
		categoria.setCategoria(rs.getInt(1));
		categoria.setNombre(rs.getString(2));
		return categoria;
	}

}

package com.uax.spring.listacompra.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.uax.spring.listacompra.dto.CategoriaDTO;
import com.uax.spring.listacompra.dto.CompraDTO;

public class CompraRowMapper implements RowMapper<CompraDTO> {

	public CompraDTO mapRow(ResultSet rs, int rowNum) throws SQLException { // crea objetos a partir de resultados
		CompraDTO compra = new CompraDTO();
		
		
		compra.setId(rs.getInt(1));
		compra.setDescripcion(rs.getString(2));
		compra.setCategoria(new CategoriaDTO(rs.getInt(3), rs.getString(4)));
		return compra;
	}

}

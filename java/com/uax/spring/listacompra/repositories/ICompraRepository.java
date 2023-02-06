package com.uax.spring.listacompra.repositories;

import java.util.List;

import org.springframework.stereotype.Service;

import com.uax.spring.listacompra.dto.CompraDTO;

public interface ICompraRepository {

	public boolean saveCompra(CompraDTO compra);
	public Boolean updateCompra(CompraDTO compra);
	public List<CompraDTO> getAllCompras();
	public CompraDTO getCompraById(int id);
	public boolean deleteCompra(int id);
}

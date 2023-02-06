package com.uax.spring.listacompra.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uax.spring.listacompra.dto.CompraDTO;
import com.uax.spring.listacompra.repositories.CompraRepository;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RequestMapping("/api")
@RestController
public class ComprasControllerRest {
	
	@Autowired
	CompraRepository comprarepository;
	
	@Cacheable(value = "compras")
	@ApiResponse(responseCode = "404", description = "")
	@Operation(summary="Obtiene una lista de todos los productos.")
	@GetMapping("/compras")
	public List<CompraDTO> getAllCompras(){
		return comprarepository.getAllCompras();
	}
	
	@CacheEvict(value = "compras")
	@ApiResponse(responseCode = "400", description = "Alguno de los campos no es correcto")
	@Operation(summary="Crea y guarda un nuevo producto.")
	@PostMapping("/compras")
	public boolean saveCompra(@RequestBody CompraDTO compra) {
		return comprarepository.saveCompra(compra);
	}
	
	@ApiResponse(responseCode = "", description = "")
	@Operation(summary="Actualiza un producto.")
	@PutMapping("/compras")
	public boolean updateCompra(@RequestBody CompraDTO compra) {
		return comprarepository.updateCompra(compra);
	}
	
	@ApiResponse(responseCode = "", description = "")
	@Operation(summary="Borra de la lista un producto.")
	@DeleteMapping("/compras/{id}")
	public boolean deleteCompra(@PathVariable int id) {
		return comprarepository.deleteCompra(id);
	}
	
	
}

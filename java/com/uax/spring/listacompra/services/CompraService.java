package com.uax.spring.listacompra.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uax.spring.listacompra.dto.CategoriaDTO;
import com.uax.spring.listacompra.dto.CompraDTO;
import com.uax.spring.listacompra.dto.RecetaDTO;
import com.uax.spring.listacompra.repositories.CompraRepository;

@Service
public class CompraService {
	public static String uriImagenIngrediente = "www.themealdb.com/image/";

	@Autowired
	public CompraRepository compraRepo;
	
	public boolean insertIngredientByApiMeal(RecetaDTO receta) {
		for (String ingrediente : receta.getIngredients()) {
			String urlImagen = String.format(uriImagenIngrediente, ingrediente);
			CategoriaDTO cat = new CategoriaDTO(1, "Fruta");
			CompraDTO compra = new CompraDTO(ingrediente, urlImagen);
			compraRepo.saveCompra(compra);
		}
		return true;
	}
}
package com.uax.spring.listacompra.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.uax.spring.listacompra.dto.RecetaDTO;
import com.uax.spring.listacompra.services.RecetasService;

@Controller
public class RecetasController {
	
	@Autowired
	RecetasService recetaService;

	@GetMapping("/go-to-Recetas")
	public String goToPageListaRecetas(Model modelo) {
		
		ArrayList<RecetaDTO> recetas = recetaService.getListRecetasRandom();
		modelo.addAttribute("recetas", recetas);
		
		return "recetas/pListaRecetas";
	}
	
	@GetMapping("/get-Ingrediente-By-IdMeal")
	public String getIngrediennteByIdMeal(@RequestParam int id, Model modelo) {
		RecetaDTO ingrediente = recetaService.getIngredientesByIdMeal(id);
		modelo.addAttribute("ingrediente", ingrediente);
		return "recetas/pListaRecetas";
	}
}

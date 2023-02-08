package com.uax.spring.listacompra.services;

import java.util.ArrayList;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;
import com.uax.spring.listacompra.dto.RecetaDTO;
import com.uax.spring.listacompra.dto.RecetaResponseDTO;

@Service
public class RecetasService {

	private final String urlMealApiRandom = "https://www.themealdb.com/api/json/v1/1/random.php";
	private final String urlMealApiByIdMeal = "https://www.themealdb.com/api/json/v1/1/lookup.php?i=";

	public RecetaDTO getRecetasFromApi() {
		RestTemplate restT = new RestTemplate();

		String result = restT.getForObject(urlMealApiRandom, String.class);

		return  getResponseByString(result).getMeals().get(0);
	}

	public ArrayList<RecetaDTO> getListRecetasRandom() {
		ArrayList<RecetaDTO> recetas = new ArrayList<RecetaDTO>();

		for (int i = 0; i < 5; i++) {
			recetas.add(getRecetasFromApi());
		}

		return recetas;
	}
	
	public RecetaDTO getIngredientesByIdMeal(int idMeal) {
		RestTemplate restT = new RestTemplate();
		String result = restT.getForObject(urlMealApiByIdMeal+idMeal, String.class);
		
		RecetaResponseDTO receta = getResponseByString(result);
		
		return receta.getMeals().get(0);
	}

	public RecetaResponseDTO getResponseByString(String result) {
		Gson gson = new Gson();

		RecetaResponseDTO recetas = gson.fromJson(result, RecetaResponseDTO.class);
		
		return recetas;
	}
}

package com.uax.spring.listacompra.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.uax.spring.listacompra.dto.CategoriaDTO;
import com.uax.spring.listacompra.dto.CompraDTO;
import com.uax.spring.listacompra.repositories.CompraRepository;

@Controller
public class WelcomeController {

	public List<CompraDTO> listaCompra = new ArrayList();
	public List<CategoriaDTO> listaCategorias = new ArrayList();

	@Autowired
	CompraRepository comprarepository;

	@GetMapping("/")
	public String goToIndex(Model model) {

		model.addAttribute("nombre", "Alvaro");

		return "index";
	}

	@GetMapping("/go-to-lista")
	public String goToLista(Model model) {

		listaCompra = comprarepository.getAllCompras();
		listaCategorias = comprarepository.getAllCategorias();

		model.addAttribute("productos", listaCompra);
		model.addAttribute("categorias", listaCategorias);

		return "pLista";
	}

	@GetMapping("/add-producto")
	public String addProducto(Model model) {
		CompraDTO producto = new CompraDTO();
		CategoriaDTO cat = new CategoriaDTO();
		producto.setCategoria(cat);
		listaCategorias = comprarepository.getAllCategorias();

		model.addAttribute("producto", producto);
		model.addAttribute("categorias", listaCategorias);
		return "addProduct";
	}

	@PostMapping("/add-producto")
	public String goProductoList(@ModelAttribute("producto") CompraDTO producto) {

		if (producto.getId() == 0) {
			comprarepository.saveCompra(producto);
		} else {
			comprarepository.updateCompra(producto);
		}

		return "redirect:/go-to-lista";
	}

	@GetMapping("/delete-producto")
	public String deleteProductoById(@RequestParam("id") int id) {

		comprarepository.deleteCompra(id);

		return "redirect:/go-to-lista";
	}

	@GetMapping("/update-producto")
	public String updateProductoById(@RequestParam("id") int id, Model model) {

		CompraDTO producto = comprarepository.getCompraById(id);
		listaCategorias = comprarepository.getAllCategorias();

		comprarepository.updateCompra(producto);

		model.addAttribute("categorias", listaCategorias);
		model.addAttribute("producto", producto);

		return "addProduct";
	}

}

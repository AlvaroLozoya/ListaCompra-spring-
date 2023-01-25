package com.uax.spring.listacompra.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpServletResponse;

@Controller
public class MyErrorsController implements ErrorController{

	@GetMapping("/error")
	public String showPageError404(Exception e, HttpServletResponse req) {
		String vista = "";
		switch (req.getStatus()) {
		case HttpServletResponse.SC_NOT_FOUND: {
			vista="404err";
		}
		case HttpServletResponse.SC_INTERNAL_SERVER_ERROR: {
			vista="500err";
		}


		}

		return vista;
	}
}

package com.univille.luiza.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.univille.luiza.model.Aluguel;
import com.univille.luiza.service.AluguelService;

@Controller
@RequestMapping("/encerrados")
public class EncerradosController {
	
	@Autowired
	private AluguelService aluguelService;
	
	@GetMapping
	public ModelAndView index() {
		List<Aluguel> lista = aluguelService.getEncerrados();
		return new ModelAndView("encerrados", "alugueis", lista);
	}
		
}

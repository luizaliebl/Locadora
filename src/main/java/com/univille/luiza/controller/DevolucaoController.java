package com.univille.luiza.controller;

import java.util.HashMap;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.univille.luiza.model.Aluguel;
import com.univille.luiza.model.Cliente;
import com.univille.luiza.model.Veiculo;
import com.univille.luiza.service.AluguelService;
import com.univille.luiza.service.ClienteService;
import com.univille.luiza.service.VeiculoService;

@Controller
@RequestMapping("/devolucao")
public class DevolucaoController {
	
	@Autowired
	private AluguelService aluguelService;
	
	@GetMapping
	public ModelAndView index() {
		List<Aluguel> lista = aluguelService.getLiberados();
		return new ModelAndView("devolucao", "alugueis", lista);
	}
	
	
	@GetMapping("/devolver/{id}")
	public ModelAndView edit(@PathVariable("id") Aluguel aluguel) {
		aluguel.setStatus(3);
		aluguelService.save(aluguel);
		return new ModelAndView("redirect:/devolucao");
	}
	
	
}

package com.univille.luiza.controller;

import java.util.HashMap;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/aluguel")
public class AluguelController {
	
	@Autowired
	private AluguelService aluguelService;
	
	@Autowired
	private ClienteService clienteService;
	 
	@Autowired
	private VeiculoService veiculoService;
	
	@GetMapping
	public ModelAndView index() {
		List<Aluguel> lista = aluguelService.getGerado();
		return new ModelAndView("aluguel/index", "alugueis", lista);
	}
	
	@GetMapping("/novo")
	public ModelAndView createForm(@ModelAttribute Aluguel aluguel) {
		HashMap<String, Object> dados = new HashMap<String, Object>();
		List<Cliente> listaClientes = clienteService.getAll();
		List<Veiculo> listaVeiculos = veiculoService.getAll();
        dados.put("listaclientes",listaClientes);
        dados.put("listaveiculos",listaVeiculos);
		return new ModelAndView("aluguel/form", dados);
	}
	
	@PostMapping(params="form")
	public ModelAndView save(@Valid Aluguel aluguel) {
		aluguel.setStatus(1);
		aluguelService.save(aluguel);
		return new ModelAndView("redirect:/aluguel");
	}
	
	@GetMapping("/edit/{id}")
	public ModelAndView edit(@PathVariable("id") Aluguel aluguel) {
		HashMap<String, Object> dados = new HashMap<String, Object>();
		List<Cliente> listaClientes = clienteService.getAll();
		List<Veiculo> listaVeiculos = veiculoService.getAll();
        dados.put("listaclientes",listaClientes);
        dados.put("listaveiculos",listaVeiculos);
        dados.put("aluguel",aluguel);
		return new ModelAndView("aluguel/form", dados);
	}
	
	@GetMapping("/delete/{id}")
	public ModelAndView delete(@PathVariable("id") Aluguel aluguel) {
		aluguelService.delete(aluguel);
		return new ModelAndView("redirect:/aluguel");
	}

}

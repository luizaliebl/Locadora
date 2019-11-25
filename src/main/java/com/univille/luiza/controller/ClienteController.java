package com.univille.luiza.controller;

import java.util.HashMap;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.univille.luiza.model.Cliente;
import com.univille.luiza.repository.ClienteRepository;
import com.univille.luiza.service.ClienteService;

@Controller
@RequestMapping("/cliente")
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private ClienteRepository clienteRepository;
	 
	@GetMapping
	public ModelAndView index() {
		List<Cliente> lista = clienteService.getAll();
		return new ModelAndView("cliente/index", "clientes", lista);
	}
	
	@GetMapping("/novo")
	public ModelAndView createForm(@ModelAttribute Cliente cliente) {
		return new ModelAndView("cliente/form");
	}
	
	@PostMapping(params="form")
	public ModelAndView save(@Valid Cliente cliente, BindingResult result) {
		if(result.hasErrors()){
			return new ModelAndView("cliente/form");
		}
		clienteService.save(cliente);
		return new ModelAndView("redirect:/cliente");
	}
	
	@GetMapping("/edit/{id}")
	public ModelAndView edit(@PathVariable("id") Cliente cliente) {
		List<Cliente> listaClientes = clienteRepository.findAll();
	    HashMap<String, Object> dados = new HashMap<String, Object>();
	    dados.put("cliente",listaClientes);
	     
		return new ModelAndView("cliente/form", "cliente", cliente);
	}

	
	@GetMapping("/delete/{id}")
	public ModelAndView delete(@PathVariable("id") Cliente cliente) {
		clienteService.delete(cliente);
		return new ModelAndView("redirect:/cliente");
	}

}

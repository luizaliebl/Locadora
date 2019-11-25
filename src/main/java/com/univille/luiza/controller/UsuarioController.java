package com.univille.luiza.controller;

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

import com.univille.luiza.model.Cliente;
import com.univille.luiza.model.Usuario;
import com.univille.luiza.service.ClienteService;
import com.univille.luiza.service.UsuarioService;

@Controller
@RequestMapping("/usuario")
@PreAuthorize("hasRole('ROLE_ADMIN')")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping
	public ModelAndView index() {
		List<Usuario> lista = usuarioService.getUsuarios();
		return new ModelAndView("usuario/index", "usuarios", lista);
	}
	
	@GetMapping("/novo")
	public ModelAndView createForm(@ModelAttribute Usuario user) {
		return new ModelAndView("usuario/form");
	}
	
	@PostMapping(params="form")
	public ModelAndView save(@Valid Usuario usuario) {
		System.out.println(usuario);
		usuarioService.save(usuario);
		return new ModelAndView("redirect:/usuario");
	}
	
	@GetMapping("/edit/{id}")
	public ModelAndView edit(@PathVariable("id") Usuario usuario) {
		return new ModelAndView("usuario/form", "usuario", usuario);
	}
	
	@GetMapping("/delete/{id}")
	public ModelAndView delete(@PathVariable("id") Usuario usuario) {
		usuarioService.delete(usuario);
		return new ModelAndView("redirect:/usuario");
	}


}

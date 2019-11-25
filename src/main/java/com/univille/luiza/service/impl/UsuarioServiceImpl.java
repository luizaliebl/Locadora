package com.univille.luiza.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.univille.luiza.model.Usuario;
import com.univille.luiza.repository.UsuarioRepository;
import com.univille.luiza.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService{
	
	@Autowired
	private UsuarioRepository repository;

	@Override
	public List<Usuario> getAll() {
		// TODO Eu tenho que voltar aqui para terminar este metodo
		return repository.findAll();
	}
	
	@Override
	public void save(Usuario usuario) {
		repository.save(usuario);
	}
	
	@Override
	public void delete(Usuario usuario) {
		repository.delete(usuario);
	}

	@Override
	public List<Usuario> getUsuarios() {
		return repository.findByUsuariosComEmail();
	}
	
}

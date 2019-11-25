package com.univille.luiza.service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.univille.luiza.model.Usuario;

@Service
public interface UsuarioService {
	
	List<Usuario> getAll();
	void save(Usuario usuario);
	void delete(Usuario usuario);
	List<Usuario> getUsuarios();

}

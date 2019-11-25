package com.univille.luiza.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.univille.luiza.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	
	Usuario findById(long id);
	Usuario email(String email);
	
	Usuario findByLogin(String login);
	
	@Query("Select u from Usuario u where u.email != null")
	public List<Usuario> findByUsuariosComEmail();
	
	
}

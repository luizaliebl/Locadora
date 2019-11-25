package com.univille.luiza;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.univille.luiza.model.Usuario;
import com.univille.luiza.repository.UsuarioRepository;

@Component
public class StartupEventListenerBean {
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	@EventListener
	public void onApplicationEvent(ContextRefreshedEvent event) {
		if(usuarioRepository.findByLogin("user") == null) {
			Usuario user = new Usuario();
			user.setLogin("user");
			user.setSenha("user");
			user.setRole("ROLE_USER");
			usuarioRepository.save(user);
		}
	}
	

}

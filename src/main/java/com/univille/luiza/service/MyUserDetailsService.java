package com.univille.luiza.service;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.univille.luiza.model.Usuario;
import com.univille.luiza.repository.UsuarioRepository;

@Service
public class MyUserDetailsService implements UserDetailsService{

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public User loadUserByUsername(String username) {
		Usuario user = usuarioRepository.findByLogin(username);
		if (user == null) {
			throw new UsernameNotFoundException(username);
		}
		Collection<SimpleGrantedAuthority> listGrants = new ArrayList<>();
		listGrants.add(new SimpleGrantedAuthority(user.getRole()));
		return new User(user.getLogin(), user.getSenha(), listGrants);
	}
}

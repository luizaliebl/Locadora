package com.univille.luiza.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.univille.luiza.model.Cliente;

@Service
public interface ClienteService {
	
	List<Cliente> getAll();
	void save(Cliente cliente);
	void delete(Cliente cliente);
	Optional<Cliente> findById(long id);
}

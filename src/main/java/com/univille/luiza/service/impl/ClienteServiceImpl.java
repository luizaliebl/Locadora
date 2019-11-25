package com.univille.luiza.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.univille.luiza.model.Cliente;
import com.univille.luiza.repository.ClienteRepository;
import com.univille.luiza.service.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService{
	
	@Autowired
	private ClienteRepository repository;

	@Override
	public List<Cliente> getAll() {
		// TODO Eu tenho que voltar aqui para terminar este metodo
		return repository.findAll();
	}
	
	@Override
	public void save(Cliente cliente) {
		repository.save(cliente);
	}
	
	@Override
	public void delete(Cliente cliente) {
		repository.delete(cliente);
	}

	@Override
	public Optional<Cliente> findById(long id) {
		return repository.findById(id);
	}
	
	

}
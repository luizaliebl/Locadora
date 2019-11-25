package com.univille.luiza.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.univille.luiza.model.Cliente;
import com.univille.luiza.model.Veiculo;
import com.univille.luiza.repository.VeiculoRepository;
import com.univille.luiza.service.VeiculoService;

@Service
public class VeiculoServiceImpl implements VeiculoService{
	
	@Autowired
	private VeiculoRepository repository;

	@Override
	public List<Veiculo> getAll() {
		// TODO Eu tenho que voltar aqui para terminar este metodo
		return repository.findAll();
	}
	
	@Override
	public void save(Veiculo veiculo) {
		repository.save(veiculo);
	}
	
	@Override
	public void delete(Veiculo veiculo) {
		repository.delete(veiculo);
	}

}

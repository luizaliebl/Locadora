package com.univille.luiza.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.univille.luiza.model.Aluguel;
import com.univille.luiza.repository.AluguelRepository;
import com.univille.luiza.service.AluguelService;

@Service
public class AluguelServiceImpl implements AluguelService{
	
	@Autowired
	private AluguelRepository repository;

	@Override
	public List<Aluguel> getAll() {
		return repository.findAll();
	}
	
	@Override
	public void save(Aluguel aluguel) {
		repository.save(aluguel);
	}
	
	@Override
	public void delete(Aluguel aluguel) {
		repository.delete(aluguel);
	}

	@Override
	public List<Aluguel> getLiberar() {
		return repository.findByDataRetirada();
	}

	@Override
	public List<Aluguel> getGerado() {
		return repository.findByAlugueisGerados();
	}

	@Override
	public List<Aluguel> getLiberados() {
		return repository.findByAlugueisLiberados();
	}

	@Override
	public List<Aluguel> getEncerrados() {
		return repository.findByAlugueisEncerrados();
	}

}
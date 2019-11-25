package com.univille.luiza.service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.univille.luiza.model.Aluguel;


@Service
public interface AluguelService {
	
	List<Aluguel> getAll();
	void save(Aluguel aluguel);
	void delete(Aluguel aluguel);
	List<Aluguel> getLiberar();
	List<Aluguel> getGerado();
	List<Aluguel> getLiberados();
	List<Aluguel> getEncerrados();
}

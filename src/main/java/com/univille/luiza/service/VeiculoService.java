package com.univille.luiza.service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.univille.luiza.model.Usuario;
import com.univille.luiza.model.Veiculo;

@Service
public interface VeiculoService {
	
	List<Veiculo> getAll();
	void save(Veiculo veiculo);
	void delete(Veiculo veiculo);

}

package com.univille.luiza.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.univille.luiza.model.Veiculo;

public interface VeiculoRepository extends JpaRepository<Veiculo, Long>{
	
	Veiculo findById(long id);
	Veiculo findByPlaca(String placa);
	
}

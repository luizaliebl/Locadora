package com.univille.luiza.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.univille.luiza.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{
	
	Cliente findByNome(String nome);
	Cliente findByCpf(String cpf);
	Cliente findByRg(String rg);
	Cliente findByCnh(String cnh);
	Cliente findByEmail(String email);
	
	

}

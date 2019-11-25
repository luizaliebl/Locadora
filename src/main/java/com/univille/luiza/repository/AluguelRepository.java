package com.univille.luiza.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.univille.luiza.model.Aluguel;

public interface AluguelRepository extends JpaRepository<Aluguel, Long>{
	
	Aluguel findById(long id);
	
	@Query("Select a from Aluguel a where a.status = 1 and a.dataRetirada = CONVERT (date, SYSDATETIME())")
	public List<Aluguel> findByDataRetirada();
	
	@Query("Select a from Aluguel a where a.status = 1")
	public List<Aluguel> findByAlugueisGerados();
	
	@Query("Select a from Aluguel a where a.status = 2")
	public List<Aluguel> findByAlugueisLiberados();
	
	@Query("Select a from Aluguel a where a.status = 3")
	public List<Aluguel> findByAlugueisEncerrados();
}

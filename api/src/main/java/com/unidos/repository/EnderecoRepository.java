package com.unidos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.unidos.entity.Endereco;

@Transactional(readOnly = true)
public interface EnderecoRepository  extends JpaRepository<Endereco, Long>{
	
	@Query("SELECT e.estado, COUNT(e.id) FROM Endereco e WHERE e.estado IN :estados GROUP BY e.estado")
    List<Object[]> countByEstado(@Param("estados") List<String> estados);

}

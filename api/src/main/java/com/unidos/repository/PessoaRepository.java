package com.unidos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.unidos.entity.Pessoa;

@Transactional(readOnly = true)
public interface PessoaRepository extends JpaRepository<Pessoa, Long>{
	
	@Query("SELECT p.id FROM Pessoa p WHERE p.nome = :nome")
    Long findNome(@Param("nome") String nome);
	
	Pessoa findByNome(String nome);
	
	Pessoa findByCpf(String cpf);
	
    Integer countByCpfIsNotNull();
	
}

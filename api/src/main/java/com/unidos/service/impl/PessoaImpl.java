package com.unidos.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.unidos.entity.Pessoa;
import com.unidos.repository.PessoaRepository;
import com.unidos.service.PessoaService;
import com.unidos.util.Util;

@Service
public class PessoaImpl implements PessoaService{
	
	@Autowired
	private PessoaRepository repository;
	
	public List<String> salvarPorUpload(List<Pessoa> pessoas) {
	    List<String> resultado = new ArrayList<>();
	    int contadorNovo = 0;
	    int contadorAtualizado = 0;
	    int contadorNaoSalvo = 0;
	    List<String> erros = new ArrayList<>();

	    for (Pessoa pessoa : pessoas) {
            try {
                pessoa = verificaPorCPF(pessoa);

                if (pessoa.getId() == null) {
                    pessoa = verificaMaePai(pessoa);
                    pessoa.setDtCadastro(new Date());
                    salvarPessoa(pessoa);
                    contadorNovo++;
                } else {
                    salvarPessoa(pessoa);
                    contadorAtualizado++;
                }

            } catch (DataIntegrityViolationException e) {
                contadorNaoSalvo++;
                erros.add("Verifique se o CPF/RG é de " + pessoa.getNome());
            } catch (Exception e) {
                contadorNaoSalvo++;
                erros.add("Erro no CPF " + Util.mascararCpf(pessoa.getCpf()) + ": " + e.getMessage());
            }
        }

	    resultado.add(contadorNovo + " pessoas cadastradas");
	    resultado.add(contadorAtualizado + " pessoas atualizadas");
	    resultado.add(contadorNaoSalvo + " erros");
	    resultado.addAll(erros);
	    
	    return resultado;
	}
	
	private void salvarPessoa(Pessoa pessoa) {
        pessoa.setDtAtualizado(new Date());
        repository.save(pessoa);
    }

	/**
	 * nome pq na lista nao tem cpf pra mae/pai, entao sera por esta busca
	 * @param pessoa
	 * @return id
	 */
	private Pessoa verificaMaePai(Pessoa pessoa) {
		Long mae = repository.findNome(pessoa.getMae().getNome());
		Long pai = repository.findNome(pessoa.getMae().getNome());
		if(mae != null) {
			pessoa.setMae(new Pessoa(mae));
		}
		if(pai != null) {
			pessoa.setPai(new Pessoa(pai));
		}
		
		return pessoa;
	}

	/**
	 * verifica existencia da pessoa no banco para somente atualizar dados
	 * @param pessoa
	 * @return
	 */
	private Pessoa verificaPorCPF(Pessoa pessoa) {
		
		Pessoa repo = repository.findByCpf(pessoa.getCpf()); 
		if(repo == null ) {
			repo = repository.findByNome(pessoa.getNome());
			if (repo == null) {				
				return pessoa;
			}else {
				return repo;
			}
		}else {
			return repo;
		}
	}

}

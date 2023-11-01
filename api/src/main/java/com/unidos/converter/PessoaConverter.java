package com.unidos.converter;

import org.springframework.stereotype.Component;

import com.unidos.entity.Endereco;
import com.unidos.entity.Pessoa;
import com.unidos.entity.Saude;
import com.unidos.form.UploadForm;

@Component
public class PessoaConverter {

	public Pessoa converterUploadFormToPessoa(UploadForm form) {
		
		Endereco endereco = new Endereco();
		endereco.setCep(form.getCep());
		endereco.setEndereco(form.getEndereco());
		endereco.setNumero(form.getNumero());
		endereco.setBairro(form.getBairro());
		endereco.setCidade(form.getCidade());
		endereco.setEstado(form.getEstado());
		
		Saude saude = new Saude();
		saude.setDtNascimento(form.getData_nasc());
		saude.setSexo(form.getSexo());
		saude.setPeso(form.getPeso());
		saude.setAltura(form.getAltura());
		saude.setTpSangue(form.getTipo_sanguineo());
		
		Pessoa pai = new Pessoa();
		pai.setNome(form.getPai());
		
		Pessoa mae = new Pessoa();
		mae.setNome(form.getMae());
		
		Pessoa pessoa = new Pessoa();
		pessoa.setNome(form.getNome());
		pessoa.setCpf(form.getCpf());
		pessoa.setRg(form.getRg());
		pessoa.setEmail(form.getEmail());
		pessoa.setTelefone1(form.getTelefone_fixo());
		pessoa.setTelefone2(form.getCelular());
		pessoa.setEndereco(endereco);
		pessoa.setSaude(saude);
		pessoa.setPai(pai);
		pessoa.setMae(mae);
		
		return pessoa;
		
	}
}

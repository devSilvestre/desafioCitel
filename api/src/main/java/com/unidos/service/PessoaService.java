package com.unidos.service;

import java.util.List;

import com.unidos.entity.Pessoa;

public interface PessoaService {

	List<String> salvarPorUpload(List<Pessoa> pessoas);
}

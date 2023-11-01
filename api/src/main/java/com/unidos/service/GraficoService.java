package com.unidos.service;

import com.unidos.dto.GraficoDTO;

public interface GraficoService {
	
	GraficoDTO getPorRegiao(String regiao);
	
	GraficoDTO getPorIMC();
	
	GraficoDTO getPorObesidade();
	
	GraficoDTO getPorMediaIdadePorSangue();
	
	GraficoDTO getDoadoresPorReceptores();
	
	Integer getQtdePorCPF();

}

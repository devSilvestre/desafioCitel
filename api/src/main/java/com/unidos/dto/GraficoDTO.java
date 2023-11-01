package com.unidos.dto;

import java.util.List;
import java.util.Map;

import lombok.Data;

@Data
public class GraficoDTO {

	private String tipoGrafico;
	
	private String titulo;
	
	private String legenda;	
	
	private String[] texto;
	
	private String[] valor;
	
	private List<Map<Object, Object>> resultadoAgrupado;

}

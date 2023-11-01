package com.unidos.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unidos.dto.GraficoDTO;
import com.unidos.enums.TipoSangue;
import com.unidos.repository.EnderecoRepository;
import com.unidos.repository.PessoaRepository;
import com.unidos.repository.SaudeRepository;
import com.unidos.service.GraficoService;
import com.unidos.util.Util;

@Service
public class GraficoImpl implements GraficoService {
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private SaudeRepository saudeRepository;
	
	@Autowired
	private PessoaRepository pessoaRepository;

	public GraficoDTO getPorRegiao(String regiao) { 
		
		List<String> estados = Util.estadosPorRegiao(regiao);
		
		GraficoDTO grafico = new GraficoDTO();
		
		List<Object[]> resultado = enderecoRepository.countByEstado(estados);
		
		grafico.setTitulo("Candidatos na região: " + regiao.toUpperCase());
		grafico.setTexto(resultado.stream()
		        .map(row -> row[0].toString()).toArray(String[]::new));
		grafico.setValor(resultado.stream()
		        .map(row -> row[1].toString()).toArray(String[]::new));
				
		return grafico;
	}
	
	public GraficoDTO getPorIMC() {
		
		GraficoDTO grafico = new GraficoDTO();
		
		List<Object[]> resultado = saudeRepository.countByIMC();
		
		grafico.setTitulo("IMC médio por faixa etária (10 em 10 anos)");
		grafico.setLegenda("Média");
		grafico.setTexto(resultado.stream()
		        .map(row -> row[0].toString()).toArray(String[]::new));
		grafico.setValor(resultado.stream()
		        .map(row -> row[1].toString()).toArray(String[]::new));
		
		return Util.gerarValorAgrupado(grafico);
	}
	
	public GraficoDTO getPorObesidade() {
		
		GraficoDTO grafico = new GraficoDTO();
		
		List<Object[]> resultado = saudeRepository.countByObesidade();

		grafico.setTitulo("Obesidade entre homens e mulheres");
		grafico.setLegenda("% obesidade entre sexo");
		grafico.setValor(resultado.stream()
		        .map(row -> row[0].toString()).toArray(String[]::new));
		grafico.setTexto(resultado.stream()
		        .map(row -> row[1].toString()).toArray(String[]::new));
		
		if(grafico.getValor().toString().isEmpty()) {
			grafico.setValor(Util.calcularPorcentagemEntreValores(grafico.getValor()[0],grafico.getValor()[1]));
		}
		
		return  Util.gerarValorAgrupado(grafico);
	}
	
	public GraficoDTO getPorMediaIdadePorSangue() {
		
		GraficoDTO grafico = new GraficoDTO();
		
		List<Object[]> resultado = saudeRepository.countByMediaIdadePorTipoSangue();

		grafico.setTitulo("Média de idade por Tipo Sanguíneo");
		grafico.setLegenda("Tipo Sanguíneo");
		grafico.setTexto(resultado.stream()
		        .map(row -> TipoSangue.fromString( (TipoSangue) row[0])).toArray(String[]::new));
		grafico.setValor(resultado.stream()
		        .map(row -> row[1].toString()).toArray(String[]::new));
		
		return  Util.gerarValorAgrupado(grafico);
	}
	
	public GraficoDTO getDoadoresPorReceptores() {
		
		GraficoDTO grafico = new GraficoDTO();
		List<TipoSangue> doadores = new ArrayList<TipoSangue>();
		List<String> tipoSangue = new ArrayList<String>();
		List<Integer> receptor = new ArrayList<Integer>();
		
		for (TipoSangue n : TipoSangue.values()) {
			doadores = Util.getDoadoresPorReceptor(n);
			tipoSangue.add(n.getDescricao());
			receptor.add(saudeRepository.countByDoadoresPorReceptores(doadores));
		}

		grafico.setTitulo("Doadores por receptores");
		grafico.setLegenda("Tipo Sanguíneo");
		grafico.setTexto(tipoSangue.stream().toArray(String[]::new));
		grafico.setValor(receptor.stream()
			    .map(Object::toString)
			    .toArray(String[]::new));
		
		return grafico;
	}
	
	public Integer getQtdePorCPF() {
		return pessoaRepository.countByCpfIsNotNull();
	}
	
	
}

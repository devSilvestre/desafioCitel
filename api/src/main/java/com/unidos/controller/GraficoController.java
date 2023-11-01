package com.unidos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.unidos.dto.GraficoDTO;
import com.unidos.response.Response;
import com.unidos.service.GraficoService;

@RestController
@RequestMapping("/api/grafico")
public class GraficoController {
	
	@Autowired
	private GraficoService graficoService;
	
	@GetMapping(path = "por-cpf")
	public ResponseEntity<Response<Integer>> getQtdePorCPF() {

		Response<Integer> response = new Response<Integer>();
		
		Integer qtde = graficoService.getQtdePorCPF();

		response.setData(qtde);
		
		return ResponseEntity.ok(response);
	}
	
	@GetMapping(path = "regiao")
	public ResponseEntity<Response<GraficoDTO>> getPorRegiao(
			@RequestParam(value = "regiao", required = false, defaultValue = "todos") String regiao) {

		Response<GraficoDTO> response = new Response<GraficoDTO>();
		
		GraficoDTO dto = graficoService.getPorRegiao(regiao);

		response.setData(dto);
		
		return ResponseEntity.ok(response);
	}
	
	@GetMapping(path = "imc")
	public ResponseEntity<Response<GraficoDTO>> getIMC() {

		Response<GraficoDTO> response = new Response<GraficoDTO>();
		
		GraficoDTO dto = graficoService.getPorIMC();

		response.setData(dto);
		
		return ResponseEntity.ok(response);
	}
	
	@GetMapping(path = "obesidade")
	public ResponseEntity<Response<GraficoDTO>> getObesidade() {

		Response<GraficoDTO> response = new Response<GraficoDTO>();
		
		GraficoDTO dto = graficoService.getPorObesidade();

		response.setData(dto);
		
		return ResponseEntity.ok(response);
	}
	
	@GetMapping(path = "media-idade-tipo-sangue")
	public ResponseEntity<Response<GraficoDTO>> getMediaIdadeTipoSangue() {

		Response<GraficoDTO> response = new Response<GraficoDTO>();
		
		GraficoDTO dto = graficoService.getPorMediaIdadePorSangue();

		response.setData(dto);
		
		return ResponseEntity.ok(response);
	}
	
	@GetMapping(path = "receptor-tipo-sangue")
	public ResponseEntity<Response<GraficoDTO>> getReceptorPorTipoSangue() {

		Response<GraficoDTO> response = new Response<GraficoDTO>();
		
		GraficoDTO dto = graficoService.getDoadoresPorReceptores();

		response.setData(dto);
		
		return ResponseEntity.ok(response);
	}

}

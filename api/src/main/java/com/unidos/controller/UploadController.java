package com.unidos.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unidos.converter.PessoaConverter;
import com.unidos.form.UploadForm;
import com.unidos.response.Response;
import com.unidos.service.PessoaService;

@RestController
@RequestMapping("/api/upload")
public class UploadController {
	
	@Autowired
	private PessoaConverter pessoaConverter;
	
	@Autowired
	private PessoaService pessoaService;
	
	@PostMapping()
    public ResponseEntity<Response<List<String>>> uploadJsonFile(@Valid @RequestBody List<UploadForm> form, BindingResult result) {
        try {
        	Response<List<String>> response = new Response<List<String>>();
        	
        	if (result.hasErrors()) {
    			result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
    			return ResponseEntity.badRequest().body(response);
    		}

            //salvar
            List<String> lista = pessoaService.salvarPorUpload(form.stream()
            	    .map(p -> pessoaConverter.converterUploadFormToPessoa(p))
            	    .collect(Collectors.toList()));

            response.setData(lista);
    		return ResponseEntity.ok(response);
        } catch (Exception e) {
        	Response<List<String>> response = new Response<List<String>>();
        	response.getErrors().add("Verifique inconsistencias no arquivo");
			return ResponseEntity.badRequest().body(response);
        }
    }

}

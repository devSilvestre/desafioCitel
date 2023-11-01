package com.unidos.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "endereco")
@Data
public class Endereco implements Serializable {
	
	private static final long serialVersionUID = -3453471406930833196L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String cep;
	
	private String endereco;
	
	private int numero;
	
	private String bairro;
	
	private String cidade;
	
	private String estado;

}

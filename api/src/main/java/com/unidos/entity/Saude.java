package com.unidos.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.unidos.enums.Sexo;
import com.unidos.enums.TipoSangue;

import lombok.Data;

@Entity
@Table(name = "saude")
@Data
public class Saude implements Serializable {
	
	private static final long serialVersionUID = -6503479842887331769L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING, locale = "pt-BR", timezone = "Brazil/East")
	@Temporal(TemporalType.DATE)
	@Column(name = "dt_nascimento")
	private Date dtNascimento;
	
	private Sexo sexo;
	
	private Double altura;
	
	private Double peso;
	
	@Column(name = "tp_sangue")
	private TipoSangue tpSangue;

}

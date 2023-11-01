package com.unidos.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "pessoa")
@JsonIgnoreProperties({ "hibernateLazyInitializer" })
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pessoa implements Serializable {


	private static final long serialVersionUID = -2876877563584667660L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	
	@Column(unique = true)
	private String rg;
	
	@Column(unique = true)
	private String cpf;
	
	private String email;
	
	private String telefone1;
	
	private String telefone2;
	
	@JoinColumn(name = "mae_id", referencedColumnName = "id")
	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private Pessoa mae;
	
	@JoinColumn(name = "pai_id", referencedColumnName = "id")
	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private Pessoa pai;
	
	@JoinColumn(name = "endereco_id", referencedColumnName = "id")
	@ManyToOne(cascade = CascadeType.ALL)
	private Endereco endereco;
	
	@JoinColumn(name = "saude_id", referencedColumnName = "id")
	@ManyToOne(cascade = CascadeType.ALL)
	private Saude saude;
	
	@JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING, locale = "pt-BR", timezone = "Brazil/East")
	@Temporal(TemporalType.DATE)
	@Column(name = "dt_cadastro")
	private Date dtCadastro;
	
	@JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING, locale = "pt-BR", timezone = "Brazil/East")
	@Temporal(TemporalType.DATE)
	@Column(name = "dt_atualizado")
	private Date dtAtualizado;

	public Pessoa(Long id) {
		this.id = id;
	}
	
	
	
}

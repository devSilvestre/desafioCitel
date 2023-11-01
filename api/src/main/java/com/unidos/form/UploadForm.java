package com.unidos.form;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.unidos.enums.Sexo;
import com.unidos.enums.TipoSangue;

import lombok.Data;


@Data
public class UploadForm {

	//pessoa
		private String nome;
		private String rg;
		private String cpf;
		private String email;
		private String telefone_fixo;
		private String celular;
		private String mae;
		private String pai;
		
		//endereco
		private String cep;
		private String endereco;
		private int numero;
		private String bairro;
		private String cidade;
		private String estado;
		
		//saude
		@JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING, locale = "pt-BR", timezone = "Brazil/East")
		private Date data_nasc;
		private Sexo sexo;
		private Double altura;
		private Double peso;
		private TipoSangue tipo_sanguineo;
		
		public void setSexo(String sexo) {
			this.sexo = Sexo.fromString(sexo);
		}
		
		public void setTipo_sanguineo(String tipo_sanguineo) {
			this.tipo_sanguineo = TipoSangue.fromString(tipo_sanguineo);
		}
		
		
}

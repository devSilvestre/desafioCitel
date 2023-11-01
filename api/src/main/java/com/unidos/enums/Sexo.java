package com.unidos.enums;

public enum Sexo {
	FEMININO("Feminino"),
	MASCULINO("Masculino");

	private final String descricao;

	private Sexo(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public static Sexo fromString(String text) {
		for (Sexo n : Sexo.values()) {
			if (n.descricao.equalsIgnoreCase(text)) {
				return n;
			}
		}
		return null;
	}

}

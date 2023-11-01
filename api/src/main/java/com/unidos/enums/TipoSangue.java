package com.unidos.enums;

public enum TipoSangue {
	O_POSITIVO("O+"),
    O_NEGATIVO("O-"),
    A_POSITIVO("A+"),
    A_NEGATIVO("A-"),
    B_POSITIVO("B+"),
    B_NEGATIVO("B-"),
    AB_POSITIVO("AB+"),
    AB_NEGATIVO("AB-");

    private final String descricao;

    TipoSangue(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
    
    public static TipoSangue fromString(String text) {
		for (TipoSangue n : TipoSangue.values()) {
			if (n.descricao.equalsIgnoreCase(text)) {
				return n;
			}
		}
		return null;
	}
    
    public static String fromString(TipoSangue text) {
		for (TipoSangue n : TipoSangue.values()) {
			if (n == text) {
				return n.getDescricao();
			}
		}
		return null;
	}

}

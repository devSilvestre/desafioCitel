package com.unidos.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.unidos.dto.GraficoDTO;
import com.unidos.enums.TipoSangue;

public class Util {
	
	public static String mascararCpf(String cpf) {
		
	    if (cpf == null || cpf.length() != 14) {
	        return cpf;
	    }

	    String mask = cpf.substring(0, 3) + "***.***" + cpf.substring(11);

	    return mask;
	}
	
	public static Double truncarDouble(Object val) {

		if (val instanceof Double) {
	        Double doubleValue = (Double) val;
	        String valorFormatado = String.format("%.2f", doubleValue);
	        return Double.parseDouble(valorFormatado);
	    } else if (val instanceof String) {
	        String stringValue = (String) val;
	        stringValue = stringValue.replace(",", ".");
	        Double doubleValue = Double.parseDouble(stringValue);
	        String valorFormatado = String.format("%.2f", doubleValue);
	        valorFormatado = valorFormatado.replace(",", ".");
	        return Double.parseDouble(valorFormatado);
	    }  else {
	        return null;
	    }
        
	}
	
	public static List<String> estadosPorRegiao(String regiao) {
	
		switch (regiao.toLowerCase()) {
        case "sudeste": 	return Arrays.asList("MG", "SP", "RJ", "ES");
        case "norte":   	return Arrays.asList("AC", "AP", "AM", "PA", "RO", "RR", "TO");
        case "sul":     	return Arrays.asList("SC", "RS", "PR");
        case "nordeste":	return Arrays.asList("AL", "BA", "CE", "MA", "PB", "PE", "PI", "RN", "SE");
        case "centro-oeste":return Arrays.asList("MS", "MT", "GO", "DF");
        default:			return Arrays.asList("MG", "SP", "RJ", "ES","AC", "AP", "AM", "PA", "RO", "RR", "TO", "SC", "RS", "PR", "AL", "BA", "CE", "MA", "PB", "PE", "PI", "RN", "SE", "MS", "MT", "GO", "DF");
		}
	}
	
	public static List<TipoSangue> getDoadoresPorReceptor(TipoSangue tipo){
		
		switch (tipo) {
		case A_POSITIVO:
			return Arrays.asList(
					TipoSangue.A_POSITIVO,
					TipoSangue.A_NEGATIVO,
					TipoSangue.O_POSITIVO,
					TipoSangue.O_NEGATIVO);
		case A_NEGATIVO:
			return Arrays.asList(
					TipoSangue.A_NEGATIVO,
					TipoSangue.O_NEGATIVO);
		case B_POSITIVO:
			return Arrays.asList(
					TipoSangue.B_POSITIVO,
					TipoSangue.B_NEGATIVO,
					TipoSangue.O_POSITIVO,
					TipoSangue.O_POSITIVO);
		case B_NEGATIVO:
			return Arrays.asList(
					TipoSangue.B_NEGATIVO,
					TipoSangue.O_NEGATIVO);
		case AB_POSITIVO:
			return Arrays.asList(
					TipoSangue.A_POSITIVO,
					TipoSangue.A_NEGATIVO,
					TipoSangue.B_POSITIVO,
					TipoSangue.B_NEGATIVO,
					TipoSangue.O_POSITIVO,
					TipoSangue.O_NEGATIVO,
					TipoSangue.AB_POSITIVO,
					TipoSangue.AB_NEGATIVO
					);
		case AB_NEGATIVO:
			return Arrays.asList(
					TipoSangue.A_NEGATIVO,
					TipoSangue.B_NEGATIVO,
					TipoSangue.O_NEGATIVO,
					TipoSangue.AB_NEGATIVO
					);
		case O_POSITIVO:
			return Arrays.asList(
					TipoSangue.O_POSITIVO,
					TipoSangue.O_NEGATIVO);

		default:
			return Arrays.asList(
					TipoSangue.O_NEGATIVO);
		}
	}
	
	public static String[] calcularPorcentagemEntreValores(Object valor_1, Object valor_2) {
		
		Double v1 = truncarDouble(valor_1);
	    Double v2 = truncarDouble(valor_2);
	    Double total = v1 + v2;
	    String percent1 = String.format("%.2f", (v1 / total) * 100);
	    String percent2 = String.format("%.2f", (v2 / total) * 100);
	    return new String[] {percent1, percent2};
	}
	
	public static  GraficoDTO gerarValorAgrupado(GraficoDTO grafico) {
		
		//agrupa valores para grafico de pizza
		List<Map<Object, Object>> lista = new ArrayList<>();

		for (int i = 0; i < grafico.getValor() .length; i++) {
	        Map<Object, Object> p = new HashMap<>();
	        p.put("name", grafico.getTexto()[i].toString());
	        p.put("value", Util.truncarDouble(grafico.getValor()[i]));
	        lista.add(p);
	    }

		grafico.setResultadoAgrupado(lista);
		
		return grafico;
	}

}

package br.edu.ufersa.multcare.persistence.validations;

import br.edu.ufersa.multcare.persistence.interfaces.IValidator;

public class CPF implements IValidator<String> {
	
	private static final int[] pesos = {11, 10, 9, 8, 7, 6, 5, 4, 3, 2};

	@Override
	public boolean isValid(String cpf) throws IllegalArgumentException {
		
		try {
			if (cpf==null)
				return false;
			
			cpf = cpf.replaceAll("[\\.\\-]", "");
			
			if (cpf.length()!=11) 
				throw new IllegalArgumentException("CPF Deve ter 11 dígitos");
			
			switch (cpf) {
				case "11111111111": throw new IllegalArgumentException("cpf de debug");
				case "22222222222": throw new IllegalArgumentException("cpf de debug");
				case "33333333333": throw new IllegalArgumentException("cpf de debug");
				case "44444444444": throw new IllegalArgumentException("cpf de debug");
				case "55555555555": throw new IllegalArgumentException("cpf de debug");
				case "66666666666": throw new IllegalArgumentException("cpf de debug");
				case "77777777777": throw new IllegalArgumentException("cpf de debug");
				case "88888888888": throw new IllegalArgumentException("cpf de debug");
				case "99999999999": throw new IllegalArgumentException("cpf de debug");
				case "00000000000": throw new IllegalArgumentException("cpf de debug");
			}
	
			Integer digito1 = calcularDigito(cpf.substring(0,9), pesos);
			Integer digito2 = calcularDigito(cpf.substring(0,9) + digito1, pesos);
			
			if(!cpf.equals(cpf.substring(0,9) + digito1.toString() + digito2.toString()))
				throw new IllegalArgumentException("CPF Inválido");
			
		} catch (Exception e) {
			throw new IllegalArgumentException("CPF Inválido ou digitado incorretamente");
		}
		return true;
	}

	private int calcularDigito(String str, int[] peso) {
		int soma = 0;
		for (int indice=str.length()-1, digito; indice >= 0; indice-- ) 
		{
			digito = Integer.parseInt(str.substring(indice,indice+1));
			soma += digito*peso[peso.length-str.length()+indice];
		}
		soma = 11 - soma % 11;
		return soma > 9 ? 0 : soma;
	}
}

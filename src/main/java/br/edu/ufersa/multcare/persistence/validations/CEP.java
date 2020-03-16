package br.edu.ufersa.multcare.persistence.validations;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import br.edu.ufersa.multcare.persistence.interfaces.IValidator;

public class CEP implements IValidator<String> {

	@Override
	public boolean isValid(String cep) throws IllegalArgumentException{
		
		String padrao = "\\d{5}[-]\\d{2}";

        Pattern p = Pattern.compile(padrao);

        Matcher m2 = p.matcher(cep);
        
        if(!m2.find())
			throw new IllegalArgumentException("CEP Inválido");
		
		return true;
	}
}

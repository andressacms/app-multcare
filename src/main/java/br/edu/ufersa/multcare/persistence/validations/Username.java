package br.edu.ufersa.multcare.persistence.validations;

import java.util.regex.Pattern;

import br.edu.ufersa.multcare.persistence.interfaces.IValidator;

public class Username implements IValidator<String> {
	
	private String fieldName;
	
	public Username(String fieldName) {
		this.fieldName = fieldName;
	}
	
	@Override
	public boolean isValid(String value) throws IllegalArgumentException {
		
		Pattern pattern = Pattern.compile("[a-z0-9_]+");
		
		if(value == null || !pattern.matcher(value).matches() )
		{
			throw new IllegalArgumentException(this.fieldName+" deve ter apenas letras, números ou _");
		}
		
		return true;
	}
}

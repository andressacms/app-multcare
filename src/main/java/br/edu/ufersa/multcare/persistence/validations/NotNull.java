package br.edu.ufersa.multcare.persistence.validations;

import br.edu.ufersa.multcare.persistence.interfaces.IValidator;

public class NotNull implements IValidator<Object> {
	
	private String fieldName;
	
	public NotNull(String fieldName) {
		this.fieldName = fieldName;
	}
	
	@Override
	public boolean isValid(Object value) throws IllegalArgumentException {
		
		if(value == null || (value instanceof String && ((String)value).trim().isEmpty()) )
		{
			throw new IllegalArgumentException(this.fieldName+" não pode ser vazio");
		}
		
		return true;
	}
}

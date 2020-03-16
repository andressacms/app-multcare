package br.edu.ufersa.multcare.persistence.validations;

import br.edu.ufersa.multcare.persistence.interfaces.IValidator;

public class PositiveNumber implements IValidator<Number> {
	
	private String fieldName;
	
	public PositiveNumber(String fieldName) {
		this.fieldName = fieldName;
	}
	
	@Override
	public boolean isValid(Number value) throws IllegalArgumentException {
		
		if(value.intValue() <= 0)
		{
			throw new IllegalArgumentException(this.fieldName+" deve ser maior que zero");
		}
		
		return true;
	}
}

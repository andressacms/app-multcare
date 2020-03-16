package br.edu.ufersa.multcare.persistence.interfaces;

public interface IValidator<T> {
	public boolean isValid(T arg) throws IllegalArgumentException;
}

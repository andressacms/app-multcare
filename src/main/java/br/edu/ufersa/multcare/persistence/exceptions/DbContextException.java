package br.edu.ufersa.multcare.persistence.exceptions;

public class DbContextException extends Exception {

	private static final long serialVersionUID = -7265411012852188003L;

	public DbContextException(String message) {
		super(message);
	}
}

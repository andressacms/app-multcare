package br.edu.ufersa.multcare.persistence.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.edu.ufersa.multcare.auth.Authentication;
import br.edu.ufersa.multcare.persistence.interfaces.IEntity;
import br.edu.ufersa.multcare.persistence.validations.NotNull;
import br.edu.ufersa.multcare.persistence.validations.Username;

@Entity
public class Usuario implements IEntity {	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String nome;
	private String login;
	private String senha;
	private int idade;
	private char sexo;
	private float peso;
	
	/** GETTERS **/
	
	public int getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	public String getLogin() {
		return login;
	}
	public String getSenha() {
		return senha;
	}
	public int getIdade() {
		return idade;
	}
	public char getSexo() {
		return sexo;
	}
	public float getPeso() {
		return peso;
	}
	
	/** SETTERS **/
	
	public void setId(int id) {
		this.id = id;
	}
	public void setNome(String nome) throws IllegalArgumentException {
		(new NotNull("Nome")).isValid(nome); // Validation
		this.nome = nome;
	}
	public void setLogin(String login) throws IllegalArgumentException {
		(new Username("Campo usuário")).isValid(login); // Validation
		this.login = login;
	}
	public void setSenha(String senha) throws IllegalArgumentException {
		(new NotNull("Senha")).isValid(nome); // Validation
		if(senha != null && !senha.trim().isEmpty())
		{
			String hash = Authentication.passwordHash(senha);
			this.senha = hash;
		}
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public void setSexo(char sexo) {
		this.sexo = sexo;
	}
	public void setPeso(float peso) {
		this.peso = peso;
	}
	
	@Override
	public String toString() {
		return this.nome.toUpperCase();
	}
}

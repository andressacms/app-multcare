package br.edu.ufersa.multcare.persistence.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import br.edu.ufersa.multcare.persistence.interfaces.IEntity;
import br.edu.ufersa.multcare.persistence.validations.NotNull;

@Entity
public class UnidadeDeSaude implements IEntity {	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String nome;
	private String endereco;
	private String telefone;
	private int longitude;
	private int latitude;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Usuario usuario;
	
	/* GETTERS */

	public int getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	public String getEndereco() {
		return endereco;
	}
	public String getTelefone() {
		return telefone;
	}
	public int getLongitude() {
		return longitude;
	}
	public int getLatitude() {
		return latitude;
	}
	
	
	/* SETTERS */
	
	public void setId(int id) {
		this.id = id;
	}
	public void setNome(String nome) throws IllegalArgumentException {
		(new NotNull("Nome")).isValid(nome);
		this.nome = nome;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public void setLongitude(int longitude) {
		this.longitude = longitude;
	}
	public void setLatitude(int latitude) {
		this.latitude = latitude;
	}
}

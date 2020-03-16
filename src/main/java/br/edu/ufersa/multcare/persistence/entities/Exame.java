package br.edu.ufersa.multcare.persistence.entities;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import br.edu.ufersa.multcare.persistence.interfaces.IEntity;
import br.edu.ufersa.multcare.persistence.validations.NotNull;

@Entity
public class Exame implements IEntity {	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String nome;
	private String resultado;
	private Date dataCadastro;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Usuario usuario;
	
	/* GETTERS */

	public int getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	public String getResultado() {
		return resultado;
	}
	public Date getDataCadastro() {
		return dataCadastro;
	}
	public Usuario getUsuario() {
		return usuario;
	}	
	
	/* SETTERS */
	
	public void setId(int id) {
		this.id = id;
	}
	public void setNome(String nome) throws IllegalArgumentException {
		(new NotNull("Nome")).isValid(nome);
		this.nome = nome;
	}
	public void setResultado(String resultado) throws IllegalArgumentException {
		(new NotNull("Resultado")).isValid(resultado);
		this.resultado = resultado;
	}
	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}

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
public class Medicamento implements IEntity {	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String nome;
	private String hora;
	private Date dataInicial;
	private Date dataFinal;
	private int quantidadeDiaria;
	private int totalMedicamento;
	private String tipo;
	private String status;
	private int frequencia;
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
	public String getHora() {
		return hora;
	}
	public Date getDataInicial() {
		return dataInicial;
	}
	public Date getDataFinal() {
		return dataFinal;
	}
	public int getQuantidadeDiaria() {
		return quantidadeDiaria;
	}
	public int getTotalMedicamento() {
		return totalMedicamento;
	}
	public String getTipo() {
		return tipo;
	}
	public String getStatus() {
		return status;
	}
	public int getFrequencia() {
		return frequencia;
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
	public void setHora(String hora) {
		this.hora = hora;
	}
	public void setDataInicial(Date dataInicial) {
		this.dataInicial = dataInicial;
	}
	public void setDataFinal(Date dataFinal) {
		this.dataFinal = dataFinal;
	}
	public void setQuantidadeDiaria(int quantidadeDiaria) {
		this.quantidadeDiaria = quantidadeDiaria;
	}
	public void setTotalMedicamento(int totalMedicamento) {
		this.totalMedicamento = totalMedicamento;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public void setFrequencia(int frequencia) {
		this.frequencia = frequencia;
	}
	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}

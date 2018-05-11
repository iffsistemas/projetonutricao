package modelo;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Schedule {
	
	@Id @GeneratedValue
	private Long id;
	private String compromisso;
	private Date dataSelecionada;
	
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCompromisso() {
		return compromisso;
	}
	public void setCompromisso(String compromisso) {
		this.compromisso = compromisso;
	}
	
	public Date getDataSelecionada() {
		return dataSelecionada;
	}
	
	public void setDataSelecionada(Date dataSelecionada) {
		this.dataSelecionada = dataSelecionada;
	}
	
	
	

	
	





}

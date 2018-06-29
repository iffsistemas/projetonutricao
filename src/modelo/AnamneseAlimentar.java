package modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class AnamneseAlimentar {
	
	@Id @GeneratedValue
	private Long id;
	
	private String ingestaoHidrica;
	private String  preferencias;
	private String aversoes;
	private String observacoes;
	
	@OneToMany(cascade=CascadeType.ALL)
	private List<Refeicao> refeicoes = new ArrayList<Refeicao>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIngestaoHidrica() {
		return ingestaoHidrica;
	}

	public void setIngestaoHidrica(String ingestaoHidrica) {
		this.ingestaoHidrica = ingestaoHidrica;
	}

	public String getPreferencias() {
		return preferencias;
	}

	public void setPreferencias(String preferencias) {
		this.preferencias = preferencias;
	}

	public String getAversoes() {
		return aversoes;
	}

	public void setAversoes(String aversoes) {
		this.aversoes = aversoes;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public List<Refeicao> getRefeicoes() {
		return refeicoes;
	}

	public void setRefeicoes(List<Refeicao> refeicoes) {
		this.refeicoes = refeicoes;
	}
	
	
	
	
	

}

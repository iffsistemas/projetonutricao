package modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;


@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class AlimentoTabela {
	
	
	
	@Id @GeneratedValue
	private Long id;
	private String nome;
	private Double quantidade;
	private Double kcal;
	private Double proteina;
	private Double lipideos;
	private Double calcio;
	private Double ferro;
	private Double vitaminaC;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Double getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Double quantidade) {
		this.quantidade = quantidade;
	}
		public Double getKcal() {
		return kcal;
	}
	public void setKcal(Double kcal) {
		this.kcal = kcal;
	}
	public Double getProteina() {
		return proteina;
	}
	public void setProteina(Double proteina) {
		this.proteina = proteina;
	}
	public Double getLipideos() {
		return lipideos;
	}
	public void setLipideos(Double lipideos) {
		this.lipideos = lipideos;
	}
	public Double getCalcio() {
		return calcio;
	}
	public void setCalcio(Double calcio) {
		this.calcio = calcio;
	}
	public Double getFerro() {
		return ferro;
	}
	public void setFerro(Double ferro) {
		this.ferro = ferro;
	}
	public Double getVitaminaC() {
		return vitaminaC;
	}
	public void setVitaminaC(Double vitaminaC) {
		this.vitaminaC = vitaminaC;
	}
	
	
	
	

}

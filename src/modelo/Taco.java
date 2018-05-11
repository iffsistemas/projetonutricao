package modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Taco {
	
	@Id @GeneratedValue
	private Long id;
	private String nome;
	private Double umidade;
	private Double kcal;
	private Double kj;
	private Double proteina;
	private Double lipideos;
	private Double colesterol;
	private Double carboidrato;
	private Double fibraAlimentar;
	private Double cinzas;
	private Double calcio;
	private Double magnesio;
	private Double manganes;
	private Double fosforo;
	private Double ferro;
	private Double sodio;
	private Double potassio;
	private Double cobre;
	private Double zinco;
	private Double retinol;
	private Double re;
	private Double rea;
	private Double tiamina;
	private Double riboflavina;
	private Double piridoxina;
	private Double niacina;
	private Double vitaminaC;
	
	
	
	public Double getUmidade() {
		return umidade;
	}
	
	public void setUmidade(Double umidade) {
		this.umidade = umidade;
	}
	
	
	
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

	public Double getKcal() {
		return kcal;
	}

	public void setKcal(Double kcal) {
		this.kcal = kcal;
	}

	public Double getKj() {
		return kj;
	}

	public void setKj(Double kj) {
		this.kj = kj;
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

	public Double getColesterol() {
		return colesterol;
	}

	public void setColesterol(Double colesterol) {
		this.colesterol = colesterol;
	}

	public Double getCarboidrato() {
		return carboidrato;
	}

	public void setCarboidrato(Double carboidrato) {
		this.carboidrato = carboidrato;
	}

	public Double getFibraAlimentar() {
		return fibraAlimentar;
	}

	public void setFibraAlimentar(Double fibraAlimentar) {
		this.fibraAlimentar = fibraAlimentar;
	}

	public Double getCinzas() {
		return cinzas;
	}

	public void setCinzas(Double cinzas) {
		this.cinzas = cinzas;
	}

	public Double getCalcio() {
		return calcio;
	}

	public void setCalcio(Double calcio) {
		this.calcio = calcio;
	}

	public Double getMagnesio() {
		return magnesio;
	}

	public void setMagnesio(Double magnesio) {
		this.magnesio = magnesio;
	}

	public Double getManganes() {
		return manganes;
	}

	public void setManganes(Double manganes) {
		this.manganes = manganes;
	}

	public Double getFosforo() {
		return fosforo;
	}

	public void setFosforo(Double fosforo) {
		this.fosforo = fosforo;
	}

	public Double getFerro() {
		return ferro;
	}

	public void setFerro(Double ferro) {
		this.ferro = ferro;
	}

	public Double getSodio() {
		return sodio;
	}

	public void setSodio(Double sodio) {
		this.sodio = sodio;
	}

	public Double getPotassio() {
		return potassio;
	}

	public void setPotassio(Double potassio) {
		this.potassio = potassio;
	}

	public Double getCobre() {
		return cobre;
	}

	public void setCobre(Double cobre) {
		this.cobre = cobre;
	}

	public Double getZinco() {
		return zinco;
	}

	public void setZinco(Double zinco) {
		this.zinco = zinco;
	}

	public Double getRetinol() {
		return retinol;
	}

	public void setRetinol(Double retinol) {
		this.retinol = retinol;
	}

	public Double getRe() {
		return re;
	}

	public void setRe(Double re) {
		this.re = re;
	}

	public Double getRea() {
		return rea;
	}

	public void setRea(Double rea) {
		this.rea = rea;
	}

	public Double getTiamina() {
		return tiamina;
	}

	public void setTiamina(Double tiamina) {
		this.tiamina = tiamina;
	}

	public Double getRiboflavina() {
		return riboflavina;
	}

	public void setRiboflavina(Double riboflavina) {
		this.riboflavina = riboflavina;
	}

	public Double getPiridoxina() {
		return piridoxina;
	}

	public void setPiridoxina(Double piridoxina) {
		this.piridoxina = piridoxina;
	}

	public Double getNiacina() {
		return niacina;
	}

	public void setNiacina(Double niacina) {
		this.niacina = niacina;
	}

	public Double getVitaminaC() {
		return vitaminaC;
	}

	public void setVitaminaC(Double vitaminaC) {
		this.vitaminaC = vitaminaC;
	}
	
	
	

}

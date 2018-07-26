package modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Alimento {

	@Id @GeneratedValue
	private Long id;
	private String alimento;
	private Double quantidade;
	private Double carboitrado;
	private Double proteina;
	private Double lipideos;
	private Double fibras;
	private Double calcio;
	private Double ferro;
	private Double fosforo;
	private Double sodio;
	private Double potassio;
	private Double tiamina;
	private Double roboflamina;
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAlimento() {
		return alimento;
	}
	public void setAlimento(String alimento) {
		this.alimento = alimento;
	}
	public Double getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Double quantidade) {
		this.quantidade = quantidade;
	}
	public Double getCarboitrado() {
		return carboitrado;
	}
	public void setCarboitrado(Double carboitrado) {
		this.carboitrado = carboitrado;
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
	public Double getFibras() {
		return fibras;
	}
	public void setFibras(Double fibras) {
		this.fibras = fibras;
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
	public Double getFosforo() {
		return fosforo;
	}
	public void setFosforo(Double fosforo) {
		this.fosforo = fosforo;
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
	public Double getTiamina() {
		return tiamina;
	}
	public void setTiamina(Double tiamina) {
		this.tiamina = tiamina;
	}
	public Double getRoboflamina() {
		return roboflamina;
	}
	public void setRoboflamina(Double roboflamina) {
		this.roboflamina = roboflamina;
	}
	
	
	
	
	
	
}

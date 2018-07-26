package modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class DescricaoMedidasCaseiras {
	
	@Id @GeneratedValue
	private Long id;
	private String nome;
	private Double quantidade;
	private Double kcal;
	private Double ptn;
	private Double gli;
	private Double lip;
	private Double ca;
	private Double fe;
	private Double vitC;
	private Double vitA;
	private String fonte;
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
	public Double getPtn() {
		return ptn;
	}
	public void setPtn(Double ptn) {
		this.ptn = ptn;
	}
	public Double getGli() {
		return gli;
	}
	public void setGli(Double gli) {
		this.gli = gli;
	}
	public Double getLip() {
		return lip;
	}
	public void setLip(Double lip) {
		this.lip = lip;
	}
	public Double getCa() {
		return ca;
	}
	public void setCa(Double ca) {
		this.ca = ca;
	}
	public Double getFe() {
		return fe;
	}
	public void setFe(Double fe) {
		this.fe = fe;
	}
	public Double getVitC() {
		return vitC;
	}
	public void setVitC(Double vitC) {
		this.vitC = vitC;
	}
	public Double getVitA() {
		return vitA;
	}
	public void setVitA(Double vitA) {
		this.vitA = vitA;
	}
	public String getFonte() {
		return fonte;
	}
	public void setFonte(String fonte) {
		this.fonte = fonte;
	}
	
	
	
	

}

package modelo;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class AtendimentoAdulto extends Atendimento {
	
	
	private Double pesoHabitual;
    private Double altura;
    private Double pesoAtual; 
    private Double pesoObjetivo; 
    private Double indiceMassaCorporal; 
    private Double gastoEnergeticoDiario;
    private Double metabolismoBasal;
    private Double valorCaloricoEscolhido;
    private String conclusao;
	
     @OneToOne(cascade=CascadeType.ALL)
     Circuferencia circunferencia = new Circuferencia();
     
     @OneToOne(cascade=CascadeType.ALL)
     PregaCutanea pregaCutanea = new PregaCutanea();
     
     
     public Double getPesoHabitual() {
		return pesoHabitual;
	}
	public void setPesoHabitual(Double pesoHabitual) {
		this.pesoHabitual = pesoHabitual;
	}
	public Double getAltura() {
		return altura;
	}
	public void setAltura(Double altura) {
		this.altura = altura;
	}
	public Double getPesoAtual() {
		return pesoAtual;
	}
	public void setPesoAtual(Double pesoAtual) {
		this.pesoAtual = pesoAtual;
	}
	public Double getPesoObjetivo() {
		return pesoObjetivo;
	}
	public void setPesoObjetivo(Double pesoObjetivo) {
		this.pesoObjetivo = pesoObjetivo;
	}
	public Double getIndiceMassaCorporal() {
		return indiceMassaCorporal;
	}
	public void setIndiceMassaCorporal(Double indiceMassaCorporal) {
		this.indiceMassaCorporal = indiceMassaCorporal;
	}
	public Circuferencia getCircunferencia() {
		return circunferencia;
	}
	public void setCircunferencia(Circuferencia circunferencia) {
		this.circunferencia = circunferencia;
	}
	public Double getGastoEnergeticoDiario() {
		return gastoEnergeticoDiario;
	}
	public void setGastoEnergeticoDiario(Double gastoEnergeticoDiario) {
		this.gastoEnergeticoDiario = gastoEnergeticoDiario;
	}
	public Double getMetabolismoBasal() {
		return metabolismoBasal;
	}
	public void setMetabolismoBasal(Double metabolismoBasal) {
		this.metabolismoBasal = metabolismoBasal;
	}
	public Double getValorCaloricoEscolhido() {
		return valorCaloricoEscolhido;
	}
	public void setValorCaloricoEscolhido(Double valorCaloricoEscolhido) {
		this.valorCaloricoEscolhido = valorCaloricoEscolhido;
	}
	public String getConclusao() {
		return conclusao;
	}
	public void setConclusao(String conclusao) {
		this.conclusao = conclusao;
	}
	public PregaCutanea getPregaCutanea() {
		return pregaCutanea;
	}
	public void setPregaCutanea(PregaCutanea pregaCutanea) {
		this.pregaCutanea = pregaCutanea;
	}
    
	
  
	


}

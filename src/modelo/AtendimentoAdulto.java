package modelo;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class AtendimentoAdulto {
	
	
	@Id @GeneratedValue
	private Long id;
	
	@Column(length=100)
	private String descricao;
	
	
	@Temporal(TemporalType.DATE)
	private Date dataAtendimento = new Date();
	
	@OneToOne
	private Paciente paciente;
	
	@OneToOne(cascade=CascadeType.ALL)
	ExamesLaboratoriais examesLaboratoriais;
	
	private Double pesoHabitual;
    private Double altura;
    private Double pesoAtual; 
    private Double pesoObjetivo; 
    private Double imc; 
    
    private Double cc;
    private Double cq;
    private Double cb;
    private Double cabd;
    
	 private Double gastoEnergetico;
     private Double metabolismoBasal;
     private Double valorCalorico;
     private String conclusao;
    
    //passar para outra classe
    

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getDataAtendimento() {
		return dataAtendimento;
	}

	public void setDataAtendimento(Date dataAtendimento) {
		this.dataAtendimento = dataAtendimento;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public ExamesLaboratoriais getExamesLaboratoriais() {
		return examesLaboratoriais;
	}

	public void setExamesLaboratoriais(ExamesLaboratoriais examesLaboratoriais) {
		this.examesLaboratoriais = examesLaboratoriais;
	}

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

	public Double getImc() {
		return imc;
	}

	public void setImc(Double imc) {
		this.imc = imc;
	}

	public Double getCc() {
		return cc;
	}

	public void setCc(Double cc) {
		this.cc = cc;
	}

	public Double getCq() {
		return cq;
	}

	public void setCq(Double cq) {
		this.cq = cq;
	}

	public Double getCb() {
		return cb;
	}

	public void setCb(Double cb) {
		this.cb = cb;
	}

	public Double getCabd() {
		return cabd;
	}

	public void setCabd(Double cabd) {
		this.cabd = cabd;
	}

	public Double getGastoEnergetico() {
		return gastoEnergetico;
	}

	public void setGastoEnergetico(Double gastoEnergetico) {
		this.gastoEnergetico = gastoEnergetico;
	}

	public Double getMetabolismoBasal() {
		return metabolismoBasal;
	}

	public void setMetabolismoBasal(Double metabolismoBasal) {
		this.metabolismoBasal = metabolismoBasal;
	}

	public Double getValorCalorico() {
		return valorCalorico;
	}

	public void setValorCalorico(Double valorCalorico) {
		this.valorCalorico = valorCalorico;
	}

	public String getConclusao() {
		return conclusao;
	}

	public void setConclusao(String conclusao) {
		this.conclusao = conclusao;
	}

	
	


}

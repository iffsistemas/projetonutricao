package modelo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

@Entity
public class PacienteAdulto extends Paciente {
	
	@Column(length=50)
  private String profissão="Professor";
	
	@ElementCollection(fetch = FetchType.EAGER)
	private Collection<MotivoAtendimento> motivos  = new ArrayList<MotivoAtendimento>();
	
	private String outrosMotivos;
	private String problemaDeSaude;
	
	@OneToMany(cascade=CascadeType.ALL)
	private List<Medicamento> medicamentos = new ArrayList<Medicamento>();
	

	//List Cirurgia
	
	private String qualCirurgia;
	
	private String quandoCirurgia;
	
	//List Hereditariedade
	
	private String outraHereditariedade;
	
	private String atividadeVezPorSem;
	private String atividadeHoras;
	private String atividadeDuracao;
	
	private Boolean comeDevagar;
	private Boolean mastigaBemOsAlimentos;
	
	private Boolean etilista;
	private Boolean tabagista;
	
	private String alergiaAlimentar;
	private String intoleranciaAlimentar;
	private String horarioDeMaisFome;
	private String alimentosPreferidos;
	private String aversaoAlimentar;
	
	@OneToMany(cascade=CascadeType.ALL)
	private List<AvaliacaoDaAlimentacao> alimentacoes = new ArrayList<AvaliacaoDaAlimentacao>();
	
	private String moraCom;
	private String manipuladorAlimento;
	
	private String horarioQueEstuda;
	private String horarioQueTrabalha;
	
	private Boolean maiorParteSentado;
	private Boolean desconfortoIntestinal;
	private Boolean temTPM;
	
	private String deslocamentoAtividade;
	private String alteracaoApetite;
	private String consumoDoces;
	private String ingestaoHidrica;
	
	
public String getProfissão() {
	return profissão;
}

public void setProfissão(String profissão) {
	this.profissão = profissão;
}

public String getOutrosMotivos() {
	return outrosMotivos;
}

public void setOutrosMotivos(String outrosMotivos) {
	this.outrosMotivos = outrosMotivos;
}

public Collection<MotivoAtendimento> getMotivos() {
	return motivos;
}

public void setMotivos(Collection<MotivoAtendimento> motivos) {
	this.motivos = motivos;
}

public String getProblemaDeSaude() {
	return problemaDeSaude;
}

public void setProblemaDeSaude(String problemaDeSaude) {
	this.problemaDeSaude = problemaDeSaude;
}

public List<Medicamento> getMedicamentos() {
	return medicamentos;
}

public void setMedicamentos(List<Medicamento> medicamentos) {
	this.medicamentos = medicamentos;
}

public String getQualCirurgia() {
	return qualCirurgia;
}

public void setQualCirurgia(String qualCirurgia) {
	this.qualCirurgia = qualCirurgia;
}

public String getQuandoCirurgia() {
	return quandoCirurgia;
}

public void setQuandoCirurgia(String quandoCirurgia) {
	this.quandoCirurgia = quandoCirurgia;
}

public String getOutraHereditariedade() {
	return outraHereditariedade;
}

public void setOutraHereditariedade(String outraHereditariedade) {
	this.outraHereditariedade = outraHereditariedade;
}


public String getAtividadeVezPorSem() {
	return atividadeVezPorSem;
}

public void setAtividadeVezPorSem(String atividadeVezPorSem) {
	this.atividadeVezPorSem = atividadeVezPorSem;
}

public String getAtividadeHoras() {
	return atividadeHoras;
}

public void setAtividadeHoras(String atividadeHoras) {
	this.atividadeHoras = atividadeHoras;
}

public String getAtividadeDuracao() {
	return atividadeDuracao;
}

public void setAtividadeDuracao(String atividadeDuracao) {
	this.atividadeDuracao = atividadeDuracao;
}

public Boolean getComeDevagar() {
	return comeDevagar;
}

public void setComeDevagar(Boolean comeDevagar) {
	this.comeDevagar = comeDevagar;
}

public Boolean getMastigaBemOsAlimentos() {
	return mastigaBemOsAlimentos;
}

public void setMastigaBemOsAlimentos(Boolean mastigaBemOsAlimentos) {
	this.mastigaBemOsAlimentos = mastigaBemOsAlimentos;
}

public Boolean getEtilista() {
	return etilista;
}

public void setEtilista(Boolean etilista) {
	this.etilista = etilista;
}

public Boolean getTabagista() {
	return tabagista;
}

public void setTabagista(Boolean tabagista) {
	this.tabagista = tabagista;
}

public String getAlergiaAlimentar() {
	return alergiaAlimentar;
}

public void setAlergiaAlimentar(String alergiaAlimentar) {
	this.alergiaAlimentar = alergiaAlimentar;
}

public String getIntoleranciaAlimentar() {
	return intoleranciaAlimentar;
}

public void setIntoleranciaAlimentar(String intoleranciaAlimentar) {
	this.intoleranciaAlimentar = intoleranciaAlimentar;
}

public String getHorarioDeMaisFome() {
	return horarioDeMaisFome;
}

public void setHorarioDeMaisFome(String horarioDeMaisFome) {
	this.horarioDeMaisFome = horarioDeMaisFome;
}

public String getAlimentosPreferidos() {
	return alimentosPreferidos;
}

public void setAlimentosPreferidos(String alimentosPreferidos) {
	this.alimentosPreferidos = alimentosPreferidos;
}

public String getAversaoAlimentar() {
	return aversaoAlimentar;
}

public void setAversaoAlimentar(String aversaoAlimentar) {
	this.aversaoAlimentar = aversaoAlimentar;
}


public List<AvaliacaoDaAlimentacao> getAlimentacoes() {
	return alimentacoes;
}

public void setAlimentacoes(List<AvaliacaoDaAlimentacao> alimentacoes) {
	this.alimentacoes = alimentacoes;
}

public String getMoraCom() {
	return moraCom;
}

public void setMoraCom(String moraCom) {
	this.moraCom = moraCom;
}

public String getManipuladorAlimento() {
	return manipuladorAlimento;
}

public void setManipuladorAlimento(String manipuladorAlimento) {
	this.manipuladorAlimento = manipuladorAlimento;
}

public String getHorarioQueEstuda() {
	return horarioQueEstuda;
}

public void setHorarioQueEstuda(String horarioQueEstuda) {
	this.horarioQueEstuda = horarioQueEstuda;
}

public String getHorarioQueTrabalha() {
	return horarioQueTrabalha;
}

public void setHorarioQueTrabalha(String horarioQueTrabalha) {
	this.horarioQueTrabalha = horarioQueTrabalha;
}

public Boolean getMaiorParteSentado() {
	return maiorParteSentado;
}

public void setMaiorParteSentado(Boolean maiorParteSentado) {
	this.maiorParteSentado = maiorParteSentado;
}

public Boolean getDesconfortoIntestinal() {
	return desconfortoIntestinal;
}

public void setDesconfortoIntestinal(Boolean desconfortoIntestinal) {
	this.desconfortoIntestinal = desconfortoIntestinal;
}

public Boolean getTemTPM() {
	return temTPM;
}

public void setTemTPM(Boolean temTPM) {
	this.temTPM = temTPM;
}

public String getDeslocamentoAtividade() {
	return deslocamentoAtividade;
}

public void setDeslocamentoAtividade(String deslocamentoAtividade) {
	this.deslocamentoAtividade = deslocamentoAtividade;
}

public String getAlteracaoApetite() {
	return alteracaoApetite;
}

public void setAlteracaoApetite(String alteracaoApetite) {
	this.alteracaoApetite = alteracaoApetite;
}

public String getConsumoDoces() {
	return consumoDoces;
}

public void setConsumoDoces(String consumoDoces) {
	this.consumoDoces = consumoDoces;
}

public String getIngestaoHidrica() {
	return ingestaoHidrica;
}

public void setIngestaoHidrica(String ingestaoHidrica) {
	this.ingestaoHidrica = ingestaoHidrica;
}









  
	

}

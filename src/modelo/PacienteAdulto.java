package modelo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

@Entity
public class PacienteAdulto extends Paciente {
	
	private String email;
	private String profissão;
	private String outrosMotivos;
	private String problemaDeSaude;
	private Boolean feitoExameDeSangue;
	private String qualCirurgia;
	private String quandoCirurgia;
	private String outrasDoencas;
	private String examesFisicos;
	private String qualAtividade;
	private String vezesPorSemanaDaAtividadeFisica;
	private String quantidadeDeHorasPorSemanaDaAtividade;
	private String duracaoDaAtividadeFisica;
	private String deslocamentoParaAsAtividades;
	private Boolean comeDevagar;
	private Boolean mastigaBemOsAlimentos;
	private String alergiaAQualAlimento;
	private String intoleranciaAlimentar;
	private String alimentoPreferido;
	private String horarioDeMaisFome;
	private String aversoesAlimentares;
	private String horaAcorda;
	private String horaDorme; 
	private String comQuemMora;
	private Boolean preparaAlimento;
	private String quemCozinhaNaCasa;
	private String horarioQueEstuda;
	private String horarioQueTrabalha;
	private Boolean maiorParteSentado;
	private Boolean desconfortosIntestinais;
	private String alteracaoDeApetiteAnsiedade;
	private Boolean temTPM;
	private String consumoDeDoces;
	private Boolean etilista;
	private Boolean tabagista;
	private String ingestaoHidrica; 
	
	private String informacaoAdicional1;
	private String informacaoAdicional2;
	private String informacaoAdicional3;
	private String informacaoAdicional4;
	private String informacaoAdicional5;
	
	
	@ElementCollection(fetch = FetchType.EAGER)
	private Collection<MotivoAtendimento> motivos  = new ArrayList<MotivoAtendimento>();
	
	@OneToMany(cascade=CascadeType.ALL)
	private List<Medicamento> medicamentos = new ArrayList<Medicamento>();
	
	
	//ENEM Hereditariedade
	//ENUM Cirurgia
	
	
	
	
	

	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}

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

	public String getProblemaDeSaude() {
		return problemaDeSaude;
	}

	public void setProblemaDeSaude(String problemaDeSaude) {
		this.problemaDeSaude = problemaDeSaude;
	}

	public Boolean getFeitoExameDeSangue() {
		return feitoExameDeSangue;
	}

	public void setFeitoExameDeSangue(Boolean feitoExameDeSangue) {
		this.feitoExameDeSangue = feitoExameDeSangue;
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

	public String getOutrasDoencas() {
		return outrasDoencas;
	}

	public void setOutrasDoencas(String outrasDoencas) {
		this.outrasDoencas = outrasDoencas;
	}

	public String getExamesFisicos() {
		return examesFisicos;
	}

	public void setExamesFisicos(String examesFisicos) {
		this.examesFisicos = examesFisicos;
	}

	public String getQualAtividade() {
		return qualAtividade;
	}

	public void setQualAtividade(String qualAtividade) {
		this.qualAtividade = qualAtividade;
	}

	public String getVezesPorSemanaDaAtividadeFisica() {
		return vezesPorSemanaDaAtividadeFisica;
	}

	public void setVezesPorSemanaDaAtividadeFisica(String vezesPorSemanaDaAtividadeFisica) {
		this.vezesPorSemanaDaAtividadeFisica = vezesPorSemanaDaAtividadeFisica;
	}

	public String getQuantidadeDeHorasPorSemanaDaAtividade() {
		return quantidadeDeHorasPorSemanaDaAtividade;
	}

	public void setQuantidadeDeHorasPorSemanaDaAtividade(String quantidadeDeHorasPorSemanaDaAtividade) {
		this.quantidadeDeHorasPorSemanaDaAtividade = quantidadeDeHorasPorSemanaDaAtividade;
	}

	public String getDuracaoDaAtividadeFisica() {
		return duracaoDaAtividadeFisica;
	}

	public void setDuracaoDaAtividadeFisica(String duracaoDaAtividadeFisica) {
		this.duracaoDaAtividadeFisica = duracaoDaAtividadeFisica;
	}

	

	public String getDeslocamentoParaAsAtividades() {
		return deslocamentoParaAsAtividades;
	}

	public void setDeslocamentoParaAsAtividades(String deslocamentoParaAsAtividades) {
		this.deslocamentoParaAsAtividades = deslocamentoParaAsAtividades;
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

	public String getAlergiaAQualAlimento() {
		return alergiaAQualAlimento;
	}

	public void setAlergiaAQualAlimento(String alergiaAQualAlimento) {
		this.alergiaAQualAlimento = alergiaAQualAlimento;
	}

	public String getIntoleranciaAlimentar() {
		return intoleranciaAlimentar;
	}

	public void setIntoleranciaAlimentar(String intoleranciaAlimentar) {
		this.intoleranciaAlimentar = intoleranciaAlimentar;
	}

	public String getAlimentoPreferido() {
		return alimentoPreferido;
	}

	public void setAlimentoPreferido(String alimentoPreferido) {
		this.alimentoPreferido = alimentoPreferido;
	}

	public String getHorarioDeMaisFome() {
		return horarioDeMaisFome;
	}

	public void setHorarioDeMaisFome(String horarioDeMaisFome) {
		this.horarioDeMaisFome = horarioDeMaisFome;
	}

	public String getAversoesAlimentares() {
		return aversoesAlimentares;
	}

	public void setAversoesAlimentares(String aversoesAlimentares) {
		this.aversoesAlimentares = aversoesAlimentares;
	}

	public String getHoraAcorda() {
		return horaAcorda;
	}

	public void setHoraAcorda(String horaAcorda) {
		this.horaAcorda = horaAcorda;
	}

	public String getHoraDorme() {
		return horaDorme;
	}

	public void setHoraDorme(String horaDorme) {
		this.horaDorme = horaDorme;
	}

	public String getComQuemMora() {
		return comQuemMora;
	}

	public void setComQuemMora(String comQuemMora) {
		this.comQuemMora = comQuemMora;
	}

	public Boolean getPreparaAlimento() {
		return preparaAlimento;
	}

	public void setPreparaAlimento(Boolean preparaAlimento) {
		this.preparaAlimento = preparaAlimento;
	}

	public String getQuemCozinhaNaCasa() {
		return quemCozinhaNaCasa;
	}

	public void setQuemCozinhaNaCasa(String quemCozinhaNaCasa) {
		this.quemCozinhaNaCasa = quemCozinhaNaCasa;
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

	public Boolean getDesconfortosIntestinais() {
		return desconfortosIntestinais;
	}

	public void setDesconfortosIntestinais(Boolean desconfortosIntestinais) {
		this.desconfortosIntestinais = desconfortosIntestinais;
	}

	public String getAlteracaoDeApetiteAnsiedade() {
		return alteracaoDeApetiteAnsiedade;
	}

	public void setAlteracaoDeApetiteAnsiedade(String alteracaoDeApetiteAnsiedade) {
		this.alteracaoDeApetiteAnsiedade = alteracaoDeApetiteAnsiedade;
	}

	public Boolean getTemTPM() {
		return temTPM;
	}

	public void setTemTPM(Boolean temTPM) {
		this.temTPM = temTPM;
	}

	public String getConsumoDeDoces() {
		return consumoDeDoces;
	}

	public void setConsumoDeDoces(String consumoDeDoces) {
		this.consumoDeDoces = consumoDeDoces;
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

	public String getIngestaoHidrica() {
		return ingestaoHidrica;
	}

	public void setIngestaoHidrica(String ingestaoHidrica) {
		this.ingestaoHidrica = ingestaoHidrica;
	}

	public Collection<MotivoAtendimento> getMotivos() {
		return motivos;
	}

	public void setMotivos(Collection<MotivoAtendimento> motivos) {
		this.motivos = motivos;
	}

	public List<Medicamento> getMedicamentos() {
		return medicamentos;
	}

	public void setMedicamentos(List<Medicamento> medicamentos) {
		this.medicamentos = medicamentos;
	}


	public String getInformacaoAdicional1() {
		return informacaoAdicional1;
	}


	public void setInformacaoAdicional1(String informacaoAdicional1) {
		this.informacaoAdicional1 = informacaoAdicional1;
	}


	public String getInformacaoAdicional2() {
		return informacaoAdicional2;
	}


	public void setInformacaoAdicional2(String informacaoAdicional2) {
		this.informacaoAdicional2 = informacaoAdicional2;
	}


	public String getInformacaoAdicional3() {
		return informacaoAdicional3;
	}


	public void setInformacaoAdicional3(String informacaoAdicional3) {
		this.informacaoAdicional3 = informacaoAdicional3;
	}


	public String getInformacaoAdicional4() {
		return informacaoAdicional4;
	}


	public void setInformacaoAdicional4(String informacaoAdicional4) {
		this.informacaoAdicional4 = informacaoAdicional4;
	}


	public String getInformacaoAdicional5() {
		return informacaoAdicional5;
	}


	public void setInformacaoAdicional5(String informacaoAdicional5) {
		this.informacaoAdicional5 = informacaoAdicional5;
	}


	
	
	
	
	
	
	
	
	
	 
	
	
	
	
	
	
	
	
	

	
	
	
	



  
	

}

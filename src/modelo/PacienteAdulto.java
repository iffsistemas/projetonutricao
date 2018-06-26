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
	
	private String ativVezPorSem;
	private String atvhoras;
	private String atvDuracao;
	
	private Boolean comeDevagar;
	private Boolean mastigaBemOsAlimentos;
	
	
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

public String getAtivVezPorSem() {
	return ativVezPorSem;
}

public void setAtivVezPorSem(String ativVezPorSem) {
	this.ativVezPorSem = ativVezPorSem;
}

public String getAtvhoras() {
	return atvhoras;
}

public void setAtvhoras(String atvhoras) {
	this.atvhoras = atvhoras;
}

public String getAtvDuracao() {
	return atvDuracao;
}

public void setAtvDuracao(String atvDuracao) {
	this.atvDuracao = atvDuracao;
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





  
	

}

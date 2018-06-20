package modelo;

import java.util.ArrayList;
import java.util.Collection;

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
	@OneToMany
	private Medicamento medicamento;
	
	
	

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

public Medicamento getMedicamento() {
	return medicamento;
}

public void setMedicamento(Medicamento medicamento) {
	this.medicamento = medicamento;
}
  

  
	

}

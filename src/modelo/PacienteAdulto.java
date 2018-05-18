package modelo;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class PacienteAdulto extends Paciente{

	
	
	private String profissão="Professor";
	
	@ElementCollection(fetch = FetchType.EAGER)
	private Collection<MotivoAtendimento> motivos  = new ArrayList<MotivoAtendimento>();
	
	

	public String getProfissão() {
		return profissão;
	}

	public void setProfissão(String profissão) {
		this.profissão = profissão;
	}
	
	public Collection<MotivoAtendimento> getMotivos() {
		return motivos;
	}

	public void setMotivos(Collection<MotivoAtendimento> motivos) {
		this.motivos = motivos;
	}	
	
}

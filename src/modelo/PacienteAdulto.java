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

	
	
	private String profiss�o="Professor";
	
	@ElementCollection(fetch = FetchType.EAGER)
	private Collection<MotivoAtendimento> motivos  = new ArrayList<MotivoAtendimento>();
	
	

	public String getProfiss�o() {
		return profiss�o;
	}

	public void setProfiss�o(String profiss�o) {
		this.profiss�o = profiss�o;
	}
	
	public Collection<MotivoAtendimento> getMotivos() {
		return motivos;
	}

	public void setMotivos(Collection<MotivoAtendimento> motivos) {
		this.motivos = motivos;
	}	
	
}

package modelo;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class PacienteGestante extends Paciente {
	
	@Column(length=20)
  private String profissão="Destista";

public String getProfissão() {
	return profissão;
}

public void setProfissão(String profissão) {
	this.profissão = profissão;
}
  
  
	

}

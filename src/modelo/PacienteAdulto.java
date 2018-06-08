package modelo;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class PacienteAdulto extends Paciente {
	
	@Column(length=20)
  private String profissão="Professor";

public String getProfissão() {
	return profissão;
}

public void setProfissão(String profissão) {
	this.profissão = profissão;
}
  
  
	

}

package modelo;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class CadastroPacienteAdulto extends CadastroPaciente {
	
	@Column(length=20)
  private String profissão;

public String getProfissão() {
	return profissão;
}

public void setProfissão(String profissão) {
	this.profissão = profissão;
}
  
  
	

}

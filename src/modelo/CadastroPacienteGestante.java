package modelo;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class CadastroPacienteGestante extends CadastroPaciente {
	
	@Column(length=20)
  private String profiss�o="Destista";

public String getProfiss�o() {
	return profiss�o;
}

public void setProfiss�o(String profiss�o) {
	this.profiss�o = profiss�o;
}
  
  
	

}

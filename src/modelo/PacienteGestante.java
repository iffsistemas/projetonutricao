package modelo;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class PacienteGestante extends Paciente {
	
	
	private String email="pac1@email.com";
	
	@Column(length=20)
  private String profiss�o="Destista";
	
	

public String getProfiss�o() {
	return profiss�o;
}

public void setProfiss�o(String profiss�o) {
	this.profiss�o = profiss�o;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}
  
  
	

}

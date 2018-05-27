package modelo;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class CadastroPacienteCrianca extends CadastroPaciente {
	
	
   private Boolean escolaridade;
   @Column(length=15)
   private String periodo;
   
   
   
public Boolean getEscolaridade() {
	return escolaridade;
}
public void setEscolaridade(Boolean escolaridade) {
	this.escolaridade = escolaridade;
}
public String getPeriodo() {
	return periodo;
}
public void setPeriodo(String periodo) {
	this.periodo = periodo;
}
   
   
   
  
	

}

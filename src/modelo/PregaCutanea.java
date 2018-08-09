package modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class PregaCutanea {
	
	@Id @GeneratedValue
	private Long id;
	private Double percentualGordura;
	public Long getId() {
		return id;
	}
	
	
	
	public void setId(Long id) {
		this.id = id;
	}
	public Double getPercentualGordura() {
		return percentualGordura;
	}
	public void setPercentualGordura(Double percentualGordura) {
		this.percentualGordura = percentualGordura;
	}
	
	

}

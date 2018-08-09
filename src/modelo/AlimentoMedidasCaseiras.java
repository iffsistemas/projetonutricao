package modelo;

import javax.persistence.Entity;

@Entity
public class AlimentoMedidasCaseiras extends AlimentoTabela {
	
	
	private Double gli;
	private Double vitaminaA;
	
	public Double getGli() {
		return gli;
	}

	public void setGli(Double gli) {
		this.gli = gli;
	}

	public Double getVitaminaA() {
		return vitaminaA;
	}

	public void setVitaminaA(Double vitaminaA) {
		this.vitaminaA = vitaminaA;
	}

	
	
	@Override
	public String getNomeAlimento() {
		StringBuilder sb = new StringBuilder();
		sb.append(getNome());
		sb.append(" (CASEIRA)");
		
		return sb.toString();
		
	}
	
	
	
}	
	

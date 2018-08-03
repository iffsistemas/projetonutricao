package modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class QuantidadePorcao {

	
	@Id @GeneratedValue
	private Long id;
	private double quantidade;
	
	@ManyToOne
	private Porcao porcao = new Porcao();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(double quantidade) {
		this.quantidade = quantidade;
	}

	public Porcao getPorcao() {
		return porcao;
	}

	public void setPorcao(Porcao porcao) {
		this.porcao = porcao;
	}

	@Override
	public String toString() {
		return "QuantidadePorcao [quantidade=" + quantidade + ", porcao=" + porcao + "]";
	}
	
	
	
	
}

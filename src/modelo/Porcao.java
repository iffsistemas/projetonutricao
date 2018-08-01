package modelo;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Porcao {
	
	
		@Id @GeneratedValue
		private Long id;
		private String descricao;
		private double quantidade;
		
		@ManyToOne(cascade=CascadeType.ALL)
		private AlimentoTabela alimentoTabela;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getDescricao() {
			return descricao;
		}

		public void setDescricao(String descricao) {
			this.descricao = descricao;
		}

		public double getQuantidade() {
			return quantidade;
		}

		public void setQuantidade(double quantidade) {
			this.quantidade = quantidade;
		}

		public AlimentoTabela getAlimentoTabela() {
			return alimentoTabela;
		}

		public void setAlimentoTabela(AlimentoTabela alimentoTabela) {
			this.alimentoTabela = alimentoTabela;
		}	
		
		
	    

}

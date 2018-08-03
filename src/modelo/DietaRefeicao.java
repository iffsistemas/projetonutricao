package modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class DietaRefeicao {
	
	
		@Id @GeneratedValue
		private Long id;
		private String descricao;
		
		private String hora;
		
		private String local;
		
		@ManyToMany(cascade=CascadeType.ALL)
		private List<QuantidadePorcao> quantidadePorcoes = new ArrayList<QuantidadePorcao>();
		
		
		
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
		public String getHora() {
			return hora;
		}
		public void setHora(String hora) {
			this.hora = hora;
		}
		public String getLocal() {
			return local;
		}
		public void setLocal(String local) {
			this.local = local;
		}
		public List<QuantidadePorcao> getQuantidadePorcoes() {
			return quantidadePorcoes;
		}
		public void setQuantidadePorcoes(List<QuantidadePorcao> quantidadePorcoes) {
			this.quantidadePorcoes = quantidadePorcoes;
		}
		  
		

}

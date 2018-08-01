package modelo;

import java.util.ArrayList;
import java.util.Date;
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
		private Date hora;
		
		@ManyToMany(cascade=CascadeType.ALL)
		private List<Porcao> porcoes = new ArrayList<Porcao>();
		
		
		
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
		public Date getHora() {
			return hora;
		}
		public void setHora(Date hora) {
			this.hora = hora;
		}
		public List<Porcao> getPorcoes() {
			return porcoes;
		}
		public void setPorcoes(List<Porcao> porcoes) {
			this.porcoes = porcoes;
		}
		
		
		
		
		
	    

}

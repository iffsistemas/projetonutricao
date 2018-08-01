package modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Dieta {
	
	
		@Id @GeneratedValue
		private Long id;
		
		@OneToMany(cascade=CascadeType.ALL)
		private List<DietaRefeicao> dietasRefeicoes = new ArrayList<DietaRefeicao>();

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public List<DietaRefeicao> getDietasRefeicoes() {
			return dietasRefeicoes;
		}

		public void setDietasRefeicoes(List<DietaRefeicao> dietasRefeicoes) {
			this.dietasRefeicoes = dietasRefeicoes;
		}
		
			    

}

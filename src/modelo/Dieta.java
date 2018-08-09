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
		
		private Double proteinaRestante = 0D;
		private Double carboidratoRestante = 0D;
		private Double lipidioRestante = 0D;
		private String substituicao;
		private String orientacao;
		

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

		public Double getProteinaRestante() {
			return proteinaRestante;
		}

		public void setProteinaRestante(Double proteinaRestante) {
			this.proteinaRestante = proteinaRestante;
		}

		
		public Double getCarboidratoRestante() {
			return carboidratoRestante;
		}

		public void setCarboidratoRestante(Double carboidratoRestante) {
			this.carboidratoRestante = carboidratoRestante;
		}

		public Double getLipidioRestante() {
			return lipidioRestante;
		}

		public void setLipidioRestante(Double lipidioRestante) {
			this.lipidioRestante = lipidioRestante;
		}

		public String getSubstituicao() {
			return substituicao;
		}

		public void setSubstituicao(String substituicao) {
			this.substituicao = substituicao;
		}

		public String getOrientacao() {
			return orientacao;
		}

		public void setOrientacao(String orientacao) {
			this.orientacao = orientacao;
		}
		

		
		
}

package modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Refeicao {
	
	
	@Id @GeneratedValue
	private Long id;
	private String nomeRefeicao;
	private String descricao;
	private String horario;
	private String preparacao;
	private String local;
	private String quantidadeCaseira;
	private String quantidadeEmGramas;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNomeRefeicao() {
		return nomeRefeicao;
	}
	public void setNomeRefeicao(String nomeRefeicao) {
		this.nomeRefeicao = nomeRefeicao;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getHorario() {
		return horario;
	}
	public void setHorario(String horario) {
		this.horario = horario;
	}
	public String getPreparacao() {
		return preparacao;
	}
	public void setPreparacao(String preparacao) {
		this.preparacao = preparacao;
	}
	public String getLocal() {
		return local;
	}
	public void setLocal(String local) {
		this.local = local;
	}
	public String getQuantidadeCaseira() {
		return quantidadeCaseira;
	}
	public void setQuantidadeCaseira(String quantidadeCaseira) {
		this.quantidadeCaseira = quantidadeCaseira;
	}
	public String getQuantidadeEmGramas() {
		return quantidadeEmGramas;
	}
	public void setQuantidadeEmGramas(String quantidadeEmGramas) {
		this.quantidadeEmGramas = quantidadeEmGramas;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((horario == null) ? 0 : horario.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Refeicao other = (Refeicao) obj;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (horario == null) {
			if (other.horario != null)
				return false;
		} else if (!horario.equals(other.horario))
			return false;
		return true;
	}
	
		
	
	
	
	

}

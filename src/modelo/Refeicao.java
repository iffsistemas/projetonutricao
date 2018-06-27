package modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Refeicao {
	
	
	@Id @GeneratedValue
	private Long id;
	private String descricao;
	private String horario;
	private String preparacao;
	private String quantidadeCaseira;
	private String quantidadeEmGramas;
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
	
	
	
	

}

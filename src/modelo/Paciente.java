package modelo;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Paciente {

	@Id @GeneratedValue
	private Long id;
	
	@Column(length=150, nullable= false)
	private String nome;
	
	private Boolean sexo;
	
	@Temporal(TemporalType.DATE)
	private Date dataNascimento;
	
	@Column(length=3)
	private Integer idade;

	
	@Column(length=15)
	private String telefoneRes;
	
	@Column(length=15)
	private String telefoneCel;
	
	@OneToOne(cascade=CascadeType.ALL)
	AnamneseAlimentar anamneseAlimentar = new AnamneseAlimentar();

	private Boolean statusPaciente = Boolean.TRUE;

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public Date getDataNascimento() {
		return dataNascimento;
	}


	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}


	public Integer getIdade() {
		return idade;
	}


	public void setIdade(Integer idade) {
		this.idade = idade;
	}


	public String getTelefoneRes() {
		return telefoneRes;
	}


	public void setTelefoneRes(String telefoneRes) {
		this.telefoneRes = telefoneRes;
	}


	public String getTelefoneCel() {
		return telefoneCel;
	}


	public void setTelefoneCel(String telefoneCel) {
		this.telefoneCel = telefoneCel;
	}


	public AnamneseAlimentar getAnamneseAlimentar() {
		return anamneseAlimentar;
	}


	public void setAnamneseAlimentar(AnamneseAlimentar anamneseAlimentar) {
		this.anamneseAlimentar = anamneseAlimentar;
	}


	public Boolean getSexo() {
		return sexo;
	}


	public void setSexo(Boolean sexo) {
		this.sexo = sexo;
	}


	public Boolean getStatusPaciente() {
		return statusPaciente;
	}


	public void setStatusPaciente(Boolean statusPaciente) {
		this.statusPaciente = statusPaciente;
	}
	
	
	
	
	
	
	
	
}

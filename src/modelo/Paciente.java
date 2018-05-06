package modelo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.ElementCollection;
import javax.persistence.FetchType;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class Paciente {
	
	
	
	private String nome="PacTeste";
	
	private Date dataNascimento;
	private Integer idade=30;
	private String email="pac1@email.com";
	private String telefoneRes="1233-1256";
	private String telefoneCel="9999-8558";
	
	
	private String efCabeca="1";
	private String efPescoco="1";
	private String efAbdmon="1";
	private String efMmii="1";
	private String efMmss="1";
	private String efEdema="1";
	
	

	

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getEfCabeca() {
		return efCabeca;
	}

	public void setEfCabeca(String efCabeca) {
		this.efCabeca = efCabeca;
	}

	public String getEfPescoco() {
		return efPescoco;
	}

	public void setEfPescoco(String efPescoco) {
		this.efPescoco = efPescoco;
	}

	public String getEfAbdmon() {
		return efAbdmon;
	}

	public void setEfAbdmon(String efAbdmon) {
		this.efAbdmon = efAbdmon;
	}

	public String getEfMmii() {
		return efMmii;
	}

	public void setEfMmii(String efMmii) {
		this.efMmii = efMmii;
	}

	public String getEfMmss() {
		return efMmss;
	}

	public void setEfMmss(String efMmss) {
		this.efMmss = efMmss;
	}

	public String getEfEdema() {
		return efEdema;
	}

	public void setEfEdema(String efEdema) {
		this.efEdema = efEdema;
	}

	
	
	
}

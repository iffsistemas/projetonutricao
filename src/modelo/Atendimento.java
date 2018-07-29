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
import javax.servlet.http.HttpServletResponse;



@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Atendimento {
	
	
	
	@Id @GeneratedValue
	private Long id;
	
	private String diagnosticoNutricional;
	
	@Temporal(TemporalType.DATE)
	private Date dataAtendimento = new Date();
	
	@OneToOne(cascade=CascadeType.ALL)
	private Paciente paciente;
	
	@OneToOne(cascade=CascadeType.ALL)
	ExamesLaboratoriais examesLaboratoriais;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
	public String getDiagnosticoNutricional() {
		return diagnosticoNutricional;
	}

	public void setDiagnosticoNutricional(String diagnosticoNutricional) {
		this.diagnosticoNutricional = diagnosticoNutricional;
	}

	public Date getDataAtendimento() {
		return dataAtendimento;
	}

	public void setDataAtendimento(Date dataAtendimento) {
		this.dataAtendimento = dataAtendimento;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public ExamesLaboratoriais getExamesLaboratoriais() {
		return examesLaboratoriais;
	}

	public void setExamesLaboratoriais(ExamesLaboratoriais examesLaboratoriais) {
		this.examesLaboratoriais = examesLaboratoriais;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}

package controle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import modelo.Paciente;
import service.AtendimentoService;
import service.PacienteService;

@ViewScoped
@ManagedBean
public class AtendimentoBean {
	
	@EJB 
	AtendimentoService atendimentoService;
	
	@EJB
	PacienteService pacienteService;
	
	
	Paciente paciente = new Paciente();
	List<Paciente> pacientes = new ArrayList<Paciente>();
	
	
	
	
	
	
	
	
	
	public Paciente getPaciente() {
		return paciente;
	}


	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}


	public List<Paciente> getPacientes() {
		return pacientes;
	}


	public void setPacientes(List<Paciente> pacientes) {
		this.pacientes = pacientes;
	}


	public void chamarFormAdulto() throws IOException {
		
		 ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		    externalContext.redirect("http://localhost:8081/ProjetoNutricao/formularioAdulto.xhtml");
		
		}
	
	
	public void chamarFormCrianca() throws IOException {
		
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
	    externalContext.redirect("http://localhost:8081/ProjetoNutricao/formularioCrianca.xhtml");
		
		}


		public void chamarFormGestante() throws IOException {
	
			
			ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		    externalContext.redirect("http://localhost:8081/ProjetoNutricao/formularioGestante.xhtml");
	
		}
		
		
		
		public void buscarNome() {
			 pacientes = atendimentoService.obtemPacientePorNome(getPaciente().getNome());
			
		}

}

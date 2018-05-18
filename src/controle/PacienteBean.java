package controle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import modelo.MotivoAtendimento;
import modelo.Paciente;
import service.PacienteService;

@ViewScoped
@ManagedBean
public class PacienteBean {
	
	@EJB
	PacienteService pacienteService;
	
	private Long id=1L;
	
	private Paciente paciente = new Paciente();
	
	List<Paciente> pacientes = new ArrayList<Paciente>();
	 
	
	
	private MotivoAtendimento[] motivosSelecionados;	
	
	public List<MotivoAtendimento> getMotivosAtendimento(){
		List<MotivoAtendimento> lista = Arrays.asList(MotivoAtendimento.values());
		return lista;
	}

	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public MotivoAtendimento[] getMotivosSelecionados() {
		return motivosSelecionados;
	}

	public void setMotivosSelecionados(MotivoAtendimento[] motivosSelecionados) {
		this.motivosSelecionados = motivosSelecionados;
	}

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


	public void gravarIdentificacao() {
		String msg="Paciente gravado com sucesso";
		
		if(getPaciente().getNome()==null){ 
		pacienteService.create(paciente);
		setPaciente(new Paciente());		
		
		FacesContext.getCurrentInstance().addMessage("menssagem", new FacesMessage("Parabéns!", msg));
		
		}
		
		
	}
	
	public void buscarNome() {
		 pacientes = pacienteService.obtemPacientePorNome(getPaciente().getNome());
		
	}
	
	
	
	
	
	
	
	
	

}

package controle;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import modelo.Atendimento;
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
	
	List<Paciente> pacientes = new ArrayList<Paciente>();
	List<Atendimento> atendimentos = new ArrayList<Atendimento>();
	Paciente paciente = new Paciente();
	Atendimento atendimento = new Atendimento();
	private Long teste = 1L;
	
	
	
	public AtendimentoService getAtendimentoService() {
		return atendimentoService;
	}


	public void setAtendimentoService(AtendimentoService atendimentoService) {
		this.atendimentoService = atendimentoService;
	}


	public PacienteService getPacienteService() {
		return pacienteService;
	}

	public void setPacienteService(PacienteService pacienteService) {
		this.pacienteService = pacienteService;
	}

	public List<Paciente> getPacientes() {
		return pacientes;
	}

	public void setPacientes(List<Paciente> pacientes) {
		this.pacientes = pacientes;
	}

	public List<Atendimento> getAtendimentos() {
		return atendimentos;
	}

	public void setAtendimentos(List<Atendimento> atendimentos) {
		this.atendimentos = atendimentos;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

		
	public Atendimento getAtendimento() {
		return atendimento;
	}


	public void setAtendimento(Atendimento atendimento) {
		this.atendimento = atendimento;
	}


	public Long getTeste() {
		return teste;
	}


	public void setTeste(Long teste) {
		this.teste = teste;
	}


	public void salvar() {
		
		String msg="Atendimento criado com sucesso";
		try {
			if(getAtendimento().getId()==null){ 
				paciente = pacienteService.obtemPorId(getTeste());	
				atendimento.setPaciente(paciente);
				atendimentoService.create(atendimento);
				setAtendimento(new Atendimento());
				FacesContext.getCurrentInstance().addMessage("menssagem", new FacesMessage("Parabéns!", msg));
					
		}
			
		} catch (RuntimeException erro) {
			
			FacesContext.getCurrentInstance().addMessage("menssagem", new FacesMessage("ERRO!", "Ocorreu um erro Inesperado"));
		
					
		}	}
		
		
		
	
		public void pegarPaciente(ActionEvent evento) {
			
		
		paciente = (Paciente) evento.getComponent().getAttributes().get("pegarPaciente");	
		
	//	atendimentos = atendimentoService.obtemPorId(paciente.getId());	
			
			
			
		//
		
		//FacesContext.getCurrentInstance().addMessage("menssagem", new FacesMessage("Paciente ", getpaciente().getNome()));
		
		
		//System.out.println(paciente.getNome());
			
		}
	
	
	
	
	
		
	}
	
		
	
	
	


package controle;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import modelo.Atendimento;
import modelo.AtendimentoAdulto;
import modelo.AtendimentoCrianca;
import modelo.AtendimentoGestante;
import modelo.ExamesLaboratoriais;
import modelo.Paciente;
import modelo.PacienteAdulto;
import service.AtendimentoAdultoService;
import service.AtendimentoCriancaService;
import service.AtendimentoGestanteService;
import service.AtendimentoService;
import service.PacienteService;



@ViewScoped
@ManagedBean
public class AtendimentoBean {
	
	
	@EJB
	AtendimentoAdultoService atendimentoAdultoService;
	@EJB
	AtendimentoCriancaService atendimentoCriancaService;
	@EJB
	AtendimentoGestanteService atendimentoGestanteService;
	@EJB
	PacienteService pacienteService;
	@EJB
	AtendimentoService atendimentoService;
	
	Paciente paciente = new Paciente();
	
	AtendimentoAdulto atendimentoAdulto = new AtendimentoAdulto();
	AtendimentoCrianca atendimentoCrianca = new AtendimentoCrianca();
	AtendimentoGestante atendimentoGestante = new AtendimentoGestante();
	
	ExamesLaboratoriais examesLaboratoriais = new ExamesLaboratoriais();
	
	List<Paciente> pacientes = new ArrayList<Paciente>();
	List<Atendimento> atendimentos = new ArrayList<Atendimento>();
	
	Paciente pacienteSelecionado = new Paciente();
	
	
	private Long teste = 1L;
	
	
	public AtendimentoAdultoService getAtendimentoAdultoService() {
		return atendimentoAdultoService;
	}

	public void setAtendimentoAdultoService(AtendimentoAdultoService atendimentoAdultoService) {
		this.atendimentoAdultoService = atendimentoAdultoService;
	}

	public AtendimentoCriancaService getAtendimentoCriancaService() {
		return atendimentoCriancaService;
	}


	public void setAtendimentoCriancaService(AtendimentoCriancaService atendimentoCriancaService) {
		this.atendimentoCriancaService = atendimentoCriancaService;
	}

	public AtendimentoGestanteService getAtendimentoGestanteService() {
		return atendimentoGestanteService;
	}

	public void setAtendimentoGestanteService(AtendimentoGestanteService atendimentoGestanteService) {
		this.atendimentoGestanteService = atendimentoGestanteService;
	}

	public PacienteService getPacienteService() {
		return pacienteService;
	}

	public void setPacienteService(PacienteService pacienteService) {
		this.pacienteService = pacienteService;
	}


	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public AtendimentoAdulto getAtendimentoAdulto() {
		return atendimentoAdulto;
	}


	public void setAtendimentoAdulto(AtendimentoAdulto atendimentoAdulto) {
		this.atendimentoAdulto = atendimentoAdulto;
	}

	public AtendimentoCrianca getAtendimentoCrianca() {
		return atendimentoCrianca;
	}

	public void setAtendimentoCrianca(AtendimentoCrianca atendimentoCrianca) {
		this.atendimentoCrianca = atendimentoCrianca;
	}

	public AtendimentoGestante getAtendimentoGestante() {
		return atendimentoGestante;
	}

	public void setAtendimentoGestante(AtendimentoGestante atendimentoGestante) {
		this.atendimentoGestante = atendimentoGestante;
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

	public Long getTeste() {
		return teste;
	}

	public void setTeste(Long teste) {
		this.teste = teste;
	}
	
		
	public ExamesLaboratoriais getExamesLaboratoriais() {
		return examesLaboratoriais;
	}

	public void setExamesLaboratoriais(ExamesLaboratoriais examesLaboratoriais) {
		this.examesLaboratoriais = examesLaboratoriais;
	}
	
		
	public AtendimentoService getAtendimentoService() {
		return atendimentoService;
	}

	public void setAtendimentoService(AtendimentoService atendimentoService) {
		this.atendimentoService = atendimentoService;
	}

	public Paciente getPacienteSelecionado() {
		return pacienteSelecionado;
	}

	public void setPacienteSelecionado(Paciente pacienteSelecionado) {
		this.pacienteSelecionado = pacienteSelecionado;
	}

	@PostConstruct
	public void init(){
		atualizarAtendimentos();
		//Paciente Enviado de outro pagina
		PacienteAdulto pacEnviado = (PacienteAdulto) FacesContext.getCurrentInstance().getExternalContext().getFlash().get("pacienteAdulto");
		System.out.println("Enviado: "+pacEnviado.getNome());
		//getAtendimentoAdulto().setPaciente(pacEnviado);
		
	}
	
	public void atualizarAtendimentos(){
		getAtendimentos().clear();
		getAtendimentos().addAll(atendimentoService.listAll());
	}
	
	
	public void carregarAtendimentos() {
		atendimentos.clear();
		atendimentos.addAll(atendimentoService.obtemAtendimentoPorPaciente(pacienteSelecionado));
	}
	
	
	
	
	
	
	
	
	
	

	public void salvarAtendimentoAdulto() {
		
		String msg="Atendimento salvo com sucesso";
		
		try {
			if(getAtendimentoAdulto().getId()==null){ 
				//paciente = pacienteService.obtemPorId(getTeste());	
				atendimentoAdulto.setExamesLaboratoriais(examesLaboratoriais);	
				//atendimentoAdulto.setPaciente(paciente);
				atendimentoAdultoService.create(atendimentoAdulto);
				setAtendimentoAdulto(new AtendimentoAdulto());
				FacesContext.getCurrentInstance().addMessage("menssagem", new FacesMessage("Parabéns!", msg));
					
		}
			
		} catch (RuntimeException erro) {
			
			FacesContext.getCurrentInstance().addMessage("menssagem", new FacesMessage("ERRO!", "Ocorreu um erro Inesperado"));
		
					
		}	}
		
		
	
	
	
	
		
		
		

		
	
		public void pegarPaciente(ActionEvent evento) {
			
		
		paciente = (Paciente) evento.getComponent().getAttributes().get("pegarPaciente");	
		
	//	atendimentos = atendimentoAdultoService.obtemPorId(paciente.getId());	
			
			
			
		//
		
		//FacesContext.getCurrentInstance().addMessage("menssagem", new FacesMessage("Paciente ", getpaciente().getNome()));
		
		
		//System.out.println(paciente.getNome());
			
		}
	
	
	
	
	
		
	}
	
		
	
	
	


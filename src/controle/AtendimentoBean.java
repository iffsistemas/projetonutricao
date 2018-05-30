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
import modelo.CadastroPaciente;
import service.AtendimentoService;
import service.CadastroPacienteService;



@ViewScoped
@ManagedBean
public class AtendimentoBean {
	
	
	@EJB
	AtendimentoService atendimentoService;
	
	@EJB
	CadastroPacienteService cadastroPacienteService;
	
	List<CadastroPaciente> cadastroPacientes = new ArrayList<CadastroPaciente>();
	
	CadastroPaciente cadastroPaciente = new CadastroPaciente();
	
	
	
	

	
	public CadastroPaciente getCadastroPaciente() {
		return cadastroPaciente;
	}



	public void setCadastroPaciente(CadastroPaciente cadastroPaciente) {
		this.cadastroPaciente = cadastroPaciente;
	}



	Atendimento atendimento = new Atendimento();

	private Long teste = 1L;


		
	
	public Long getTeste() {
		return teste;
	}



	public void setTeste(Long teste) {
		this.teste = teste;
	}



	public AtendimentoService getAtendimentoService() {
		return atendimentoService;
	}



	public void setAtendimentoService(AtendimentoService atendimentoService) {
		this.atendimentoService = atendimentoService;
	}



	public Atendimento getAtendimento() {
		return atendimento;
	}



	public void setAtendimento(Atendimento atendimento) {
		this.atendimento = atendimento;
	}
	
	
		
	
	public CadastroPacienteService getCadastroPacienteService() {
		return cadastroPacienteService;
	}



	public void setCadastroPacienteService(CadastroPacienteService cadastroPacienteService) {
		this.cadastroPacienteService = cadastroPacienteService;
	}



	public List<CadastroPaciente> getCadastroPacientes() {
		return cadastroPacientes;
	}



	public void setCadastroPacientes(List<CadastroPaciente> cadastroPacientes) {
		this.cadastroPacientes = cadastroPacientes;
	}



	public void salvar() {
		
		String msg="Atendimento criado com sucesso";
		
		
		
		
 		
		try {
			
			
			if(getAtendimento().getId()==null){ 
				
				
				cadastroPaciente = cadastroPacienteService.obtemPorId(getTeste());	
				atendimento.setPaciente(cadastroPaciente);
				
					
				
				
				atendimentoService.create(atendimento);
				setAtendimento(new Atendimento());
				FacesContext.getCurrentInstance().addMessage("menssagem", new FacesMessage("Parabéns!", msg));
			
			
		}
			
		} catch (RuntimeException erro) {
			
			FacesContext.getCurrentInstance().addMessage("menssagem", new FacesMessage("ERRO!", "Ocorreu um erro Inesperado"));
		
					
		}	}
		
		
		
	
		public void pegarPaciente(ActionEvent evento) {
			
		
			System.out.println("teste");
			
			
		//cadastroPaciente = (CadastroPaciente) evento.getComponent().getAttributes().get("pegarPaciente");
		
		//FacesContext.getCurrentInstance().addMessage("menssagem", new FacesMessage("Paciente ", getCadastroPaciente().getNome()));
		
		
		
			
		}
	
	
	
	
	
		
	}
	
		
	
	
	


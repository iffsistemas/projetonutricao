package controle;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import modelo.AtendimentoAdulto;
import modelo.ExamesLaboratoriais;
import modelo.Paciente;
import modelo.PacienteAdulto;
import service.AtendimentoAdultoService;

@ViewScoped
@ManagedBean
public class AtendimentoAdultoBean {
	
	
	@EJB
	AtendimentoAdultoService atendimentoAdultoService;
	
	AtendimentoAdulto atendimentoAdulto = new  AtendimentoAdulto();
	
	List<AtendimentoAdulto> atendimentosAdulto = new ArrayList<AtendimentoAdulto>();
	
	ExamesLaboratoriais examesLaboratoriais = new ExamesLaboratoriais();
	
	Paciente pacienteSelecionado = new Paciente();
	
	
	
	

	public AtendimentoAdultoService getAtendimentoAdultoService() {
		return atendimentoAdultoService;
	}

	public void setAtendimentoAdultoService(AtendimentoAdultoService atendimentoAdultoService) {
		this.atendimentoAdultoService = atendimentoAdultoService;
	}

	public AtendimentoAdulto getAtendimentoAdulto() {
		return atendimentoAdulto;
	}

	public void setAtendimentoAdulto(AtendimentoAdulto atendimentoAdulto) {
		this.atendimentoAdulto = atendimentoAdulto;
	}

	public ExamesLaboratoriais getExamesLaboratoriais() {
		return examesLaboratoriais;
	}

	public void setExamesLaboratoriais(ExamesLaboratoriais examesLaboratoriais) {
		this.examesLaboratoriais = examesLaboratoriais;
	}
	
		
	public List<AtendimentoAdulto> getAtendimentosAdulto() {
		return atendimentosAdulto;
	}

	public void setAtendimentosAdulto(List<AtendimentoAdulto> atendimentosAdulto) {
		this.atendimentosAdulto = atendimentosAdulto;
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
		getAtendimentoAdulto().setPaciente(pacEnviado);
		
		
	}
	
	
	
	public void salvarAtendimentoAdulto() {
		
		String msg="Atendimento salvo com sucesso";
		
		try {
			if(getAtendimentoAdulto().getId()==null){ 
				//paciente = pacienteService.obtemPorId(getTeste());	
				//atendimentoAdulto.setPaciente(paciente);
				
				atendimentoAdulto.setExamesLaboratoriais(examesLaboratoriais);	
				atendimentoAdultoService.merge(atendimentoAdulto);
				setAtendimentoAdulto(new AtendimentoAdulto());
				FacesContext.getCurrentInstance().addMessage("menssagem", new FacesMessage("Parabéns!", msg));
					
		}
			
		} catch (RuntimeException erro) {
			
			FacesContext.getCurrentInstance().addMessage("menssagem", new FacesMessage("ERRO!", "Ocorreu um erro Inesperado"));
			erro.printStackTrace();
					
		}	}
		
		
	
	public void atualizarAtendimentos(){
		getAtendimentosAdulto().clear();
		getAtendimentosAdulto().addAll(atendimentoAdultoService.listAll());
	}
	
	public void carregarAtendimentos() {
		atendimentosAdulto.clear();
		atendimentosAdulto.addAll(atendimentoAdultoService.obtemAtendimentoAdultoPorPaciente(pacienteSelecionado));
	}
	

	
	
	public void calcularIMC() {
		 
	Double imc = atendimentoAdulto.getPesoAtual()/(atendimentoAdulto.getAltura() * atendimentoAdulto.getAltura());
	BigDecimal imcConverter = new BigDecimal(imc).setScale(2, RoundingMode.HALF_EVEN);
	
	atendimentoAdulto.setIndiceMassaCorporal(imcConverter.doubleValue());

	
	
	}
	
	public void classificacaoIMC() {
		 
	            if(atendimentoAdulto.getIndiceMassaCorporal() <= 19.1) {
	            	atendimentoAdulto.setClassificacaoIMC(" Abaixo do peso");
	            }else if(atendimentoAdulto.getIndiceMassaCorporal() > 19.1 && atendimentoAdulto.getIndiceMassaCorporal() <= 25.8) {
	            	atendimentoAdulto.setClassificacaoIMC(" Peso Normal");
	            }else if(atendimentoAdulto.getIndiceMassaCorporal() > 25.8 && atendimentoAdulto.getIndiceMassaCorporal() <= 27.3 ) {
	            	atendimentoAdulto.setClassificacaoIMC(" Sobre peso");
	            }else if(atendimentoAdulto.getIndiceMassaCorporal() > 27.3 && atendimentoAdulto.getIndiceMassaCorporal() <= 32.3) {
	            	atendimentoAdulto.setClassificacaoIMC(" Obesidade Grau I");
	            }else {
	            	atendimentoAdulto.setClassificacaoIMC(" Obesidade Grau II");
	            }            
	        
	        }
		
		
		
 
	
	
	
	
}







package controle;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import modelo.Atendimento;
import service.AtendimentoService;



@ViewScoped
@ManagedBean
public class AtendimentoBean {
	
	
	@EJB
	AtendimentoService atendimentoService;
	

	
	
	
	
	
	
	
	Atendimento atendimento = new Atendimento();



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
	
	
		

	

	public void salvar() {
		
		String msg="Atendimento criado com sucesso";
		
		
		
		
 		
		try {
			
			
			if(getAtendimento().getId()==null){ 
				
				
					
				
				
				atendimentoService.create(atendimento);
				setAtendimento(new Atendimento());
				FacesContext.getCurrentInstance().addMessage("menssagem", new FacesMessage("Parabéns!", msg));
			
			
		}
			
		} catch (RuntimeException erro) {
			
			FacesContext.getCurrentInstance().addMessage("menssagem", new FacesMessage("ERRO!", "Ocorreu um erro Inesperado"));
		
					
		}	}
		
		
		
		
	}
	
		
	
	
	


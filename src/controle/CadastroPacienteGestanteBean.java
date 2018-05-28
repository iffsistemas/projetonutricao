package controle;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import modelo.CadastroPacienteGestante;
import service.CadastroPacienteGestanteService;



@ViewScoped
@ManagedBean
public class CadastroPacienteGestanteBean {
	
	

	@EJB
	CadastroPacienteGestanteService cadastroPacienteGestanteService;	 
	private CadastroPacienteGestante cadastroPacienteGestante = new  CadastroPacienteGestante();
	
	
	 


		
	public CadastroPacienteGestanteService getCadastroPacienteGestanteService() {
		return cadastroPacienteGestanteService;
	}






	public void setCadastroPacienteGestanteService(CadastroPacienteGestanteService cadastroPacienteGestanteService) {
		this.cadastroPacienteGestanteService = cadastroPacienteGestanteService;
	}






	public CadastroPacienteGestante getCadastroPacienteGestante() {
		return cadastroPacienteGestante;
	}






	public void setCadastroPacienteGestante(CadastroPacienteGestante cadastroPacienteGestante) {
		this.cadastroPacienteGestante = cadastroPacienteGestante;
	}


	
	public void salvar() {
		String msg="Paciente gravado com sucesso";
		
		 		
	try {
		
		
		if(getCadastroPacienteGestante().getId()==null){ 
			cadastroPacienteGestanteService.create(cadastroPacienteGestante);
			setCadastroPacienteGestante(new CadastroPacienteGestante());
			FacesContext.getCurrentInstance().addMessage("menssagem", new FacesMessage("Parabéns!", msg));
		
		
	}
		
	} catch (RuntimeException erro) {
		
		FacesContext.getCurrentInstance().addMessage("menssagem", new FacesMessage("ERRO!", "Ocorreu um erro Inesperado"));
	
				
	}	}
	
	
	
	
	
	
	
	
	
}

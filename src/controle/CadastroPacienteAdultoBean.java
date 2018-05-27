package controle;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import modelo.CadastroPaciente;
import modelo.CadastroPacienteAdulto;
import service.CadastroPacienteAdultoService;



@ViewScoped
@ManagedBean
public class CadastroPacienteAdultoBean {
	
	
	@EJB
	CadastroPacienteAdultoService cadastroPacienteAdultoService;	 
	private CadastroPacienteAdulto cadastroPacienteAdulto = new  CadastroPacienteAdulto();
	
	
	 


		
	public CadastroPacienteAdultoService getCadastroPacienteAdultoService() {
		return cadastroPacienteAdultoService;
	}






	public void setCadastroPacienteAdultoService(CadastroPacienteAdultoService cadastroPacienteAdultoService) {
		this.cadastroPacienteAdultoService = cadastroPacienteAdultoService;
	}






	public CadastroPacienteAdulto getCadastroPacienteAdulto() {
		return cadastroPacienteAdulto;
	}






	public void setCadastroPacienteAdulto(CadastroPacienteAdulto cadastroPacienteAdulto) {
		this.cadastroPacienteAdulto = cadastroPacienteAdulto;
	}


	
	public void salvar() {
		String msg="Paciente gravado com sucesso";
		
		 		
	try {
		
		
		if(getCadastroPacienteAdulto().getId()==null){ 
			cadastroPacienteAdultoService.create(cadastroPacienteAdulto);
			setCadastroPacienteAdulto(new CadastroPacienteAdulto());
			FacesContext.getCurrentInstance().addMessage("menssagem", new FacesMessage("Parabéns!", msg));
		
		
	}
		
	} catch (RuntimeException erro) {
		
		FacesContext.getCurrentInstance().addMessage("menssagem", new FacesMessage("ERRO!", "Ocorreu um erro Inesperado"));
	
				
	}	}
	
	
	
	
	
}

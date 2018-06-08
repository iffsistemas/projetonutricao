package controle;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import modelo.CadastroPacienteCrianca;
import service.CadastroPacienteCriancaService;



@ViewScoped
@ManagedBean
public class CadastroPacienteCriancaBean extends PacienteGenericoBean{
	


	@EJB
	CadastroPacienteCriancaService cadastroPacienteCriancaService;	 
	private CadastroPacienteCrianca cadastroPacienteCrianca = new  CadastroPacienteCrianca();
	
	
	 


		
	public CadastroPacienteCriancaService getCadastroPacienteCriancaService() {
		return cadastroPacienteCriancaService;
	}






	public void setCadastroPacienteCriancaService(CadastroPacienteCriancaService cadastroPacienteCriancaService) {
		this.cadastroPacienteCriancaService = cadastroPacienteCriancaService;
	}






	public CadastroPacienteCrianca getCadastroPacienteCrianca() {
		return cadastroPacienteCrianca;
	}






	public void setCadastroPacienteCrianca(CadastroPacienteCrianca cadastroPacienteCrianca) {
		this.cadastroPacienteCrianca = cadastroPacienteCrianca;
	}


	
	public void salvar() {
		String msg="Paciente gravado com sucesso";
		
		 		
	try {
		
		
		if(getCadastroPacienteCrianca().getId()==null){ 
			cadastroPacienteCriancaService.create(cadastroPacienteCrianca);
			setCadastroPacienteCrianca(new CadastroPacienteCrianca());
			atualizarPacientes();
			FacesContext.getCurrentInstance().addMessage("menssagem", new FacesMessage("Parabéns!", msg));
		
		
	}
		
	} catch (RuntimeException erro) {
		
		FacesContext.getCurrentInstance().addMessage("menssagem", new FacesMessage("ERRO!", "Ocorreu um erro Inesperado"));
		erro.printStackTrace();
				
	}	}
	
	
	
	
	public void limpar() {
		setCadastroPacienteCrianca(new CadastroPacienteCrianca());
	}
	
	
	
	
}

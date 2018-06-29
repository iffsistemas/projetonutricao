package controle;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import modelo.AtendimentoAdulto;
import modelo.ExamesLaboratoriais;
import service.AtendimentoAdultoService;

@ViewScoped
@ManagedBean
public class AtendimentoAdultoBean {
	
	
	@EJB
	AtendimentoAdultoService atendimentoAdultoService;
	
	AtendimentoAdulto atendimentoAdulto = new  AtendimentoAdulto();
	
	ExamesLaboratoriais examesLaboratoriais = new ExamesLaboratoriais();

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

	

	

}

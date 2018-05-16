package controle;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import modelo.ExamesLaboratoriais;
import service.ExamesLaboratoriaisService;

@ViewScoped
@ManagedBean
public class ExamesLaboratoriaisBean {
	
	
	
	@EJB
	ExamesLaboratoriaisService examesLaboratoriaisService;
	
	
	ExamesLaboratoriais examesLaboratoriais = new ExamesLaboratoriais();


	public ExamesLaboratoriais getExamesLaboratoriais() {
		return examesLaboratoriais;
	}


	public void setExamesLaboratoriais(ExamesLaboratoriais examesLaboratoriais) {
		this.examesLaboratoriais = examesLaboratoriais;
	}
	
	
	
	
	
	
	

}

package controle;

import javax.faces.context.FacesContext;

public class PacienteGenericoBean {

	
	public void atualizarPacientes(){
		FacesContext context = FacesContext.getCurrentInstance();
		PacienteBean pacienteBean = (PacienteBean) context.getApplication().getELResolver().getValue(context.getELContext(), null, "pacienteBean");
		pacienteBean.atualizarPacientes();
	}
}

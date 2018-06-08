package controle;

import javax.faces.context.FacesContext;

public class PacienteGenericoBean {

	
	public void atualizarPacientes(){
		FacesContext context = FacesContext.getCurrentInstance();
		CadastroPacienteBean cadastroPacienteBean = (CadastroPacienteBean) context.getApplication().getELResolver().getValue(context.getELContext(), null, "cadastroPacienteBean");
		cadastroPacienteBean.atualizarPacientes();
	}
}

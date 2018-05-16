package controle;

import java.io.IOException;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import service.AtendimentoService;

@ViewScoped
@ManagedBean
public class AtendimentoBean {
	
	@EJB 
	AtendimentoService atendimentoService;
	
	
	
	
	
	
	
	public void chamarFormAdulto() throws IOException {
		
		 ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		    externalContext.redirect("http://localhost:8081/ProjetoNutricao/formularioAdulto.xhtml");
		
		}
	
	
	public void chamarFormCrianca() throws IOException {
		
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
	    externalContext.redirect("http://localhost:8081/ProjetoNutricao/formularioCrianca.xhtml");
		
		}


		public void chamarFormGestante() throws IOException {
	
			
			ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		    externalContext.redirect("http://localhost:8081/ProjetoNutricao/formularioGestante.xhtml");
	
		}

}

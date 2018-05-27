package controle;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import modelo.CadastroPacienteAdulto;
import service.CadastroPacienteAdultoService;



@ViewScoped
@ManagedBean
public class CadastroPacienteAdultoBean {
	
	
	@EJB
	CadastroPacienteAdultoService cadAdultoservice;
	
	 
	private CadastroPacienteAdulto cadAdulto;


	public CadastroPacienteAdultoService getCadAdultoservice() {
		return cadAdultoservice;
	}


	public void setCadAdultoservice(CadastroPacienteAdultoService cadAdultoservice) {
		this.cadAdultoservice = cadAdultoservice;
	}


	public CadastroPacienteAdulto getCadAdulto() {
		return cadAdulto;
	}


	public void setCadAdulto(CadastroPacienteAdulto cadAdulto) {
		this.cadAdulto = cadAdulto;
	}
	
	
	
	
	
	
	
}

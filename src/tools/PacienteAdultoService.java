package tools;

import javax.ejb.Stateless;

import service.GenericService;

@Stateless
public class PacienteAdultoService extends GenericService<PacienteAdulto> {

	public PacienteAdultoService(){
		super(PacienteAdulto.class);
	}
	
	
}

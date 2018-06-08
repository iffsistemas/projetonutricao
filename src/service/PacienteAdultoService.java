package service;

import javax.ejb.Stateless;

import modelo.PacienteAdulto;
import modelo.Taco;

@Stateless
public class PacienteAdultoService extends GenericService<PacienteAdulto> {

	public PacienteAdultoService(){
		super(PacienteAdulto.class);
	}
	
	
	 
}

package service;

import javax.ejb.Stateless;

import modelo.Paciente;
import modelo.PacienteAdulto;

@Stateless
public class PacienteAdultoService extends GenericService<PacienteAdulto> {

	public PacienteAdultoService(){
		super(PacienteAdulto.class);
	}
	
	
}

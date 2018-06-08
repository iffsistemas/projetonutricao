package service;

import javax.ejb.Stateless;

import modelo.PacienteGestante;

@Stateless
public class PacienteGestanteService extends GenericService<PacienteGestante> {

	public PacienteGestanteService(){
		super(PacienteGestante.class);
	}
	
	
 
}

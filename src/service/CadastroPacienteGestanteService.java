package service;

import javax.ejb.Stateless;

import modelo.CadastroPacienteGestante;

@Stateless
public class CadastroPacienteGestanteService extends GenericService<CadastroPacienteGestante> {

	public CadastroPacienteGestanteService(){
		super(CadastroPacienteGestante.class);
	}
	
	
 
}

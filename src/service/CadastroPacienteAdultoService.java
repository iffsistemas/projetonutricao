package service;

import javax.ejb.Stateless;

import modelo.CadastroPacienteAdulto;
import modelo.Taco;

@Stateless
public class CadastroPacienteAdultoService extends GenericService<CadastroPacienteAdulto> {

	public CadastroPacienteAdultoService(){
		super(CadastroPacienteAdulto.class);
	}
	
	
	 
}

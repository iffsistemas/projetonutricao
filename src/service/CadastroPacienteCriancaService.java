package service;

import javax.ejb.Stateless;

import modelo.CadastroPacienteCrianca;
import modelo.Taco;

@Stateless
public class CadastroPacienteCriancaService extends GenericService<CadastroPacienteCrianca> {

	public CadastroPacienteCriancaService(){
		super(CadastroPacienteCrianca.class);
	}
	
	
	 

}

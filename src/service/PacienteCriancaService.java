package service;

import javax.ejb.Stateless;

import modelo.PacienteCrianca;
import modelo.Taco;

@Stateless
public class PacienteCriancaService extends GenericService<PacienteCrianca> {

	public PacienteCriancaService(){
		super(PacienteCrianca.class);
	}
	
	
	 

}

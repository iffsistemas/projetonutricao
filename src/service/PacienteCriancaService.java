package service;

import javax.ejb.Stateless;

import modelo.PacienteCrianca;
import modelo.AlimentoTaco;

@Stateless
public class PacienteCriancaService extends GenericService<PacienteCrianca> {

	public PacienteCriancaService(){
		super(PacienteCrianca.class);
	}
	
	
	 

}

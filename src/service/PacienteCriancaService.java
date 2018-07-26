package service;

import javax.ejb.Stateless;

import modelo.PacienteCrianca;
import modelo.DescricaoTaco;

@Stateless
public class PacienteCriancaService extends GenericService<PacienteCrianca> {

	public PacienteCriancaService(){
		super(PacienteCrianca.class);
	}
	
	
	 

}

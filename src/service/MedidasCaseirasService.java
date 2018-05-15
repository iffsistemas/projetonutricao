package service;

import javax.ejb.Stateless;

import modelo.MedidasCaseiras;

@Stateless
public class MedidasCaseirasService extends GenericService<MedidasCaseiras> {

	public MedidasCaseirasService(){
		super(MedidasCaseiras.class);
	}
	
	
	
	
}

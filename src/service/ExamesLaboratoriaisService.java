package service;

import javax.ejb.Stateless;

import modelo.ExamesLaboratoriais;

@Stateless
public class ExamesLaboratoriaisService extends GenericService<ExamesLaboratoriais> {
	
	public ExamesLaboratoriaisService(){
		super(ExamesLaboratoriais.class);
	}

}

package service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import modelo.PacienteAdulto;

@Stateless
public class PacienteAdultoService extends GenericService<PacienteAdulto> {

	public PacienteAdultoService(){
		super(PacienteAdulto.class);
	}
	
	public List<PacienteAdulto> obtemPacientesAdultosComMedicamentos(){
		CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
		CriteriaQuery<PacienteAdulto> cquery = cb.createQuery(PacienteAdulto.class);
		//Root<PacienteAdulto> root = cquery.from(PacienteAdulto.class);
		
		List<PacienteAdulto> pacienteAdultos = getEntityManager().createQuery(cquery).getResultList();
		
		for (PacienteAdulto pac: pacienteAdultos) {
			pac.getMedicamentos().size();
		}
		
		return pacienteAdultos;
	}
	
	public List<PacienteAdulto> obtemUmPacienteComMedicamentos(Long id){
		CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
		CriteriaQuery<PacienteAdulto> cquery = cb.createQuery(PacienteAdulto.class);
		Root<PacienteAdulto> root = cquery.from(PacienteAdulto.class);
		
		cquery.select(root).where(cb.equal(root.get("id") ,id));
		
		List<PacienteAdulto> pacienteAdultos = getEntityManager().createQuery(cquery).getResultList();
		
		for (PacienteAdulto pac: pacienteAdultos) {
			pac.getMedicamentos().size();
		}
		
		return pacienteAdultos;
	}
	 
}

package service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import modelo.Atendimento;
import modelo.AtendimentoAdulto;
import modelo.Paciente;

@Stateless
public class AtendimentoAdultoService extends GenericService<AtendimentoAdulto> {

	public AtendimentoAdultoService(){
		super(AtendimentoAdulto.class);
	}
	
	
	
	public List<AtendimentoAdulto> obtemAtendimentoAdultoPorPaciente(Paciente paciente) {
		CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
		CriteriaQuery<AtendimentoAdulto> cquery = cb.createQuery(AtendimentoAdulto.class);
		Root<AtendimentoAdulto> root = cquery.from(AtendimentoAdulto.class);
		
			
		cquery.select(root).where(cb.equal(root.get("paciente"), paciente));
		
		List<AtendimentoAdulto> atendimentos = getEntityManager().createQuery(cquery).getResultList();
		
		return atendimentos;
		
		
		
	}
	
	
	
	
	
}

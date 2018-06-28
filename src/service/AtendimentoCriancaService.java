package service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import modelo.Atendimento;
import modelo.Paciente;

@Stateless
public class AtendimentoCriancaService extends GenericService<Atendimento> {

	public AtendimentoCriancaService(){
		super(Atendimento.class);
	}
	
	
	
	public List<Atendimento> obtemAtendimentoPorPaciente(Paciente paciente) {
		CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
		CriteriaQuery<Atendimento> cquery = cb.createQuery(Atendimento.class);
		Root<Atendimento> root = cquery.from(Atendimento.class);
		
			
		cquery.select(root).where(cb.equal(root.get("paciente"), paciente));
		
		List<Atendimento> atendimentos = getEntityManager().createQuery(cquery).getResultList();
		
		return atendimentos;
		
		
		
	}
	
	
	
	
	
}

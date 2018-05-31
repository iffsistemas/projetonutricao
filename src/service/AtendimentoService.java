package service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;

import modelo.Atendimento;
import modelo.Taco;

@Stateless
public class AtendimentoService extends GenericService<Atendimento> {

	public AtendimentoService(){
		super(Atendimento.class);
	}
	
	
	
	public List<Atendimento> obtemAtendimentoPorPaciente(Long pacienteId) {
		CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
		CriteriaQuery<Atendimento> cquery = cb.createQuery(Atendimento.class);
		Root<Atendimento> root = cquery.from(Atendimento.class);
		
		Expression<String> colunaPacienteId = root.get("pacienteId");
		
		//cquery.select(root).where(colunaPacienteId, pacienteId);
		
		List<Atendimento> atendimentos = getEntityManager().createQuery(cquery).getResultList();
		
		return atendimentos;
		
		
		
	}
	
	
	
	
	
}

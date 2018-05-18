package service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;

import modelo.Atendimento;
import modelo.Paciente;
import modelo.Taco;

@Stateless
public class AtendimentoService extends GenericService<Atendimento> {
	
	public AtendimentoService(){
		super(Atendimento.class);
	}
	
	
	
	
	
	

	public List<Paciente> obtemPacientePorNome(String nome){
		CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
		CriteriaQuery<Paciente> cquery = cb.createQuery(Paciente.class);
		Root<Paciente> root = cquery.from(Paciente.class);
		
		Expression<String> colunaNome = root.get("nome");
		
		cquery.select(root).where(cb.like(colunaNome, "%"+nome+"%"));
		
		List<Paciente> pacientes = getEntityManager().createQuery(cquery).getResultList();
		
		return pacientes;
	}

}

package tools;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;

import service.GenericService;

@Stateless
public class PacienteService extends GenericService<Paciente>{
	
	public PacienteService(){
		super(Paciente.class);
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

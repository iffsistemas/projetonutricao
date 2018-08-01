package service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;

import modelo.Paciente;

@Stateless
public class PacienteService extends GenericService<Paciente> {

	public PacienteService(){
		super(Paciente.class);
	}
	
	public List<Paciente> obtemPacientePorNome(String nome, Boolean statusPaciente){
		CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
		CriteriaQuery<Paciente> cquery = cb.createQuery(Paciente.class);
		Root<Paciente> root = cquery.from(Paciente.class);
		
		Expression<String> colunaNome = root.get("nome");
		
		
		//cquery.select(root).where(cb.like(colunaNome, "%"+nome+"%"));
		
		cquery.where(cb.and(cb.like(colunaNome, "%"+nome+"%"), cb.equal(root.get("statusPaciente"), statusPaciente)));
		
		List<Paciente> pacientes = getEntityManager().createQuery(cquery).getResultList();
		
		return pacientes;
	}
	
	
	
	public List<Paciente> obtemPacienteInativo(Boolean statusPaciente){
		CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
		CriteriaQuery<Paciente> cquery = cb.createQuery(Paciente.class);
		Root<Paciente> root = cquery.from(Paciente.class);
		
		cquery.select(root).where(cb.equal(root.get("statusPaciente"), statusPaciente));
		
		List<Paciente> pacientes = getEntityManager().createQuery(cquery).getResultList();
		
		return pacientes;
	}
	 
}

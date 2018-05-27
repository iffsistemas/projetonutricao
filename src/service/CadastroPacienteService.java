package service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;

import modelo.CadastroPaciente;
import tools.Paciente;

@Stateless
public class CadastroPacienteService extends GenericService<CadastroPaciente> {

	public CadastroPacienteService(){
		super(CadastroPaciente.class);
	}
	
	public List<CadastroPaciente> obtemPacientePorNome(String nome){
		CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
		CriteriaQuery<CadastroPaciente> cquery = cb.createQuery(CadastroPaciente.class);
		Root<CadastroPaciente> root = cquery.from(CadastroPaciente.class);
		
		Expression<String> colunaNome = root.get("nome");
		
		cquery.select(root).where(cb.like(colunaNome, "%"+nome+"%"));
		
		List<CadastroPaciente> pacientes = getEntityManager().createQuery(cquery).getResultList();
		
		return pacientes;
	}
	 
}

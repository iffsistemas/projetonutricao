package service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;

import modelo.Taco;

@Stateless
public class TacoService extends GenericService<Taco> {

	public TacoService(){
		super(Taco.class);
	}
	
	
	
	
	public List<Taco> obtemAlimentosPorNome(String nome){
		CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
		CriteriaQuery<Taco> cquery = cb.createQuery(Taco.class);
		Root<Taco> root = cquery.from(Taco.class);
		
		Expression<String> colunaNome = root.get("nome");
		
		cquery.select(root).where(cb.like(colunaNome, "%"+nome+"%"));
		
		List<Taco> alimentos = getEntityManager().createQuery(cquery).getResultList();
		
		return alimentos;
	}

}

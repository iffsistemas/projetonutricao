package service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;

import modelo.AlimentoTaco;

@Stateless
public class AlimentoTacoService extends GenericService<AlimentoTaco> {

	public AlimentoTacoService(){
		super(AlimentoTaco.class);
	}
	
	
	
	
	public List<AlimentoTaco> obtemAlimentosPorNome(String nome){
		CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
		CriteriaQuery<AlimentoTaco> cquery = cb.createQuery(AlimentoTaco.class);
		Root<AlimentoTaco> root = cquery.from(AlimentoTaco.class);
		
		Expression<String> colunaNome = root.get("nome");
		
		cquery.select(root).where(cb.like(colunaNome, "%"+nome+"%"));
		
		List<AlimentoTaco> alimentos = getEntityManager().createQuery(cquery).getResultList();
		
		return alimentos;
	}

}

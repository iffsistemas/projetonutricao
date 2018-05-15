package service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;

import modelo.MedidasCaseiras;
import modelo.Taco;

@Stateless
public class TacoService extends GenericService<Taco> {

	public TacoService(){
		super(Taco.class);
	}
	
	
	
	
	public List<MedidasCaseiras> obtemAlimentosPorNome(String nome){
		CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
		CriteriaQuery<MedidasCaseiras> cquery = cb.createQuery(MedidasCaseiras.class);
		Root<MedidasCaseiras> root = cquery.from(MedidasCaseiras.class);
		
		Expression<String> colunaNome = root.get("nome");
		
		cquery.select(root).where(cb.like(colunaNome, "%"+nome+"%"));
		
		List<MedidasCaseiras> alimentos = getEntityManager().createQuery(cquery).getResultList();
		
		return alimentos;
	}

}

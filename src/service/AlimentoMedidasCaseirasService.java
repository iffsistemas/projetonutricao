package service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;

import modelo.AlimentoMedidasCaseiras;

@Stateless
public class AlimentoMedidasCaseirasService extends GenericService<AlimentoMedidasCaseiras> {

	public AlimentoMedidasCaseirasService(){
		super(AlimentoMedidasCaseiras.class);
	}
	
	
	
	
	public List<AlimentoMedidasCaseiras> obtemAlimentosPorNomeOrdenado(String nome){
		CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
		CriteriaQuery<AlimentoMedidasCaseiras> cquery = cb.createQuery(AlimentoMedidasCaseiras.class);
		Root<AlimentoMedidasCaseiras> root = cquery.from(AlimentoMedidasCaseiras.class);
		
		Expression<String> colunaNome = root.get("nome");
		
		cquery.select(root).where(cb.like(colunaNome, "%"+nome+"%"));
		cquery.orderBy(cb.asc(colunaNome));
		
		List<AlimentoMedidasCaseiras> alimentos = getEntityManager().createQuery(cquery).getResultList();
		
		return alimentos;
	}
	
	
	public List<AlimentoMedidasCaseiras> listarAlimentosOrdenados(){
		CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
		CriteriaQuery<AlimentoMedidasCaseiras> cquery = cb.createQuery(AlimentoMedidasCaseiras.class);
		Root<AlimentoMedidasCaseiras> root = cquery.from(AlimentoMedidasCaseiras.class);
		
		Expression<String> colunaNome = root.get("nome");
		
		cquery.select(root);
		cquery.orderBy(cb.asc(colunaNome));
		
		List<AlimentoMedidasCaseiras> alimentos = getEntityManager().createQuery(cquery).getResultList();
		
		return alimentos;
	}
	
	
}

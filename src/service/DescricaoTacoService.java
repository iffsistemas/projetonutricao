package service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;

import modelo.DescricaoTaco;

@Stateless
public class DescricaoTacoService extends GenericService<DescricaoTaco> {

	public DescricaoTacoService(){
		super(DescricaoTaco.class);
	}
	
	
	
	
	public List<DescricaoTaco> obtemAlimentosPorNome(String nome){
		CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
		CriteriaQuery<DescricaoTaco> cquery = cb.createQuery(DescricaoTaco.class);
		Root<DescricaoTaco> root = cquery.from(DescricaoTaco.class);
		
		Expression<String> colunaNome = root.get("nome");
		
		cquery.select(root).where(cb.like(colunaNome, "%"+nome+"%"));
		
		List<DescricaoTaco> alimentos = getEntityManager().createQuery(cquery).getResultList();
		
		return alimentos;
	}

}

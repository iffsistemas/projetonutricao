package service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;

import modelo.AlimentoTabela;

@Stateless
public class AlimentoTabelaService extends GenericService<AlimentoTabela> {
	
	public AlimentoTabelaService() {
		super(AlimentoTabela.class);
	}
	
	public List<AlimentoTabela> listarAlimentosOrdenados(){
		CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
		CriteriaQuery<AlimentoTabela> cquery = cb.createQuery(AlimentoTabela.class);
		Root<AlimentoTabela> root = cquery.from(AlimentoTabela.class);
		
		Expression<String> colunaNome = root.get("nome");
		
		cquery.select(root);
		cquery.orderBy(cb.asc(colunaNome));
		
		List<AlimentoTabela> alimentos = getEntityManager().createQuery(cquery).getResultList();
		
		return alimentos;
	}

}

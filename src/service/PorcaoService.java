package service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;

import modelo.Porcao;

@Stateless
public class PorcaoService extends GenericService<Porcao> {

	public PorcaoService(){
		super(Porcao.class);
	}
	
	public List<Porcao> porcoesDeUmAlimento(Long idAlimento){
		CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
		CriteriaQuery<Porcao> cquery = cb.createQuery(Porcao.class);
		Root<Porcao> root = cquery.from(Porcao.class);
		
		Expression<String> idAlimentoTabela = root.get("alimentoTabela").get("id");
		
		cquery.where(cb.equal(idAlimentoTabela, idAlimento));
		cquery.orderBy(cb.asc(root.get("descricao")));
		
		List<Porcao> porcoes = getEntityManager().createQuery(cquery).getResultList();
		
		return porcoes;
	}
}

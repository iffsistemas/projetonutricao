package controle;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import modelo.AlimentoTabela;
import modelo.Porcao;
import service.AlimentoTabelaService;
import service.PorcaoService;



@ViewScoped
@ManagedBean
public class PorcaoBean  {
	
	
	
	@EJB
	PorcaoService porcaoService;
	
	@EJB
	AlimentoTabelaService alimentoTabelaService	;
	
	private Porcao porcao = new Porcao();
	
	
	List<Porcao> porcoes = new ArrayList<Porcao>();
	List<AlimentoTabela> alimentos = new ArrayList<AlimentoTabela>();
	
	Long alimentoId=0L;
	
	
	public Porcao getPorcao() {
		return porcao;
	}
	public void setPorcao(Porcao porcao) {
		this.porcao = porcao;
	}
	public List<Porcao> getPorcoes() {
		return porcoes;
	}
	public void setPorcoes(List<Porcao> porcoes) {
		this.porcoes = porcoes;
	}
	
	public List<AlimentoTabela> getAlimentos() {
		return alimentos;
	}
	public void setAlimentos(List<AlimentoTabela> alimentos) {
		this.alimentos = alimentos;
	}
	public Long getAlimentoId() {
		return alimentoId;
	}
	public void setAlimentoId(Long alimentoId) {
		this.alimentoId = alimentoId;
	}
	@PostConstruct
	public void init(){
		//atualizarPorcoes();
		
		setAlimentos(alimentoTabelaService.listarAlimentosOrdenados());
		
		
		
	}
	
	
	public void atualizarPorcoes(){
		getPorcoes().clear();
		getPorcoes().addAll(porcaoService.listAll());
	}
	
	
	public void salvarPorcao() {
		String msg;		
		if(getPorcao().getId()==null)	{
		AlimentoTabela alimento = new AlimentoTabela();
		alimento =   alimentoTabelaService.obtemPorId(alimentoId);
		porcao.setAlimentoTabela(alimento);
		porcaoService.create(porcao);
		msg="Porção Cadastrada com sucesso!";
		
		}else {
			porcaoService.merge(getPorcao());
			msg="Porcao Atualizada com sucesso!";
		}
			
		setPorcao(new Porcao());
		FacesContext.getCurrentInstance().addMessage("menssagem", new FacesMessage("Parabéns!", msg));
		
			
	}
	
	
	public void editarPorcao(Porcao porcaoAtual) {
		setPorcao(porcaoAtual);
		
		
	}
	
	public void excluirPorcao(Porcao porcaoAtual) {
		porcaoService.remove(porcaoAtual);
		filtrarPorcao();
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Parabens", "Porção excluída com sucesso!");
		FacesContext.getCurrentInstance().addMessage(null, message);
		
	}
	
	
	public void filtrarPorcao() {
		setPorcoes(porcaoService.porcoesDeUmAlimento(alimentoId));
	}
	
}
	
	


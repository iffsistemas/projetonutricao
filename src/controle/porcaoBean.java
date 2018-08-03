package controle;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import modelo.AlimentoMedidasCaseiras;
import modelo.AlimentoTabela;
import modelo.Porcao;
import service.AlimentoMedidasCaseirasService;
import service.PorcaoService;



@ViewScoped
@ManagedBean
public class porcaoBean  {
	
	
	
	@EJB
	PorcaoService porcaoService;
	
	@EJB
	AlimentoMedidasCaseirasService alimentoMedidasCaseirasService	;
	
	private Porcao porcao = new Porcao();
	
	
	List<Porcao> porcoes = new ArrayList<Porcao>();
	List<AlimentoMedidasCaseiras> alimentos = new ArrayList<AlimentoMedidasCaseiras>();
	
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
	
			
	public List<AlimentoMedidasCaseiras> getAlimentos() {
		return alimentos;
	}
	public void setAlimentos(List<AlimentoMedidasCaseiras> alimentos) {
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
		atualizarPorcoes();
		
		setAlimentos(alimentoMedidasCaseirasService.listarAlimentosOrdenados());
		
		
		
	}
	
	
	public void atualizarPorcoes(){
		getPorcoes().clear();
		getPorcoes().addAll(porcaoService.listAll());
	}
	
	
	public void salvarPorcao() {
		String msg;		
		if(getPorcao().getId()==null)	{
		AlimentoTabela alimento = new AlimentoTabela();
		alimento =   alimentoMedidasCaseirasService.obtemPorId(alimentoId);
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
	
	


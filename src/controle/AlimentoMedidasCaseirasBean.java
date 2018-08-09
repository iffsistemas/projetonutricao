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
import modelo.Porcao;
import service.AlimentoMedidasCaseirasService;
import service.PorcaoService;



@ViewScoped
@ManagedBean
public class AlimentoMedidasCaseirasBean {
	
	
	@EJB
	AlimentoMedidasCaseirasService medidasCaseirasService;
	@EJB
	PorcaoService porcaoService;
	
	
	AlimentoMedidasCaseiras medidasCaseiras = new AlimentoMedidasCaseiras();
	Porcao porcaoPadrao = new Porcao();
	
	List<AlimentoMedidasCaseiras> alimentos = new ArrayList<AlimentoMedidasCaseiras>();
	
	AlimentoMedidasCaseiras alimentoSelecionado = new AlimentoMedidasCaseiras();
	
	
	
	public Porcao getPorcaoPadrao() {
		return porcaoPadrao;
	}

	public void setPorcaoPadrao(Porcao porcaoPadrao) {
		this.porcaoPadrao = porcaoPadrao;
	}

	public AlimentoMedidasCaseiras getMedidasCaseiras() {
		return medidasCaseiras;
	}
	
	public void setMedidasCaseiras(AlimentoMedidasCaseiras medidasCaseiras) {
		this.medidasCaseiras = medidasCaseiras;
	}

	public List<AlimentoMedidasCaseiras> getAlimentos() {
		return alimentos;
	}

	public void setAlimentos(List<AlimentoMedidasCaseiras> alimentos) {
		this.alimentos = alimentos;
	}
	
	
	public AlimentoMedidasCaseiras getAlimentoSelecionado() {
		return alimentoSelecionado;
	}

	public void setAlimentoSelecionado(AlimentoMedidasCaseiras alimentoSelecionado) {
		this.alimentoSelecionado = alimentoSelecionado;
	}

	@PostConstruct
	public void init(){
		atualizarAlimentos();
	}
	
	protected void atualizarAlimentos(){
		getAlimentos().clear();
		getAlimentos().addAll(medidasCaseirasService.listarAlimentosOrdenados());
	}
	
	
	
	
	
	
	public void salvar() {
		String msg;
		
	if(getMedidasCaseiras().getId()==null)	{
		medidasCaseiras.setQuantidade(100D);
		medidasCaseirasService.create(medidasCaseiras);
		salvarPorcaoCemGramas();
		msg="Alimento Cadastrado!!!";	

	}else {
		
		medidasCaseirasService.merge(getMedidasCaseiras());
		msg="Alimento Atualizado!!!";
		
	}
	
	
	setMedidasCaseiras(new AlimentoMedidasCaseiras());
	FacesContext.getCurrentInstance().addMessage("menssagem", new FacesMessage("Parabéns!", msg));
	atualizarAlimentos();	
	}

	
	public void editarAlimento (AlimentoMedidasCaseiras alimentoAtual) {
		setMedidasCaseiras(alimentoAtual);
	}
	
	
	public void removerAlimento(AlimentoMedidasCaseiras alimento) {
		medidasCaseirasService.remove(alimento);
		//FacesContext.getCurrentInstance().addMessage("menssagem", new FacesMessage("Parabéns!", "Alimento Removido!"));
		 
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Parabens", "Alimento excluído com sucesso");
		FacesContext.getCurrentInstance().addMessage(null, message);
		
		
		atualizarAlimentos();		
	}
	
	
	public void buscarAlimento() {
		 alimentos = medidasCaseirasService.obtemAlimentosPorNomeOrdenado(getMedidasCaseiras().getNome());	
		
		 
	
		
	}
	
	
	public void salvarPorcaoCemGramas() {
		porcaoPadrao.setDescricao("Porção");
		porcaoPadrao.setQuantidade(100D);
		porcaoPadrao.setAlimentoTabela(medidasCaseiras);
		porcaoService.merge(porcaoPadrao);
		
		
	}
	
	
	
	
	
	
	
	
}

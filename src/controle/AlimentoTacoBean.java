package controle;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import modelo.AlimentoTaco;
import modelo.Atendimento;
import modelo.Porcao;
import service.AlimentoTacoService;
import service.PorcaoService;



@ViewScoped
@ManagedBean
public class AlimentoTacoBean  {
	
	
	
	@EJB
	AlimentoTacoService tacoService;
	@EJB
	PorcaoService porcaoService;
	
	
	AlimentoTaco alimentoSelecionado = new AlimentoTaco();
	
	AlimentoTaco taco = new AlimentoTaco();
	Porcao porcaoPadrao = new Porcao();
	
	
	List<AlimentoTaco> alimentos = new ArrayList<AlimentoTaco>();
	
	
	
	public Porcao getPorcaoPadrao() {
		return porcaoPadrao;
	}

	public void setPorcaoPadrao(Porcao porcaoPadrao) {
		this.porcaoPadrao = porcaoPadrao;
	}

	public AlimentoTaco getTaco() {
		return taco;
	}
	
	public void setTaco(AlimentoTaco taco) {
		this.taco = taco;
	}
	
		
	
	public AlimentoTacoService getTacoService() {
		return tacoService;
	}

	public void setTacoService(AlimentoTacoService tacoService) {
		this.tacoService = tacoService;
	}

	public List<AlimentoTaco> getAlimentos() {
		return alimentos;
	}

	public void setAlimentos(List<AlimentoTaco> alimentos) {
		this.alimentos = alimentos;
	}
	
	
	public AlimentoTaco getAlimentoSelecionado() {
		return alimentoSelecionado;
	}

	public void setAlimentoSelecionado(AlimentoTaco alimentoSelecionado) {
		this.alimentoSelecionado = alimentoSelecionado;
	}

	@PostConstruct
	public void init(){
		atualizarAlimentos();
	}
	
	protected void atualizarAlimentos(){
		getAlimentos().clear();
		getAlimentos().addAll(tacoService.listAll());
	}
	
	
	
	
	
	
	public void salvar() {
		String msg;
		
	if(getTaco().getId()==null)	{
		taco.setQuantidade(100D);
		tacoService.create(taco);
		salvarPorcaoCemGramas();
		msg="Alimento Cadastrado!!!";	

	}else {
		
		tacoService.merge(getTaco());
		msg="Alimento Atualizado!!!";
		
	}
	
	
	setTaco(new AlimentoTaco());
	FacesContext.getCurrentInstance().addMessage("menssagem", new FacesMessage("Parabéns!", msg));
	atualizarAlimentos();	
	}

	
	public void editarAlimeto (AlimentoTaco alimentoAtual) {
		setTaco(alimentoAtual);
	}
	
	
	public void removerAlimento(AlimentoTaco alimento) {
		tacoService.remove(alimento);
		//FacesContext.getCurrentInstance().addMessage("menssagem", new FacesMessage("Parabéns!", "Alimento Removido!"));
		 
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Parabéns", "Alimento excluído com sucesso");
		FacesContext.getCurrentInstance().addMessage(null, message);
		
		
		atualizarAlimentos();
		setTaco(new AlimentoTaco());
	}
	
	
	public void buscarAlimento() {
		 alimentos = tacoService.obtemAlimentosPorNome(getTaco().getNome());	
		
	
		
	}
	
	
	public void salvarPorcaoCemGramas() {
		porcaoPadrao.setDescricao("Porção");
		porcaoPadrao.setQuantidade(100D);
		porcaoPadrao.setAlimentoTabela(taco);
		porcaoService.merge(porcaoPadrao);
		
		
	}
	
}
	
	


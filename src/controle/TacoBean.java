package controle;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import modelo.Taco;
import service.TacoService;



@ViewScoped
@ManagedBean
public class TacoBean {
	
	
	
	@EJB
	TacoService tacoService;
	
	
	Taco alimentoSelecionado = new Taco();
	
	Taco taco = new Taco();
	
	
	List<Taco> alimentos = new ArrayList<Taco>();
	
	
	
	public Taco getTaco() {
		return taco;
	}
	
	public void setTaco(Taco taco) {
		this.taco = taco;
	}
	
		
	
	public TacoService getTacoService() {
		return tacoService;
	}

	public void setTacoService(TacoService tacoService) {
		this.tacoService = tacoService;
	}

	public List<Taco> getAlimentos() {
		return alimentos;
	}

	public void setAlimentos(List<Taco> alimentos) {
		this.alimentos = alimentos;
	}
	
	
	public Taco getAlimentoSelecionado() {
		return alimentoSelecionado;
	}

	public void setAlimentoSelecionado(Taco alimentoSelecionado) {
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
		tacoService.create(taco);
		msg="Alimento Cadastrado!!!";	

	}else {
		
		tacoService.merge(getTaco());
		msg="Alimento Atualizado!!!";
		
	}
	
	
	setTaco(new Taco());
	FacesContext.getCurrentInstance().addMessage("menssagem", new FacesMessage("Parabéns!", msg));
	atualizarAlimentos();	
	}

	
	public void editarAlimeto (Taco alimentoAtual) {
		setTaco(alimentoAtual);
	}
	
	
	public void removerAlimento(Taco alimento) {
		tacoService.remove(alimento);
		//FacesContext.getCurrentInstance().addMessage("menssagem", new FacesMessage("Parabéns!", "Alimento Removido!"));
		 
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Parabéns", "Alimento excluído com sucesso");
		FacesContext.getCurrentInstance().addMessage(null, message);
		
		
		atualizarAlimentos();
		setTaco(new Taco());
	}
	
	
	public void buscarAlimento() {
		 alimentos = tacoService.obtemAlimentosPorNome(getTaco().getNome());	
		
	
		
	}
	
}
	
	


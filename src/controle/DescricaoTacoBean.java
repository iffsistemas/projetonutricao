package controle;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import modelo.DescricaoTaco;
import service.DescricaoTacoService;



@ViewScoped
@ManagedBean
public class DescricaoTacoBean {
	
	
	
	@EJB
	DescricaoTacoService tacoService;
	
	
	DescricaoTaco alimentoSelecionado = new DescricaoTaco();
	
	DescricaoTaco taco = new DescricaoTaco();
	
	
	List<DescricaoTaco> alimentos = new ArrayList<DescricaoTaco>();
	
	
	
	public DescricaoTaco getTaco() {
		return taco;
	}
	
	public void setTaco(DescricaoTaco taco) {
		this.taco = taco;
	}
	
		
	
	public DescricaoTacoService getTacoService() {
		return tacoService;
	}

	public void setTacoService(DescricaoTacoService tacoService) {
		this.tacoService = tacoService;
	}

	public List<DescricaoTaco> getAlimentos() {
		return alimentos;
	}

	public void setAlimentos(List<DescricaoTaco> alimentos) {
		this.alimentos = alimentos;
	}
	
	
	public DescricaoTaco getAlimentoSelecionado() {
		return alimentoSelecionado;
	}

	public void setAlimentoSelecionado(DescricaoTaco alimentoSelecionado) {
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
	
	
	setTaco(new DescricaoTaco());
	FacesContext.getCurrentInstance().addMessage("menssagem", new FacesMessage("Parabéns!", msg));
	atualizarAlimentos();	
	}

	
	public void editarAlimeto (DescricaoTaco alimentoAtual) {
		setTaco(alimentoAtual);
	}
	
	
	public void removerAlimento(DescricaoTaco alimento) {
		tacoService.remove(alimento);
		//FacesContext.getCurrentInstance().addMessage("menssagem", new FacesMessage("Parabéns!", "Alimento Removido!"));
		 
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Parabéns", "Alimento excluído com sucesso");
		FacesContext.getCurrentInstance().addMessage(null, message);
		
		
		atualizarAlimentos();
		setTaco(new DescricaoTaco());
	}
	
	
	public void buscarAlimento() {
		 alimentos = tacoService.obtemAlimentosPorNome(getTaco().getNome());	
		
	
		
	}
	
}
	
	


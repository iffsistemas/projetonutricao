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
import service.AlimentoMedidasCaseirasService;



@ViewScoped
@ManagedBean
public class AlimentoMedidasCaseirasBean {
	
	
	@EJB
	AlimentoMedidasCaseirasService medidasCaseirasService;
	
	AlimentoMedidasCaseiras medidasCaseiras = new AlimentoMedidasCaseiras();
	
	List<AlimentoMedidasCaseiras> alimentos = new ArrayList<AlimentoMedidasCaseiras>();
	
	AlimentoMedidasCaseiras alimentoSelecionado = new AlimentoMedidasCaseiras();
	
	
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
		getAlimentos().addAll(medidasCaseirasService.listAll());
	}
	
	
	
	
	
	
	public void salvar() {
		String msg;
		
	if(getMedidasCaseiras().getId()==null)	{
		medidasCaseirasService.create(medidasCaseiras);
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
		 
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alimento", "excluído com sucesso");
		FacesContext.getCurrentInstance().addMessage(null, message);
		
		
		atualizarAlimentos();		
	}
	
	
	public void buscarAlimento() {
		 alimentos = medidasCaseirasService.obtemAlimentosPorNome(getMedidasCaseiras().getNome());	
		
	
		
	}
	
	
	
	
	
	
	
	
	
	
	
}

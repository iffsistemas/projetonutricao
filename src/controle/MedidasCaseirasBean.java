package controle;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import modelo.MedidasCaseiras;
import service.MedidasCaseirasService;



@ViewScoped
@ManagedBean
public class MedidasCaseirasBean {
	
	
	@EJB
	MedidasCaseirasService medidasCaseirasService;
	
	MedidasCaseiras medidasCaseiras = new MedidasCaseiras();
	
	List<MedidasCaseiras> alimentos = new ArrayList<MedidasCaseiras>();
	
	
	
	public MedidasCaseiras getMedidasCaseiras() {
		return medidasCaseiras;
	}
	
	public void setMedidasCaseiras(MedidasCaseiras medidasCaseiras) {
		this.medidasCaseiras = medidasCaseiras;
	}

	public List<MedidasCaseiras> getAlimentos() {
		return alimentos;
	}

	public void setAlimentos(List<MedidasCaseiras> alimentos) {
		this.alimentos = alimentos;
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
	
	
	setMedidasCaseiras(new MedidasCaseiras());
	FacesContext.getCurrentInstance().addMessage("menssagem", new FacesMessage("Parabéns!", msg));
	atualizarAlimentos();	
	}

	
	public void editarAlimento (MedidasCaseiras alimentoAtual) {
		setMedidasCaseiras(alimentoAtual);
	}
	
	
	public void removerAlimento(MedidasCaseiras alimento) {
		medidasCaseirasService.remove(alimento);
		//FacesContext.getCurrentInstance().addMessage("menssagem", new FacesMessage("Parabéns!", "Alimento Removido!"));
		 
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alimento", "excluído com sucesso");
		FacesContext.getCurrentInstance().addMessage(null, message);
		
		
		atualizarAlimentos();		
	}
	
	
	public void buscarAlimento(String nome) {
		 
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
}

package controle;

import java.util.Arrays;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import modelo.MotivoAtendimento;
import modelo.PacienteAdulto;
import service.PacienteAdultoService;

@ViewScoped
@ManagedBean
public class PacienteAdultoBean {

	
	@EJB 
	PacienteAdultoService pacienteAdultoService;
	
	
	private Long id=1L;
	
	PacienteAdulto pacienteAdulto = new PacienteAdulto();
	
	
				
	private MotivoAtendimento[] motivosSelecionados;	
	
	public List<MotivoAtendimento> getMotivosAtendimento(){
		List<MotivoAtendimento> lista = Arrays.asList(MotivoAtendimento.values());
		return lista;
	}
	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}
	
	
	public MotivoAtendimento[] getMotivosSelecionados() {
		return motivosSelecionados;
	}

	public void setMotivosSelecionados(MotivoAtendimento[] motivosSelecionados) {
		this.motivosSelecionados = motivosSelecionados;
	}
	
	

	public PacienteAdulto getPacienteAdulto() {
		return pacienteAdulto;
	}

	public void setPacienteAdulto(PacienteAdulto pacienteAdulto) {
		this.pacienteAdulto = pacienteAdulto;
	}	
		
	
	
	public void gravarIdentificacao() {
		String msg="Paciente gravado com sucesso";
				
		if(getPacienteAdulto().getId()==null){ 
		//	getPacienteAdulto().getMotivos().addAll(Arrays.asList(motivosSelecionados));
			pacienteAdultoService.create(pacienteAdulto);
			setPacienteAdulto(new PacienteAdulto());		
		//	Arrays.fill(motivosSelecionados, null);
			FacesContext.getCurrentInstance().addMessage("menssagem", new FacesMessage("Parabéns!", msg));
		
		}
		
		
	}
	
	public void testar(){		
		getPacienteAdulto().getMotivos().addAll(Arrays.asList(motivosSelecionados));
		pacienteAdulto.setNome("Roberto Jr.");
		pacienteAdultoService.create(pacienteAdulto);
		Arrays.fill(motivosSelecionados, null);
		setPacienteAdulto(new PacienteAdulto());
		
	 
	}
	
	public void testarCarregar(){
		setPacienteAdulto(pacienteAdultoService.obtemPorId(getId()));
		motivosSelecionados = getPacienteAdulto().getMotivos().toArray(new MotivoAtendimento[getPacienteAdulto().getMotivos().size()]);
	}
	
	 
}

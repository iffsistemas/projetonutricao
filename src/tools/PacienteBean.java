package tools;

import java.util.Arrays;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import modelo.MotivoAtendimento;


public class PacienteBean {
	
	
	PacienteService pacienteService;
	
	private Long id=1L;
	
	private Paciente paciente = new Paciente();
	
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

	public Paciente getPaciente() {
		return paciente;
	}


	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}


	
	
	public void gravarIdentificacao() {
		String msg="Paciente gravado com sucesso";
		
		if(getPaciente().getId()==null){ 
		pacienteService.create(paciente);
		setPaciente(new Paciente());		
		
		FacesContext.getCurrentInstance().addMessage("menssagem", new FacesMessage("Parabéns!", msg));
		
		}
		
		
	}
	
	
	
	
	
	
	
	
	public void testar(){		
		//getPaciente().getMotivos().addAll(Arrays.asList(motivosSelecionados));
		paciente.setNome("Roberto Jr.");
		pacienteService.create(paciente);
		Arrays.fill(motivosSelecionados, null);
		setPaciente(new Paciente());
	}
	
	public void testarCarregar(){
		setPaciente(pacienteService.obtemPorId(getId()));
		
		motivosSelecionados = getPaciente().getMotivos().toArray(new MotivoAtendimento[getPaciente().getMotivos().size()]);
	}

}

package controle;

import java.util.Arrays;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import modelo.MotivoAtendimento;
import modelo.Paciente;
import service.PacienteService;

@ViewScoped
@ManagedBean
public class PacienteBean {
	
	@EJB
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


	public void testar(){		
		getPaciente().getMotivos().addAll(Arrays.asList(motivosSelecionados));
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

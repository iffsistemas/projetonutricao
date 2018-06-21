package controle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import modelo.Atendimento;
import modelo.Medicamento;
import modelo.MotivoAtendimento;
import modelo.Paciente;
import modelo.PacienteAdulto;
import modelo.PacienteCrianca;
import modelo.PacienteGestante;
import service.AtendimentoService;
import service.PacienteAdultoService;
import service.PacienteCriancaService;
import service.PacienteGestanteService;
import service.PacienteService;



@ViewScoped
@ManagedBean
public class PacienteBean {
	
	
	@EJB
	PacienteService pacienteService;
	@EJB
	AtendimentoService atendimentoService;
	@EJB
	PacienteAdultoService pacienteAdultoService;	
	@EJB
	PacienteCriancaService pacienteCriancaService;	
	@EJB
	PacienteGestanteService pacienteGestanteService;	 
	
	
	PacienteGestante pacienteGestante = new  PacienteGestante();
	PacienteCrianca pacienteCrianca = new  PacienteCrianca();
	PacienteAdulto pacienteAdulto = new  PacienteAdulto();
	
	private MotivoAtendimento[] motivosSelecionados;	
	
	public List<MotivoAtendimento> getMotivosAtendimento(){
		List<MotivoAtendimento> lista = Arrays.asList(MotivoAtendimento.values());
		return lista;
	}
	
	Medicamento medicamento = new Medicamento();
	List<Medicamento> medicamentos = new ArrayList<Medicamento>();
	
	
	
	
	
	Paciente paciente = new Paciente();
	Paciente pacienteSelecionado = new Paciente();
	private String nome;
	
	
	
	List<Paciente> pacientes = new ArrayList<Paciente>();
	List<Atendimento> atendimentos = new ArrayList<Atendimento>();	
	
		
	public PacienteService getPacienteService() {
		return pacienteService;
	}

	public void setPacienteService(PacienteService pacienteService) {
		this.pacienteService = pacienteService;
	}

	public AtendimentoService getAtendimentoService() {
		return atendimentoService;
	}

	public void setAtendimentoService(AtendimentoService atendimentoService) {
		this.atendimentoService = atendimentoService;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Paciente getPacienteSelecionado() {
		return pacienteSelecionado;
	}

	public void setPacienteSelecionado(Paciente pacienteSelecionado) {
		this.pacienteSelecionado = pacienteSelecionado;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Paciente> getPacientes() {
		return pacientes;
	}

	public void setPacientes(List<Paciente> pacientes) {
		this.pacientes = pacientes;
	}

	public List<Atendimento> getAtendimentos() {
		return atendimentos;
	}

	public void setAtendimentos(List<Atendimento> atendimentos) {
		this.atendimentos = atendimentos;
	}

	public PacienteAdultoService getPacienteAdultoService() {
		return pacienteAdultoService;
	}

	public void setPacienteAdultoService(PacienteAdultoService pacienteAdultoService) {
		this.pacienteAdultoService = pacienteAdultoService;
	}

	public PacienteAdulto getPacienteAdulto() {
		return pacienteAdulto;
	}

	public void setPacienteAdulto(PacienteAdulto pacienteAdulto) {
		this.pacienteAdulto = pacienteAdulto;
	}
	
	public PacienteCriancaService getPacienteCriancaService() {
		return pacienteCriancaService;
	}

	public void setPacienteCriancaService(PacienteCriancaService pacienteCriancaService) {
		this.pacienteCriancaService = pacienteCriancaService;
	}

	public PacienteCrianca getPacienteCrianca() {
		return pacienteCrianca;
	}

	public void setPacienteCrianca(PacienteCrianca pacienteCrianca) {
		this.pacienteCrianca = pacienteCrianca;
	}

		
	public PacienteGestanteService getPacienteGestanteService() {
		return pacienteGestanteService;
	}

	public void setPacienteGestanteService(PacienteGestanteService pacienteGestanteService) {
		this.pacienteGestanteService = pacienteGestanteService;
	}

	public PacienteGestante getPacienteGestante() {
		return pacienteGestante;
	}

	public void setPacienteGestante(PacienteGestante pacienteGestante) {
		this.pacienteGestante = pacienteGestante;
	}
	
		

	public MotivoAtendimento[] getMotivosSelecionados() {
		return motivosSelecionados;
	}

	public void setMotivosSelecionados(MotivoAtendimento[] motivosSelecionados) {
		this.motivosSelecionados = motivosSelecionados;
	}
	
		
	public Medicamento getMedicamento() {
		return medicamento;
	}

	public void setMedicamento(Medicamento medicamento) {
		this.medicamento = medicamento;
	}

	public List<Medicamento> getMedicamentos() {
		return medicamentos;
	}

	public void setMedicamentos(List<Medicamento> medicamentos) {
		this.medicamentos = medicamentos;
	}

	@PostConstruct
	public void init(){
		atualizarPacientes();
	}
	
	public void atualizarPacientes(){
		getPacientes().clear();
		getPacientes().addAll(pacienteService.listAll());
	}
	
	
	public void carregarAtendimentos() {
		atendimentos.clear();
		atendimentos.addAll(atendimentoService.obtemAtendimentoPorPaciente(pacienteSelecionado));
	}
	
	
	public void buscarNome() {
		pacientes = pacienteService.obtemPacientePorNome(getNome());
				
	}
		
	
	
	public void salvarPacienteAdulto() {
		String msg="Paciente gravado com sucesso";
	try {
		if(getPacienteAdulto().getId()==null){ 
			getPacienteAdulto().getMotivos().addAll(Arrays.asList(motivosSelecionados));
			pacienteAdultoService.create(pacienteAdulto);
			Arrays.fill(motivosSelecionados, null);
			setPacienteAdulto(new PacienteAdulto());
			atualizarPacientes();
			FacesContext.getCurrentInstance().addMessage("menssagem", new FacesMessage("Parabéns!", msg));
	}
		
	} catch (RuntimeException erro) {
		FacesContext.getCurrentInstance().addMessage("menssagem", new FacesMessage("ERRO!", "Ocorreu um erro Inesperado"));
		erro.printStackTrace();
				
	}	}
	
	
	/*	
	public void editarMotivos(){
		setPaciente(pacienteService.obtemPorId(getId()));
		
		motivosSelecionados = getPaciente().getMotivos().toArray(new MotivoAtendimento[getPaciente().getMotivos().size()]);
	}
	
	*/
	
	
	public void adicionarMedicamento() {
		
		
		medicamentos.add(medicamento);
		FacesContext.getCurrentInstance().addMessage("menssagem", new FacesMessage("Parabéns!", "Medicamento Cadastrado com Sucesso"));
		
		for(Medicamento  m : medicamentos) {
		System.out.println(m.getNome());
		 
		}
	}
	
	
	
	
	
	
	public void salvarPacienteCrianca() {
		String msg="Paciente gravado com sucesso";
		 		
	try {
				
		if(getPacienteCrianca().getId()==null){ 
			pacienteCriancaService.create(pacienteCrianca);
			setPacienteCrianca(new PacienteCrianca());
			atualizarPacientes();
			FacesContext.getCurrentInstance().addMessage("menssagem", new FacesMessage("Parabéns!", msg));
		}
		
	} catch (RuntimeException erro) {
		
		FacesContext.getCurrentInstance().addMessage("menssagem", new FacesMessage("ERRO!", "Ocorreu um erro Inesperado"));
		erro.printStackTrace();
				
	}	}
	
		
	public void limpar() {
		setPacienteCrianca(new PacienteCrianca());
	}
	
	public void salvarPacienteGestante() {
		String msg="Paciente gravado com sucesso";
				 		
	try {
			if(getPacienteGestante().getId()==null){ 
			pacienteGestanteService.create(pacienteGestante);
			setPacienteGestante(new PacienteGestante());
			atualizarPacientes();
			FacesContext.getCurrentInstance().addMessage("menssagem", new FacesMessage("Parabéns!", msg));
		
		
	}
		
	} catch (RuntimeException erro) {
		
		FacesContext.getCurrentInstance().addMessage("menssagem", new FacesMessage("ERRO!", "Ocorreu um erro Inesperado"));
		erro.printStackTrace();
				
	}	}
	
	
public int calcularIdade() {
		
		Calendar dateOfBirth = new GregorianCalendar();
		
		dateOfBirth.setTime(getPaciente().getDataNascimento());
		Calendar today = Calendar.getInstance();
		
		int age = today.get(Calendar.YEAR) - dateOfBirth.get(Calendar.YEAR);
		dateOfBirth.add(Calendar.YEAR, age);
	
		
		if (today.before(dateOfBirth)) {

			age--;

	
			}
		
		return age;
		
			}
	
	
	
	
	
	public void chamarAtendimento() throws IOException {
		//formularioAdulto?faces-redirect=true
		if(pacienteSelecionado instanceof PacienteAdulto) {
			FacesContext.getCurrentInstance().getExternalContext().redirect("formularioAdulto.xhtml");
		}else
		if(pacienteSelecionado instanceof PacienteCrianca) {
			FacesContext.getCurrentInstance().getExternalContext().redirect("formularioCrianca.xhtml");
		} else
		if(pacienteSelecionado instanceof PacienteGestante) {
			FacesContext.getCurrentInstance().getExternalContext().redirect("formularioGestante.xhtml");
		}	
	}
	
}

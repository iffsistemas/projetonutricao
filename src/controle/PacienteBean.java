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

import org.primefaces.context.RequestContext;

import modelo.AnamneseAlimentar;
import modelo.AtendimentoAdulto;
import modelo.Medicamento;
import modelo.MotivoAtendimento;
import modelo.Paciente;
import modelo.PacienteAdulto;
import modelo.PacienteCrianca;
import modelo.PacienteGestante;
import modelo.Refeicao;
import service.AtendimentoAdultoService;
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
	AtendimentoAdultoService atendimentoAdultoService;
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
	AnamneseAlimentar anamneseAlimentar = new AnamneseAlimentar();
	Refeicao refeicao = new Refeicao();
	
	
	Paciente paciente = new Paciente();
	Paciente pacienteSelecionado = new Paciente();
	private String nome;
	
	
	
	List<Paciente> pacientes = new ArrayList<Paciente>();
	List<AtendimentoAdulto> atendimentosAdulto = new ArrayList<AtendimentoAdulto>();	
	
		
	public PacienteService getPacienteService() {
		return pacienteService;
	}

	public void setPacienteService(PacienteService pacienteService) {
		this.pacienteService = pacienteService;
	}

	

	public AtendimentoAdultoService getAtendimentoAdultoService() {
		return atendimentoAdultoService;
	}

	public void setAtendimentoAdultoService(AtendimentoAdultoService atendimentoAdultoService) {
		this.atendimentoAdultoService = atendimentoAdultoService;
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

	

	public List<AtendimentoAdulto> getAtendimentosAdulto() {
		return atendimentosAdulto;
	}

	public void setAtendimentosAdulto(List<AtendimentoAdulto> atendimentosAdulto) {
		this.atendimentosAdulto = atendimentosAdulto;
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
	
		
	

	public AnamneseAlimentar getAnamneseAlimentar() {
		return anamneseAlimentar;
	}

	public void setAnamneseAlimentar(AnamneseAlimentar anamneseAlimentar) {
		this.anamneseAlimentar = anamneseAlimentar;
	}

	public Refeicao getRefeicao() {
		return refeicao;
	}

	public void setRefeicao(Refeicao refeicao) {
		this.refeicao = refeicao;
	}

	@PostConstruct
	public void init(){
		atualizarPacientes();
	}
	
	public void atualizarPacientes(){
		getPacientes().clear();
		getPacientes().addAll(pacienteService.listAll());
	}
	
	
	public void carregarAtendimentos() throws IOException { {
		
				
			if(pacienteSelecionado instanceof PacienteAdulto) {
				atendimentosAdulto.clear();
				atendimentosAdulto.addAll(atendimentoAdultoService.obtemAtendimentoAdultoPorPaciente(pacienteSelecionado));
				
			}else
			if(pacienteSelecionado instanceof PacienteCrianca) {
				FacesContext.getCurrentInstance().getExternalContext().redirect("formularioCrianca.xhtml");
			} else
			if(pacienteSelecionado instanceof PacienteGestante) {
				FacesContext.getCurrentInstance().getExternalContext().redirect("formularioGestante.xhtml");
			}	
		}
		
		
		
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
			RequestContext.getCurrentInstance().execute("PF('dialogCadAdulto').hide();");
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
		
		if(getPacienteAdulto().getMedicamentos().contains(medicamento)) {
			medicamento= new Medicamento();
            FacesMessage msg = new FacesMessage("Duplicidade!", "Este Medicamento já foi Adicionado!");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            
        } 
        else {
        	getPacienteAdulto().getMedicamentos().add(medicamento);	
    		medicamento= new Medicamento();
    		FacesContext.getCurrentInstance().addMessage("menssagem", new FacesMessage("Parabéns!", "Medicamento Cadastrado com Sucesso"));
        }
		
	
	}
	
	public void excluirMedicamento(Medicamento medAtual) {
		getPacienteAdulto().getMedicamentos().remove(medAtual);
		FacesContext.getCurrentInstance().addMessage("menssagem", new FacesMessage("Parabéns!", "Medicamento Excluído com Sucesso"));
	}
	

public void adicionarRefeicao() {
		
		if(getPacienteAdulto().getAnamneseAlimentar().getRefeicoes().contains(refeicao)) {
			refeicao= new Refeicao();
            FacesMessage msg = new FacesMessage("Duplicidade!", "Esta Refeicão já foi Adicionada!");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            
        } 
        else {
        	getPacienteAdulto().getAnamneseAlimentar().getRefeicoes().add(refeicao);	
        	refeicao= new Refeicao();
    		FacesContext.getCurrentInstance().addMessage("menssagem", new FacesMessage("Parabéns!", "Refeicão Cadastrada com Sucesso"));
        }
		
	
	}
	
	public void excluirRefeicao(Refeicao refeicaoAtual) {
		getPacienteAdulto().getAnamneseAlimentar().getRefeicoes().remove(refeicaoAtual);
		FacesContext.getCurrentInstance().addMessage("menssagem", new FacesMessage("Parabéns!", "Refeicão Excluída com Sucesso"));
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
	
	
public void calcularIdade() {
		Calendar dataNasci = new GregorianCalendar();
		
		dataNasci.setTime(getPacienteAdulto().getDataNascimento());
		Calendar hoje = Calendar.getInstance();
		
		int idade = hoje.get(Calendar.YEAR) - dataNasci.get(Calendar.YEAR);
		dataNasci.add(Calendar.YEAR, idade);
	
		
		if (hoje.before(dataNasci)) {
			idade--;
		}
		
		pacienteAdulto.setIdade(idade);		
		
		
		
}
	
	
	public void ecluirPaciente(Paciente paciente) {
		String msg="Paciente exluído com sucesso";
 		
		try {
				pacienteService.remove(paciente);
				atualizarPacientes();
				FacesContext.getCurrentInstance().addMessage("menssagem", new FacesMessage("Parabéns!", msg));
		} catch (RuntimeException erro) {
				FacesContext.getCurrentInstance().addMessage("menssagem", new FacesMessage("ERRO!", "Ocorreu um erro Inesperado"));
				erro.printStackTrace();
					
		}	
	
	}
	
	
	
	public void chamarAtendimento() throws IOException {
		//formularioAdulto?faces-redirect=true
		if(pacienteSelecionado instanceof PacienteAdulto) {
			FacesContext.getCurrentInstance().getExternalContext().getFlash().put("pacienteAdulto", pacienteSelecionado);
			FacesContext.getCurrentInstance().getExternalContext().redirect("atendimentoAdulto.xhtml");
		}else
		if(pacienteSelecionado instanceof PacienteCrianca) {
			FacesContext.getCurrentInstance().getExternalContext().redirect("formularioCrianca.xhtml");
		} else
		if(pacienteSelecionado instanceof PacienteGestante) {
			FacesContext.getCurrentInstance().getExternalContext().redirect("formularioGestante.xhtml");
		}	
	}
	
}

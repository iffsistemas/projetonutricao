package controle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import modelo.Atendimento;
import modelo.CadastroPaciente;
import modelo.CadastroPacienteAdulto;
import modelo.CadastroPacienteCrianca;
import modelo.CadastroPacienteGestante;
import service.AtendimentoService;
import service.CadastroPacienteService;



@ViewScoped
@ManagedBean
public class CadastroPacienteBean {
	
	
	@EJB
	CadastroPacienteService cadastroPacienteService;
	
	@EJB
	AtendimentoService atendimentoService;
	
	private String nome;
	
	CadastroPaciente cadastroPaciente = new CadastroPaciente();
	
	List<CadastroPaciente> cadastroPacientes = new ArrayList<CadastroPaciente>();
	
	List<Atendimento> atendimentos = new ArrayList<Atendimento>();	
	
	CadastroPaciente pacienteSelecionado = new CadastroPaciente();
	
	
	public List<Atendimento> getAtendimentos() {
		return atendimentos;
	}


	public void setAtendimentos(List<Atendimento> atendimentos) {
		this.atendimentos = atendimentos;
	}


	public CadastroPaciente getPacienteSelecionado() {
		return pacienteSelecionado;
	}


	public void setPacienteSelecionado(CadastroPaciente pacienteSelecionado) {
		this.pacienteSelecionado = pacienteSelecionado;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public CadastroPaciente getCadastroPaciente() {
		return cadastroPaciente;
	}


	public void setCadastroPaciente(CadastroPaciente cadastroPaciente) {
		this.cadastroPaciente = cadastroPaciente;
	}


	public CadastroPacienteService getCadastroPacienteService() {
		return cadastroPacienteService;
	}


	public void setCadastroPacienteService(CadastroPacienteService cadastroPacienteService) {
		this.cadastroPacienteService = cadastroPacienteService;
	}


	

	public List<CadastroPaciente> getCadastroPacientes() {
		return cadastroPacientes;
	}


	public void setCadastroPacientes(List<CadastroPaciente> cadastroPacientes) {
		this.cadastroPacientes = cadastroPacientes;
	}


	public void buscarNome() {
		cadastroPacientes = cadastroPacienteService.obtemPacientePorNome(getNome());
		
		
		
	}
	
	
	
	
	
	@PostConstruct
	public void init(){
		atualizarPacientes();
	}
	
	public void atualizarPacientes(){
		getCadastroPacientes().clear();
		getCadastroPacientes().addAll(cadastroPacienteService.listAll());
	}
	
	
	public void carregarAtendimentos() {
		atendimentos.clear();
		atendimentos.addAll(atendimentoService.obtemAtendimentoPorPaciente(pacienteSelecionado));
	}
	
	
	public void chamarAtendimento() throws IOException {
		//formularioAdulto?faces-redirect=true
		if(pacienteSelecionado instanceof CadastroPacienteAdulto) {
			FacesContext.getCurrentInstance().getExternalContext().redirect("formularioAdulto.xhtml");
		}else
		if(pacienteSelecionado instanceof CadastroPacienteCrianca) {
			FacesContext.getCurrentInstance().getExternalContext().redirect("formularioCrianca.xhtml");
		} else
		if(pacienteSelecionado instanceof CadastroPacienteGestante) {
			FacesContext.getCurrentInstance().getExternalContext().redirect("formularioGestante.xhtml");
		}	
	}
	
}

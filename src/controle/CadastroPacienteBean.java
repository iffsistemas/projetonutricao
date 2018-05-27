package controle;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import modelo.CadastroPaciente;
import service.CadastroPacienteService;



@ViewScoped
@ManagedBean
public class CadastroPacienteBean {
	
	
	@EJB
	CadastroPacienteService cadastroPacienteService;
	
	private String nome;
	
	CadastroPaciente cadastroPaciente = new CadastroPaciente();
	
	List<CadastroPaciente> cadastroPacientes = new ArrayList<CadastroPaciente>();
	
		
	
	
	
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
	
	
	
	
	
}

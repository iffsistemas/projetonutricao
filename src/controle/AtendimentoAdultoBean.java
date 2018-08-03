package controle;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import modelo.AlimentoTabela;
import modelo.AtendimentoAdulto;
import modelo.DietaRefeicao;
import modelo.ExamesLaboratoriais;
import modelo.Paciente;
import modelo.PacienteAdulto;
import modelo.Porcao;
import modelo.QuantidadePorcao;
import service.AlimentoTabelaService;
import service.AtendimentoAdultoService;
import service.PorcaoService;

@ViewScoped
@ManagedBean
public class AtendimentoAdultoBean {
	
	
	@EJB
	AtendimentoAdultoService atendimentoAdultoService;
	
	@EJB
	AlimentoTabelaService alimentoTabelaService;
	
	@EJB
	PorcaoService porcaoService;
	
	AtendimentoAdulto atendimentoAdulto = new  AtendimentoAdulto();
	ExamesLaboratoriais examesLaboratoriais = new ExamesLaboratoriais();
	
	Porcao porcao = new Porcao();
	
	Paciente pacienteSelecionado = new Paciente();
	
	DietaRefeicao dietaRefeicaoAtual = new DietaRefeicao();
	
	List<AlimentoTabela> alimentos = new ArrayList<AlimentoTabela>();
	
	List<AtendimentoAdulto> atendimentosAdulto = new ArrayList<AtendimentoAdulto>();
	
	List<QuantidadePorcao> porcoesQuantidadeAtuais = new ArrayList<QuantidadePorcao>();
	
	List<Porcao> porcoes = new ArrayList<Porcao>();

	Long alimentoId=0L;
	
	Long porcaoId=0L;	
	
	double quantidadePorcaoAtual=0D;
	

	
	public double getQuantidadePorcaoAtual() {
		return quantidadePorcaoAtual;
	}

	public void setQuantidadePorcaoAtual(double quantidadePorcaoAtual) {
		this.quantidadePorcaoAtual = quantidadePorcaoAtual;
	}

	public List<QuantidadePorcao> getPorcoesQuantidadeAtuais() {
		return porcoesQuantidadeAtuais;
	}

	public void setPorcoesQuantidadeAtuais(List<QuantidadePorcao> porcoesQuantidadeAtuais) {
		this.porcoesQuantidadeAtuais = porcoesQuantidadeAtuais;
	}

	public Long getPorcaoId() {
		return porcaoId;
	}

	public void setPorcaoId(Long porcaoId) {
		this.porcaoId = porcaoId;
	}

	public List<Porcao> getPorcoes() {
		return porcoes;
	}

	public void setPorcoes(List<Porcao> porcoes) {
		this.porcoes = porcoes;
	}

	public Long getAlimentoId() {
		return alimentoId;
	}

	public void setAlimentoId(Long alimentoId) {
		this.alimentoId = alimentoId;
	}

	public DietaRefeicao getDietaRefeicaoAtual() {
		return dietaRefeicaoAtual;
	}

	public void setDietaRefeicaoAtual(DietaRefeicao dietaRefeicaoAtual) {
		this.dietaRefeicaoAtual = dietaRefeicaoAtual;
	}

	public AtendimentoAdulto getAtendimentoAdulto() {
		return atendimentoAdulto;
	}

	public void setAtendimentoAdulto(AtendimentoAdulto atendimentoAdulto) {
		this.atendimentoAdulto = atendimentoAdulto;
	}

	public ExamesLaboratoriais getExamesLaboratoriais() {
		return examesLaboratoriais;
	}

	public void setExamesLaboratoriais(ExamesLaboratoriais examesLaboratoriais) {
		this.examesLaboratoriais = examesLaboratoriais;
	}
	
		
	public List<AtendimentoAdulto> getAtendimentosAdulto() {
		return atendimentosAdulto;
	}

	public void setAtendimentosAdulto(List<AtendimentoAdulto> atendimentosAdulto) {
		this.atendimentosAdulto = atendimentosAdulto;
	}
	
	public List<AlimentoTabela> getAlimentos() {
		return alimentos;
	}

	public void setAlimentos(List<AlimentoTabela> alimentos) {
		this.alimentos = alimentos;
	}

	public Paciente getPacienteSelecionado() {
		return pacienteSelecionado;
	}

	public void setPacienteSelecionado(Paciente pacienteSelecionado) {
		this.pacienteSelecionado = pacienteSelecionado;
	}
	
	public Porcao getPorcao() {
		return porcao;
	}

	public void setPorcao(Porcao porcao) {
		this.porcao = porcao;
	}

	@PostConstruct
	public void init(){
		atualizarAtendimentos();
		//Paciente Enviado de outro pagina
		PacienteAdulto pacEnviado = (PacienteAdulto) FacesContext.getCurrentInstance().getExternalContext().getFlash().get("pacienteAdulto");
		System.out.println("Enviado: "+pacEnviado.getNome());
		getAtendimentoAdulto().setPaciente(pacEnviado);
		setAlimentos(alimentoTabelaService.listarAlimentosOrdenados());
		
	}
	
	
	
	public void salvarAtendimentoAdulto() {
		
		String msg="Atendimento salvo com sucesso";
		
		try {
			if(getAtendimentoAdulto().getId()==null){ 
				//paciente = pacienteService.obtemPorId(getTeste());	
				//atendimentoAdulto.setPaciente(paciente);
				
				atendimentoAdulto.setExamesLaboratoriais(examesLaboratoriais);	
				atendimentoAdultoService.merge(atendimentoAdulto);
				setAtendimentoAdulto(new AtendimentoAdulto());
				FacesContext.getCurrentInstance().addMessage("menssagem", new FacesMessage("Parabéns!", msg));
					
		}
			
		} catch (RuntimeException erro) {
			
			FacesContext.getCurrentInstance().addMessage("menssagem", new FacesMessage("ERRO!", "Ocorreu um erro Inesperado"));
			erro.printStackTrace();
					
		}	}
		
		
	
	public void atualizarAtendimentos(){
		getAtendimentosAdulto().clear();
		getAtendimentosAdulto().addAll(atendimentoAdultoService.listAll());
	}
	
	public void carregarAtendimentos() {
		atendimentosAdulto.clear();
		atendimentosAdulto.addAll(atendimentoAdultoService.obtemAtendimentoAdultoPorPaciente(pacienteSelecionado));
	}
	

	
	
	public void calcularIMC() {
		 
	Double imc = atendimentoAdulto.getPesoAtual()/(atendimentoAdulto.getAltura() * atendimentoAdulto.getAltura());
	BigDecimal imcConverter = new BigDecimal(imc).setScale(2, RoundingMode.HALF_EVEN);
	
	atendimentoAdulto.setIndiceMassaCorporal(imcConverter.doubleValue());

	
	
	}
	
	public void classificacaoIMC() {
		 
	            if(atendimentoAdulto.getIndiceMassaCorporal() <= 19.1) {
	            	atendimentoAdulto.setClassificacaoIMC(" Abaixo do peso");
	            }else if(atendimentoAdulto.getIndiceMassaCorporal() > 19.1 && atendimentoAdulto.getIndiceMassaCorporal() <= 25.8) {
	            	atendimentoAdulto.setClassificacaoIMC(" Peso Normal");
	            }else if(atendimentoAdulto.getIndiceMassaCorporal() > 25.8 && atendimentoAdulto.getIndiceMassaCorporal() <= 27.3 ) {
	            	atendimentoAdulto.setClassificacaoIMC(" Sobre peso");
	            }else if(atendimentoAdulto.getIndiceMassaCorporal() > 27.3 && atendimentoAdulto.getIndiceMassaCorporal() <= 32.3) {
	            	atendimentoAdulto.setClassificacaoIMC(" Obesidade Grau I");
	            }else {
	            	atendimentoAdulto.setClassificacaoIMC(" Obesidade Grau II");
	            }            
	        
	        }
	
	public void calculoMetabolismoBasal() {
		
		// homem.. 66 + (13,7 x Peso) + (5,0 x Altura em cm) – (6,8 x Idade)
		// mulher.. 665 + (9,6 x Peso) + (1,8 x Altura em cm) – (4,7 x Idade)
		
		
			
			
			
	Double calculoMetabolismoBasal = 66 + (13.7 * atendimentoAdulto.getPesoAtual())+ (5.0 * (atendimentoAdulto.getAltura() * 100)) + (-6.8 * -atendimentoAdulto.getPaciente().getIdade());
	BigDecimal metabolismoConverter = new BigDecimal(calculoMetabolismoBasal).setScale(2, RoundingMode.HALF_EVEN);
	
	atendimentoAdulto.setMetabolismoBasal(metabolismoConverter.doubleValue());		
	getAtendimentoAdulto().getDieta().setMetabolismoBasalDieta(metabolismoConverter.doubleValue());	
		
	}
	
	public void calculoMetabolismoBasalDieta() {
		getAtendimentoAdulto().getDieta().setMetabolismoBasalDieta(0D);
	}
	
	public void filtrarPorcao() {
		setPorcoes(porcaoService.porcoesDeUmAlimento(alimentoId));
	}
		
		
		
	public void adicionarPorcao() {
		QuantidadePorcao quantidadePorcaoAtual = new QuantidadePorcao();
		quantidadePorcaoAtual.setQuantidade(getQuantidadePorcaoAtual());
		quantidadePorcaoAtual.setPorcao(porcaoService.obtemPorId(porcaoId));
		porcoesQuantidadeAtuais.add(quantidadePorcaoAtual);
		
	}
	
	
	public void adicionarRefeicao() {
		getDietaRefeicaoAtual().setQuantidadePorcoes(getPorcoesQuantidadeAtuais());
		getAtendimentoAdulto().getDieta().getDietasRefeicoes().add(getDietaRefeicaoAtual());
		setPorcoesQuantidadeAtuais(new ArrayList<QuantidadePorcao>());
		setDietaRefeicaoAtual(new DietaRefeicao());
	}
	
	
	
}







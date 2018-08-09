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

import org.primefaces.context.RequestContext;

import modelo.AlimentoMedidasCaseiras;
import modelo.AlimentoTabela;
import modelo.AlimentoTaco;
import modelo.AtendimentoAdulto;
import modelo.DietaRefeicao;
import modelo.ExamesLaboratoriais;
import modelo.Paciente;
import modelo.PacienteAdulto;
import modelo.Porcao;
import modelo.QuantidadePorcao;
import service.AlimentoMedidasCaseirasService;
import service.AlimentoTabelaService;
import service.AlimentoTacoService;
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
	AlimentoTacoService alimentoTacoService;
	@EJB
	AlimentoMedidasCaseirasService alimentoMedidasCaseirasService;
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
	
	AlimentoTabela alimentoProvisorio = new AlimentoTabela();
	
	AlimentoTaco tacoConvertido = new AlimentoTaco();
	AlimentoMedidasCaseiras medidasConvertido = new AlimentoMedidasCaseiras();
	
	Long alimentoId=0L;
	
	Long porcaoId=0L;	
	
	Double quantidadePorcaoAtual=1D;
	
	Double calcProteinaAtual;
	Double calcCarboidratoAtual;
	Double calcLipidioAtual;
	

	
	

	public AlimentoTaco getTacoConvertido() {
		return tacoConvertido;
	}

	public void setTacoConvertido(AlimentoTaco tacoConvertido) {
		this.tacoConvertido = tacoConvertido;
	}

	public AlimentoMedidasCaseiras getMedidasConvertido() {
		return medidasConvertido;
	}

	public void setMedidasConvertido(AlimentoMedidasCaseiras medidasConvertido) {
		this.medidasConvertido = medidasConvertido;
	}

	public AlimentoTabela getAlimentoProvisorio() {
		return alimentoProvisorio;
	}

	public void setAlimentoProvisorio(AlimentoTabela alimentoProvisorio) {
		this.alimentoProvisorio = alimentoProvisorio;
	}

	public Double getCalcCarboidratoAtual() {
		return calcCarboidratoAtual;
	}

	public void setCalcCarboidratoAtual(Double calcCarboidratoAtual) {
		this.calcCarboidratoAtual = calcCarboidratoAtual;
	}

	public Double getCalcLipidioAtual() {
		return calcLipidioAtual;
	}

	public void setCalcLipidioAtual(Double calcLipidioAtual) {
		this.calcLipidioAtual = calcLipidioAtual;
	}

	public Double getCalcProteinaAtual() {
		return calcProteinaAtual;
	}

	public void setCalcProteinaAtual(Double calcProteinaAtual) {
		this.calcProteinaAtual = calcProteinaAtual;
	}

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
		//System.out.println("Enviado: "+pacEnviado.getNome());
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
	
	
	//getAtendimentoAdulto().getDieta().setMetabolismoBasalDieta(metabolismoConverter.doubleValue());	
	//calcAtualMetabolismoBasal = atendimentoAdulto.getMetabolismoBasal();
	
	Double calcProteinaRestante = atendimentoAdulto.getMetabolismoBasal()*0.15/4;
	Double calcCarboitratoRestante = atendimentoAdulto.getMetabolismoBasal()*0.6/4;
	Double calcLipidioRestante = atendimentoAdulto.getMetabolismoBasal()*0.25/9;
	
	BigDecimal calcProteinaRestanteConvertido = new BigDecimal(calcProteinaRestante).setScale(2, RoundingMode.HALF_EVEN);
	BigDecimal calcCarboitratoRestanteConvertido = new BigDecimal(calcCarboitratoRestante).setScale(2, RoundingMode.HALF_EVEN);
	BigDecimal calcLipidioRestanteConvertido = new BigDecimal(calcLipidioRestante).setScale(2, RoundingMode.HALF_EVEN);
	
	
	
	
	
	atendimentoAdulto.getDieta().setProteinaRestante(calcProteinaRestanteConvertido.doubleValue());
	atendimentoAdulto.getDieta().setCarboidratoRestante(calcCarboitratoRestanteConvertido.doubleValue());
	atendimentoAdulto.getDieta().setLipidioRestante(calcLipidioRestanteConvertido.doubleValue());
	
	calcProteinaAtual= atendimentoAdulto.getDieta().getProteinaRestante();
	calcCarboidratoAtual = atendimentoAdulto.getDieta().getCarboidratoRestante();
	calcLipidioAtual = atendimentoAdulto.getDieta().getLipidioRestante();
	
	
	}
	
	public void carboidratoRestante() {
		getAtendimentoAdulto().getDieta().setCarboidratoRestante(100D);
	}
	
	public void proteinaRestante() {
		getAtendimentoAdulto().getDieta().setProteinaRestante(100D);
	}
	
	public void lipidiosRestante() {
		getAtendimentoAdulto().getDieta().setLipidioRestante(100D);
	}
	
	
	
	
	public void filtrarPorcao() {
		setPorcoes(porcaoService.porcoesDeUmAlimento(alimentoId));
	}
		
		
		
	public void adicionarPorcao() {
		QuantidadePorcao quantidadePorcaoAtual = new QuantidadePorcao();
		quantidadePorcaoAtual.setQuantidade(getQuantidadePorcaoAtual());
		quantidadePorcaoAtual.setPorcao(porcaoService.obtemPorId(porcaoId));
		porcoesQuantidadeAtuais.add(quantidadePorcaoAtual);
		
	//	calcAtualMetabolismoBasal = calcAtualMetabolismoBasal - (quantidadePorcaoAtual.getQuantidade() * quantidadePorcaoAtual.getPorcao().getQuantidade());
	//	BigDecimal calcAtualMetabolismoBasalConvet = new BigDecimal(calcAtualMetabolismoBasal).setScale(2, RoundingMode.HALF_EVEN);
		
	//	getAtendimentoAdulto().getDieta().setMetabolismoBasalDieta(calcAtualMetabolismoBasalConvet.doubleValue());
	
		if(quantidadePorcaoAtual.getPorcao().getAlimentoTabela() instanceof AlimentoTaco) {
			AlimentoTaco t = new AlimentoTaco();
			t = alimentoTacoService.obtemPorId(quantidadePorcaoAtual.getPorcao().getAlimentoTabela().getId());
			AlimentoTaco tacoProvisorio = new AlimentoTaco();
			
			tacoProvisorio.setNome(t.getNome());
			tacoProvisorio.setKcal(t.getKcal() * quantidadePorcaoAtual.getPorcao().getQuantidade() / t.getQuantidade());
			tacoProvisorio.setProteina(t.getProteina() * quantidadePorcaoAtual.getPorcao().getQuantidade()/ t.getQuantidade());
			tacoProvisorio.setLipideos(t.getLipideos() * quantidadePorcaoAtual.getPorcao().getQuantidade()/ t.getQuantidade());
			tacoProvisorio.setCalcio(t.getCalcio() * quantidadePorcaoAtual.getPorcao().getQuantidade()/ t.getQuantidade());
			tacoProvisorio.setFerro(t.getFerro() * quantidadePorcaoAtual.getPorcao().getQuantidade()/ t.getQuantidade());
			tacoProvisorio.setVitaminaC(t.getVitaminaC() * quantidadePorcaoAtual.getPorcao().getQuantidade()/ t.getQuantidade());
			tacoProvisorio.setUmidade(t.getUmidade() * quantidadePorcaoAtual.getPorcao().getQuantidade()/ t.getQuantidade());
			tacoProvisorio.setKj(t.getKj() * quantidadePorcaoAtual.getPorcao().getQuantidade()/ t.getQuantidade());
			tacoProvisorio.setColesterol(t.getColesterol() * quantidadePorcaoAtual.getPorcao().getQuantidade()/ t.getQuantidade());
			tacoProvisorio.setCarboidrato(t.getCarboidrato() * quantidadePorcaoAtual.getPorcao().getQuantidade()/ t.getQuantidade());
			tacoProvisorio.setFibraAlimentar(t.getFibraAlimentar() * quantidadePorcaoAtual.getPorcao().getQuantidade()/ t.getQuantidade());
			tacoProvisorio.setCinzas(t.getCinzas() * quantidadePorcaoAtual.getPorcao().getQuantidade()/ t.getQuantidade());
			tacoProvisorio.setMagnesio(t.getMagnesio() * quantidadePorcaoAtual.getPorcao().getQuantidade()/ t.getQuantidade());
			tacoProvisorio.setManganes(t.getManganes() * quantidadePorcaoAtual.getPorcao().getQuantidade()/ t.getQuantidade());
			tacoProvisorio.setFosforo(t.getFosforo() * quantidadePorcaoAtual.getPorcao().getQuantidade()/ t.getQuantidade());
			tacoProvisorio.setSodio(t.getSodio() * quantidadePorcaoAtual.getPorcao().getQuantidade()/ t.getQuantidade());
			tacoProvisorio.setPotassio(t.getPotassio() * quantidadePorcaoAtual.getPorcao().getQuantidade()/ t.getQuantidade());
			tacoProvisorio.setCobre(t.getCobre() * quantidadePorcaoAtual.getPorcao().getQuantidade()/ t.getQuantidade());
			tacoProvisorio.setZinco(t.getZinco() * quantidadePorcaoAtual.getPorcao().getQuantidade()/ t.getQuantidade());
			tacoProvisorio.setRetinol(t.getRetinol() * quantidadePorcaoAtual.getPorcao().getQuantidade()/ t.getQuantidade());
			tacoProvisorio.setRe(t.getRe() * quantidadePorcaoAtual.getPorcao().getQuantidade()/ t.getQuantidade());
			tacoProvisorio.setRea(t.getRea() * quantidadePorcaoAtual.getPorcao().getQuantidade()/ t.getQuantidade());
			tacoProvisorio.setTiamina(t.getTiamina() * quantidadePorcaoAtual.getPorcao().getQuantidade()/ t.getQuantidade());
			tacoProvisorio.setRiboflavina(t.getRiboflavina() * quantidadePorcaoAtual.getPorcao().getQuantidade()/ t.getQuantidade());
			tacoProvisorio.setPiridoxina(t.getPiridoxina() * quantidadePorcaoAtual.getPorcao().getQuantidade()/ t.getQuantidade());
			tacoProvisorio.setNiacina(t.getNiacina() * quantidadePorcaoAtual.getPorcao().getQuantidade()/ t.getQuantidade());
			
			
			
			alimentoProvisorio = tacoProvisorio;
		
					
		}else {
			AlimentoMedidasCaseiras mc = new AlimentoMedidasCaseiras();
			mc = alimentoMedidasCaseirasService.obtemPorId(quantidadePorcaoAtual.getPorcao().getAlimentoTabela().getId());
			AlimentoMedidasCaseiras medidasCaseirasProvisorio = new AlimentoMedidasCaseiras();	
			
			
			medidasCaseirasProvisorio.setNome(mc.getNome());
			medidasCaseirasProvisorio.setKcal(mc.getKcal() * quantidadePorcaoAtual.getPorcao().getQuantidade() / mc.getQuantidade());
			medidasCaseirasProvisorio.setProteina(mc.getProteina() * quantidadePorcaoAtual.getPorcao().getQuantidade()/ mc.getQuantidade());
			medidasCaseirasProvisorio.setLipideos(mc.getLipideos() * quantidadePorcaoAtual.getPorcao().getQuantidade()/ mc.getQuantidade());
			medidasCaseirasProvisorio.setCalcio(mc.getCalcio() * quantidadePorcaoAtual.getPorcao().getQuantidade()/ mc.getQuantidade());
			medidasCaseirasProvisorio.setFerro(mc.getFerro() * quantidadePorcaoAtual.getPorcao().getQuantidade()/ mc.getQuantidade());
			medidasCaseirasProvisorio.setVitaminaC(mc.getVitaminaC() * quantidadePorcaoAtual.getPorcao().getQuantidade()/ mc.getQuantidade());
			medidasCaseirasProvisorio.setGli(mc.getGli() * quantidadePorcaoAtual.getPorcao().getQuantidade()/ mc.getQuantidade());
			medidasCaseirasProvisorio.setVitaminaA(mc.getVitaminaA() * quantidadePorcaoAtual.getPorcao().getQuantidade()/ mc.getQuantidade());
			
			alimentoProvisorio = medidasCaseirasProvisorio;
			
						
			
		}
		
		
		
		
		
		
		
	calcProteinaAtual = calcProteinaAtual - (alimentoProvisorio.getProteina() * quantidadePorcaoAtual.getQuantidade());	
	BigDecimal calcProteinaAtualConvertido = new BigDecimal(calcProteinaAtual).setScale(2, RoundingMode.HALF_EVEN);
	getAtendimentoAdulto().getDieta().setProteinaRestante(calcProteinaAtualConvertido.doubleValue());
			
	calcCarboidratoAtual = calcCarboidratoAtual - (alimentoProvisorio.getKcal() * quantidadePorcaoAtual.getQuantidade());	
	BigDecimal calcCarboidratoAtualConvertido = new BigDecimal(calcCarboidratoAtual).setScale(2, RoundingMode.HALF_EVEN);
	getAtendimentoAdulto().getDieta().setCarboidratoRestante(calcCarboidratoAtualConvertido.doubleValue());
	
	calcLipidioAtual = calcLipidioAtual - (alimentoProvisorio.getLipideos() * quantidadePorcaoAtual.getQuantidade());	
	BigDecimal calcLipidioAtualConvertido = new BigDecimal(calcLipidioAtual).setScale(2, RoundingMode.HALF_EVEN);
	getAtendimentoAdulto().getDieta().setLipidioRestante(calcLipidioAtualConvertido.doubleValue());
	
	
	
	
	
	}
	
	
	public void alimentoRegraDeTrez() {
		
		QuantidadePorcao quantidadePorcaoAtual = new QuantidadePorcao();
		quantidadePorcaoAtual.setQuantidade(getQuantidadePorcaoAtual());
		quantidadePorcaoAtual.setPorcao(porcaoService.obtemPorId(porcaoId));
		
		
		if(quantidadePorcaoAtual.getPorcao().getAlimentoTabela() instanceof AlimentoTaco) {
			AlimentoTaco t = new AlimentoTaco();
			t = alimentoTacoService.obtemPorId(quantidadePorcaoAtual.getPorcao().getAlimentoTabela().getId());
			AlimentoTaco tacoProvisorio = new AlimentoTaco();
			
			tacoProvisorio.setNome(t.getNome());
			tacoProvisorio.setKcal(t.getKcal() * quantidadePorcaoAtual.getPorcao().getQuantidade() / t.getQuantidade());
			tacoProvisorio.setProteina(t.getProteina() * quantidadePorcaoAtual.getPorcao().getQuantidade()/ t.getQuantidade());
			tacoProvisorio.setLipideos(t.getLipideos() * quantidadePorcaoAtual.getPorcao().getQuantidade()/ t.getQuantidade());
			tacoProvisorio.setCalcio(t.getCalcio() * quantidadePorcaoAtual.getPorcao().getQuantidade()/ t.getQuantidade());
			tacoProvisorio.setFerro(t.getFerro() * quantidadePorcaoAtual.getPorcao().getQuantidade()/ t.getQuantidade());
			tacoProvisorio.setVitaminaC(t.getVitaminaC() * quantidadePorcaoAtual.getPorcao().getQuantidade()/ t.getQuantidade());
			tacoProvisorio.setUmidade(t.getUmidade() * quantidadePorcaoAtual.getPorcao().getQuantidade()/ t.getQuantidade());
			tacoProvisorio.setKj(t.getKj() * quantidadePorcaoAtual.getPorcao().getQuantidade()/ t.getQuantidade());
			tacoProvisorio.setColesterol(t.getColesterol() * quantidadePorcaoAtual.getPorcao().getQuantidade()/ t.getQuantidade());
			tacoProvisorio.setCarboidrato(t.getCarboidrato() * quantidadePorcaoAtual.getPorcao().getQuantidade()/ t.getQuantidade());
			tacoProvisorio.setFibraAlimentar(t.getFibraAlimentar() * quantidadePorcaoAtual.getPorcao().getQuantidade()/ t.getQuantidade());
			tacoProvisorio.setCinzas(t.getCinzas() * quantidadePorcaoAtual.getPorcao().getQuantidade()/ t.getQuantidade());
			tacoProvisorio.setMagnesio(t.getMagnesio() * quantidadePorcaoAtual.getPorcao().getQuantidade()/ t.getQuantidade());
			tacoProvisorio.setManganes(t.getManganes() * quantidadePorcaoAtual.getPorcao().getQuantidade()/ t.getQuantidade());
			tacoProvisorio.setFosforo(t.getFosforo() * quantidadePorcaoAtual.getPorcao().getQuantidade()/ t.getQuantidade());
			tacoProvisorio.setSodio(t.getSodio() * quantidadePorcaoAtual.getPorcao().getQuantidade()/ t.getQuantidade());
			tacoProvisorio.setPotassio(t.getPotassio() * quantidadePorcaoAtual.getPorcao().getQuantidade()/ t.getQuantidade());
			tacoProvisorio.setCobre(t.getCobre() * quantidadePorcaoAtual.getPorcao().getQuantidade()/ t.getQuantidade());
			tacoProvisorio.setZinco(t.getZinco() * quantidadePorcaoAtual.getPorcao().getQuantidade()/ t.getQuantidade());
			tacoProvisorio.setRetinol(t.getRetinol() * quantidadePorcaoAtual.getPorcao().getQuantidade()/ t.getQuantidade());
			tacoProvisorio.setRe(t.getRe() * quantidadePorcaoAtual.getPorcao().getQuantidade()/ t.getQuantidade());
			tacoProvisorio.setRea(t.getRea() * quantidadePorcaoAtual.getPorcao().getQuantidade()/ t.getQuantidade());
			tacoProvisorio.setTiamina(t.getTiamina() * quantidadePorcaoAtual.getPorcao().getQuantidade()/ t.getQuantidade());
			tacoProvisorio.setRiboflavina(t.getRiboflavina() * quantidadePorcaoAtual.getPorcao().getQuantidade()/ t.getQuantidade());
			tacoProvisorio.setPiridoxina(t.getPiridoxina() * quantidadePorcaoAtual.getPorcao().getQuantidade()/ t.getQuantidade());
			tacoProvisorio.setNiacina(t.getNiacina() * quantidadePorcaoAtual.getPorcao().getQuantidade()/ t.getQuantidade());
			
			
			
			tacoConvertido = tacoProvisorio;
			RequestContext.getCurrentInstance().execute("PF('dialogVerTacoConvertido').show();");
		
		
		}else {
			AlimentoMedidasCaseiras mc = new AlimentoMedidasCaseiras();
			mc = alimentoMedidasCaseirasService.obtemPorId(quantidadePorcaoAtual.getPorcao().getAlimentoTabela().getId());
			AlimentoMedidasCaseiras medidasCaseirasProvisorio = new AlimentoMedidasCaseiras();	
			
			
			medidasCaseirasProvisorio.setNome(mc.getNome());
			medidasCaseirasProvisorio.setKcal(mc.getKcal() * quantidadePorcaoAtual.getPorcao().getQuantidade() / mc.getQuantidade());
			medidasCaseirasProvisorio.setProteina(mc.getProteina() * quantidadePorcaoAtual.getPorcao().getQuantidade()/ mc.getQuantidade());
			medidasCaseirasProvisorio.setLipideos(mc.getLipideos() * quantidadePorcaoAtual.getPorcao().getQuantidade()/ mc.getQuantidade());
			medidasCaseirasProvisorio.setCalcio(mc.getCalcio() * quantidadePorcaoAtual.getPorcao().getQuantidade()/ mc.getQuantidade());
			medidasCaseirasProvisorio.setFerro(mc.getFerro() * quantidadePorcaoAtual.getPorcao().getQuantidade()/ mc.getQuantidade());
			medidasCaseirasProvisorio.setVitaminaC(mc.getVitaminaC() * quantidadePorcaoAtual.getPorcao().getQuantidade()/ mc.getQuantidade());
			medidasCaseirasProvisorio.setGli(mc.getGli() * quantidadePorcaoAtual.getPorcao().getQuantidade()/ mc.getQuantidade());
			medidasCaseirasProvisorio.setVitaminaA(mc.getVitaminaA() * quantidadePorcaoAtual.getPorcao().getQuantidade()/ mc.getQuantidade());
			
			medidasConvertido = medidasCaseirasProvisorio;
			RequestContext.getCurrentInstance().execute("PF('dialogVerMedidasConvertido').show();");
			
			
		}
				
	}
	
	
	
	public void removerPorcao(Porcao porcaoAtual) {
		
		
		
	}
	
	public void adicionarRefeicao() {
		getDietaRefeicaoAtual().setQuantidadePorcoes(getPorcoesQuantidadeAtuais());
		getAtendimentoAdulto().getDieta().getDietasRefeicoes().add(getDietaRefeicaoAtual());
		setPorcoesQuantidadeAtuais(new ArrayList<QuantidadePorcao>());
		setDietaRefeicaoAtual(new DietaRefeicao());
	}
	
	
	
}







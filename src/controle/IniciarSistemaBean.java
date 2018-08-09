package controle;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;

import modelo.AlimentoMedidasCaseiras;
import modelo.AlimentoTaco;
import modelo.Porcao;
import modelo.Usuario;
import service.AlimentoMedidasCaseirasService;
import service.AlimentoTacoService;
import service.PorcaoService;
import service.UsuarioService;

@ViewScoped
@ManagedBean
public class IniciarSistemaBean {
	
	
	@EJB
	UsuarioService usuarioService;
	@EJB
	AlimentoTacoService tacoService;
	@EJB
	AlimentoMedidasCaseirasService caseirasService;
	@EJB
	PorcaoService porcaoService;
	
	Usuario usuario = new Usuario();
	AlimentoTaco taco = new AlimentoTaco();
	AlimentoMedidasCaseiras medidasCaseiras = new AlimentoMedidasCaseiras();
	Porcao porcao = new Porcao();
	
	Boolean iniciado = Boolean.FALSE;
	
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public AlimentoTaco getTaco() {
		return taco;
	}

	public void setTaco(AlimentoTaco taco) {
		this.taco = taco;
	}

	
	public AlimentoMedidasCaseiras getMedidasCaseiras() {
		return medidasCaseiras;
	}

	public void setMedidasCaseiras(AlimentoMedidasCaseiras medidasCaseiras) {
		this.medidasCaseiras = medidasCaseiras;
	}

	public Porcao getPorcao() {
		return porcao;
	}

	public void setPorcao(Porcao porcao) {
		this.porcao = porcao;
	}
	
	public Boolean getIniciado() {
		return iniciado;
	}

	public void setIniciado(Boolean iniciado) {
		this.iniciado = iniciado;
	}

	public void iniciar() {

		
		if (!iniciado) {
			
			iniciarUsuario();	
			iniciarTaco();
			//iniciarMedidasCaseiras();
		
			setIniciado(Boolean.TRUE);
			
				
		FacesContext.getCurrentInstance().addMessage("menssagem", new FacesMessage("Mensagem!", "Sistema Configurado com Sucesso."));
		
		RequestContext.getCurrentInstance().execute("$('.iniciarSistema').attr('disabled', true)");
		
		}else {
		
			FacesContext.getCurrentInstance().addMessage("menssagem", new FacesMessage("Atenção!", "O Sistema ja foi iniciado. Entre com seu login e senha."));
			
		}
			
	}
	
	public void iniciarUsuario() {
		
		usuario.setNome("Administrador");
		usuario.setLogin("admin");
		usuario.setSenha("admin");
		usuarioService.create(usuario);
		
	}
	
	
	public void iniciarTaco() {
		
		taco.setNome("Arroz, Interal, cozido");
		taco.setQuantidade(100D);
		taco.setUmidade(70.1D);
		taco.setKcal(124D);
		taco.setKj(571D);
		taco.setProteina(2.6D);
		taco.setLipideos(1D);
		taco.setColesterol(0D);
		taco.setCarboidrato(25.8D);
		taco.setFibraAlimentar(2.7);
		taco.setCinzas(0.5D);
		taco.setCalcio(5D);
		taco.setMagnesio(59D);
		taco.setManganes(0.63D);
		taco.setFosforo(106D);
		taco.setFerro(0.3D);
		taco.setSodio(1D);
		taco.setPotassio(75D);
		taco.setCobre(0.02D);
		taco.setZinco(0.7D);
		taco.setRetinol(0D);
		taco.setRe(0D);
		taco.setRea(0D);
		taco.setTiamina(0.08D);
		taco.setRiboflavina(0D);
		taco.setPiridoxina(0.08D);
		taco.setNiacina(0D);
		taco.setVitaminaC(0D);
		tacoService.create(taco);
		
		porcao.setDescricao("Porção");
		porcao.setQuantidade(100D);
		porcao.setAlimentoTabela(taco);
		porcaoService.merge(porcao);
				
		
	}
	
	public void iniciarMedidasCaseiras() {
		
		medidasCaseiras.setNome("Abacaxi");
		medidasCaseiras.setQuantidade(100D);
		medidasCaseiras.setKcal(177D);
		medidasCaseiras.setProteina(1.8D);
		medidasCaseiras.setGli(6.4D);
		medidasCaseiras.setLipideos(16D);
		medidasCaseiras.setCalcio(13D);
		medidasCaseiras.setFerro(0.70D);
		medidasCaseiras.setVitaminaC(12D);
		medidasCaseiras.setVitaminaA(20D);
		caseirasService.merge(medidasCaseiras);
		
		medidasCaseiras.setNome("Acelga");
		medidasCaseiras.setQuantidade(100D);
		medidasCaseiras.setKcal(33D);
		medidasCaseiras.setProteina(1.8D);
		medidasCaseiras.setGli(5.6D);
		medidasCaseiras.setLipideos(0.40D);
		medidasCaseiras.setCalcio(110D);
		medidasCaseiras.setFerro(3.6D);
		medidasCaseiras.setVitaminaC(3.4D);
		medidasCaseiras.setVitaminaA(292D);
		caseirasService.create(medidasCaseiras);

				
				
		
		
	}
	
	

}

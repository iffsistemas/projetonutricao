package controle;

import java.io.IOException;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

 
@ViewScoped
@ManagedBean
public class UsuarioBean {

	
		
	
	private String login;
	private String senha;
	private String confirmarSenha;
	private Boolean achouParticipante = Boolean.FALSE;
	
	
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getConfirmarSenha() {
		return confirmarSenha;
	}

	public void setConfirmarSenha(String confirmarSenha) {
		this.confirmarSenha = confirmarSenha;
	}
	
	
	public Boolean getAchouParticipante() {
		return achouParticipante;
	}

	public void setAchouParticipante(Boolean achouParticipante) {
		this.achouParticipante = achouParticipante;
	}

	
	
	
	
	
	public void validarLoginESenha() throws IOException {
		
		if (login.equals("admin") && (senha.equals("admin"))) {
				setAchouParticipante(Boolean.TRUE);
			
		}
		
		/*else {
			
			for (Participante p: participantes) {
			
			if(login.equals(p.getNome()) && senha.equals(p.getSenha())) {
				
				setAchouParticipante(Boolean.TRUE);
			}
			
			}
		}	
			*/
			
		if(!getAchouParticipante()) {
			
				FacesContext.getCurrentInstance().addMessage("menssagem", new FacesMessage("ERRO!!", "Usuario e/ou Senha incorretos"));
			 				
			}else {
				
				FacesContext.getCurrentInstance().getExternalContext().redirect("paciente.xhtml");
			
			}
			
			
	
		
		
		
		
		
		
		
	}
	
}

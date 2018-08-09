package controle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import modelo.Usuario;
import service.UsuarioService;

 
@ViewScoped
@ManagedBean
public class UsuarioBean {
	
	@EJB
	UsuarioService usuarioService;
	
	
	private Usuario usuario = new Usuario();
	List<Usuario> usuarios = new ArrayList<Usuario>();
	
	private String login;
	private String senha;
	private String confirmarSenha;
	private Boolean achouUsuario = Boolean.FALSE;
	
	

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

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

	
	public Boolean getAchouUsuario() {
		return achouUsuario;
	}

	public void setAchouUsuario(Boolean achouUsuario) {
		this.achouUsuario = achouUsuario;
	}

	@PostConstruct
	public void init(){
		atualizarUsuarios();
	}
	
	protected void atualizarUsuarios(){
		getUsuarios().clear();
		getUsuarios().addAll(usuarioService.listAll());
	}
	
	
public void salvarUsuario() {
			String msg;
		
			if(usuario.getSenha().equals(confirmarSenha)) {
			
			if(getUsuario().getId()==null){ 
				
				usuarioService.create(usuario);
				msg="Usuário cadastrado com sucesso";
					
				
			}else {
				usuarioService.merge(usuario);
				 msg="Usuário atualizado com sucesso";	
				
			}
			
			FacesContext.getCurrentInstance().addMessage("menssagem", new FacesMessage("Parabéns!", msg));
			setUsuario(new Usuario());
			atualizarUsuarios();
			
			}else {
				
				FacesContext.getCurrentInstance().addMessage("menssagem", new FacesMessage("Atenção!", "Senhas não coincidem."));
				
			}
		
}
		
		

	public void editarUsuario(Usuario usuarioAtual) {
		setUsuario(usuarioAtual);
		 
	}


	
	public void removerUsuario(Usuario usuarioAtual) {
		
		String msg="Usuário exluído com sucesso";
	 		
		usuarioService.remove(usuarioAtual);
					atualizarUsuarios();
					FacesContext.getCurrentInstance().addMessage("menssagem", new FacesMessage("Parabéns!", msg));
			
		
		
	}
	
	public void validarLoginESenha() throws IOException {
		
		
							
			for (Usuario u: usuarios) {
			
			if(login.equals(u.getLogin()) && senha.equals(u.getSenha())) {
				
				setAchouUsuario(Boolean.TRUE);
			}else {
				
				setAchouUsuario(Boolean.FALSE);
			
			}
		}	
			
			if(!getAchouUsuario()) {
			
				FacesContext.getCurrentInstance().addMessage("menssagem", new FacesMessage("ERRO!!", "Usuario e/ou Senha incorretos"));
			 				
			}else {
				
				FacesContext.getCurrentInstance().getExternalContext().redirect("paciente.xhtml");
			
			}
			
	
	}
	
}

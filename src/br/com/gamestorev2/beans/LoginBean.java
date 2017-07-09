package br.com.gamestorev2.beans;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.com.gamestorev2.entidades.Administrador;
import br.com.gamestorev2.entidades.Usuario;
import br.com.gamestorev2.repository.AdministradorRepository;
import br.com.gamestorev2.repository.UsuarioRepository;



@ManagedBean
@SessionScoped
public class LoginBean{

private Administrador admin;
private Usuario usuario;
private String login;
private String senha;

public String getLogin() {
	return login;
}

public String getSenha() {
	return senha;
}

public void setSenha(String senha) {
	this.senha = senha;
}

public void setLogin(String login) {
	this.login = login;
}

public Usuario getUsuario() {
	return usuario;
}

private void setUsuario(Usuario usuario) {
	this.usuario = usuario;
}


public Administrador getAdmin() {
	return admin;
}

public void setAdmin(Administrador admin) {
	this.admin = admin;
}



public String logar(){
	
	Usuario usuarioLogado = UsuarioRepository.getByLoginSenha(getLogin(), getSenha());
	
		if(usuarioLogado == null){
			String messageSumary = "Login ou senha inválidos";
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, messageSumary, "");
			FacesContext.getCurrentInstance().addMessage(null, message);
			System.out.println(messageSumary + " - " + login + " - " + senha);
			setSenha("");
			return "/index";		
		}
		
	if(usuarioLogado.isAdmin()){	
		setUsuario(usuarioLogado);
		System.out.println("Login autorizado para: " + getUsuario());
		return "/admin/index?faces-redirect=true";
	}else{
		setUsuario(usuarioLogado);
		System.out.println("Login autorizado para: " + getUsuario());
		return "/index.jsf";
	}

}

public String deslogar(){
	setUsuario(null);
	return "index.jsf";
	
}


}
package br.com.gamestorev2.beans;

import br.com.gamestorev2.entidades.Usuario;

public class UsuarioBean {

	private Usuario usuario;
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public UsuarioBean(){
		usuario = new Usuario();
	}
	
}

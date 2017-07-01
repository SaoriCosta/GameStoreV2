package br.com.gamestorev2.beans;

import br.com.gamestorev2.entidades.Administrador;

public class AdministradorBean {
	
	private Administrador administrador;
	
	public Administrador getAdministrador() {
		return administrador;
	}

	public void setAdministrador(Administrador administrador) {
		this.administrador = administrador;
	}

	public AdministradorBean(){
		
		administrador = new Administrador();
	}
}

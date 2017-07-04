package br.com.gamestorev2.beans;

import java.util.List;

import br.com.gamestorev2.entidades.Usuario;
import br.com.gamestorev2.repository.UsuarioRepository;

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
	
	public String salvar(){
		if(UsuarioRepository.getByLogin(usuario.getEmail())==null){
			UsuarioRepository.setUsuario(usuario);
			setUsuario(new Usuario());
			return "/index.jsf";
		}
		
		UsuarioRepository.update(getUsuario());
		setUsuario(new Usuario());
		return "/index.jsf";
		
	}
	
	public List<Usuario> getUsuarios(){
		return UsuarioRepository.getUsuarios();
	}
	
	public Usuario getUsuarioByLogin(String email){
		return UsuarioRepository.getByLogin(email);
	}
	
	public Usuario getUsuarioByLoginSenha(Usuario user){
		return UsuarioRepository.getByLoginSenha(user.getEmail(), user.getSenha());	
	}
	
}

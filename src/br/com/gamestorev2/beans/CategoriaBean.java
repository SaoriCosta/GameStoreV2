package br.com.gamestorev2.beans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.gamestorev2.entidades.Categoria;
import br.com.gamestorev2.repository.CategoriaRepository;

@ManagedBean
@ViewScoped
public class CategoriaBean {
	
	private Categoria categoria;
	
	
	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public CategoriaBean(){
	
		categoria = new Categoria();
	
	}
	
	public String salvar(){
		if(CategoriaRepository.getCategoriaByName(categoria.getNome())==null){
			CategoriaRepository.setCategoria(categoria);
			setCategoria(new Categoria());
			System.out.println("deu certo");
			return "/admin/index.jsf";
		}
		System.out.println("deu pau");
		return "/categoria.jsf";
		
	}

	public List<Categoria> getCategorias(){
		return CategoriaRepository.getCategorias();
	}
	
}

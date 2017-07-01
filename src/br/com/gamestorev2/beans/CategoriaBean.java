package br.com.gamestorev2.beans;

import br.com.gamestorev2.entidades.Categoria;

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

}

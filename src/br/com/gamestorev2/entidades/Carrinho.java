package br.com.gamestorev2.entidades;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


@Entity
public class Carrinho {

	@Id
	@GeneratedValue
	private int id;
	@ManyToMany(fetch = FetchType.EAGER,cascade= {
			
			CascadeType.DETACH,
			CascadeType.REFRESH
	})
	private List<Produto> produto;
	private double preco_acumulado;
	@OneToOne
	private Usuario usuario;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public List<Produto> getProduto() {
		return produto;
	}
	public void setProduto(List<Produto> produto) {
		this.produto = produto;
	}
	public double getPreco_acumulado() {
		return preco_acumulado;
	}
	public void setPreco_acumulado(double preco_acumulado) {
		this.preco_acumulado = preco_acumulado;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}

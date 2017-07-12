package br.com.gamestorev2.entidades;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;



@Entity
public class Venda {
	
	@Id
	@GeneratedValue
	private int id;
	private Date data;
	@ManyToMany(fetch = FetchType.EAGER,cascade = {
			CascadeType.DETACH,
			CascadeType.REFRESH
			
	})
	private List<Produto> produtos;
	private double codigo;
	private double preco_total;
	@OneToOne
	private Usuario usuario;
	
	
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public List<Produto> getProdutos() {
		return produtos;
	}
	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
	public double getCodigo() {
		return codigo;
	}
	public void setCodigo(double codigo) {
		this.codigo = codigo;
	}
	public double getPreco_total() {
		return preco_total;
	}
	public void setPreco_total(double preco_total) {
		this.preco_total = preco_total;
	}

}

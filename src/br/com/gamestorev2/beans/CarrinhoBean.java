package br.com.gamestorev2.beans;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.gamestorev2.entidades.Carrinho;
import br.com.gamestorev2.entidades.Produto;
import br.com.gamestorev2.entidades.Usuario;
import br.com.gamestorev2.repository.CarrinhoRepository;

@ManagedBean
@ViewScoped
public class CarrinhoBean {

		private Carrinho carrinho;
		@ManagedProperty("#{loginBean.usuario}")
		private Usuario user;
		@ManagedProperty("#{produtoBean.produto}")
		private Produto produto;
		
		public Usuario aux = new Usuario();
		@PostConstruct
		private void init(){
			carrinho = new Carrinho();
			carrinho.setUsuario(user);
			List<Produto> car = new ArrayList<>();
			car.add(produto);
			carrinho.setProduto(car);
		}
		public Produto getProduto() {
			return produto;
		}

		public void setProduto(Produto produto) {
			this.produto = produto;
		}

		public Carrinho getCarrinho() {
			return carrinho;
		}

		public void setCarrinho(Carrinho carrinho) {
			this.carrinho = carrinho;
		}

		public CarrinhoBean(){
			carrinho = new Carrinho();
		}
		public String salvar(Produto produto){
			
			if(CarrinhoRepository.getCarByUser(user)==null){
				carrinho.getProduto().add(produto);;
				CarrinhoRepository.setCarrinho(carrinho);
				setCarrinho(new Carrinho());
				return "/index.jsf";
			}
			carrinho = CarrinhoRepository.getCarByUser(user);
			carrinho.getProduto().add(produto);
			CarrinhoRepository.setCarrinho(carrinho);
			return "/admin/index.jsf";
		}
		
		public Carrinho getcartUser(){
			Carrinho aux = CarrinhoRepository.getCarByUser(user);
			if(aux==null){
				return carrinho;
			}
			return aux;
			
		}
		
		private Carrinho getcartUser2(Usuario user){
			Carrinho aux = CarrinhoRepository.getCarByUser(user);
			if(aux==null){
				return carrinho;
			}
			return aux;
			
		}
		
		public String setUseraux(Usuario user){
			this.aux = user;
			System.out.println("---------"+this.aux.getNome());
			return "";
		}
		
		public Carrinho getCart(){
			return getcartUser2(aux);
		}
		
		public int getcartSize(){
			Carrinho aux = CarrinhoRepository.getCarByUser(user);
			if(aux==null){
				return 0;
			}
			return aux.getProduto().size();
			
		}
		
		public Usuario getUser() {
			return user;
		}

		public void setUser(Usuario user) {
			this.user = user;
		}
		
		
		
}


package br.com.gamestorev2.beans;

import br.com.gamestorev2.entidades.Carrinho;

public class CarrinhoBean {

		private Carrinho carrinho;
		
		public Carrinho getCarrinho() {
			return carrinho;
		}

		public void setCarrinho(Carrinho carrinho) {
			this.carrinho = carrinho;
		}

		public CarrinhoBean(){
			carrinho = new Carrinho();
		}
		
}


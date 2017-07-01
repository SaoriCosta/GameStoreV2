package br.com.gamestorev2.beans;

import br.com.gamestorev2.entidades.Venda;

public class VendaBean {
	
	private Venda venda;
	
	public Venda getVenda() {
		return venda;
	}

	public void setVenda(Venda venda) {
		this.venda = venda;
	}

	public VendaBean(){
		
		venda = new Venda();
		
	}
	

}

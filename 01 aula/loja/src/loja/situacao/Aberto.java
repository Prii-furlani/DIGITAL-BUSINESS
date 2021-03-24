package loja.situacao;

import loja.Pedido;

public class Aberto extends Situacao {

	@Override
	public void abrirChamado() {
		System.out.println("chamado para financeiro");
	}

	@Override
	public void pagar(Pedido pedido) {
		pedido.setSituacao(new Pago());
	}

	@Override
	public void cancelar(Pedido pedido) {
		pedido.setSituacao(new Cancelado());
	}
	
	

}

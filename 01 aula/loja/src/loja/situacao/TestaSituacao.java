package loja.situacao;

import java.math.BigDecimal;

import loja.EmailListener;
import loja.LogListener;
import loja.Pedido;

public class TestaSituacao {
	
	public static void main(String[] args) {
		Pedido pedido = new Pedido(new BigDecimal("100"));
		pedido.handler.subscribe(new EmailListener());
		pedido.handler.subscribe(new LogListener());
		
		pedido.pagar();
		pedido.entregar();
		pedido.abrirChamado();
	}

}

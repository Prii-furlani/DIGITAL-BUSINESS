package loja;

import java.math.BigDecimal;

import loja.situacao.Aberto;
import loja.situacao.Situacao;

public class Pedido {
	private BigDecimal valor;
	private int totalDeItens;
	private Situacao situacao;
	public PedidoHandler handler;
	
	public void abrirChamado() {
		this.situacao.abrirChamado();	
	}

	public Pedido(BigDecimal valor) {
		this.valor = valor;
		this.totalDeItens = 1;
		this.situacao = new Aberto();
		this.handler = new PedidoHandler();
	}

	public Pedido(BigDecimal valor, int totalDeItens) {
		this.valor = valor;
		this.totalDeItens = totalDeItens;
		this.situacao = new Aberto();
		this.handler = new PedidoHandler();
	}

	public BigDecimal getValor() {
		return valor;
	}

	public int getTotalDeItens() {
		return totalDeItens;
	}

	public void setSituacao(Situacao situacao) {
		this.handler.notify(this);
		this.situacao = situacao;
	}
	
	public void pagar() {
		this.situacao.pagar(this);
	}
	
	public void entregar() {
		this.situacao.entregar(this);
	}
	
	public void cancelar() {
		this.situacao.cancelar(this);
	}
	
	public void reabrir() {
		this.situacao.reabrir(this);
	}
	
	
	
	
		
	
	
}

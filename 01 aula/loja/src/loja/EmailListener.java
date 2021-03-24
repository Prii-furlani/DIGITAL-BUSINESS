package loja;

public class EmailListener implements EventListener{

	@Override
	public void update(Pedido pedido) {
		System.out.println("Enviando email para o pedido " + pedido);
	}
	
}

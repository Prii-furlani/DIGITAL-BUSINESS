package loja;

public class LogListener implements EventListener{

	@Override
	public void update(Pedido pedido) {
		System.out.println("Gravando log do pedido " + pedido);
	}

}

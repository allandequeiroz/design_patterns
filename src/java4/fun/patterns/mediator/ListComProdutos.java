package java4.fun.patterns.mediator;

public class ListComProdutos {
	
	public String[] produtos = new String[]{"ma�a","chocolate","frutas"};
	
	public ListComProdutos(IMediator mediator) {
		mediator.registerListComProdutos(this);
	}
	
}

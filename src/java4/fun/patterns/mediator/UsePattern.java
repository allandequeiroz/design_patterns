package java4.fun.patterns.mediator;

/**
 * Exemplo de uso e teste do Pattern: Mediator 
 * 
 *
 */
public class UsePattern {
	
	
	public static void main(String[] args) {
		
		IMediator mediator = new Mediator();
		
		new ListComProdutos(mediator);
		new TextButtonEmpresa(mediator);
		new TextButtonVendedor(mediator);
		
		mediator.init();
		
	} 
	
}

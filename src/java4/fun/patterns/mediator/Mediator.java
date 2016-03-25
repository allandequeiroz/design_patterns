package java4.fun.patterns.mediator;

/**
 * Implementação do Pattern mediator.
 * 
 *
 */
public class Mediator implements IMediator {

	/* Objetos que o Mediator faz a mediação. */
	private TextButtonEmpresa textButtonEmpresa;
	private TextButtonVendedor textButtonVendedor;
	private ListComProdutos listComProdutos;
	
	private void limparTela(){
		
		System.out.println("Limpando o nome da Empresa!");
		textButtonEmpresa.nmEmpresa = "";
		
		
		System.out.println("Limpando o nome do vendedor");
		textButtonVendedor.nmVendedor = "";
		
		System.out.println("Limpando os produtos.");
		listComProdutos.produtos = new String[]{};
	}
	
	/* metodos que registram os objetos. */
	public void registerTextButtonEmpresa(TextButtonEmpresa arg0){
		textButtonEmpresa = arg0;
	}	
	public void registerTextButtonVendedor(TextButtonVendedor arg0){
		textButtonVendedor = arg0;
	}	
	public void registerListComProdutos(ListComProdutos arg0){
		listComProdutos = arg0;
	}
	
	public void init(){
		limparTela();
	}
	
}

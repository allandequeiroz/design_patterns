package java4.fun.patterns.mediator;

/**
 * Interface que garante no futuro se for necessario ter outra classe Mediator, assim poderemos ter
 * quantas implementa��es forem necessarias para a solu��o do problema. 
 * 
 *
 */
public interface IMediator {
	public void init();
	public void registerTextButtonEmpresa(TextButtonEmpresa arg0);
	public void registerTextButtonVendedor(TextButtonVendedor arg0);
	public void registerListComProdutos(ListComProdutos arg0);
}

package java4.fun.patterns.mediator;

public class TextButtonVendedor {
	public String nmVendedor = "Vendedox";
	
	public TextButtonVendedor(IMediator mediator) {
		mediator.registerTextButtonVendedor(this);
	}
	
}

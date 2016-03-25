package java4.fun.patterns.mediator;

public class TextButtonEmpresa {
	public String nmEmpresa = "Empresa X S.A";
	
	public TextButtonEmpresa(IMediator mediator) {
		mediator.registerTextButtonEmpresa(this);
	}
	
}

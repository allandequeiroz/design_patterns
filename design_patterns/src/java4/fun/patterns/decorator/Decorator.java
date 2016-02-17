package java4.fun.patterns.decorator;

/**
 * Classe base que prove as funcionalidades padroes e prove infra-estrutura para a aplicação dos Decorators.
 * 
 *
 */
public abstract class Decorator {
	
	protected Object resource = null;
	
	public Decorator(Object resource) {
		this.resource = resource;
	}
	
	public Object provideResource(){
		return resource;
	}
	public void setResource(Object resource){
		this.resource = resource;
	}
}

package java4.fun.patterns.decorator;

/**
 * Implementa��o do Pattern Decorator. Este pattern prove a possibilidade de mudar o comportamento de um objeto
 * sem mexer nele propriamente ou na classe que usa o objeto(Semelhante a uma decora��o que voc� troca). Esse pattern
 * � muito utilizado na api de java.io.* e tambem no conceito de classes Wrapper com Number.
 * 
 * 
 *
 */
public class BorderDecorator extends Decorator {
	
	public BorderDecorator(Object resource) {
		super(resource);	
	}
	
	public void setResource(Object resource) {
		this.resource = resource; 
	}
	
	public Object provideResource() {
	
		String res = "*******************************\n";
		res += resource + "\n"; 
		res += "*******************************\n";
		
		return res;
	}
}

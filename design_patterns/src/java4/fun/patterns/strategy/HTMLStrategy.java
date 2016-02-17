package java4.fun.patterns.strategy;

public class HTMLStrategy  extends AbstractStrategy {
	
	@Override
	public void save(Object resource) {
		System.out.println("Salvando em HTML:> " + resource);
	}
}

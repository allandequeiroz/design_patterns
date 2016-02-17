package java4.fun.patterns.strategy;

public class PDFStrategy  extends AbstractStrategy{
	
	public void save(Object resource) {	
		System.out.println("Salvando o objeto em PDF>: " + resource);
	}
	
}

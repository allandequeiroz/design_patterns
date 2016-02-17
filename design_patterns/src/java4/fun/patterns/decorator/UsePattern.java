package java4.fun.patterns.decorator;

/**
 * Classe de teste e exemplo de uso do Pattern Decorator.
 * 
 *
 */
public class UsePattern {
	
	public static void main(String[] args) {
		
		String value = new String("Teste");
		
		ConsolePrinter.print(new Decorator(value){});
		ConsolePrinter.print(new BorderDecorator(value));
		
	}
	
}

package java4.fun.patterns.strategy;

/**
 * Classe de testes e exemplo de uso do Pattern Strategy.
 * 
 *
 */
public class UsePattern {

	public static void main(String[] args) {
		
		Context context = new Context();
		
		context.setSavePDF();
		context.save(new String("Java é uma café!"));
		
		context.setSaveHTML();
		context.save(new String("Java é uma café!"));
		
	}
	
}

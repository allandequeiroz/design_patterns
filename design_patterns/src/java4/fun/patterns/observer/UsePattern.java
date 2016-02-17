package java4.fun.patterns.observer;

/**
 * Classe de teste e exemplo de uso do pattern Observer.
 * 
 *
 */
public class UsePattern {
	
	public static void main(String[] args) {

		/* RecursosHumanos criado com salario base de 100 */
		RecursosHumanosSubject rhs = new RecursosHumanosSubject(100);
		
		/* Interessados no aumento de salario! */
		rhs.registerInterest(new MercadoObserver());
		rhs.registerInterest(new FuncionariosObserver());
		rhs.registerInterest(new AcionistasObserver());
		
		/* Aplica o aumento de salario. */
		rhs.aplicaAumento(50);
		
	}
	
}

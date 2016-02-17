package java4.fun.patterns.memento;

/**
 * Classe de testes e exemplo de uso do pattern Memento.
 * 
 *
 */
public class UsePattern {

	public static void main(String[] args) {
		
		Ponto ponto = new Ponto(10,5);
		
		System.out.println("Valores originais");
		System.out.println("X: " + ponto.getX() + " Y: " + ponto.getY());
		
		
		ponto.setX(2);
		ponto.setY(3);
		System.out.println("Valores modificados");
		System.out.println("X: " + ponto.getX() + " Y: " + ponto.getY());
				
		
		System.out.println("Efetuado restore...");		
		
		ponto.restore();
		System.out.println("X: " + ponto.getX() + " Y: " + ponto.getY());
	}
	
}

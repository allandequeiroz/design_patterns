package java4.fun.patterns.facade;

/**
 * Classe de teste e exemplo de uso do Pattern Fa�ade.
 * 
 *
 */
public class UsePattern {

	public static void main(String[] args) {
		
		XicaraDeCafeFacadeImplementada xdci = new XicaraDeCafeFacadeImplementada();
		XicaraDeCafe xdc = xdci.xicaraDeCafe();
		System.out.println(xdc);
		
	}
	
}

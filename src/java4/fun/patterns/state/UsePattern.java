package java4.fun.patterns.state;

/**
 * Exemplo de uso e teste do pattern Sate.
 * 
 *
 */
public class UsePattern {

	public static void main(String[] args) {
		
		GerenteDoBar gerenteBar = new GerenteDoBar();
		
		System.out.println(gerenteBar.vender());
		System.out.println(gerenteBar.vender());
		System.out.println(gerenteBar.vender());
		
	}
	
}

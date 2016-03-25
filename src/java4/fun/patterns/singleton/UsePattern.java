package java4.fun.patterns.singleton;

/**
 * Classe de teste e uso do pattern Singleton
 * 
 *
 */
public class UsePattern {

	/**
	 * MainMethod
	 *  - 04/02/2007 
	 **/
	public static void main(String[] args) {

		try {

			System.out.println("Instancia 1: " + Singleton.getInstance());
			System.out.println("Instancia 2: " + Singleton.getInstance());
			System.out.println("Instancia 3: " + Singleton.getInstance());
			

		} catch (Throwable t) {
			t.printStackTrace();
		}
	}
	
}

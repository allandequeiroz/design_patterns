package java4.fun.patterns.factory;

/**
 * Classe de teste e exemplo de uso de Factory.
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

			Factory fac = new Factory();
			
			System.out.println(fac.buildPessoa(Factory.ROCK).getLocaleCountry());
			System.out.println(fac.buildPessoa(Factory.SAMBA).getLocaleCountry());			
			System.out.println(fac.buildPessoa(Factory.COUNTRY).getLocaleCountry());						
			
			System.out.println(fac.buildPessoa(Factory.ROCK));
			System.out.println(fac.buildPessoa(Factory.ROCK));
			
			System.out.println(fac.buildPessoa("URSS").getLocaleCountry());

		} catch (Throwable t) {
			t.printStackTrace();
		}
	}
	
}


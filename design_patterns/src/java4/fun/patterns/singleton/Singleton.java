package java4.fun.patterns.singleton;

/**
 * Pattern Singleton (aperfeiçoado com lazy int loading).<BR>
 * Garante uma unica instancia de um determinado objeto em memoria. <BR>
 * Esse Pattern poderia ser aplicado a um database connection por exemplo.
 * 
 * 
 *
 */
public class Singleton {

	private static class SingletonHoler{
		static Singleton singletonHolder = new Singleton();  
	}
	
	private Singleton(){};
	
	public static Singleton getInstance(){
		return SingletonHoler.singletonHolder;
	}	
}



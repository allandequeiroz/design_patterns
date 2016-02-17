package java4.fun.patterns.state;

/**
 * Classe abstrata que define oque um Bar deve ter. 
 * 
 *
 */
public abstract class Bar {
	public abstract Beer buyBeer() throws ThereIsNoBeerException;
}

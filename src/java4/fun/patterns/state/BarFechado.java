package java4.fun.patterns.state;

/**
 * Classe filha de Bar, que define o estado do Bar no caso: BarFechado.
 * .
 *
 */
public class BarFechado extends Bar {

	public Beer buyBeer() throws ThereIsNoBeerException {
		throw new ThereIsNoBeerException("Acabou a Cerveja!");
	}
	
}

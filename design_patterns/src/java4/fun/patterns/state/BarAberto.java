package java4.fun.patterns.state;

/**
 * Classe filha de Bar, que define o estado do Bar no caso: BarAberto.
 * .
 *
 */
public class BarAberto extends Bar {
	
	@Override
	public Beer buyBeer() {
		return new Beer("Polar");
	}
}

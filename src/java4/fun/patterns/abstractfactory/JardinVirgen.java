package java4.fun.patterns.abstractfactory;
/**
 * Factory de JardinVirgen
 *
 */
public class JardinVirgen extends Jardin {

	@Override
	public Planta getFlores() {
		return new Planta("tulipas");
	}
	
	@Override
	public Planta getGrama() {
		return new Planta("Grama rasteira");
	}
	
	@Override
	public Planta getVegetacoes() {
		return new Planta("Pequenas arvores");
	}	
}

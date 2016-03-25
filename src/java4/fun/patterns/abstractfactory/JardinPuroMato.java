package java4.fun.patterns.abstractfactory;

/**
 * Factory de JardinPuroMato
 *
 */
public class JardinPuroMato extends Jardin {

	@Override
	public Planta getFlores() {
		return new Planta("MATAGAL");
	}
	
	@Override
	public Planta getGrama() {
		return new Planta("GRAMA MATO-ALTO");
	}
	
	@Override
	public Planta getVegetacoes() {
		return new Planta("TREPADEIRAS");
	}

}

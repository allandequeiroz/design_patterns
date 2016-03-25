package java4.fun.patterns.abstractfactory;

/**
 * Factory de JardinSuspenso
 *
 */
public class JardinSuspenso extends Jardin {

	@Override
	public Planta getFlores() {
		return new Planta("Girasol");
	}
	
	@Override
	public Planta getGrama() {
		return new Planta("futibol");
	}
	
	@Override
	public Planta getVegetacoes() {
		return new Planta("sabana vegetacao");
	}

}

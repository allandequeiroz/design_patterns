package java4.fun.patterns.abstractfactory;

/**
 * Classe que representa uma Planta.
 *
 */
public class Planta {

	private String nome;

	public Planta() {}	
	
	public Planta(String nome) {
		super();
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}	
}

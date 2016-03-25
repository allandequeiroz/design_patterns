package java4.fun.patterns.templatemethod;

/**
 * Herança de Carro a classe CarroFamilia implenta um conportamento diferente
 * do padão, mas usa os metodos existem prorem acrece funcionalidade(comportamento) aos
 * metodos herdados de Carro.
 * 
 * 
 *
 */
public class CarroFamilia extends Carro {
	
	public CarroFamilia() {
		portas = 6;
	}
	
	public CarroFamilia(int portas, String freios, String model) {
		super(portas, freios, model);
		portas = 6;
	}	
	
	public void acelerar() {	
		velocidade += 2;
	}
	
	public void parar() {		
		System.out.println("Prando carro de " + portas + " portas" );		
		super.parar();
	}
	
}

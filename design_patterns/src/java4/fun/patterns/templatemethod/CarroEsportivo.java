package java4.fun.patterns.templatemethod;

/**
 * Heran�a de Carro a classe CarroEsportivo implenta um conportamento diferente
 * do pad�o, mas usa os metodos existem prorem acrece funcionalidade(comportamento) aos
 * metodos herdados de Carro.
 * 
 * 
 *
 */
public class CarroEsportivo extends Carro {
	
	public CarroEsportivo() {
		freios = "ABS";
		portas = 2;
	}
	
	public CarroEsportivo(int portas, String freios, String model) {
		super(portas, freios, model);
		freios = "ABS";
	}

	public void acelerar() {
		velocidade += 50; 
	}	
	

	public void parar() {
		
		System.out.println("Prando carro com freios: " + freios );		
		super.parar();
	}
	
}

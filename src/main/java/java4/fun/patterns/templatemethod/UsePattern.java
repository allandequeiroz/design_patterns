package java4.fun.patterns.templatemethod;

/**
 * Classe de teste e exemplo de uso do Pattern TemplateMethod.
 * 
 *
 */
public class UsePattern {

	public static void main(String[] args) {
		
		Carro ferrari = new CarroEsportivo();
		ferrari.model = "Ferari";

		ferrari.acelerar();
		ferrari.acelerar();
		ferrari.acelerar();
		
		System.out.println(ferrari + " " + ferrari.getVelocidade());
		
		ferrari.parar();
		
		
		Carro van = new CarroFamilia();
		van.model = "Van";
		
		van.acelerar();
		van.acelerar();
		van.acelerar();
		
		System.out.println(van + " " + van.getVelocidade());
		
		van.parar();
		
	}
	
}

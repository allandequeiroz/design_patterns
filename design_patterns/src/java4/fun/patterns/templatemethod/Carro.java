package java4.fun.patterns.templatemethod;

/**
 * Template Method � um padr�o que j� � inerente ao java por conta da heran�a com uso de classe abstrata.
 * Com esse padr�o podemos prover uma funcionalidade default e assim as classes implementadoras v�o
 * aprimorando os metodos e mudando o seu comportamento.
 * 
 * 
 *
 */
public abstract class Carro {

	protected int velocidade = 0;
	protected int portas = 4;	
	protected String freios = "Comum";
	
	protected String model = "Ford";
	
	
	public Carro() {}	
	
	public Carro(int portas, String freios, String model) {
		super();
		this.portas = portas;
		this.freios = freios;
		this.model = model;
	}

	public void acelerar(){
		velocidade += 10;	
	}	
	public void parar(){
		velocidade = 0;
	}
	public int getVelocidade(){
		return velocidade;
	}
	

	public String getFreios() {
		return freios;
	}
	public void setFreios(String freios) {
		this.freios = freios;
	}

	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}

	
	public int getPortas() {
		return portas;
	}
	public void setPortas(int portas) {
		this.portas = portas;
	}
	
}

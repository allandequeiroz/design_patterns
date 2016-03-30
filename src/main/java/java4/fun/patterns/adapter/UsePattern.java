package java4.fun.patterns.adapter;

/**
 * Exemplo de uso e teste do pattern Adapter.
 */
public class UsePattern {

	public static void main(String[] args) {
		Contrato c = new ContratoAdpter();
		c.setIdade(22);
		c.setNome("Diego");
		c.setTelefone("1000");
	
		System.out.println(c.toString());
	}
	
}

package java4.fun.patterns.prototype;

/**
 * Exemplo de uso e teste do pattern prototype.
 * 
 *
 */
public class UsePattern {

	public static void main(String[] args) {
		
		Pessoa pessoa = new Pessoa("Diego","GTI",22);
		pessoa.setSenhaDoCartaoDeCredito("123deoliveira4");
		
		System.out.println("Pessoa> " + pessoa);
		
		try {
			System.out.println("Clone> " + pessoa.clone());
		} catch (CloneNotSupportedException e) {		
			e.printStackTrace();
		}
		
	}
	
}

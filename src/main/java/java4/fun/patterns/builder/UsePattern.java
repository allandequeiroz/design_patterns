package java4.fun.patterns.builder;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe de testes e exmplo de uso do patterm Builder.
 * 
 *
 */
public class UsePattern {

	public static void main(String[] args) {
		
		List<String> filhos = new ArrayList<String>();
		filhos.add("Ze");
		filhos.add("Juana");
		filhos.add("Maria");
		filhos.add("Toninho");
		filhos.add("Deuzuite");
		filhos.add("Marislaine");
		filhos.add("Zeca");
		
		PessoaFactory pf = new PessoaFactory();
		Pessoa pessoa = pf.getPessoa(filhos);
		
		pessoa.nome = "Mãe Joana";
		
		System.out.println(pessoa);
		
	}
	
}

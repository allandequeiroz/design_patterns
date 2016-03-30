package java4.fun.patterns.builder;

import java.util.List;

/**
 * Esse � o Pattern Builder ele � praticamente igual ao pattern Factory.
 * A grande diferen�a � que esse pattern recebe parametros na hora de instanciar o Objeto de retorno 
 * da factory. E esses parametros s�o pasados para o metodo de cria��o da factory, no caso getPessoa.
 * Devemos usar esse patter quando necessitamos uma abstra��o da logica de cria��o dos objetos, porem necessitamos
 * parametrizar algums coisas.  
 *  
 * 
 *
 */
public class PessoaFactory {
	
	public Pessoa getPessoa(List<String> filhos){
		
		if (filhos.size()<=2){
			return new PessoaRica(filhos);
		}else if (filhos.size()>=3){
			return new PessoaPobre(filhos);
		}
		
		throw new IllegalArgumentException("Argumento inv�lido para o Builder de Pessoa! Argumento: " + filhos); 
		 
	}
	
}

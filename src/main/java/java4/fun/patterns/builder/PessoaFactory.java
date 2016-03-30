package java4.fun.patterns.builder;

import java.util.List;

/**
 * Esse é o Pattern Builder ele é praticamente igual ao pattern Factory.
 * A grande diferença é que esse pattern recebe parametros na hora de instanciar o Objeto de retorno 
 * da factory. E esses parametros são pasados para o metodo de criação da factory, no caso getPessoa.
 * Devemos usar esse patter quando necessitamos uma abstração da logica de criação dos objetos, porem necessitamos
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
		
		throw new IllegalArgumentException("Argumento inválido para o Builder de Pessoa! Argumento: " + filhos); 
		 
	}
	
}

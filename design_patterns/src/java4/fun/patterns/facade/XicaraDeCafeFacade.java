package java4.fun.patterns.facade;

/**
 * O Pattern Façade prove uma abstração para sub-rotinas e assim cria-se uma façada que 
 * prove abstração e desacoplamento e uma necessidade de conhecer sub-compromentes. Esse pattern é bastante utilizado
 * em sistemas comercias(Ou deveria pelo menos) para abstrair certas regras de negocios e encapsular operações. A Inrface prove menos acoplamento
 * e muitiplas possibilidades de implementação da Façade.
 * 
 *  
 *
 */
public interface XicaraDeCafeFacade {
	public XicaraDeCafe xicaraDeCafe();
}

package java4.fun.patterns.facade;

/**
 * O Pattern Fa�ade prove uma abstra��o para sub-rotinas e assim cria-se uma fa�ada que 
 * prove abstra��o e desacoplamento e uma necessidade de conhecer sub-compromentes. Esse pattern � bastante utilizado
 * em sistemas comercias(Ou deveria pelo menos) para abstrair certas regras de negocios e encapsular opera��es. A Inrface prove menos acoplamento
 * e muitiplas possibilidades de implementa��o da Fa�ade.
 * 
 *  
 *
 */
public interface XicaraDeCafeFacade {
	public XicaraDeCafe xicaraDeCafe();
}

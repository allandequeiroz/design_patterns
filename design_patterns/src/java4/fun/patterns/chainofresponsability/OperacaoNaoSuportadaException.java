package java4.fun.patterns.chainofresponsability;

public class OperacaoNaoSuportadaException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public OperacaoNaoSuportadaException() {}
	public OperacaoNaoSuportadaException(String msg) {super(msg);}
	
}

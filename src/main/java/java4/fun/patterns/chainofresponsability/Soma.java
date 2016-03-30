package java4.fun.patterns.chainofresponsability;

public class Soma implements Chain {

	public boolean isMyResponsability(String operateName) {
		return operateName.equals("soma");
	}
	
	public Chain nextChain() {
		throw new OperacaoNaoSuportadaException("Essa opera��o n�o est� suportada!!!");
	}
	
	public double operate(double a, double b) {
		return a + b;
	}

}

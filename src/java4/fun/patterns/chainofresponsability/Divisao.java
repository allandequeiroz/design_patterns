package java4.fun.patterns.chainofresponsability;

public class Divisao implements Chain {
	
	public double operate(double a, double b) {		
		return a / b; 
	}
	
	public boolean isMyResponsability(String operateName) {
		return operateName.equals("divisao");
	}
	
	public Chain nextChain() {
		return new Multiplicacao();
	}

}

package java4.fun.patterns.chainofresponsability;

public class Multiplicacao implements Chain {
	
	public boolean isMyResponsability(String operateName) {
		return operateName.equals("multiplicacao");
	}
	public Chain nextChain() {
		return new Soma();
	}
	public double operate(double a, double b) {
		return a * b;
	}

}

package java4.fun.patterns.visitor;

public class FuncionarioC implements IFuncionario {
	public double getSalario() {
		return 9000;
	}
	
	public String toString() {	
		return "FuncionarioC : " + getSalario();
	}
}
package java4.fun.patterns.visitor;

public class FuncionarioA implements IFuncionario {
	public double getSalario() {
		return 1000;
	}
	public String toString() {	
		return "FuncionarioA : " + getSalario();
	}
}

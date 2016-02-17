package java4.fun.patterns.visitor;

public class FuncionarioB implements IFuncionario {
	public double getSalario() {
		return 2000;
	}
	public String toString() {	
		return "FuncionarioB : " + getSalario();
	}
}

package java4.fun.patterns.visitor;

/**
 * Implementa��o do Patterm Visitor: que prove uma abstra��o as regras de fecth de um determinado conjuto de objetos 
 * ou situa��o. Pode ser usado em casos que queremos isolar determinados calculos, normalmente usando cole��es de objetos.
 * 
 * 
 *
 */
public class FuncionarioVisitor extends Visitor {

	private double totalSal = 0;
	
	@Override
	public void visit(IFuncionario func) {
		System.out.println("Somando salario de: " + func);
		totalSal += func.getSalario();
	}
	
	public double getTotSal(){
		return totalSal;
	}
	
}

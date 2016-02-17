package java4.fun.patterns.visitor;

import java.util.ArrayList;
import java.util.Collection;

public class UsePattern {

	public static void main(String[] args) {
		
		FuncionarioVisitor fv = new FuncionarioVisitor();
		
		FuncionarioA funcA = new FuncionarioA();
		FuncionarioB funcB = new FuncionarioB();
		FuncionarioC funcC = new FuncionarioC();
		
		Collection<IFuncionario> funcs = new ArrayList<IFuncionario>();
		funcs.add(funcA);
		funcs.add(funcB);
		funcs.add(funcC);
		
		for(IFuncionario fun : funcs){
			fv.visit(fun);
		}
		
		System.out.println("Total de Salários: " + fv.getTotSal());
		
	}
	
}

package java4.fun.patterns.interpreter;

import java.util.Stack;

/**
 * Implementa a interpreta��o para um Express�o de Soma.
 * 
 * 
 *
 */
class TerminalExpression_Plus implements Expression {
	   public void interpret(Stack<Integer> s){
		   int res = s.pop();
		   int res2 = s.pop();
		   int res3 = res + res2;
		   
		   s.push( res3 ); 
	  }
}

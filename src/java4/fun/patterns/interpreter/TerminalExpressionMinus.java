package java4.fun.patterns.interpreter;

import java.util.Stack;

/**
 * Implementa a interpretação para um Expressão de Subtração.
 * 
 * 
 *
 */
class TerminalExpression_Minus implements Expression {
	   public void interpret(Stack<Integer> s){ 
		   int tmp =  s.pop();
		   int tmp2 = s.pop();
		   int tmp3 = tmp2 - tmp;
		   
		   s.push( tmp3 ); 
	   }
}

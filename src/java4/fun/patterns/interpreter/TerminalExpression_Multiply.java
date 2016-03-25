package java4.fun.patterns.interpreter;

import java.util.Stack;

/**
 * Implementa a interpretação para um Expressão de Multiplicação.
 * 
 * 
 *
 */
public class TerminalExpression_Multiply implements Expression {

   public void interpret(Stack<Integer> s){
	   int res = s.pop();
	   int res2 = s.pop();
	   int res3 = res * res2;
	   
	   s.push( res3 ); 
  }	
}


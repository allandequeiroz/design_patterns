package java4.fun.patterns.interpreter;

import java.util.Stack;

public class TerminalExpression_POW implements Expression {

	   public void interpret(Stack<Integer> s){
		   int res = s.pop();
		   int res2 = res * res;
		   
		   s.push( res2 ); 
	  }	
}

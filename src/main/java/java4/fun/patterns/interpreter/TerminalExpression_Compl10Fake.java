package java4.fun.patterns.interpreter;

import java.util.Stack;

public class TerminalExpression_Compl10Fake implements Expression {
	
	   public void interpret(Stack<Integer> s){
		   int res  = s.pop();
		   
		   if (res>=10) {
			   s.push( res );
		   }
		   
		   s.push(10-res); 
		    
	  }

}

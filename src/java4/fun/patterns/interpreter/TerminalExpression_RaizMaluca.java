package java4.fun.patterns.interpreter;

import java.util.Stack;

public class TerminalExpression_RaizMaluca implements Expression {

	   public void interpret(Stack<Integer> s){
		   int res = s.pop();
		   
		   int i = 0;
		   boolean achei = false;
		   
		   while(true){
			 
			   if (i * i > res){
				   break;
			   }
			   
			   if (i * i == res){
				   achei = true;
				   break;
			   }
			   
			   i++;
			   
		   }
		   
		   if (achei==true){
			   
			   // se achou			   
			   s.push( i );
			   
		   }else{
			   
			   // significa que nao existe
			   s.push( -999 );			   
		   }
		   
		    
	  }	

}

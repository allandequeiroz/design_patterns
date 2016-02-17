package java4.fun.patterns.interpreter;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 
 * Pattern Interpreter. Padrão de interpretação(Parser)
 * Se você necessita avaliar determinadas expressões
 * como SQL ou linguagens como REGEX esse é o pattern para isso.
 * 
 * Nesse exemplo foi implementada uma calculadora Simples de
 * expressões inversas.
 * 
 * Ela faz da direita para esquerda com o sinal mais a esquerda.
 * 
 * 
 *
 */
class Parser {
	   private ArrayList<Expression> parseTree = new ArrayList<Expression>(); // Somente expressões não terminais aki!

	   public Parser(String s) {
	       for (String token : s.split(" ")) {
	           
	    	   if (token.equals("+")) {
	        	   parseTree.add( new TerminalExpression_Plus() );
	           }
	    	   
	           else if (token.equals("-")) {	        	   
	        	   parseTree.add( new TerminalExpression_Minus() );
	           }
	    	   
	           else if (token.equals("*")) {	        	   
	        	   parseTree.add( new TerminalExpression_Multiply() );
	           }
	    	   
	           else if (token.equals("/")) {	        	   
	        	   parseTree.add( new TerminalExpression_Division() );
	           }
	    	   
	           else if (token.equals("r2")) {	        	   
	        	   parseTree.add( new TerminalExpression_POW() );
	           }
	    	   
	           else if (token.equals("c10|")) {	        	   
	        	   parseTree.add( new TerminalExpression_Compl10Fake() );
	           }    	   
	    	   
	           else if (token.equals("%raiz")) {	        	   
	        	   parseTree.add( new TerminalExpression_RaizMaluca() );
	           }   	   
	    	   
	    	   
	           // ... é um numero.
	           else {
	        	   parseTree.add( new TerminalExpression_Number(Integer.valueOf(token)) );
	           }
	       }
	   }

	   public int evaluate() {
	       Stack<Integer> context = new Stack<Integer>();	       
	       for (Expression e : parseTree){
	    	   e.interpret(context);
	       }
	       
	       return context.pop();
	   }
}
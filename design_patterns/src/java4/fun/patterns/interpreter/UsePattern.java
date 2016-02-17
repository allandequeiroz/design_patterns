package java4.fun.patterns.interpreter;

/**
 * Exemplo de uso e teste do pattern Interpreter.
 * 
 *
 */
public class UsePattern{
	
	public static void main(String[] args) {			

		 //final String EXP = "42 2 1 - +";		   // 43
		 //final String EXP = "42 2 1 + *";        // 126
		 //final String EXP = "2 0 42 + /";        // 21
		 //final String EXP = "7 1 + r2";     	   // 64
		 //final String EXP = "8 2 - c10|";        // 4	
		   final String EXP = "30 1 5 + + %raiz";  // 6	 
		   
		
		 System.out.println("'" +  EXP + "' == " + new Parser(EXP).evaluate());
	}
}
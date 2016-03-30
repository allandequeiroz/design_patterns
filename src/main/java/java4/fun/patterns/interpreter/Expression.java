package java4.fun.patterns.interpreter;

import java.util.Stack;

/**
 * Interface base que prove a estrutura, contrato
 * que um interpretador devera fazer.
 * 
 * 
 *
 */
interface Expression {
	public void interpret(Stack<Integer> s);
}

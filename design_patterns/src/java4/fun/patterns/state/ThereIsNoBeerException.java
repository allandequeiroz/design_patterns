package java4.fun.patterns.state;

/**
 * Classe de Exception que herda de: RuntimeException.
 * Serve para representar que acabou a serveja.
 * 
 * 
 *
 */
public class ThereIsNoBeerException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	public ThereIsNoBeerException() {}
	public ThereIsNoBeerException(String msg) { super(msg); }
	
}

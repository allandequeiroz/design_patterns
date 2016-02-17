package java4.fun.dataLayer.exceptions;

/**
 * Responsible for defining data access exceptions.
 * 
 * @author <a href="mailto:allandequeiroz@gmail.com" style="text-decoration:  none;">Queiroz, Allan - </a>
 */
@SuppressWarnings("serial")
public class DataLayerError extends Exception {

	/**
	 * Class Constructor
	 */
	public DataLayerError() {
		super();
	}

	/**
	 * Class Constructor
	 * 
	 * @param msg
	 */
	public DataLayerError(String msg) {
		super(msg);
	}

	/**
	 * Class Constructor
	 * 
	 * @param cause
	 */
	public DataLayerError(Throwable cause) {
		super(cause);
	}

	/**
	 * Class Constructor
	 * 
	 * @param msg
	 * @param cause
	 */
	public DataLayerError(String msg, Throwable cause) {
		super(msg, cause);
	}

}

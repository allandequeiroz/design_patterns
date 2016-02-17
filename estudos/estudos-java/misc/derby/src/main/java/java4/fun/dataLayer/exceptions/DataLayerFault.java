package java4.fun.dataLayer.exceptions;

/**
 * Responsible for defining data access exceptions.
 * 
 * @author <a href="mailto:allandequeiroz@gmail.com" style="text-decoration:  none;">Queiroz, Allan - </a>
 */
@SuppressWarnings("serial")
public class DataLayerFault extends Exception {

	/**
	 * Class Constructor
	 */
	public DataLayerFault() {
		super();
	}

	/**
	 * Class Constructor
	 * 
	 * @param msg
	 */
	public DataLayerFault(String msg) {
		super(msg);
	}

	/**
	 * Class Constructor
	 * 
	 * @param cause
	 */
	public DataLayerFault(Throwable cause) {
		super(cause);
	}

	/**
	 * Class Constructor
	 * 
	 * @param msg
	 * @param cause
	 */
	public DataLayerFault(String msg, Throwable cause) {
		super(msg, cause);
	}

}

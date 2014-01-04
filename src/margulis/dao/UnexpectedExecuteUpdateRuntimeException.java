package margulis.dao;

/**
 * 
 * @author marco
 *
 */
public class UnexpectedExecuteUpdateRuntimeException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 * @param message
	 */
	public UnexpectedExecuteUpdateRuntimeException(final String message) {
		super(message);
	}

}

package ma.gloster.microservice.exception;

/**
 * The Class BusinessException.
 */
public class BusinessException extends ApplicationException {

	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -1471439077315708352L;

	/**
	 * Instantiates a new business exception.
	 */
	public BusinessException() {
		super();
	}

	/**
	 * Instantiates a new business exception.
	 *
	 * @param e the e
	 * @param msg the msg
	 */
	public BusinessException(Exception e, String msg) {
		super(e, msg);
	}

	/**
	 * Instantiates a new business exception.
	 *
	 * @param msg the msg
	 */
	public BusinessException(String msg) {
		super(msg);
	}

	/**
	 * Instantiates a new business exception.
	 *
	 * @param t the t
	 * @param msg the msg
	 */
	public BusinessException(Throwable t, String msg) {
		super(t, msg);
	}

	/**
	 * Instantiates a new business exception.
	 *
	 * @param t the t
	 */
	public BusinessException(Throwable t) {
		super(t);
	}

}

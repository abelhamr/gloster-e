
package ma.gloster.microservice.exception;

import java.io.PrintWriter;
import java.io.StringWriter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * The Class ApplicationException.
 */
@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
public class ApplicationException extends Exception {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 954505039512559526L;

	/**
	 * Instantiates a new application exception.
	 *
	 * @param msg
	 *            the msg
	 */
	public ApplicationException(String msg) {
		super(msg);
	}

	/**
	 * Instantiates a new application exception.
	 */
	public ApplicationException() {
		super();
	}

	/**
	 * Instantiates a new application exception.
	 *
	 * @param t
	 *            the t
	 */
	public ApplicationException(Throwable t) {
		super(t);
	}

	/**
	 * Instantiates a new application exception.
	 *
	 * @param t
	 *            the t
	 * @param msg
	 *            the msg
	 */
	public ApplicationException(Throwable t, String msg) {
		super(msg, t);
	}

	/**
	 * Instantiates a new application exception.
	 *
	 * @param e
	 *            the e
	 * @param msg
	 *            the msg
	 */
	public ApplicationException(Exception e, String msg) {
		super(msg, e);
	}

	/**
	 * Gets the stack trace.
	 *
	 * @param e
	 *            the e
	 * @return the stack trace
	 */
	public static String getStackTrace(Exception e) {
		StringWriter errors = new StringWriter();
		e.printStackTrace(new PrintWriter(errors));
		return errors.toString();
	}

}

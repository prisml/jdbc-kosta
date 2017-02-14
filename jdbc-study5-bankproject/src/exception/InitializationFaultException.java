package exception;

public class InitializationFaultException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3133876717567636508L;

	public InitializationFaultException() {
		super("1000원 이상 입금하세요");
	}

	public InitializationFaultException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public InitializationFaultException(String message, Throwable cause) {
		super(message, cause);
	}

	public InitializationFaultException(String message) {
		super(message);
	}

	public InitializationFaultException(Throwable cause) {
		super(cause);
	}
}

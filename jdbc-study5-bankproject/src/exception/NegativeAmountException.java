package exception;

public class NegativeAmountException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6175274890555909109L;

	public NegativeAmountException() {
		super("�� 0������ �߸��� �ݾ� �Է�");
	}

	public NegativeAmountException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public NegativeAmountException(String message, Throwable cause) {
		super(message, cause);
	}

	public NegativeAmountException(String message) {
		super(message);
	}

	public NegativeAmountException(Throwable cause) {
		super(cause);
	}
}

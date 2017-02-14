package exception;

public class LackOfBalanceException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6056467412492642296L;

	public LackOfBalanceException() {
		super("�ܾ� ����");
	}

	public LackOfBalanceException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public LackOfBalanceException(String message, Throwable cause) {
		super(message, cause);
	}

	public LackOfBalanceException(String message) {
		super(message);
	}

	public LackOfBalanceException(Throwable cause) {
		super(cause);
	}
}

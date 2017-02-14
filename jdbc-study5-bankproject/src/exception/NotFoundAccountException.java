package exception;

public class NotFoundAccountException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5450998566497470933L;

	public NotFoundAccountException() {
		super("해당 계좌가 없습니다");
	}

	public NotFoundAccountException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public NotFoundAccountException(String message, Throwable cause) {
		super(message, cause);
	}

	public NotFoundAccountException(String message) {
		super(message + "의 계좌가 없습니다");
	}

	public NotFoundAccountException(Throwable cause) {
		super(cause);
	}
}

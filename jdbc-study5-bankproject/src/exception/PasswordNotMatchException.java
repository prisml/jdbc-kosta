package exception;

public class PasswordNotMatchException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4547798392725783373L;

	public PasswordNotMatchException() {
		super("��й�ȣ�� ��ġ���� �ʽ��ϴ�");
	}

	public PasswordNotMatchException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public PasswordNotMatchException(String message, Throwable cause) {
		super(message, cause);
	}

	public PasswordNotMatchException(String message) {
		super(message);
	}

	public PasswordNotMatchException(Throwable cause) {
		super(cause);
	}
}

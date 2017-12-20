package main.java.org.xdove.jwt.exception;

/**
 * 不支持的算法异常
 */
public class UnsupportedAlgorithmException extends RuntimeException {

	private static final long serialVersionUID = -1528424161366273351L;

	public UnsupportedAlgorithmException() {
	}

	public UnsupportedAlgorithmException(String message) {
		super(message);
	}

	public UnsupportedAlgorithmException(String message, Throwable cause) {
		super(message, cause);
	}

	public UnsupportedAlgorithmException(Throwable cause) {
		super(cause);
	}

	public UnsupportedAlgorithmException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}

package org.xdove.jwt.exception;

/**
 * 不支持的jwt格式异常.
 * @author Wszl
 * @date 2018年1月18日
 */
public class UnsupportedFormatException extends AbstractJwtException {

    public UnsupportedFormatException() {
        super();
    }

    public UnsupportedFormatException(String message) {
        super("unspport format by " + message);
    }

    public UnsupportedFormatException(String message, Throwable cause) {
        super(message, cause);
    }

    public UnsupportedFormatException(Throwable cause) {
        super(cause);
    }

    protected UnsupportedFormatException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

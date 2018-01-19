package org.xdove.jwt.exception;

import java.io.PrintStream;
import java.io.PrintWriter;

/**
 * 不可信任的JWT凭证异常类
 * @author Wszl
 * @date 2017年12月27日
 */
public class TrustlessException extends AbstractJwtException {
    public TrustlessException() {
        super();
    }

    public TrustlessException(String message) {
        super(message);
    }

    public TrustlessException(String message, Throwable cause) {
        super(message, cause);
    }

    public TrustlessException(Throwable cause) {
        super(cause);
    }

    protected TrustlessException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }

    @Override
    public String getLocalizedMessage() {
        return super.getLocalizedMessage();
    }

    @Override
    public synchronized Throwable getCause() {
        return super.getCause();
    }

    @Override
    public synchronized Throwable initCause(Throwable cause) {
        return super.initCause(cause);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public void printStackTrace() {
        super.printStackTrace();
    }

    @Override
    public void printStackTrace(PrintStream s) {
        super.printStackTrace(s);
    }

    @Override
    public void printStackTrace(PrintWriter s) {
        super.printStackTrace(s);
    }

    @Override
    public synchronized Throwable fillInStackTrace() {
        return super.fillInStackTrace();
    }

    @Override
    public StackTraceElement[] getStackTrace() {
        return super.getStackTrace();
    }

    @Override
    public void setStackTrace(StackTraceElement[] stackTrace) {
        super.setStackTrace(stackTrace);
    }
}

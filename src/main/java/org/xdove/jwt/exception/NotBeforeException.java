package org.xdove.jwt.exception;

/**
 * NotBeforeException
 *
 * @author zhangchao
 * @date 2018年1月11日
 */
public class NotBeforeException extends AbstractJwtException {

    public NotBeforeException(String message) {
        super(message);
    }
}

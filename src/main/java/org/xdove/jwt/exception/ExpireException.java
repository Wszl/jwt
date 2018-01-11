package org.xdove.jwt.exception;

/**
 * ExpireException
 *
 * @author zhangchao
 * @date 2018年1月11日
 */
public class ExpireException extends AbstractJWTException {
    public ExpireException(String message) {
        super(message);
    }
}

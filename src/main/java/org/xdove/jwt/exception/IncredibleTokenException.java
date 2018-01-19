package org.xdove.jwt.exception;

/**
 * IncredibleTokenException
 *
 * @author zhangchao
 * @date 2018年1月11日
 */
public class IncredibleTokenException extends AbstractJwtException {
    public IncredibleTokenException(String message) {
        super(message);
    }
}

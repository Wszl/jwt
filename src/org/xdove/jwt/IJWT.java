package org.xdove.jwt;

/**
 * JWT
 *
 * @author 张超
 * @date 2017年12月20日
 */
public interface IJWT {

    IHeader getHeader();

    void setHeader(IHeader header);

    IPayload getPayload();

    void setPayload(IPayload payload);

    String getSignature();
}

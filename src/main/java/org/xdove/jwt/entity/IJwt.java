package org.xdove.jwt.entity;

/**
 * JWT
 *
 * @author 张超
 * @date 2017年12月20日
 */
public interface IJwt {

    IHeader getHeader();

    void setHeader(IHeader header);

    IPayload getPayload();

    void setPayload(IPayload payload);

    String getSignature();

    void setSignature(String signature);
}

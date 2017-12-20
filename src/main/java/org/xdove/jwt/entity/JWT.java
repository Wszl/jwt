package org.xdove.jwt.entity;


import org.xdove.jwt.IHeader;
import org.xdove.jwt.IJWT;
import org.xdove.jwt.IPayload;

import java.util.Date;

/**
 * JWT实体类
 * 本类定义了JWT标准中的实体类，包含标准所规定的header, payload, signature 以及其内部的各种字段.
 * 如需添加/扩展自定义字段，请重写Payload 并注入本类实例即可。
 * @author Wszl
 * @date 2017年11月21日
 */
public class JWT implements IJWT {
	/** JWT头 */
    protected IHeader header;
    /** JWT载荷，向此处注入Payload子类即实现了对JWT的扩展*/
    protected IPayload payload;
    /** JWT签名，默认使用 Hmacsha256算法 */
    protected String    signature;


    public JWT setAlg(String alg) {
        if (this.header == null) {
            header = new Header();
        }
        header.setAlg(alg);

        return this;
    }

    public JWT setTyp(String typ) {
        if (this.header == null) {
            header = new Header();
        }
        header.setTyp(typ);

        return this;
    }

    public JWT setIat(Date iat) {
        if (this.payload == null) {
            payload = new Payload();
        }
        payload.setIat(iat);

        return this;
    }


    @Override
    public IHeader getHeader() {
        return header;
    }

    @Override
    public void setHeader(IHeader header) {
        this.header = header;
    }

    @Override
    public IPayload getPayload() {
        return payload;
    }

    @Override
    public void setPayload(IPayload payload) {
        this.payload = payload;
    }

    @Override
    public String getSignature() {
        return signature;
    }

}

package org.xdove.jwt.entity;

/**
 * JWT实体类
 * 本类定义了JWT标准中的实体类，包含标准所规定的header, payload, signature 以及其内部的各种字段.
 * 如需添加/扩展自定义字段，请重写Payload 并注入本类实例即可。
 * @author Wszl
 * @date 2017年11月21日
 */
public class JWT {
	/** JWT头 */
    protected Header    header;
    /** JWT载荷，向此处注入Payload子类即实现了对JWT的扩展*/
    protected Payload   payload;
    /** JWT签名，默认使用 Hmacsha256算法 */
    protected String    signature;


    public JWT setAlg(String alg) {
        if (this.header == null)
            header = new Header();
        header.setAlg(alg);

        return this;
    }

    public JWT setTyp(String typ) {
        if (this.header == null)
            header = new Header();
        header.setTyp(typ);

        return this;
    }

    public Header getHeader() {
        return header;
    }

    public void setHeader(Header header) {
        this.header = header;
    }

    public Payload getPayload() {
        return payload;
    }

    public void setPayload(Payload payload) {
        this.payload = payload;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

}

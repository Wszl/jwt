package org.xdove.jwt.entity;

import org.xdove.jwt.JWTBuilder;
import org.xdove.jwt.utils.SignatureAlgorithm;

/**
 * JWT实体
 */
public class JWT {
    protected Header    header;
    protected Payload   payload;
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

    public static JWT construct() {
        return new JWT();
    }

    public JWTBuilder build(SignatureAlgorithm alg, byte[] key) {
        return new JWTBuilder(this, alg, key);
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

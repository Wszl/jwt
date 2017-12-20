package org.xdove.jwt.entity;

import org.xdove.jwt.IPayload;

import java.util.Date;

/**
 * 由于JWT的时效性，注定了服务器和客户端需要保持时间的同步
 * 建议服务器和客户端同时使用ntp服务
 */
public class Payload implements IPayload {
    /**
     * 本JWT所适用的对象 */
    protected String sub;

    /**
     * JWT签发者
     */
    protected String iss;

    /**
     * 签发日期
     */
    protected Date iat;
    /**
     * 失效日期/超时时间
     */
    protected Date exp;
    /**
     * JWT在此时间前不能被接受处理
     */
    protected Date nbf;

    /**
     * JWE ID作为唯一标识
     */
    protected String jti;

    @Override
    public String getSub() {
        return sub;
    }

    @Override
    public void setSub(String sub) {
        this.sub = sub;
    }

    @Override
    public String getIss() {
        return iss;
    }

    @Override
    public void setIss(String iss) {
        this.iss = iss;
    }

    @Override
    public Date getIat() {
        return iat;
    }

    @Override
    public void setIat(Date iat) {
        this.iat = iat;
    }

    @Override
    public Date getExp() {
        return exp;
    }

    @Override
    public void setExp(Date exp) {
        this.exp = exp;
    }

    @Override
    public Date getNbf() {
        return nbf;
    }

    @Override
    public void setNbf(Date nbf) {
        this.nbf = nbf;
    }

    @Override
    public String getJti() {
        return jti;
    }

    @Override
    public void setJti(String jti) {
        this.jti = jti;
    }
}

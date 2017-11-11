package org.xdove.jwt.entity;

/**
 * 由于JWT的时效性，注定了服务器和客户端需要保持时间的同步
 * 建议服务器和客户端同时使用ntp服务
 */
public class Payload {
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
    protected Long iat;
    /**
     * 失效日期/超时时间
     */
    protected Long exp;
    /**
     * JWT在此时间前不能被接受处理
     */
    protected Long nbf;

    /**
     * JWE ID作为唯一标识
     */
    protected String jti;

    public String getSub() {
        return sub;
    }

    public void setSub(String sub) {
        this.sub = sub;
    }

    public String getIss() {
        return iss;
    }

    public void setIss(String iss) {
        this.iss = iss;
    }

    public Long getIat() {
        return iat;
    }

    public void setIat(Long iat) {
        this.iat = iat;
    }

    public Long getExp() {
        return exp;
    }

    public void setExp(Long exp) {
        this.exp = exp;
    }

    public Long getNbf() {
        return nbf;
    }

    public void setNbf(Long nbf) {
        this.nbf = nbf;
    }

    public String getJti() {
        return jti;
    }

    public void setJti(String jti) {
        this.jti = jti;
    }
}

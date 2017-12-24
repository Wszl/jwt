package org.xdove.jwt.entity.common;

import org.xdove.jwt.entity.AbstractContains;
import org.xdove.jwt.entity.IPayload;
import sun.security.x509.IPAddressName;

import java.util.Date;

/**
 * 由于JWT的时效性，注定了服务器和客户端需要保持时间的同步
 * 建议服务器和客户端同时使用ntp服务
 */
public class Payload extends AbstractContains implements IPayload {

    public Payload() {
        this.setIat(new Date());
    }

    @Override
    public void setSub(String sub) {
        this.put(IPayload.SUB, sub);
    }

    @Override
    public String getSub() {
        return (String) this.get(IPayload.SUB);
    }

    @Override
    public void setIss(String iss) {
        this.put(IPayload.ISS, iss);
    }

    @Override
    public String getIss() {
        return (String) this.get(IPayload.ISS);
    }

    @Override
    public void setIat(Date iat) {
        this.put(IPayload.IAT, iat);
    }

    @Override
    public Date getIat() {
        return (Date) this.get(IPayload.IAT);
    }

    @Override
    public void setExp(Date exp) {
        this.put(IPayload.EXP, exp);
    }

    @Override
    public Date getExp() {
        return (Date) this.get(IPayload.EXP);
    }

    @Override
    public void setNbf(Date nbf) {
        this.put(IPayload.NBF, nbf);
    }

    @Override
    public Date getNbf() {
        return (Date) this.get(IPayload.NBF);
    }

    @Override
    public void setJti(String jti) {
        this.put(IPayload.JTI, jti);
    }

    @Override
    public String getJti() {
        return (String) this.get(IPayload.JTI);
    }
}

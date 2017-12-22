package org.xdove.jwt.entity.common;

import org.xdove.jwt.entity.AbstractContains;
import org.xdove.jwt.entity.IPayload;

import java.util.Date;

/**
 * 由于JWT的时效性，注定了服务器和客户端需要保持时间的同步
 * 建议服务器和客户端同时使用ntp服务
 */
public class Payload extends AbstractContains implements IPayload {

    @Override
    public void setSub(String sub) {

    }

    @Override
    public String getSub() {
        return null;
    }

    @Override
    public void setIss(String iss) {

    }

    @Override
    public String getIss() {
        return null;
    }

    @Override
    public void setIat(Date iat) {

    }

    @Override
    public Date getIat() {
        return null;
    }

    @Override
    public void setExp(Date exp) {

    }

    @Override
    public Date getExp() {
        return null;
    }

    @Override
    public void setNbf(Date nbf) {

    }

    @Override
    public Date getNbf() {
        return null;
    }

    @Override
    public void setJti(String jti) {

    }

    @Override
    public String getJti() {
        return null;
    }
}

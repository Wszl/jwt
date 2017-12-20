package main.java.org.xdove.jwt;

import java.util.Date;

/**
 * Payload
 *
 * @author 张超
 * @date 2017年12月20日
 */
public interface IPayload {

    void setSub(String sub);

    String getSub();

    void setIss(String iss);

    String getIss();

    void setIat(Date iat);

    Date getIat();

    void setExp(Date exp);

    Date getExp();

    void setNbf(Date nbf);

    Date getNbf();

    void setJti(String jti);

    String getJti();

}

package org.xdove.jwt.entity;

import java.util.Date;
import java.util.Map;

/**
 * Payload
 *
 * @author 张超
 * @date 2017年12月20日
 */
public interface IPayload {

    public static final String SUB = "sub";
    public static final String ISS = "iss";
    public static final String IAT = "iat";
    public static final String EXP = "exp";
    public static final String NBF = "nbf";
    public static final String JTI = "jti";

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

    void add(String key, String value);

    void add(Map map);

}

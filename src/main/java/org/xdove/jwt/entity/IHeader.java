package org.xdove.jwt.entity;

import java.util.Map;

/**
 * Header
 *
 * @author 张超
 * @date 2017年12月20日
 */
public interface IHeader {

    public static final String TYP = "typ";
    public static final String ALG = "alg";

    String getTyp();

    void setTyp(String typ);

    String getAlg();

    void setAlg(String alg);

    void add(String key, String value);

    void add(Map map);
}

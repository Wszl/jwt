package org.xdove.jwt.entity;

/**
 * Header
 *
 * @author 张超
 * @date 2017年12月20日
 */
public interface IHeader {

    String getTyp();

    void setTyp(String typ);

    String getAlg();

    void setAlg(String alg);
}

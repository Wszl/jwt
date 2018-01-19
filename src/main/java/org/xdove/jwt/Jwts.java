package org.xdove.jwt;

import org.xdove.jwt.entity.IJwt;
import org.xdove.jwt.utils.EncryptJwt;

import java.security.Key;

/**
 * Jwts
 */
public class Jwts {

    public static JwtBuilder construct() {
        return new JwtBuilder();
    }

    public static IJwt verify(String jwtStr, Key key) {
        return verify(jwtStr, key.getEncoded());
    }

    public static IJwt verify(String jwtStr, byte[] key) {
        return EncryptJwt.decrypt(jwtStr, key);
    }
}

package org.xdove.jwt;

import org.junit.Test;
import org.xdove.jwt.entity.IJwt;
import org.xdove.jwt.utils.algorithm.SignatureAlgorithm;

public class JwtTest {

    private final byte[] key = "2333".getBytes();

    private String jwtStr;

    @Test
    public void testConstruct() {
        String jwt = Jwts.construct()
                .setKey(key, SignatureAlgorithm.HS256)
                .add("test", "test")
                .build()
                .compact();

        this.jwtStr = jwt;
        System.out.println("new :" + jwt);
    }

    @Test
    public void testVerify() {
        testConstruct();
        IJwt jwt = Jwts.verify(jwtStr, key);
        System.out.println("verify :" + jwt.toString());
    }
}
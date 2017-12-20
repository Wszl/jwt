package test.org.xdove.jwt;

import org.junit.Test;
import org.xdove.jwt.JWTBuilder;
import org.xdove.jwt.entity.JWT;

import java.util.Date;

public class JWTBuilderTest {

    @Test
    public void build() {
        JWTBuilder jb = new JWTBuilder();
        jb.build();
    }

    @Test
    public void compact() {
    }

    @Test
    public void test() {
        JWT jwt = new JWT();
        jwt.setIat(new Date());
        JWTBuilder jb = JWTBuilder.construct();

        jb.setKey("233".getBytes());

        String jwtStr = jb.compact();
        System.out.println(jwtStr);
    }
}
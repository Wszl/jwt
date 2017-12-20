package org.xdove.jwt.utils;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xdove.jwt.IJWT;

import java.util.Base64;

/**
 * CryptJWT
 *
 * @author 张超
 * @date 2017年12月20日
 */
public class CryptJWT {

    private final static Logger log = LoggerFactory.getLogger(CryptJWT.class);

    public static final String JWT_SPLIT_SPEC = ".";

    public static String cryptJWT(IJWT jwt, Algorithm algorithm, byte[] key) {
        StringBuilder sb = new StringBuilder();
        sb.append(base64Crypt(jwt.getHeader()))
                .append(JWT_SPLIT_SPEC)
                .append(base64Crypt(jwt.getPayload()))
                .append(JWT_SPLIT_SPEC)
                .append(jwtCrypt(sb.toString(), algorithm, key));

        return sb.toString();
    }

    public static String parseJson(Object obj) {
        return JSONObject.toJSONString(obj);
    }

    public static byte[] parseBase64Url(byte[] data) {
        Base64.Encoder encoder = Base64.getUrlEncoder();
        return encoder.encode(data);
    }

    public static String base64Crypt(Object obj) {
        return new String(parseBase64Url(parseJson(obj).getBytes()));
    }

    public static String jwtCrypt(String str, Algorithm algorithm, byte[] key) {
        log.info("jwt crypt : str={}, alg={}, key={}", str, algorithm, key);
        Base64.Encoder encoder = Base64.getEncoder();
        return new String(encoder.encode(algorithm.signature(str.getBytes(), key)));
    }

}

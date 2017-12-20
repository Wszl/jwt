package org.xdove.jwt.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xdove.jwt.IJWT;

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
        sb.append(AlgorithmUtils.base64Crypt(jwt.getHeader()))
                .append(JWT_SPLIT_SPEC)
                .append(AlgorithmUtils.base64Crypt(jwt.getPayload()));
        log.debug("crypt sting : {}", sb);

        String signature = jwtCrypt(sb.toString(), algorithm, key);
        log.trace("sinature string : {}", signature);

        sb.append(JWT_SPLIT_SPEC)
                .append(signature);

        return sb.toString();
    }


    public static String jwtCrypt(String str, Algorithm algorithm, byte[] key) {
        log.info("jwt crypt : str={}, alg={}, key={}", str, algorithm, key);
        return AlgorithmUtils.byte2hex(algorithm.signature(str.getBytes(), key));
    }

}

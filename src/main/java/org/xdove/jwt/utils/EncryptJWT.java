package org.xdove.jwt.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xdove.jwt.entity.IJWT;

/**
 * CryptJWT
 *
 * @author 张超
 * @date 2017年12月20日
 */
public class EncryptJWT {

    private final static Logger log = LoggerFactory.getLogger(EncryptJWT.class);

    public static final String JWT_SPLIT_SPEC = ".";

    public static String encrypt(IJWT jwt, Algorithm algorithm, byte[] key) {
        StringBuilder sb = new StringBuilder();
        sb.append(new String(AlgorithmUtils.parseBase64Url(AlgorithmUtils.parseJson(jwt.getHeader()).getBytes())))
                .append(JWT_SPLIT_SPEC)
                .append(new String(AlgorithmUtils.parseBase64Url(AlgorithmUtils.parseJson(jwt.getPayload()).getBytes())));
        log.debug("crypt sting : {}", sb);

        String signature = AlgorithmUtils.byte2hex(algorithm.signature(sb.toString().getBytes(), key));
        log.trace("sinature string : {}", signature);

        sb.append(JWT_SPLIT_SPEC)
                .append(signature);

        return sb.toString();
    }

    public static String decrypt(String jwt, Algorithm algorithm, byte[] key) {
        String[] jwtArr = jwt.split(JWT_SPLIT_SPEC);
        if (jwtArr.length != 3) {
            log.debug("unsupport format : {}.");
        }

        return null;
    }

}

package org.xdove.jwt.utils;

import org.xdove.jwt.entity.IHeader;
import org.xdove.jwt.entity.IJwt;
import org.xdove.jwt.entity.IPayload;
import org.xdove.jwt.entity.common.Header;
import org.xdove.jwt.entity.common.JWT;
import org.xdove.jwt.entity.common.Payload;
import org.xdove.jwt.exception.TrustlessException;
import org.xdove.jwt.exception.UnsupportedFormatException;
import org.xdove.jwt.utils.algorithm.Algorithm;
import org.xdove.jwt.utils.algorithm.AlgorithmFactory;
import org.xdove.jwt.utils.algorithm.SignatureAlgorithm;

/**
 * CryptJWT
 *
 * @author 张超
 * @date 2017年12月20日
 */
public class EncryptJwt {

    public static final String JWT_SPLIT_SPEC = ".";

    public static String encrypt(IJwt jwt, String alg, byte[] key) {

        Algorithm algorithm = AlgorithmFactory.getInstance(alg);

        StringBuilder sb = construct(jwt);
        String signature = AlgorithmUtils.byte2hex(algorithm.signature(sb.toString().getBytes(), key));
        sb.append(JWT_SPLIT_SPEC)
                .append(signature);

        return sb.toString();
    }

    public static StringBuilder construct(IJwt jwt) {
        StringBuilder sb = new StringBuilder();
        sb.append(new String(AlgorithmUtils.parseBase64Url(JsonUtils.parseJson(jwt.getHeader()).getBytes())))
                .append(JWT_SPLIT_SPEC)
                .append(new String(AlgorithmUtils.parseBase64Url(JsonUtils.parseJson(jwt.getPayload()).getBytes())));
        return sb;
    }

    public static IJwt construct(String jwtStr) {
        String[] jwtArr = jwtStr.split("\\" + JWT_SPLIT_SPEC);
        if (jwtArr.length != 3) {
            throw new UnsupportedFormatException(jwtStr);
        }
        IHeader header = JsonUtils.parseObject(AlgorithmUtils.decodeBase64Url(jwtArr[0]), Header.class);
        IPayload payload = JsonUtils.parseObject(AlgorithmUtils.decodeBase64Url(jwtArr[1]), Payload.class);
        IJwt jwt = new JWT(header, payload);

        return jwt;
    }

    public static IJwt decrypt(String jwtStr, byte[] key) {
        String[] jwtArr = jwtStr.split("\\" + JWT_SPLIT_SPEC);
        if (jwtArr.length != 3) {
            throw new UnsupportedFormatException(jwtStr);
        }

        IJwt jwt = construct(jwtStr);

        SignatureAlgorithm.valueOf(jwt.getHeader().getAlg());

        String localSignature = encrypt(jwt, jwt.getHeader().getAlg(), key).split("\\" + JWT_SPLIT_SPEC)[2];
        jwt.setSignature(localSignature);

        if (localSignature.equalsIgnoreCase(jwtArr[2])) {
            return jwt;
        } else {
            throw new TrustlessException();
        }
    }

}

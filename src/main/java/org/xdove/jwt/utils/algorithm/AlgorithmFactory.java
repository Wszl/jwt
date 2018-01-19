package org.xdove.jwt.utils.algorithm;

import org.xdove.jwt.exception.UnsupportedAlgorithmException;

/**
 * Alg factory .
 * @author Wszl
 * @date 2018年1月19日
 */
public class AlgorithmFactory {

    public static Algorithm getInstance(String alg) {
        if (alg == null
                || "".equalsIgnoreCase(alg)) {
            throw new UnsupportedAlgorithmException(alg);
        }

        return getInstance(SignatureAlgorithm.valueOf(alg));
    }

    public static Algorithm getInstance(SignatureAlgorithm alg) {

        switch (alg) {
            case HS256:
                return new HmacSHA256();
                default:
                   throw new UnsupportedAlgorithmException(alg.name());
        }

    }
}

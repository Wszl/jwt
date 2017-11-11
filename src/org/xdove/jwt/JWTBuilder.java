package org.xdove.jwt;

import org.xdove.jwt.entity.JWT;
import org.xdove.jwt.exception.UnsupportedAlgorithmException;
import org.xdove.jwt.utils.Algorithm;
import org.xdove.jwt.utils.SignatureAlgorithm;
import org.xdove.jwt.utils.algorithm.HMACSHA256;

public class JWTBuilder {
	
	private JWT jwt;

	private Algorithm alg;

    public JWTBuilder(JWT jwt, SignatureAlgorithm alg, byte[] key) {
        this.jwt = jwt;
        switch (alg) {
            case HS256:
                jwt.setAlg(alg.name());
                this.alg = new HMACSHA256(key, jwt);
                break;

            default:
                throw new UnsupportedAlgorithmException("unsupport algorithm " + alg);
        }
    }

    public String compact() {
        return alg.build();
    }

}

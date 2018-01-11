package org.xdove.jwt.utils.verify;

import org.xdove.jwt.entity.IJWT;
import org.xdove.jwt.exception.IncredibleTokenException;
import org.xdove.jwt.utils.Algorithm;
import org.xdove.jwt.utils.EncryptJWT;
import org.xdove.jwt.utils.SignatureAlgorithm;
import org.xdove.jwt.utils.algorithm.CommonAlgorithm;
import org.xdove.jwt.web.Config;

/**
 * EffectiveNode.
 * 验证JWT合法性节点，作为校验阶段的开始.
 *
 * @author Wszl
 * @date 2018年1月11日
 */
public class EffectiveNode extends Node {

    @Override
    public void validate(IJWT jwt) {

        Algorithm alg = CommonAlgorithm.getInstance(SignatureAlgorithm.HS256);

        String jwts = EncryptJWT.encrypt(jwt, alg, Config.key);

        if (jwt.getSignature().equalsIgnoreCase(jwts)) {
            this.node.validate(jwt);
        } else {
            throw new IncredibleTokenException("JWT 没有通过校验，该信息可能已经被篡改.");
        }

    }
}

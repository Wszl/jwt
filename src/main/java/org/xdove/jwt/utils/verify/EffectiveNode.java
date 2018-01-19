package org.xdove.jwt.utils.verify;

import org.xdove.jwt.entity.IJwt;
import org.xdove.jwt.exception.IncredibleTokenException;
import org.xdove.jwt.utils.EncryptJwt;
import org.xdove.jwt.utils.algorithm.Algorithm;
import org.xdove.jwt.utils.algorithm.AlgorithmFactory;
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
    public void validate(IJwt jwt) {

        Algorithm alg = AlgorithmFactory.getInstance(jwt.getHeader().getAlg());

        String jwts = EncryptJwt.encrypt(jwt, alg.getFullName(), Config.key);

        if (jwt.getSignature().equalsIgnoreCase(jwts)) {
            this.node.validate(jwt);
        } else {
            throw new IncredibleTokenException("JWT 没有通过校验，该信息可能已经被篡改.");
        }

    }
}

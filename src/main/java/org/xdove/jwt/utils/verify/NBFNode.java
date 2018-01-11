package org.xdove.jwt.utils.verify;

import org.xdove.jwt.entity.IJWT;
import org.xdove.jwt.exception.NotBeforeException;

import java.util.Date;

/**
 * NBFNode.
 * JWT标准字段: nbf字段验证，时间校验取本地时间为参考，请保证本地时间的正确性.
 *
 * @author Wszl
 * @date 2018年1月11日
 */
public class NBFNode extends Node {

    @Override
    public void validate(IJWT jwt) {
        Date now = new Date();
        Date nbf = jwt.getPayload().getNbf();
        if (nbf != null
                && now.after(nbf)) {
            this.node.validate(jwt);
        } else {
            throw new NotBeforeException("JWT 未生效");
        }
    }


}

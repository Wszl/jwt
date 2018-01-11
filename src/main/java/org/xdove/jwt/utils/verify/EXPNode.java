package org.xdove.jwt.utils.verify;

import org.xdove.jwt.entity.IJWT;
import org.xdove.jwt.exception.ExpireException;

import java.util.Date;

/**
 * EXPNode.
 * JWT标准字段: exp 校验, 参考时间使用本地时间, 请保证本地时间的正确性.
 * @author Wszl
 * @date 2018年1月11日
 */
public class EXPNode extends Node {

    @Override
    void validate(IJWT jwt) {
        Date now = new Date();
        Date exp = jwt.getPayload().getExp();
        if (exp != null
                && exp.before(now)) {
            this.node.validate(jwt);
        } else {
            throw new ExpireException("JWT 已过使用期限");
        }
    }
}

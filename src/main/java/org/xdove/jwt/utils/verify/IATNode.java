package org.xdove.jwt.utils.verify;

import org.xdove.jwt.entity.IJwt;

/**
 * IATNode.
 * JWT标准字段: iat 校验, 参考时间使用本地时间, 请确保本地时间的正确性.
 *
 * @author Wszl
 * @date 2018年1月11日
 */
public class IATNode extends Node {

    @Override
    void validate(IJwt jwt) {
        this.node.validate(jwt);
    }
}

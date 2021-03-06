package org.xdove.jwt.utils.verify;

import org.xdove.jwt.entity.IJwt;

/**
 * Node
 *
 * @author Wszl
 * @date 2018年1月11日
 */
public abstract class Node {

    protected Node node;

    /**
     * 信息校验方法
     * @param jwt
     */
    abstract void validate(IJwt jwt);

    public Node getNode() {
        return node;
    }

    public void setNode(Node node) {
        this.node = node;
    }
}

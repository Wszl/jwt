package org.xdove.jwt.utils;

import org.xdove.jwt.entity.JWT;

/**
 * 前面算法接口
 * @author Wszl
 * @date 2017年11月21日
 */
public interface Algorithm {
	
	/**
	 * 子类需重写本方法，使得传入的JWT对象能够进行签名
	 * @return
	 */
	String signature(JWT jwt);
}

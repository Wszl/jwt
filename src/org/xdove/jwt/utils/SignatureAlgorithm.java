package org.xdove.jwt.utils;

/**
 * 签名算法枚举类
 * @author Wszl
 * @date 2017年11月21日
 */
public enum SignatureAlgorithm {
	HS256("HmacSHA256");
	
	private SignatureAlgorithm(String name) {

	}
	
}

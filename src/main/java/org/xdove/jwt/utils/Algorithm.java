package main.java.org.xdove.jwt.utils;

import main.java.org.xdove.jwt.entity.JWT;

/**
 * 算法接口
 * @author Wszl
 * @date 2017年11月21日
 */
public interface Algorithm {
	
	/**
	 * 子类需重写本方法，使得传入的JWT对象能够进行签名
	 * @return
	 */
	byte[] signature(byte[] data, byte[] key);

	String getName();
}

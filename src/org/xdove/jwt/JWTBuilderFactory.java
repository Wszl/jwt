package org.xdove.jwt;

import org.xdove.jwt.entity.JWT;
import org.xdove.jwt.utils.algorithm.HMACSHA256;

/**
 * JWTBuilder工厂类
 * 负责创建JWTBuilder对象
 * @author Wszl
 * @date 2017年11月21日
 */
public class JWTBuilderFactory {
	public static JWTBuilder getInstance() {
		JWTBuilder builder = new JWTBuilder();

		return builder;
	}
}

package org.xdove.jwt;

import org.xdove.jwt.entity.common.JWT;
import org.xdove.jwt.exception.CryptException;
import org.xdove.jwt.utils.EncryptJwt;
import org.xdove.jwt.utils.algorithm.Algorithm;
import org.xdove.jwt.utils.algorithm.AlgorithmFactory;
import org.xdove.jwt.utils.algorithm.SignatureAlgorithm;

import java.util.Date;
import java.util.Map;

/**
 * jwt builder.
 * @author Wszl
 * @date 2017年11月21日
 */
public class JwtBuilder {

	/** JWT实例 */
	private JWT jwt;

	/** 签名算法*/
	private Algorithm alg;
	
	/** 签名密钥*/
	private byte[] key;


	public static final String DEFAULT_TYP = "JWT";

    public JwtBuilder() {
		super();
		this.jwt = new JWT();
		this.alg = AlgorithmFactory.getInstance(SignatureAlgorithm.HS256);
	}

	public JwtBuilder(JWT jwt, SignatureAlgorithm alg, byte[] key) {
        this.jwt = jwt;
        this.alg = AlgorithmFactory.getInstance(alg);
        this.key = key;
    }

    public static JwtBuilder construct() {
    	return new JwtBuilder();
	}

	public static JwtBuilder construct(JWT jwt, SignatureAlgorithm alg, byte[] key) {
		return new JwtBuilder(jwt, alg, key);
}

	public JwtBuilder build() {
		jwt.setAlg(alg.getName());
		jwt.setTyp(DEFAULT_TYP);

		jwt.setIat(new Date());
		return this;
	}

    public String compact() {
        if (key == null) {
        	throw new CryptException("密钥不能为null，请设置加密密钥。");
		}

		return EncryptJwt.encrypt(jwt, jwt.getHeader().getAlg(), key);
    }

	public JwtBuilder setKey(byte[] key, SignatureAlgorithm algorithm) {
        this.key = key;
        this.alg = AlgorithmFactory.getInstance(algorithm);
        return this;
	}

	public JwtBuilder add(String key, String value) {
    	jwt.getPayload().add(key, value);
		return this;
	}

	public JwtBuilder addSet(Map data) {
    	jwt.getPayload().add(data);
    	return this;
	}
}

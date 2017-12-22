package org.xdove.jwt;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xdove.jwt.entity.common.JWT;
import org.xdove.jwt.exception.CryptException;
import org.xdove.jwt.utils.Algorithm;
import org.xdove.jwt.utils.EncryptJWT;
import org.xdove.jwt.utils.SignatureAlgorithm;
import org.xdove.jwt.utils.algorithm.CommonAlgorithm;

import java.util.Date;

/**
 * JWT构建器
 * @author Wszl
 * @date 2017年11月21日
 */
public class JWTBuilder {

	private final Logger log = LoggerFactory.getLogger(JWTBuilder.class);

	/** JWT实例 */
	private JWT jwt;

	/** 签名算法*/
	private Algorithm alg;
	
	/** 签名密钥*/
	private byte[] key;


	public static final String DEFAULT_TYP = "JWT";

    public JWTBuilder() {
		super();
		this.jwt = new JWT();
		this.alg = CommonAlgorithm.getInstance(SignatureAlgorithm.HS256);
	}

	public JWTBuilder(JWT jwt, SignatureAlgorithm alg, byte[] key) {
        this.jwt = jwt;
        this.alg = CommonAlgorithm.getInstance(alg);
        this.key = key;
    }

    public static JWTBuilder construct() {
    	return new JWTBuilder();
	}

	public static JWTBuilder construct(JWT jwt, SignatureAlgorithm alg, byte[] key) {
		return new JWTBuilder(jwt, alg, key);
}

	public JWTBuilder build() {
		jwt.setAlg(alg.getName());
		jwt.setTyp(DEFAULT_TYP);

		jwt.setIat(new Date());
		return this;
	}

    public String compact() {
        if (key == null) {
            log.error("密钥不能为null, 请设置加密密钥，key={}", key);
        	throw new CryptException("密钥不能为null，请设置加密密钥。");
		}

		return EncryptJWT.encrypt(jwt, alg, key);
    }

    public JWT getJwt() {
		return jwt;
	}

	public void setJwt(JWT jwt) {
		this.jwt = jwt;
	}

	public byte[] getKey() {
		return key;
	}

	public void setKey(byte[] key) {
		this.key = key;
	}

	public Algorithm getAlg() {
		return alg;
	}

	public void setAlg(Algorithm alg) {
		this.alg = alg;
	}
}

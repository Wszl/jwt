package org.xdove.jwt;

import org.xdove.jwt.entity.JWT;
import org.xdove.jwt.exception.UnsupportedAlgorithmException;
import org.xdove.jwt.utils.Algorithm;
import org.xdove.jwt.utils.SignatureAlgorithm;
import org.xdove.jwt.utils.algorithm.HMACSHA256;

import com.alibaba.fastjson.JSONObject;

/**
 * JWT构建器
 * @author Wszl
 * @date 2017年11月21日
 */
public class JWTBuilder {
	
	/** JWTBuilder属性：JWT实例 */
	private JWT jwt;

	/** JWTBuilder属性：签名算法*/
	private SignatureAlgorithm alg;
	
	/** JWTBuilder属性：签名密钥*/
	private byte[] key;

	/** 默认签名算法 */
	public static final SignatureAlgorithm defAlg = SignatureAlgorithm.HS256;
	public static final String defType = "JWT";
	
    public JWTBuilder() {
		super();
		
		this.jwt = new JWT();

		this.alg = defAlg;	
	}

	public JWTBuilder(JWT jwt, SignatureAlgorithm alg, byte[] key) {
        this.jwt = jwt;
        this.alg = alg;
        this.key = key;
    }
	
	public JWT build() {
		jwt.setAlg(alg.name());
		jwt.setTyp(defType);
		return jwt;
	}

    public String compact() {
    	JSONObject 
    	jwt.setSignature(signature);
    }

    public JWT getJwt() {
		return jwt;
	}

	public void setJwt(JWT jwt) {
		this.jwt = jwt;
	}

	public SignatureAlgorithm getAlg() {
		return alg;
	}

	public void setAlg(SignatureAlgorithm alg) {
		this.alg = alg;
	}

	public byte[] getKey() {
		return key;
	}

	public void setKey(byte[] key) {
		this.key = key;
	}

}

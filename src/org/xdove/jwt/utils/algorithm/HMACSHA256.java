package org.xdove.jwt.utils.algorithm;

import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.xdove.jwt.entity.Header;
import org.xdove.jwt.entity.JWT;
import org.xdove.jwt.utils.Algorithm;

public final class HMACSHA256 implements Algorithm {
	
	public static final String NAME = "HmacSHA256";

	private byte[] key;

	private JWT jwt;

	public HMACSHA256() {
		super();
		
		this.key = Mac.getInstance(algorithm);
	}

	public HMACSHA256(byte[] key, JWT jwt) {
		this.key = key;
		this.jwt = jwt;
	}

	private byte[] signature(byte[] data) {
		try {
			SecretKeySpec signingKey = new SecretKeySpec(key, "HmacSHA256");
			Mac mac = Mac.getInstance("HmacSHA256");
			mac.init(signingKey);
			return mac.doFinal(data);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String build() {
		Base64.Encoder encoder = Base64.getEncoder();
		byte[] headerCrypt = encoder.encode(JSONObject.toJSONString(jwt.getHeader()).getBytes());
		byte[] payloadCrypt = encoder.encode(JSONObject.toJSONString(jwt.getPayload()).getBytes());

		byte[] jwtCrypt = signature((new String(headerCrypt) + new String(payloadCrypt)).getBytes());

		return new String(jwtCrypt);
	}

}

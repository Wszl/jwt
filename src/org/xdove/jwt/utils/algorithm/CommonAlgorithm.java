package org.xdove.jwt.utils.algorithm;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.xdove.jwt.utils.Algorithm;
import org.xdove.jwt.utils.SignatureAlgorithm;

public final class CommonAlgorithm implements Algorithm {

	private String alg;

	@Override
	public byte[] signature(byte[] data, byte[] key) {
		try {
			SecretKeySpec signingKey = new SecretKeySpec(key, alg);
			Mac mac = Mac.getInstance(alg);
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
	public String getName() {
		return alg;
	}

	public static Algorithm getInstance(SignatureAlgorithm algorithm) {
		CommonAlgorithm alg = new CommonAlgorithm();
		alg.setAlg(algorithm.getFullName());

		return alg;
	}

	public String getAlg() {
		return alg;
	}

	public void setAlg(String alg) {
		this.alg = alg;
	}
}

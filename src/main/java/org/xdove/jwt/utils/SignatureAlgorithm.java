package main.java.org.xdove.jwt.utils;

/**
 * 签名算法枚举类
 * @author Wszl
 * @date 2017年11月21日
 */
public enum SignatureAlgorithm {
	HS256("HmacSHA256");

	private String fullName;
	private SignatureAlgorithm(String name) {
		this.fullName = name;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
}

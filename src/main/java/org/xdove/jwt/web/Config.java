package org.xdove.jwt.web;

public class Config {
	public static final byte[] key;
	public static final String username = "test";
	public static final String password = "test";
	
	static {
		key = "test".getBytes();
	}
}

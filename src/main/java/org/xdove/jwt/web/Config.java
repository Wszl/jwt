package main.java.org.xdove.jwt.web;

import java.security.Key;
import java.security.KeyFactory;


public class Config {
	public static final byte[] key;
	public static final String username = "test";
	public static final String password = "test";
	
	static {
		key = "test".getBytes();
	}
}

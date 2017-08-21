package com.mf.util;

import org.apache.shiro.crypto.hash.Md5Hash;

public class Cryptography {

	/**
	 * MD5º”√‹À„∑®
	 * @param source
	 * @param salt
	 * @return
	 */
	public static String md5(String source,String salt){
		return new Md5Hash(source, salt).toString();
	}
	
	public static void main(String[] args) {
		System.out.println(Cryptography.md5("123456","1234"));
	}
}

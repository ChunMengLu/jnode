package com.lcm.jnode.utils;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Hex;

public class AESDecrypt {
	/**
	 * 加密
	 * 
	 * @param content
	 *            需要加密的内容
	 * @param password
	 *            加密密码
	 * @return
	 */
	public static String encrypt(String content, String password) throws Exception{
			//指定一个算法生成KeyGenerator对象，这里使用 AES 算法
			KeyGenerator kgen = KeyGenerator.getInstance("AES");
			//SecureRandom,此类提供加密的强随机数生成器
			//用指定参数集和用户提供的随机源初始化此密钥生成器
			kgen.init(128, new SecureRandom(password.getBytes()));
			//kgen.generateKey()生成一个密钥
			SecretKey secretKey = kgen.generateKey();
			//返回基本编码格式的密钥，如果此密钥不支持编码，则返回 null
			byte[] enCodeFormat = secretKey.getEncoded();
			//根据给定的字节数组构造一个密钥
			SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");
			//生成一个实现指定转换的 Cipher 对象
			Cipher cipher = Cipher.getInstance("AES");// 创建密码器
			byte[] byteContent = content.getBytes("utf-8");
			//用密钥初始化此 cipher
			cipher.init(Cipher.ENCRYPT_MODE, key);
			//按单部分操作加密或解密数据，或者结束一个多部分操作,数据被加密还是解密取决于此 cipher 的初始化方式 
			byte[] result = cipher.doFinal(byteContent);
			return Hex.encodeHexString(result); // 加密,生成密钥内容
	}

	/**
	 * 解密
	 * 
	 * @param content
	 *            待解密内容
	 * @param password
	 *            解密密钥
	 * @return
	 */
	public static String decrypt(String content, String password) throws Exception {
			KeyGenerator kgen = KeyGenerator.getInstance("AES");
			kgen.init(128, new SecureRandom(password.getBytes()));
			SecretKey secretKey = kgen.generateKey();
			byte[] enCodeFormat = secretKey.getEncoded();
			SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");
			Cipher cipher = Cipher.getInstance("AES");// 创建密码器
			cipher.init(Cipher.DECRYPT_MODE, key);// 初始化
			byte[] result = cipher.doFinal(Hex.decodeHex(content.toCharArray()));
			return new String(result); // 加密
	}

	public static void main(String[] args) {
		String content = "so good";
		String password = "12345678";
		// 加密
		System.out.println("加密前：" + content);
		String code = null;
		try {
			code = encrypt(content, password);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		System.out.println("加密后：" + code);
		
		// 解密
		try {
			String decryptResult = decrypt(code, password);
			System.out.println("解密后：" + decryptResult);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
package com.lcm.jnode.utils;


import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

import org.apache.commons.codec.binary.Base64;

/**
 * 
 * DES 加密工具类
 * 
 * @author "JakeLiu"
 * @version Jun 30, 2012 10:59:55 AM
 * @see DESUtils
 * @since 1.0.0
 */
public class DESUtils {

	// 指定DES加密解密所用的密钥
	private static Key key;

	/**
	 * 加密key为空
	 */
	public DESUtils() {
		setkey(ConfigUtil.get("secret"));
	}

	/**
	 * 设置加密key
	 * 
	 * @param keyStr
	 *            加密key值
	 */
	public DESUtils(String keyStr) {
		setkey(keyStr);
	}

	/**
	 * 设置加密的校验码
	 * 
	 * @Author:dot
	 * @Date:2012-10-16 下午04:25:13
	 * @ClassDescription:
	 */
	private void setkey(String keyStr) {
		try {
			DESKeySpec objDesKeySpec = new DESKeySpec(keyStr.getBytes("UTF-8"));
			SecretKeyFactory objKeyFactory = SecretKeyFactory.getInstance("DES");
			key = objKeyFactory.generateSecret(objDesKeySpec);

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	// 对字符串进行DES加密，返回BASE64编码的加密字符串
	public final String encryptString(String str) {

		byte[] bytes = str.getBytes();
		try {
			Cipher cipher = Cipher.getInstance("DES");
			cipher.init(Cipher.ENCRYPT_MODE, key);
			byte[] encryptStrBytes = cipher.doFinal(bytes);
			return Base64.encodeBase64String(encryptStrBytes);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	// 对BASE64编码的加密字符串进行解密，返回解密后的字符串
	public final String decryptString(String str) {
		try {
			byte[] bytes = Base64.decodeBase64(str);
			Cipher cipher = Cipher.getInstance("DES");
			cipher.init(Cipher.DECRYPT_MODE, key);
			bytes = cipher.doFinal(bytes);
			return new String(bytes);
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}

	// 提供main函数，方便转换加密字符
	public static void main(String[] args) {
//		DESUtils utils= new DESUtils("132132");
//		System.out.println(utils.encryptString("123123123123123"));
//		System.out.println(utils.decryptString("z150xXvVC/rAWcN0w8HsEoMv20eOsZNABi3g9ciH6cY7zyX3lvikh96sck0dR8Gx3R96QMo+fW8udZmP7kLt81iq51Qmw9q/Fr2YJjhZQexjsjfW8BYSHWVsMb/OGCA9vrY2gbRVK5MnlVx1vo/1GKIMSbr3ZpOajuo5ZQNXXwwIBj86/YpymoHeh4s8sbTy/rsvxOntJF46FzeW76xwKC2g3aid1UutbySAp1GLgHxxmUdf7EubSXvhbDXOa8zTDxANkQw+gOWr3VXlHJ8rdWnMOUUav9ogqdWvrJgIss/19B4sChCWcmViUOttQUjDt+1dQPOSSvPpjYA52SrGkyLp8U6FDX2A7ZVxb6mnPH1xQcq1FHIHyMIvJhKex5PRFpynWMxnPI48yQTh49NpkbCpe+VVY/qBfKJmpiTe0mQzAoJb028AjyXjHiB4sN68grNVKACuCM0VoT0Jmu/XiA=="));
	}

}

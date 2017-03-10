package org.simon.zhao.java.security.encryption;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 * Created by zhou01.zhao on 2017/1/10.
 */
public class HMACSHA1 {

	public static final String MAC_NAME = "HmacSHA256";
	public static final String ENCODING = "UTF-8";

	public static final String DEFAULT_KEY = "C63Uo4suTzDJxz8VgR2Ln1P+wO7D5luBPMZAOKjP66E=";


	/**
	 * 使用 HMAC-SHA1 签名方法对对encryptText进行签名
	 * @param encryptText 被签名的字符串
	 * @param encryptKey  密钥
	 * @return
	 * @throws Exception
	 */
	public static byte[] HmacSHA1Encrypt(String encryptText, String encryptKey) throws Exception
	{
		byte[] data=encryptKey.getBytes(ENCODING);
		//根据给定的字节数组构造一个密钥,第二参数指定一个密钥算法的名称
		SecretKey secretKey = new SecretKeySpec(data, MAC_NAME);
		//生成一个指定 Mac 算法 的 Mac 对象
		Mac mac = Mac.getInstance(MAC_NAME);
		//用给定密钥初始化 Mac 对象
		mac.init(secretKey);

		byte[] text = encryptText.getBytes(ENCODING);
		//完成 Mac 操作
		return mac.doFinal(text);
	}
}

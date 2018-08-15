package com.ph.shopping.common.util;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;

import javax.crypto.Cipher;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.spec.X509EncodedKeySpec;


/**
 * RSA公钥/私钥/签名工具包 罗纳德·李维斯特（Ron [R]ivest）、阿迪·萨莫尔（Adi [S]hamir）和伦纳德·阿德曼（Leonard
 * [A]dleman） 字符串格式的密钥在未在特殊说明情况下都为BASE64编码格式<br/>
 * 由于非对称加密速度极其缓慢，一般文件不使用它来加密而是使用对称加密，<br/>
 * 非对称加密算法可以用来对对称加密的密钥加密，这样保证密钥的安全也就保证了数据的安全
 */
public class RSAUtils {
	
//	private static String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCa90rmouOslXTDSUTXu/jcBHaeoALfsUTVsSqzITAiUVXUlRMz1xb2SbAAQO9eFs7oH0mXW/scZRpjUJmp2ofl8mCkDnYO5OCGgeqChT2ACFNYiSApCDpXWhQes+K2TWsDcRIJ01c+OKhlGRnIQFizmfG8Kf5Ik4HozrF6d7QwdQIDAQAB";

	public static enum CharSet {
		/**
		 * UTF8 字符编码集
		 */
		UTF8 {
			@Override
            public String getName() {
				return "UTF-8";
			}
		};
		public abstract String getName();
	}
	/**
	 * 加密算法RSA
	 */
	public static final String KEY_ALGORITHM = "RSA";

	/**
	 * 签名算法
	 */
	public static final String SIGNATURE_ALGORITHM = "MD5withRSA";

	/**
	 * RSA最大加密明文大小
	 */
	private static final int MAX_ENCRYPT_BLOCK = 117;

	/**
	 * RSA最大解密密文大小
	 */
	private static final int MAX_DECRYPT_BLOCK = 128;
	
	/**
	 * 根据公钥加密
	 * @param content 需加密内容
	 * @param charSet 字符集编码格式
	 * @return
	 */
	public static String encryptByPublicKey(String content,String publicKey, CharSet charSet) {
		byte[] b=null;
		try {
			b = encrypt(content.getBytes(charSet.getName()),true,publicKey);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("不支持的编码格式，错误信息"+e.getMessage());	
		}
		return bytesToString(b);
	}
	
	/**
	 * 根据公钥加密生成sgin验签值
	 * @param orderNum 商户自定义订单号
	 * @param totalFee 商品总额
	 * @param bankNo  银行卡号
	 * @param merchantNo 商户号
	 * @param charSet UTF-8
	 * @return null值: 生成失败.
	 */
	public static String sgin(String orderNum, Integer totalFee,String bankNo,String merchantNo,String publicKey, CharSet charSet) {
		byte[] b=null;
		if (StrShyUtil.empty(orderNum)
			||	StrShyUtil.empty(totalFee)
			||	StrShyUtil.empty(bankNo)
			||	StrShyUtil.empty(merchantNo)
			||	StrShyUtil.empty(charSet)) {
            return null;
        }
		String content = orderNum+"&"+totalFee+"&"+bankNo+"&"+merchantNo;
		try {
			b = encrypt(content.getBytes(charSet.getName()),true,publicKey);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("不支持的编码格式，错误信息"+e.getMessage());	
		}
		return bytesToString(b);
	}
	/**
	 * 字节数组转换为字符串
	 * @param decrytString
	 * @return
	 */
	private  static String bytesToString(byte[] encrytpByte) {
		char[] charHex=Hex.encodeHex(encrytpByte);
		return new String(charHex);
	}
	/**
	 * 加密
	 * @param data
	 * @return
	 */
	private static byte[] encrypt(byte[] data,boolean isPublicKey,String publicKey) {
		isPublicKey = true;
		try {
			if(isPublicKey){
				return RSAUtils.encryptByPublicKey(data, publicKey);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("加密失败，错误信息"+e.getMessage());
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * <p>
	 * 校验数字签名
	 * </p>
	 * 
	 * @param data 加密数据
	 * @param publicKey 公钥(BASE64编码)
	 * @param sign 数字签名
	 * 
	 * @return
	 * @throws Exception
	 * 
	 */
	public static boolean verify(String sign,String publicKey,CharSet charSet) {
		try {
			decryptByPublicKey(sign, publicKey,charSet);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}


	/**
	 * <p>
	 * 公钥解密
	 * </p>
	 * 
	 * @param encryptedData 已加密数据
	 * @param publicKey 公钥(BASE64编码)
	 * @return
	 * @throws Exception
	 */
	public static byte[] decryptByPublicKey(byte[] encryptedData, String publicKey)
			throws Exception {
		byte[] keyBytes = EncodeUtils.base64Decode(publicKey);
		X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(keyBytes);
		KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
		Key publicK = keyFactory.generatePublic(x509KeySpec);
		Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
		cipher.init(Cipher.DECRYPT_MODE, publicK);
		int inputLen = encryptedData.length;
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		int offSet = 0;
		byte[] cache;
		int i = 0;
		// 对数据分段解密
		while (inputLen - offSet > 0) {
			if (inputLen - offSet > MAX_DECRYPT_BLOCK) {
				cache = cipher.doFinal(encryptedData, offSet, MAX_DECRYPT_BLOCK);
			} else {
				cache = cipher.doFinal(encryptedData, offSet, inputLen - offSet);
			}
			out.write(cache, 0, cache.length);
			i++;
			offSet = i * MAX_DECRYPT_BLOCK;
		}
		byte[] decryptedData = out.toByteArray();
		out.close();
		return decryptedData;
	}
	/**
	 * 字符串转换成为字节数组
	 * @param decrytString
	 * @return
	 */
	private  static byte[] stringToBytes(String decrytString) {
		 
		char[] charHex=decrytString.toCharArray();
		byte[] clone=null;
		try {
			clone = Hex.decodeHex(charHex);
		} catch (DecoderException e) {
			e.printStackTrace();
		}		
		return clone;
	}
	/**
	 * <p>
	 * 公钥加密
	 * </p>
	 * 
	 * @param data 源数据
	 * @param publicKey 公钥(BASE64编码)
	 * @return
	 * @throws Exception
	 */
	public static byte[] encryptByPublicKey(byte[] data, String publicKey) throws Exception {
		byte[] keyBytes = EncodeUtils.base64Decode(publicKey);
		X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(keyBytes);
		KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
		Key publicK = keyFactory.generatePublic(x509KeySpec);
		// 对数据加密
		Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
		cipher.init(Cipher.ENCRYPT_MODE, publicK);
		int inputLen = data.length;
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		int offSet = 0;
		byte[] cache;
		int i = 0;
		// 对数据分段加密
		while (inputLen - offSet > 0) {
			if (inputLen - offSet > MAX_ENCRYPT_BLOCK) {
				cache = cipher.doFinal(data, offSet, MAX_ENCRYPT_BLOCK);
			} else {
				cache = cipher.doFinal(data, offSet, inputLen - offSet);
			}
			out.write(cache, 0, cache.length);
			i++;
			offSet = i * MAX_ENCRYPT_BLOCK;
		}
		byte[] encryptedData = out.toByteArray();
		out.close();
		return encryptedData;
	}
	/**
	 * 根据公钥解密字符串
	 * @param content
	 * @param charSet
	 * @return
	 */
	public  static String decryptByPublicKey(String content,String publicKey, CharSet charSet) {
		 
		byte[] b = decrypt(stringToBytes(content),publicKey);
		try {
			return new String(b, charSet.getName());
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 解密
	 * @param data
	 * @return
	 */
	private static byte[] decrypt(byte[] data,String publicKey) {
		try {
				return RSAUtils.decryptByPublicKey(data, publicKey);
		} catch (Exception e) {
			e.printStackTrace();
		}
		 
		return null;
	}
}

package application;

import java.security.SecureRandom;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

//密钥必须为8的倍数
public class DES {
	 public static String encrypt(String content, String key) {
	        try {
	            SecureRandom random = new SecureRandom();
	            DESKeySpec desKey = new DESKeySpec(key.getBytes("UTF-8"));
	            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
	            SecretKey securekey = keyFactory.generateSecret(desKey);
	            Cipher cipher = Cipher.getInstance("DES");
	            cipher.init(Cipher.ENCRYPT_MODE, securekey, random);
	            byte[] result = cipher.doFinal(content.getBytes("UTF-8"));
	            return Base64.getEncoder().encodeToString(result);
	        } catch (Throwable e) {
	            e.printStackTrace();
	        }
	        return null;
	    }


	    public static String decrypt(String content, String key) {
	        try {
	            SecureRandom random = new SecureRandom();
	            DESKeySpec desKey = new DESKeySpec(key.getBytes("UTF-8"));
	            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
	            SecretKey securekey = keyFactory.generateSecret(desKey);
	            Cipher cipher = Cipher.getInstance("DES");
	            cipher.init(Cipher.DECRYPT_MODE, securekey, random);
	            byte[] result = cipher.doFinal(content.getBytes("UTF-8"));
	            return Base64.getEncoder().encodeToString(result);
	        } catch (Throwable e) {
	            e.printStackTrace();
	        }
	        return null;
	    }
	}

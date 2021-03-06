package application;

import java.security.Key;  

import javax.crypto.Cipher;  
import javax.crypto.spec.SecretKeySpec;  
  
import sun.misc.BASE64Decoder;  
import sun.misc.BASE64Encoder; 

public class AES {
	
	 // 加密算法  
    private String ALGO;  
  
    // 加密密钥  
    // 16位的加密密钥  
    private byte[] keyValue;  
  
   
    public String encrypt(String Data) throws Exception {  
        Key key = generateKey();  
        Cipher c = Cipher.getInstance(ALGO);  
        c.init(Cipher.ENCRYPT_MODE, key);  
        byte[] encVal = c.doFinal(Data.getBytes());  
        String encryptedValue = new BASE64Encoder().encode(encVal);  
        return encryptedValue;  
    }  
  
    /** 
     * 用来进行解密的操作 
     *  
     * @param encryptedData 
     * @return 
     * @throws Exception 
     */  
    public String decrypt(String encryptedData) throws Exception {  
        Key key = generateKey();  
        Cipher c = Cipher.getInstance(ALGO);  
        c.init(Cipher.DECRYPT_MODE, key);  
        byte[] decordedValue = new BASE64Decoder().decodeBuffer(encryptedData);  
        byte[] decValue = c.doFinal(decordedValue);  
        String decryptedValue = new String(decValue);  
        return decryptedValue;  
    }  
  
    /** 
     * 根据密钥和算法生成Key 
     *  
     * @return 
     * @throws Exception 
     */  
    private Key generateKey() throws Exception {  
        Key key = new SecretKeySpec(keyValue, ALGO);  
        return key;  
    }  
  
    public String getALGO() {  
        return ALGO;  
    }  
  
    public void setALGO(String aLGO) {  
        ALGO = aLGO;  
    }  
  
    public byte[] getKeyValue() {  
        return keyValue;  
    }  
  
    public void setKeyValue(byte[] keyValue) {  
        this.keyValue = keyValue;  
    }  
}

package application;

import java.security.Key;  

import javax.crypto.Cipher;  
import javax.crypto.spec.SecretKeySpec;  
  
import sun.misc.BASE64Decoder;  
import sun.misc.BASE64Encoder; 

public class AES {
	
	 // �����㷨  
    private String ALGO;  
  
    // ������Կ  
    // 16λ�ļ�����Կ  
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
     * �������н��ܵĲ��� 
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
     * ������Կ���㷨����Key 
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

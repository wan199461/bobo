package com.wanbo.cipher;

import java.security.KeyFactory;
import java.security.KeyPair; 
import java.security.KeyPairGenerator; 
import java.security.PrivateKey; 
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Arrays; 
  
import javax.crypto.Cipher;

import org.apache.commons.codec.binary.Base64;

public class RSAUtils {
    
    public static final String KEY_ALGORITHM = "RSA"; 
    public static final String CIPHER_ALGORITHM_ECB1 = "RSA/ECB/PKCS1Padding"; 
    public static final String CIPHER_ALGORITHM_ECB2 = "RSA/ECB/OAEPWithSHA-1AndMGF1Padding"; //不能用 
    public static final String CIPHER_ALGORITHM_ECB3 = "OAEPWithSHA-256AndMGF1Padding"; //不能用 
     
    static PublicKey publicKey; 
    static PrivateKey privateKey; 
    static Cipher cipher; 
    static KeyPair keyPair; 
     
    public static void main(String[] args) throws Exception { 
    method1("斯柯达U*(Sfsad7f()*^%%$"); 
//    method2("斯柯达U*(Sfsad7f()*^%%$"); 
//    method3("斯柯达U*(Sfsad7f()*^%%$"); 
      
    } 
     
    /** 
    * 公钥加密，私钥解密 使用默认CIPHER_ALGORITHM_ECB1 
    * @param str 
    * @throws Exception 
    */
    static void method1(String str) throws Exception { 
    KeyPairGenerator keyGenerator = KeyPairGenerator.getInstance(KEY_ALGORITHM); 
    keyGenerator.initialize(512);  //指定密钥长度
    KeyPair keyPair = keyGenerator.generateKeyPair(); 
    publicKey = keyPair.getPublic(); 
    privateKey = keyPair.getPrivate(); 
    
    String[] couple = printKey(publicKey, privateKey);
    
    privateKey = loadPrivateKey(couple[1]);
    publicKey = loadPublicKey(couple[0]);
    
    cipher = Cipher.getInstance(KEY_ALGORITHM); 
    cipher.init(Cipher.ENCRYPT_MODE, publicKey); //公钥加密 
    byte[] encrypt = cipher.doFinal(str.getBytes()); 
    System.out.println("公钥加密后1：" + Arrays.toString(encrypt)); 
      
    cipher.init(Cipher.DECRYPT_MODE, privateKey);//私钥解密 
    byte[] decrypt = cipher.doFinal(encrypt); 
    System.out.println("私钥解密后1：" + new String(decrypt)); 
    } 
     

    /** 
    * 私钥加密，公钥解密 使用默认CIPHER_ALGORITHM_ECB1 
    * @param str 
    * @throws Exception 
    */
    static void method2(String str) throws Exception { 
    KeyPairGenerator keyGenerator = KeyPairGenerator.getInstance(KEY_ALGORITHM); 
    KeyPair keyPair = keyGenerator.generateKeyPair(); 
    publicKey = keyPair.getPublic(); 
    privateKey = keyPair.getPrivate(); 
    cipher = Cipher.getInstance(KEY_ALGORITHM); 
    cipher.init(Cipher.ENCRYPT_MODE, privateKey); //私钥加密 
    byte[] encrypt = cipher.doFinal(str.getBytes()); 
    System.out.println("私钥加密后2：" + Arrays.toString(encrypt)); 
      
    cipher.init(Cipher.DECRYPT_MODE, publicKey);//公钥解密 
    byte[] decrypt = cipher.doFinal(encrypt); 
    System.out.println("公钥解密后2：" + new String(decrypt)); 
    } 
     
    /** 
    * 私钥加密，公钥解密 使用CIPHER_ALGORITHM_ECB1 = RSA/ECB/PKCS1Padding 
    * @param str 
    * @throws Exception 
    */
    static void method3(String str) throws Exception { 
    KeyPairGenerator keyGenerator = KeyPairGenerator.getInstance(KEY_ALGORITHM); 
    KeyPair keyPair = keyGenerator.generateKeyPair(); 
    publicKey = keyPair.getPublic(); 
    privateKey = keyPair.getPrivate(); 
    cipher = Cipher.getInstance(CIPHER_ALGORITHM_ECB1); 
    cipher.init(Cipher.ENCRYPT_MODE, privateKey); //私钥加密 
    byte[] encrypt = cipher.doFinal(str.getBytes()); 
    System.out.println("私钥加密后3：" + Arrays.toString(encrypt)); 
      
    cipher.init(Cipher.DECRYPT_MODE, publicKey);//公钥解密 
    byte[] decrypt = cipher.doFinal(encrypt); 
    System.out.println("公钥解密后3：" + new String(decrypt)); 
    } 
    
    
    private static String[] printKey(PublicKey publicKey2, PrivateKey privateKey2) {
        byte[] pub = publicKey2.getEncoded();
        byte[] prb = privateKey2.getEncoded();
        System.out.println("Public Size:" + pub.length);
        System.out.println("Private Size:" + prb.length);
        
        String[] pairs = {new String(pub), new String(prb)};
        return pairs;
    }
    
    
    //构造私钥对象
    public static PrivateKey loadPrivateKey(String privateKey)  throws Exception    {
                    //  解密由base64编码的私钥
                    byte[]  keyBytes = Base64.decodeBase64(privateKey);
                    //  构造PKCS8EncodedKeySpec对象
                    PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(keyBytes);
                    //  KEY_ALGORITHM   指定的加密算法
                    KeyFactory keyFactory = KeyFactory.getInstance("RSA");
                    //  取私钥匙对象
                    return keyFactory.generatePrivate(pkcs8KeySpec);
    }
    
    
    public static PublicKey loadPublicKey(String publicKey) throws Exception  {
        byte[]  buffer = Base64.decodeBase64(publicKey);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(buffer);
        return keyFactory.generatePublic(keySpec);
}

}

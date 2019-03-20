package com.wanbo.cipher;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RsaSignUtils {
    

    
    private static Logger LOGGER = LoggerFactory.getLogger(RsaSignUtils.class);
   
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
   
   
   /**
    *  构造公钥对象
    * @param publicKey  字符串公钥
    * @return           公钥对象
    * @throws Exception
    */
   public static PublicKey loadPublicKey(String publicKey) throws Exception    {
                   byte[]  buffer = Base64.decodeBase64(publicKey);
                   KeyFactory keyFactory = KeyFactory.getInstance("RSA");
                   X509EncodedKeySpec keySpec = new X509EncodedKeySpec(buffer);
                   return keyFactory.generatePublic(keySpec);
   }
   
   
   /**
    *  
    *   读取公私钥件
    * @param keyFile  文件位置
    * @return         密钥
    * @throws Exception
    */
   public static String readKeyFile(String keyFile) throws Exception {
       BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(keyFile)));
       String readLine = null;
       StringBuilder sb = new StringBuilder();
       while ((readLine = br.readLine()) != null) {
           if (readLine.charAt(0) != '-') {
               sb.append(readLine);
               sb.append(System.getProperty("line.separator"));
           }
       }
       return sb.toString();
   }
   
   
   /**
    *  读取密钥 
    * @param keyStr  包含分隔符密钥
    * @return        字符串密钥
    * @throws Exception
    */
   public static String readKeyStr(String keyStr) throws Exception {
       String[] lines = keyStr.trim().split("\n");
       StringBuilder sb = new StringBuilder();
       for (String line : lines) {
           String readLine = line.trim();
           if (readLine.charAt(0) != '-') {
               sb.append(readLine);
               sb.append(System.getProperty("line.separator"));
           }
       }
       return sb.toString();
   }
   
   
   // rsa加密
   public static byte[] rsaEncrypt(RSAPublicKey publicKey, byte[] plainTextData) throws Exception {
       Cipher cipher = Cipher.getInstance("RSA");
       cipher.init(Cipher.ENCRYPT_MODE, publicKey);
       return cipher.doFinal(plainTextData);
   }

   
   // rsa解密
   public static byte[] rsaDecrypt(RSAPrivateKey privateKey, byte[] cipherData) throws Exception {
       Cipher cipher = Cipher.getInstance("RSA");
       cipher.init(Cipher.DECRYPT_MODE, privateKey);
       return cipher.doFinal(cipherData);
   }
   
   
   // rsa 签名
   public static String rsaSign(PrivateKey privateKey, String plainText) throws Exception {
       Signature sig = Signature.getInstance("SHA1WithRSA");
       sig.initSign(privateKey);
       byte[] plainTextData = plainText.getBytes("UTF-8");
       sig.update(plainTextData);
       byte[] signature = sig.sign();
       return Base64.encodeBase64String(signature);
   }
   
   // rsa 签名验证
   public static boolean rsaSignCheck(PublicKey publicKey, String plainText, String sign) {
       try {
           Signature sig = Signature.getInstance("SHA1WithRSA");
           sig.initVerify(publicKey);
           byte[] plainTextData = plainText.getBytes("UTF-8");
           sig.update(plainTextData);
           byte[] signature = Base64.decodeBase64(sign);
           return sig.verify(signature);
       } catch (Exception e) {
           e.printStackTrace();
           LOGGER.error("rsaSignCheck: param={},   sign={}", plainText, sign);
       }
       return false;
   }

   
   public static void main(String[] args) throws Exception {
/*       String publicKeyFile = OutRequestService.class.getResource("/rsa_public_key.pem").getPath();
       String privateKeyFile = OutRequestService.class.getResource("/rsa_private_key_pkcs8.pem").getPath();*/
       String plainText = "Hello FinTell";
       
//       String privateKeyString = readKeyFile(privateKeyFile);
       
       String privateKeyString = "";
       System.out.println("privateKeyString:" + privateKeyString); 
       PrivateKey privateKey = loadPrivateKey(privateKeyString);
       String signResult = rsaSign(privateKey, plainText);
       System.out.println("signResult:" + signResult);
       
//       String publicKeyString = readKeyFile(publicKeyFile);
       
        String publicKeyString = "";
       System.out.println("publicKey:" + publicKeyString);
       PublicKey publicKey = loadPublicKey(publicKeyString);
       boolean signCheckResult = rsaSignCheck(publicKey, plainText, signResult);
       
       
       
       System.out.println("signCheckResult:" + signCheckResult);
       
       
       
   }
}

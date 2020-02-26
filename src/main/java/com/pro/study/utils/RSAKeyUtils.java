package com.pro.study.utils;

import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import org.apache.commons.codec.binary.Base64;
/** 
* @author: wgl
* @date: 2020年2月23日下午3:24:08 
* @version:1.0
* @Description: RSA生成公钥私钥工具
*/
public class RSAKeyUtils {

	public static final String KEY_ALGORITHM = "RSA";
    public static final String PUBLIC_KEY = "RSAPublicKey";
    public static final String PRIVATE_KEY = "RSAPrivateKey";
    public static final String SIGNATURE_ALGORITHM="MD5withRSA";
    
    
    public static void main(String[] args) {
    	//创建一个map用来保存公钥私钥
        HashMap<String, String> keyMap = new HashMap<String,String>();
        //生成公钥和私钥
        genKeyPair(keyMap);
        //加密字符串
        String message = "{\"name\":\"wgl\",\"name1\":\"wgl\",\"name2\":\"wgl\",\"name3\":\"wgl\",\"name4\":\"wgl\",\"name5\":\"wgl\",\"name6\":\"wgl\",\"name7\":\"wgl\",\"name8\":\"wgl\",\"name9\":\"wgl\",\"name0\":\"wgl\",\"name12\":\"wgl\",\"name13\":\"wgl\",\"name14\":\"wgl\",\"name15\":\"wgl\",\"name16\":\"wgl\",\"name17\":\"wgl\",\"name18\":\"wgl\",\"name19\":\"wgl\",\"name20\":\"wgl\",\"name21\":\"wgl\",\"name22\":\"wgl\",\"name23\":\"wgl\",\"name24\":\"wgl\",\"name25\":\"wgl\"}";
        System.out.println("随机生成的公钥为:" + keyMap.get(PUBLIC_KEY));
        System.out.println("随机生成的私钥为:" + keyMap.get(PRIVATE_KEY));
        String messageEn = encrypt(message, keyMap.get(PUBLIC_KEY));
        System.out.println("加密后的字符串为:" + messageEn);
        String messageDe = decrypt(messageEn, keyMap.get(PRIVATE_KEY));
        System.out.println("还原后的字符串为:" + messageDe);
    }
    
    //随机生成密钥对
    public static void genKeyPair(Map<String,String> keyMap) {
    	//用来保存生成的Rsa公钥私钥
        // KeyPairGenerator类用于生成公钥和私钥对，基于RSA算法生成对象
        KeyPairGenerator keyPairGen = null;
        
        try {
            keyPairGen = KeyPairGenerator.getInstance("RSA");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        
        // 初始化密钥对生成器，密钥大小为96-1024位
        assert keyPairGen != null;
        keyPairGen.initialize(1024, new SecureRandom());
        // 生成一个密钥对，保存在keyPair中
        KeyPair keyPair = keyPairGen.generateKeyPair();
        RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();   // 得到私钥
        RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();  // 得到公钥
        String publicKeyString = new String(Base64.encodeBase64(publicKey.getEncoded()));
        // 得到私钥字符串
        String privateKeyString = new String(Base64.encodeBase64((privateKey.getEncoded())));
        // 将公钥和私钥保存到Map
        keyMap.put(PUBLIC_KEY, publicKeyString);
        keyMap.put(PRIVATE_KEY, privateKeyString);
    }
    
    /** RSA公钥加密
     * @param str  加密字符串
     * @param publicKey  公钥
     * @return  密文
     */
    public static String encrypt(String str, String publicKey) {
        //base64编码的公钥
        byte[] decoded = Base64.decodeBase64(publicKey);
        RSAPublicKey pubKey = null;
        String outStr = null;
        
        try {
            pubKey = (RSAPublicKey) KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(decoded));
            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.ENCRYPT_MODE, pubKey);
            outStr = Base64.encodeBase64String(cipher.doFinal(str.getBytes(StandardCharsets.UTF_8)));
        } catch (InvalidKeySpecException | BadPaddingException | IllegalBlockSizeException | InvalidKeyException | NoSuchPaddingException | NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        //RSA加密
        return outStr;
    }
    
    /**  RSA私钥解密
     * @param str   加密字符串
     * @param privateKey  私钥
     * @return  铭文
     */
    public static String decrypt(String str, String privateKey) {
        //64位解码加密后的字符串
        byte[] inputByte = Base64.decodeBase64(str.getBytes(StandardCharsets.UTF_8));
        //base64编码的私钥
        byte[] decoded = Base64.decodeBase64(privateKey);
        RSAPrivateKey priKey = null;
        //RSA解密
        Cipher cipher = null;
        String outStr = null;
        
        try {
            priKey = (RSAPrivateKey) KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(decoded));
            cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.DECRYPT_MODE, priKey);
            outStr = new String(cipher.doFinal(inputByte));
        } catch (InvalidKeySpecException | NoSuchAlgorithmException | NoSuchPaddingException | BadPaddingException | IllegalBlockSizeException | InvalidKeyException e) {
            e.printStackTrace();
        }
        return outStr;
    }
}

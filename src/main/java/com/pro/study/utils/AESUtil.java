package com.pro.study.utils;

import org.springframework.util.Base64Utils;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/** 
 * @author: wgl
 * @date: 2020年2月24日上午10:28:55 
 * @version:1.0
 * @Description: AES加密工具
 */
public class AESUtil {

    private static final String KEY_ALGORITHM = "AES";
    private static final String DEFAULT_CIPHER_ALGORITHM = "AES/ECB/PKCS5Padding";//默认的加密算法

    /**
     * AES 加密操作
     *
     * @param content  待加密内容
     * @param password 加密密码
     * @return 返回Base64转码后的加密数据
     */
    public static String encrypt(String content, String password) {
        try {
            Cipher cipher = Cipher.getInstance(DEFAULT_CIPHER_ALGORITHM);// 创建密码器

            byte[] byteContent = content.getBytes("utf-8");

            cipher.init(Cipher.ENCRYPT_MODE, getSecretKey(password));// 初始化为加密模式的密码器

            byte[] result = cipher.doFinal(byteContent);// 加密

            return Base64Utils.encodeToString(result);//通过Base64转码返回
        } catch (Exception ex) {
            Logger.getLogger(AESUtil.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    /**
     * AES 解密操作
     *
     * @param content
     * @param password
     * @return
     */
    public static String decrypt(String content, String password) {

        try {
            //实例化
            Cipher cipher = Cipher.getInstance(DEFAULT_CIPHER_ALGORITHM);

            //使用密钥初始化，设置为解密模式
            cipher.init(Cipher.DECRYPT_MODE, getSecretKey(password));

            //执行操作
            byte[] result = cipher.doFinal(Base64Utils.decodeFromString(content));

            return new String(result, "utf-8");
        } catch (Exception ex) {
            Logger.getLogger(AESUtil.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    /**
     * 生成加密秘钥
     *
     * @return
     */
    private static SecretKeySpec getSecretKey(String password) {
        //返回生成指定算法密钥生成器的 KeyGenerator 对象
        KeyGenerator kg = null;
        try {
            kg = KeyGenerator.getInstance(KEY_ALGORITHM);
            //AES 要求密钥长度为 128
            kg.init(128, new SecureRandom(password.getBytes()));
            //生成一个密钥
            SecretKey secretKey = kg.generateKey();
            return new SecretKeySpec(secretKey.getEncoded(), KEY_ALGORITHM);// 转换为AES专用密钥
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(AESUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    /**
     * byte数组转化为16进制字符串
     * @param bytes
     * @return
     */
     public static String byteToHexString(byte[] bytes) {
       StringBuffer sb = new StringBuffer();
       for (int i = 0; i < bytes.length; i++) {
         String strHex=Integer.toHexString(bytes[i]);
         if(strHex.length() > 3) {
           sb.append(strHex.substring(6));
         } else {
           if(strHex.length() < 2) {
             sb.append("0" + strHex);
           } else {
             sb.append(strHex);
           }
         }
       }
       return sb.toString();
     }
     
    /**
     * 
     * @Description:（AES秘钥生成） 
        *  方法返回值:
     */
    public static String getKey() {
        try {
          KeyGenerator kg = KeyGenerator.getInstance("AES");
          kg.init(128);
          //要生成多少位，只需要修改这里即可128, 192或256
          SecretKey sk = kg.generateKey();
          byte[] b = sk.getEncoded();
          String s = byteToHexString(b);
          System.out.println(s);
//          System.out.println("十六进制密钥长度为"+s.length());
//          System.out.println("二进制密钥的长度为"+s.length()*4);
          return s;
        }
        catch (NoSuchAlgorithmException e) {
          e.printStackTrace();
          System.out.println("没有此算法。");
          return null;
        }
      }
    
    /**
         * 使用指定的字符串生成秘钥
     */
     public static void getKeyByPass() {
       //生成秘钥
       String password="testkey";
       try {
         KeyGenerator kg = KeyGenerator.getInstance("AES");
         // kg.init(128);//要生成多少位，只需要修改这里即可128, 192或256
         //SecureRandom是生成安全随机数序列，password.getBytes()是种子，只要种子相同，序列就一样，所以生成的秘钥就一样。
         kg.init(128, new SecureRandom(password.getBytes()));
         SecretKey sk = kg.generateKey();
         byte[] b = sk.getEncoded();
         String s = byteToHexString(b);
         System.out.println(s);
         System.out.println("十六进制密钥长度为"+s.length());
         System.out.println("二进制密钥的长度为"+s.length()*4);
       }
       catch (NoSuchAlgorithmException e) {
         e.printStackTrace();
         System.out.println("没有此算法。");
       }
     }
    public static void main(String[] args) {
		String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCVBJPCcxsCF3/fii3TLBWP5wGUb/kyYSZT7nkwsj7yHuTtsp+MZs4Xg57G4Isq09zPPTEgZPUUsbxS21r96yrCr3uSvOmR13U6HyeT/49X6LFiL6nBylYwm7akv8j6Mz8dliJ8zBoe9q6+BIZWUJktOOYiF5PMiNirQKyIm1k6ewIDAQAB";
		String dataPlainText= "{\"sites\":{\"site\":[{\"id\":\"1\",\"name\":\"菜鸟教程\",\"url\":\"www.runoob.com\"},{\"id\":\"2\",\"name\":\"菜鸟工具\",\"url\":\"c.runoob.com\"},{\"id\":\"3\",\"name\":\"Google\",\"url\":\"www.google.com\"}]}}";
		//生成一个RESkey对其加密
		String keyPlainText = getKey();
		//利用RSA工具对aesKey其进行加密
		String aseKey = RSAKeyUtils.encrypt(keyPlainText, publicKey);
		//利用AES工具对data的内容进行加密
		String data = encrypt(dataPlainText,keyPlainText);
		System.out.println("AESKey明文:"+keyPlainText);
		System.out.println("利用RSA加密后的AESKey:"+aseKey);
		System.out.println("AES加密后的数据:"+data);
    }

}

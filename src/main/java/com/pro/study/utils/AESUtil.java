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
		String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQC2uRLo7WN5wOHpYAVOufOAMpQlKZeDEMAB9/IfclYtiIH9C2VcypvJaDwvUACYIVgEx4hcnAsBaycCO6LAXMioPpPJmfKsCyV7zxqK0XmlZ9qOdw8JzV3gmQBMW2DNdTdPRCGfH7yrTFqK3SelM3s2MiM4Tx0QSD5w/jxkJNPsfQIDAQAB";
//		String dataPlainText= "{\"username\":\"wgl\",\"password\":\"1234\"}";
//		String dataPlainText= "{\"username\":\"companyAdmin\",\"password\":\"1234\"}";
//		String dataPlainText = "{\"userId\":1,\"phoneNumber\":\"150****0776\",\"email\":\"w1234567@163.com\",\"headImage\":\"1234\"}";
//		String dataPlainText = "{\"pageNum\":1,\"pageSize\":10,\"companyName\":\"开元\",\"productName\":\"消费\",\"orderType\":\"1\"}";
//		String dataPlainText = "{\"perinfo\":{\"applicantName\":\"张三\",\"sex\":1,\"idCard\":\"430203199206251018\",\"idCardLocation\":\"株洲\",\"nowLocation\":\"株洲现居地\",\"marryInfo\":1,\"postalCode\":\"xxxxpostalCode\",\"supportNum\":2,\"edu\":1,\"houseType\":1,\"phoneNum\":\"15811170776\",\"nativeProvince\":\"湖南\",\"nativeCity\":\"株洲\",\"nativeArea\":\"石峰区\",\"socialNum\":\"社保号\",\"upImage\":\"2.key\",\"downImage\":\"1.key\",\"weChatCode\":\"wechatcode\",\"email\":\"w50638957@163.com\"},\"loanInfo\":{\"companyId\":1,\"productId\":1,\"repayType\":1,\"loanUseType\":1,\"repayment\":50000,\"amount\":50000},\"bankCardList\":[{\"bankCardCode\":\"银行卡号1\",\"bankName\":\"招商银行1\",\"bankCardUpImage\":\"11up.key\",\"bankCardDownImage\":\"11down.key\"},{\"bankCardCode\":\"银行卡号2\",\"bankName\":\"招商银行2\",\"bankCardUpImage\":\"22up.key\",\"bankCardDownImage\":\"22down.key\"}],\"creditCardList\":[{\"creditCardCode\":\"信用卡号1\",\"creditName\":\"建设银行1\",\"creditCardUpImage\":\"11up.key\",\"creditCardDownImage\":\"11down.key\"},{\"creditCardCode\":\"信用卡号2\",\"creditName\":\"建设银行2\",\"creditCardUpImage\":\"22up.key\",\"creditCardDownImage\":\"22down.key\"}],\"linkPerInfoList\":[{\"linkPerName\":\"李四\",\"linkPerPhoneNumber\":\"1501117077x\",\"linkPerLocation\":\"湖南株洲1\",\"linkPerType\":1},{\"linkPerName\":\"王五\",\"linkPerPhoneNumber\":\"1501117077x\",\"linkPerLocation\":\"湖南株洲2\",\"linkPerType\":2},{\"linkPerName\":\"陈六\",\"linkPerPhoneNumber\":\"1501117077x\",\"linkPerLocation\":\"湖南株洲3\",\"linkPerType\":3}]}";
		String dataPlainText= "{\"nodeName\":\"准入规则\",\"nodeDescribe\":\"首先利用准入规则筛选第一部分人员\"}";
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

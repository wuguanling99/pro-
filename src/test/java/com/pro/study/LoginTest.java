package com.pro.study;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.pro.study.utils.AESUtil;
import com.pro.study.utils.RSAKeyUtils;

/** 
* @author: wgl
* @date: 2020年3月3日上午2:50:01 
* @version:1.0
* @Description: 创建用户登录测试
*/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ProApi.class)
public class LoginTest {

	@Test
	public void testCreateUser() {
		String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCAnTnGSqTCjho3wPBJRrOxBdX3B+SenYmOsGnr+Cp56IOB2dWBdDw+6B4i7CzkLYXnJMchvaqdawgy/udinUQpcvVx5XWMtWoP6ZE+uJmrPSilmY2pZ9qXNyoKI68aa8PMWrmO44UJ7oAccpIb2pSs8I7RImAmAGO28QPXOSdZfwIDAQAB";
//		String dataPlainText= "{\"username\":\"wgl\",\"password\":\"1234\",\"name\":\"吴冠霖\",\"idCard\":\"430203199206251018\",\"email\":\"w506238957@163.com\",\"phoneNumber\":\"15011170776\"}";
		String dataPlainText= "{\"username\":\"wgl\",\"password\":\"1234\"}";
		//生成一个RESkey对其加密
		String keyPlainText = AESUtil.getKey();
		//利用RSA工具对aesKey其进行加密
		String aseKey = RSAKeyUtils.encrypt(keyPlainText, publicKey);
		//利用AES工具对data的内容进行加密
		String data = AESUtil.encrypt(dataPlainText,keyPlainText);
		System.out.println("AESKey明文:"+keyPlainText);
		System.out.println("利用RSA加密后的AESKey:"+aseKey);
		System.out.println("AES加密后的数据:"+data);
	}

}

package com.pro.study.controller.key;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pro.study.utils.RSAKeyUtils;
import com.pro.study.vo.KeyVO;

/** 
* @author: wgl
* @date: 2020年2月23日下午2:52:06 
* @version:1.0
* @Description: 获取公钥私钥对应的视图层
*/
@RequestMapping("/key")
@RestController
public class KeyController{
	
	@Autowired
	private RedisTemplate redisTemplate;
	
	@Value("${rsatime}")
	private Integer rsatime;
	
	
	
	//------------RSA加密流程------------
	//1)首先我们生成一组公钥私钥，和一个uuid值
	//我们把公钥发给客户端
	//我们保留私钥我们将私钥保留在redis中，用一个UUID值作key,并设置超时时间
	//每次接口请求的数据通过公钥加密,我们拦截请求,拿到UUID值从redis里拿到对应的私钥对数据进行解密
	@GetMapping("/getRSAKey")
	public KeyVO createRSAKey() {
		//构建一个map用来保存RSA公钥私钥
		Map<String, String> keyMap = new HashMap<String,String>();
		RSAKeyUtils.genKeyPair(keyMap);
		//拿到公钥私钥
		String publicKey = keyMap.get(RSAKeyUtils.PUBLIC_KEY);
		String privateKey = keyMap.get(RSAKeyUtils.PRIVATE_KEY);
		//生成一个MD5值作为redis的key
		UUID redisKey = UUID.randomUUID();
//		redisTemplate.boundValueOps(RSAKeyUtils.PRIVATE_KEY+redisKey).set(privateKey,rsatime, TimeUnit.SECONDS);
//		redisTemplate.boundValueOps(RSAKeyUtils.PUBLIC_KEY+redisKey).set(publicKey,rsatime, TimeUnit.SECONDS);
		redisTemplate.opsForValue().set(RSAKeyUtils.PRIVATE_KEY+redisKey, privateKey,rsatime,TimeUnit.SECONDS);
		redisTemplate.opsForValue().set(RSAKeyUtils.PUBLIC_KEY+redisKey, publicKey,rsatime,TimeUnit.SECONDS);
		KeyVO keyVO = new KeyVO(redisKey.toString(),publicKey);
		return keyVO;
	}
	
}

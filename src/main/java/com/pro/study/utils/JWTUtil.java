package com.pro.study.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.pro.study.dto.user.UserInfoDTO;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/** 
* @author: wgl
* @date: 2020年3月1日下午11:26:24 
* @version:1.0
* @Description: 利用jwt加密解密工具---主要生成身份信息token
*/
public class JWTUtil {
	
	
	private static String keyt = "com.pro.study";
	
	/**
     * 解密
     * @param jsonWebToken
     * @param base64Security
     * @return
     */
    public static UserInfoDTO parseJWT(String jsonWebToken) {
        try {
        	return (UserInfoDTO) JsonUtil.jsonToPojo(JsonUtil.objectToJson(Jwts.parser()
                    .setSigningKey(keyt.getBytes())
                    .parseClaimsJws(jsonWebToken).getBody()),UserInfoDTO.class);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    /**
     * 前三个参数为自己用户token的一些信息比如id，权限，名称等。不要将隐私信息放入（大家都可以获取到）
     * @param map
     * @param base64Security
     * @return
     * @throws Exception 
     */
    public static String createJWT(UserInfoDTO user) throws Exception {
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        //添加构成JWT的参数
        JwtBuilder builder = Jwts.builder().setHeaderParam("typ", "JWT")
                .setPayload(JsonUtil.objectToJson(user))
                .signWith(signatureAlgorithm,keyt.getBytes()); 
        //生成JWT
        return builder.compact();
    }

    public static void main(String[] args) throws Exception {
    	UserInfoDTO userInfoVO = new UserInfoDTO();
    	userInfoVO.setName("吴冠霖");
    	userInfoVO.setRole("admin");
        //密钥
        String token=JWTUtil.createJWT(userInfoVO);
        System.out.println("JWT加密的结果："+ token);
        System.out.println("JWT解密的结果："+ parseJWT(token));
    } 
}

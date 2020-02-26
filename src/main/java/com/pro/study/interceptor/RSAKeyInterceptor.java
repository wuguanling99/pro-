package com.pro.study.interceptor;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.pro.study.config.ContentCachingRequestWrapper;
import com.pro.study.enums.PermitUrlsEnum;
import com.pro.study.utils.AESUtil;
import com.pro.study.utils.JsonUtils;
import com.pro.study.utils.RSAKeyUtils;

/**
 * @author: wgl
 * @date: 2020年2月23日下午1:28:55
 * @version:1.0
 * @Description: RSA加密解密拦截器
 */
@Component
public class RSAKeyInterceptor extends HandlerInterceptorAdapter {
	
	private static final String redisBodyKey = "redisBody";
	
	@Autowired
	private RedisTemplate redisTemplate;

	/**
	 * 前置拦截器 1)首先我们要本次请求是否是我们要拦截的请求 如果在不需要权限控制的接口我们直接放行 如果不在需要流量控制的接口范围内我们拦截判断权限
	 * 2)解密过程 我们采用的RSA+aes加密 a)前端请求后台拿到RSA公钥 我们把公钥和私钥都保存在Redsi里
	 * b)前端对数据进行aes加密然后把aes秘钥用我们刚刚发给前端的RSA公钥进行加密 c)前端发送请求回来需要如下格式 d){ "uuid":"xxxx",
	 * "data":"这里的数据已经经过前端的aes加密", "aesKey":"这里的aesKey已经经过RSA公钥加密"
	 * 
	 * } e)我们后台从redis里拿到对应的公钥私钥 f)我们首先用私钥解密aeskey拿到对应的aesKey的明文
	 * g)我们再用aesKey对data里的数据进行解密
	 * 
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("权限校验开始");
		String requestURI = request.getRequestURI();
		if (PermitUrlsEnum.hasPermitUrls(requestURI)) {
			// 判断是否是不需要认证且需要RSA解密的方法
			if (PermitUrlsEnum.hasPermitUrlAndNeedRsaDecrypt(requestURI)) {
				return DecryRequest(request, response);
			} else {
				// 剩下的接口是不需要认证的接口直接放行
				return true;
			}
		} else {
			// 判断权限即token是否存在
			String header = request.getHeader("token");
			// 如果token为空那么也拦截请求
			if (StringUtils.isEmpty(header)) {
				return false;
			} else {
				// 验证token是否有效
				// 如果有效那么放行
				return true;
			}
		}
	}

	/**
	 * 后置拦截器
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			@Nullable ModelAndView modelAndView) throws Exception {
	}

	/**
	 * 
	 * @throws IOException
	 * @Description:（不符合我们和客户端约定的数据格式） 方法返回值: @param response
	 */
	private void requestNoNeedParam(HttpServletResponse response) throws IOException {
		// 我们设置返回状态码是406证明本次请求不被接受
		response.setStatus(HttpStatus.NOT_ACCEPTABLE.value());
		response.getWriter().write("request params error");
		response.getWriter().flush();
	}

	/**
	 * 
	 * @throws IOException
	 * @Description:（不符合我们和客户端约定的数据格式） 方法返回值: @param response
	 */
	private void needGetKeyAgain(HttpServletResponse response) throws IOException {
		// 我们设置返回状态码是406证明本次请求不被接受
		response.setStatus(HttpStatus.UNPROCESSABLE_ENTITY.value());
		response.getWriter().write("get Key again");
		response.getWriter().flush();
	}

	/**
	 * 
	 * @Description:（对前端传回来的数据进行解密操作） 方法返回值: @param data 方法返回值: @return
	 */
	private Map<String, Object> proDecryptData(String data, String aesKey, String publicKey, String privateKey) {
		// 1)用私钥对aesKey里的数据数据进行解密拿到aesKey的明文
		String aesKeyPlainText = RSAKeyUtils.decrypt(aesKey, privateKey);
		// 2)用解密后的aesKey明文对data里的数据进行解密
		String dataPlainText = AESUtil.decrypt(data, aesKeyPlainText);
		// 3)将解密后的数据返回
		Map dataMap = JsonUtils.jsonToPojo(dataPlainText, Map.class);
		return dataMap;
	}

	/**
	 * 
	 * @throws Exception 
	 * @Description:（优化整个解密流程） 方法返回值: @param request 方法返回值: @param response
	 *                         方法返回值: @return 方法返回值: @throws IOException
	 */
	private boolean DecryRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String content_type = request.getHeader("content-type");
		if (content_type.equals("application/x-www-form-urlencoded")) {
			// 1)获取request里的uuid data aesKey
			String uuid = request.getParameter("uuid");
			String data = request.getParameter("data");
			String aesKey = request.getParameter("aesKey");
			return DecryDataByRequestData(uuid,data,aesKey,request,response);
			
		} else if (content_type.equals("application/json")) {
			String bodyString = getRequestBody(request);
			//拿到了body里的内容后我们将其转换成map
			Map bodyMap = JsonUtils.jsonToPojo(bodyString, Map.class);
			Object uuid=bodyMap.get("uuid");
			Object data=bodyMap.get("data");
			Object aesKey=bodyMap.get("aesKey");
			return DecryDataByRequestData(uuid,data,aesKey,request,response);
		}
		return false;
	}
	
	/**
	 * 
	* @throws Exception 
	 * @Description:（根据传入数据对数据进行判断并解密） 
	* 方法返回值: @param uuid
	* 方法返回值: @param data
	* 方法返回值: @param aesKey
	* 方法返回值: @param request
	* 方法返回值: @param response
	* 方法返回值: @return
	 */
	private boolean DecryDataByRequestData(Object uuid, Object data, Object aesKey, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if (uuid==null || data==null) {
			// 如果客户端返回的key是空的证明不符合我们的加密逻辑
			// 我们需要拦截该请求--并设置返回内容
			requestNoNeedParam(response);
			return false;
		}
		// 我们根据前端传过来的uuid 从redis里拿到我们的公钥
		// 需要拿到对应的publicKey 和 privateKey
		Object privateKey =redisTemplate.opsForValue().get(RSAKeyUtils.PRIVATE_KEY+uuid);
		Object publicKey =redisTemplate.opsForValue().get(RSAKeyUtils.PUBLIC_KEY+uuid);
		if (publicKey == null || privateKey == null) {
			// 证明我们在redis里没有找到对应的数据
			// 设置返回内容并拦截
			needGetKeyAgain(response);
			return false;
		}
		// 如果我们拿到了公钥我们需要对数据进行解密
		// 解密数据
		Map<String, Object> dataPlainText = proDecryptData(data+"", aesKey+"", publicKey.toString(),
				privateKey.toString());
		// 将数据保存到request里
		Set<String> keySet = dataPlainText.keySet();
		for (String key : keySet) {
			request.setAttribute(key, dataPlainText.get(key));
		}
		setBodyData(request,dataPlainText);
		return true;
	}
	
	/**
	 * 修改requestBody里的内容
	 * @throws Exception 
	* @Description:（方法功能描述） 
	* 方法返回值: @param request
	* 方法返回值: @param dataPlainText
	 */
	private void setBodyData(HttpServletRequest request, Map<String, Object> dataPlainText) throws Exception {
		ContentCachingRequestWrapper requestWrapper = (ContentCachingRequestWrapper) request;
		requestWrapper.updateBody(JsonUtils.objectToJson(dataPlainText));
	}

	/**
	 * 
	* @throws IOException 
	 * @Description:（获取requestBody里的内容，由于我们的request里的body只能读取一次，
	* 					这里读取了controller里就不能再次获取我们添加修饰类，利用修饰类来获取） 
	* 方法返回值: @param request
	* 方法返回值: @return
	 */
	private String getRequestBody(HttpServletRequest request) throws IOException {
		ContentCachingRequestWrapper requestWrapper = (ContentCachingRequestWrapper) request;
		String body = IOUtils.toString(requestWrapper.getBody(),request.getCharacterEncoding());
	    return (body.replace("\r", "")).replace("\n","");
	}
	
	/**
	 * 
	* @throws IOException 
	 * @Description:（获取requestBody里的内容，采用流的方式获取requestBody里的内容） 
	* 方法返回值: @param request
	* 方法返回值: @return
	 */
	private String getRequestBodyByStream(HttpServletRequest request) throws IOException {
		BufferedReader br = null;
		StringBuilder sb = new StringBuilder("");
		try {
			br = request.getReader();
			String str;
			while ((str = br.readLine()) != null) {
				sb.append(str);
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally{
            if(null != br) {
                try{
                    br.close();
                } catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
		return br.toString();
	}
	
}
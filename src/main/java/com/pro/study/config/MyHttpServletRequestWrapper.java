package com.pro.study.config;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/**
 * @author: wgl
 * @date: 2020年2月25日上午1:41:21
 * @version:1.0
 * @Description:
 */
public class MyHttpServletRequestWrapper extends HttpServletRequestWrapper {
	public MyHttpServletRequestWrapper(HttpServletRequest request) {
		super(request);
	}

	private String getBodyAsString() {
		StringBuffer buff = new StringBuffer();
		char[] charArr = new char[getContentLength()];
		try {
			BufferedReader reader = new BufferedReader(getReader());
			reader.read(charArr, 0, charArr.length);
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		buff.append(charArr);
		return buff.toString();
	}

	public String toString() {
		return getBodyAsString().replace("\r","").replace("\n","");
	}
}

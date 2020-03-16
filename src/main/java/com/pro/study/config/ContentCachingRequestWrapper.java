package com.pro.study.config;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * 
* @author: wgl
* @date: 2020年3月16日上午12:30:50 
* @version:1.0
* @Description:HttpReuqest修饰器
 */
public class ContentCachingRequestWrapper extends HttpServletRequestWrapper {

	private byte[] body;

	private BufferedReader reader;

	private ServletInputStream inputStream;
	
	private Map params;
	

	public ContentCachingRequestWrapper(HttpServletRequest request) throws IOException {
		super(request);
		loadBody(request);
	}
	
	public ContentCachingRequestWrapper(HttpServletRequest request, Map newParams) throws IOException {
		super(request);
		this.params = newParams;
	}
	

	private void loadBody(HttpServletRequest request) throws IOException {
		body = IOUtils.toByteArray(request.getInputStream());
		inputStream = new RequestCachingInputStream(body);
	}

	public byte[] getBody() {
		return body;
	}

	@Override
	public ServletInputStream getInputStream() throws IOException {

		final ByteArrayInputStream bais = new ByteArrayInputStream(body);

        return new ServletInputStream() {
            @Override
            public boolean isFinished() {
                return false;
            }

            @Override
            public boolean isReady() {
                return false;
            }

            @Override
            public void setReadListener(ReadListener readListener) {

            }

            @Override
            public int read() throws IOException {
                return bais.read();
            }
        };
	}
	@Override
	public BufferedReader getReader() throws IOException {
		if (reader == null) {
			reader = new BufferedReader(new InputStreamReader(inputStream, getCharacterEncoding()));
		}
		return reader;
	}

	private static class RequestCachingInputStream extends ServletInputStream {

		private final ByteArrayInputStream inputStream;

		public RequestCachingInputStream(byte[] bytes) {
			inputStream = new ByteArrayInputStream(bytes);
		}

		@Override
		public int read() throws IOException {
			return inputStream.read();
		}

		@Override
		public boolean isFinished() {
			return inputStream.available() == 0;
		}

		@Override
		public boolean isReady() {
			return true;
		}

		@Override
		public void setReadListener(ReadListener readlistener) {
		}

	}
	
	public void updateBody(String bodyString) {
		body = bodyString.getBytes();
	}
}
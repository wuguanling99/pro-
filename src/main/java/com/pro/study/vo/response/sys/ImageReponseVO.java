package com.pro.study.vo.response.sys;

/**
 * '
* @author: wgl
* @date: 2020年3月19日下午6:38:57 
* @version:1.0
* @Description:图片返回对象
 */
public class ImageReponseVO extends SysResponseVO{
	
	private String url;
	
	private String key;

	public ImageReponseVO(Integer code, String message, String url, String key) {
		super(code, message);
		this.url = url;
		this.key = key;
	}

	public ImageReponseVO(Integer code, String message) {
		super(code, message);
		// TODO Auto-generated constructor stub
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	@Override
	public String toString() {
		return "ImageReponseVO [url=" + url + ", key=" + key + "]";
	}

}

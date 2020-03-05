package com.pro.study.exception;

import com.pro.study.enums.SysDicEnum;

/** 
* @author: wgl
* @date: 2020年3月6日上午2:20:17 
* @version:1.0
* @Description: OSS异常
*/
public class OSSException extends RuntimeException{
	
	public OSSException(){
	    super();
	}
	
	public OSSException(String mes ,Throwable cause , 
	        boolean  str ,boolean str1 ){
	    super(mes , cause , str ,str1) ;
	}

	public OSSException(String mes ,Throwable cause){

	    super( mes , cause);
	}
	
	public OSSException(SysDicEnum sysDicEnum){
	    super( sysDicEnum.getMessage() );
	}

	public OSSException(Throwable cause){
	    super(  cause);
	}
}
package com.pro.study.vo.response.sys;

import java.util.List;

import com.pro.study.dto.sys.LimitDto;
import com.pro.study.enums.SysDicEnum;
import com.pro.study.vo.response.user.CheckUserListReponseVO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Page<T> {
	/**
	 * 返回码
	 */
	private Integer code;
	
	/**
	 * 返回消息
	 */
	private String message;
	/**
	 * 页码
	 */
	private int pageNo;
	/**
	 * 每页显示条数
	 */
	private int pageSize;
	/**
	 * 总条数
	 */
	private int totalRecordNo;
	/**
	 * 总页数
	 */
	private int totalPageNo;
	/**
	 * 页面数据
	 */
	private List<T> list;
	
		
	/**
	 * 
	* @Description:（获取mybatis 的limit分页参数） 
	* 方法返回值: @param pageNo
	* 方法返回值: @param pageSize
	* 方法返回值: @return
	 */
	public static LimitDto getLimit(int pageNo , int pageSize) {
		LimitDto limitDto = new LimitDto();
		Integer limitStart = (pageNo-1)*pageSize;
		limitDto.setLimitStart(limitStart);
		limitDto.setLimitEnd(pageSize);
		return limitDto;
	}
	
	/**
	 * 
	* @Description:（分页获取页数） 
	* 方法返回值: @param total
	* 方法返回值: @param pageSize
	* 方法返回值: @return
	 */
	public static Integer getTotalPageNo(Integer total,Integer pageSize) {
		if(total%pageSize==0) {
			return total/pageSize;
		}else {
			return (total/pageSize)+1;
		}
	}
	/*
	 * 分页数据获取失败返回类
	 */
	public static Page<CheckUserListReponseVO> fail() {
		Page page = new Page();
		page.setCode(SysDicEnum.ERROR.getCode());
		page.setMessage("分页数据获取失败");
		return page;
	}
}

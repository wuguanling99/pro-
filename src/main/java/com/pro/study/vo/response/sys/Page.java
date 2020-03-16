package com.pro.study.vo.response.sys;

import java.util.List;

import com.pro.study.dto.sys.LimitDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Page<T> {
	
	private int pageNo;//页码
	private int pageSize;//每页显示记录数
	private int totalRecordNo;//总共的记录数
	private int totalPageNo;//总共页数
	private List<T> list;//每页显示的数据
	
		
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
}

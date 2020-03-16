package com.pro.study.dao.loan_apply;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

/**
 * 
* @author: wgl
* @date: 2020年3月16日上午12:43:01 
* @version:1.0
* @Description:贷款申请订单表数据层
 */
public interface LoanApplyMybatisDao {

	List<Map> getAllAuditedList(@Param("companyId")Long companyId, 
			@Param("limitStart")Integer limitStart,
			@Param("limitEnd") Integer limitEnd, 
			@Param("userId")Long userId,
			@Param("deleteFlag")Integer deleteFlag);

	/**
	 * 
	* @Description:（分页获取总数） 
	* 方法返回值: @param companyId
	* 方法返回值: @param userId
	* 方法返回值: @param code
	* 方法返回值: @return
	 */
	Integer getTotalSize(@Param("companyId")Long companyId,@Param("userId") Long userId,@Param("deleteFlag") Integer deleteFlag);
	

}

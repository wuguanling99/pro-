package com.pro.study.dao.company;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.pro.study.dto.company.CompanyLoanerLocationDto;

/** 
* @author: wgl
* @date: 2020年3月5日下午4:24:25 
* @version:1.0
* @Description: 公司接口
*/
@Repository
public interface CompanyMybaitsDao {
	/**
	 * 
	* @Description:（根据公司id获取公司对应的贷款人所在分布） 
	* 方法返回值: @return
	 */
	public List<CompanyLoanerLocationDto> getLonerLocationMapByCompanyId(@Param("companyId")Long companyId);

}

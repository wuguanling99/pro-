package com.pro.study.dao.loan_apply;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pro.study.dto.loanApply.LinkPerDTO;

/**
 * 
* @author: wgl
* @date: 2020年3月21日下午7:38:16 
* @version:1.0
* @Description:联系人数据层
 */
public interface LinkPerMybatisDao {
	/**
	 * 
	* @Description:（添加联系人信息） 
	* 方法返回值: @param bankInfo
	 */
	void addLinker(@Param("list")List<LinkPerDTO> bankInfo);
}

package com.pro.study.vo.response.company;

import java.util.List;

import com.pro.study.dto.company.CompanyDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/** 
* @author: wgl
* @date: 2020年3月4日上午12:28:50 
* @version:1.0
* @Description: 公司返回类
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompanyResponseVO {

	private Integer code;
	
	private List<CompanyDto> companyNameList;
}

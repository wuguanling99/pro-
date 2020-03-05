package com.pro.study.vo.response.company;

import java.util.List;

import com.pro.study.dto.company.LocationMapDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/** 
* @author: wgl
* @date: 2020年3月5日上午2:59:50 
* @version:1.0
* @Description: 贷款申请人地图分布图
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoanerLocationMapResponseVO {
	
	private Integer code;
	
	private List<LocationMapDto> locationData; 
}

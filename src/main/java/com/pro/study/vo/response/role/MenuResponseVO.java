package com.pro.study.vo.response.role;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/** 
* @author: wgl
* @date: 2020年3月2日下午3:45:26 
* @version:1.0
* @Description: 目录返回实体
*/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MenuResponseVO {
	/**
	 * 
	 */
	private Long id;
    /**
     * 目录名
     */
    private String name;
    /**
     * url
     */
    private String url;
    /**
     * 子目录
     */
    private List<MenuResponseVO> sonMenu;
    
}

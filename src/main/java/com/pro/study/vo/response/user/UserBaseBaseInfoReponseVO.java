package com.pro.study.vo.response.user;

import com.pro.study.vo.response.sys.SysResponseVO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
* @author: wgl
* @date: 2020年3月19日上午3:36:42 
* @version:1.0
* @Description:用户基本信息
 */
public class UserBaseBaseInfoReponseVO  extends SysResponseVO{
	
	/**
	 * 用户Id
	 */
	private Long userId;
	
	/**
	 * 姓名
	 */
	private String name;
	
	/**
	 * 身份证
	 */
	private String idCard;
	
	/**
	 * 邮箱
	 */
	private String email;
	
	/**
	 * 手机号
	 */
	private String phoneNumber;
	
	/**
	 * 头像
	 */
	private String headImage;

	public UserBaseBaseInfoReponseVO(Integer code, String message, Long userId, String name, String idCard,
			String email, String phoneNumber, String headImage) {
		super(code, message);
		this.userId = userId;
		this.name = name;
		this.idCard = idCard;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.headImage = headImage;
	}

	public UserBaseBaseInfoReponseVO(Integer code, String message) {
		super(code, message);
		// TODO Auto-generated constructor stub
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getHeadImage() {
		return headImage;
	}

	public void setHeadImage(String headImage) {
		this.headImage = headImage;
	}

	@Override
	public String toString() {
		return "UserBaseBaseInfoReponseVO [userId=" + userId + ", name=" + name + ", idCard=" + idCard + ", email="
				+ email + ", phoneNumber=" + phoneNumber + ", headImage=" + headImage + "]";
	}

}

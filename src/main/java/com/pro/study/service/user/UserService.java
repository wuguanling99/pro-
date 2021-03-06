package com.pro.study.service.user;

import java.text.ParseException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import com.pro.study.dto.user.UserInfoDTO;
import com.pro.study.vo.request.sys.PageInfo;
import com.pro.study.vo.request.user.CheckUserReuqestDTO;
import com.pro.study.vo.request.user.CreateUserInfoVO;
import com.pro.study.vo.request.user.UserBaseInfoRequestVO;
import com.pro.study.vo.request.user.UserLoginVO;
import com.pro.study.vo.response.sys.ImageReponseVO;
import com.pro.study.vo.response.sys.Page;
import com.pro.study.vo.response.sys.SysListResponseVO;
import com.pro.study.vo.response.sys.SysResponseVO;
import com.pro.study.vo.response.user.CheckUserListReponseVO;
import com.pro.study.vo.response.user.LoanApplyTableUserBaseInfoVO;
import com.pro.study.vo.response.user.LoginResponseVO;
import com.pro.study.vo.response.user.LogoutResponseVO;
import com.pro.study.vo.response.user.UserBaseBaseInfoReponseVO;

/** 
* @author: wgl
* @date: 2020年2月26日下午11:05:40 
* @version:1.0
* @Description: 用户业务层
*/
public interface UserService {
	
	/**
	 * 
	* @Description:（登陆） 
	* 方法返回值: @param loginVo
	* 方法返回值: @return
	 */
	LoginResponseVO login(UserLoginVO loginVo)  throws Exception ;
	
	/**
	 * 
	* @Description:（创建用户） 
	* 方法返回值: @param user
	* 方法返回值: @return
	 */
	SysResponseVO createLoanApplicant(CreateUserInfoVO user);
	
	/**
	 * 
	* @Description:（登出） 
	* 方法返回值: @param token
	* 方法返回值: @return
	 */
	LogoutResponseVO logout(String token);
	
	
	/**
	 * 
	* @Description:（获取用户基本信息的方法） 
	* 方法返回值: @param request
	* 方法返回值: @return
	 */
	LoanApplyTableUserBaseInfoVO getBaseUserInfo(HttpServletRequest request) throws ParseException;

	/**
	 * 
	* @Description:（获取用户基本信息） 
	* 方法返回值: @param user
	* 方法返回值: @return
	 */
	UserBaseBaseInfoReponseVO getBaseUserInfo(UserInfoDTO user);
	
	/**
	 * 
	* @Description:（修改个人基本信息） 
	* 方法返回值: @param user
	* 方法返回值: @return
	 */
	UserBaseBaseInfoReponseVO updateBaseInfo(UserBaseInfoRequestVO userBaseInfo);

	/**
	 * 
	* @param userInfoDTO 
	 * @Description:（上传头像） 
	 * 方法返回值: @param user
	* 方法返回值: @param file
	* 方法返回值: @return
	 */
	ImageReponseVO uploadUserHeadImage(UserInfoDTO userInfoDTO, MultipartFile file);
	
	/**
	 * 
	* @Description:（分页显示审核员） 
	* 方法返回值: @param user
	* 方法返回值: @param page
	* 方法返回值: @return
	 */
	Page<CheckUserListReponseVO> getCheckUserList(UserInfoDTO user, PageInfo page);
	
	/**
	 * 
	 * @Description:（创建贷款审核人） 
	* 方法返回值: @param userInfoDTO 
	* 方法返回值: @param userInfo
	* 方法返回值: @return
	 */
	SysResponseVO createCheckUser(UserInfoDTO userInfoDTO, CreateUserInfoVO userInfo);
	
	/**
	 * 
	* @Description:（根据用户id获取用户详细信息） 
	* 方法返回值: @param userId
	* 方法返回值: @return
	 */
	UserBaseBaseInfoReponseVO getBaseUserInfo(Long userId);
	
	/**
	 * 
	* @Description:（修改审核人员数据） 
	* 方法返回值: @param checkUserInfo
	* 方法返回值: @return
	 */
	SysResponseVO updateCheckUserInfo(CheckUserReuqestDTO checkUserInfo);

}

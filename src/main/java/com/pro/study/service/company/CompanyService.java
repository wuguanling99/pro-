package com.pro.study.service.company;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import com.pro.study.dto.user.UserInfoDTO;
import com.pro.study.vo.request.product.ProductRequestVO;
import com.pro.study.vo.request.sys.PageInfo;
import com.pro.study.vo.request.workflow.NodeRequestVO;
import com.pro.study.vo.request.workflow.RuleFieldRequestVO;
import com.pro.study.vo.request.workflow.RulePage;
import com.pro.study.vo.request.workflow.WorkFlowRequestVO;
import com.pro.study.vo.response.company.CheckLoanFormReponseVO;
import com.pro.study.vo.response.company.CompanyResponseVO;
import com.pro.study.vo.response.company.LoanerLocationMapResponseVO;
import com.pro.study.vo.response.product.ProductResponseVO;
import com.pro.study.vo.response.sys.ImageReponseVO;
import com.pro.study.vo.response.sys.Page;
import com.pro.study.vo.response.sys.SysListResponseVO;
import com.pro.study.vo.response.sys.SysResponseVO;
import com.pro.study.vo.response.workflow.NodeResponseVO;
import com.pro.study.vo.response.workflow.RuleFieldReponseVO;
import com.pro.study.vo.response.workflow.WorkFLowResponseVO;

/** 
* @author: wgl
* @date: 2020年2月26日下午11:03:17 
* @version:1.0
* @Description: 公司业务层
*/
public interface CompanyService {
	
	/**
	 * 
	* @Description:（获取公司信息） 
	* 方法返回值: @return
	 */
	CompanyResponseVO geCompanyList();
	
	/**
	 * 
	* @Description:（获取贷款人分布地图） 
	* 方法返回值: @param request
	* 方法返回值: @return
	 */
	LoanerLocationMapResponseVO getLocationMap(HttpServletRequest request);
	
	/**
	 * 
	* @Description:（获取产品列表） 
	* 方法返回值: @param user
	* 方法返回值: @return
	 */
	List<ProductResponseVO> getProductInfo(UserInfoDTO user);
	
	/**
	 * 
	* @param workflow 
	 * @Description:（创建工作流） 
	* 方法返回值: @param user
	* 方法返回值: @return
	 */
	WorkFLowResponseVO createWorkFlow(UserInfoDTO user, WorkFlowRequestVO workflow);
	
	//==================================审核员===========================================
	/**
	 * 
	* @Description:（获取我的待审核列表） 
	* 方法返回值: @param user
	* 方法返回值: @return
	 */
	CheckLoanFormReponseVO getMyToBeAuditedList(UserInfoDTO user);
	
	/**
	 * 
	* @Description:（分页获取所有审核订单） 
	* 方法返回值: @param user
	* 方法返回值: @param page
	* 方法返回值: @return
	 */
	CheckLoanFormReponseVO getAllAuditedList(UserInfoDTO user, PageInfo page);
	
	/**
	 * 
	* @Description:（创建节点） 
	* 方法返回值: @param user
	* 方法返回值: @param node
	* 方法返回值: @return
	 */
	NodeResponseVO createNode(UserInfoDTO user, NodeRequestVO node);

	/**
	 * 
	* @Description:（创建规则字段） 
	* 方法返回值: @param user
	* 方法返回值: @param ruleField
	* 方法返回值: @return
	 */
	RuleFieldReponseVO createRuleField(UserInfoDTO user, RuleFieldRequestVO ruleField);
	
	/**
	 * 
	* @Description:（获取公司列表） 
	* 方法返回值: @param user
	* 方法返回值: @return
	 */
	SysListResponseVO getCompanyProductList(UserInfoDTO user);
	
	/**
	 * 
	* @Description:（创建产品） 
	* 方法返回值: @param user
	* 方法返回值: @param product
	* 方法返回值: @return
	 */
	SysResponseVO createProduct(UserInfoDTO user, ProductRequestVO product);
	
	/**
	 * 
	* @Description:（上传产品logo） 
	* 方法返回值: @param user
	* 方法返回值: @param file
	* 方法返回值: @return
	 */
	ImageReponseVO uploadProductLogo(UserInfoDTO user, MultipartFile file);
	
	/**
	 * 
	 * @Description:（分页获取产品列表） 
	* 方法返回值: @param user
	* 方法返回值: @param page 
	* 方法返回值: @return
	 */
	Page getProductByPage(UserInfoDTO user, PageInfo page);
	
	/**
	 * 
	* @Description:（修改产品信息） 
	* 方法返回值: @param user
	* 方法返回值: @param product
	* 方法返回值: @return
	 */
	SysResponseVO updateProductInfo(UserInfoDTO user, ProductRequestVO product);
	
	/**
	 * 
	* @Description:（根据产品Id查询对应的工作流节点） 
	* 方法返回值: @param user
	* 方法返回值: @param productId
	* 方法返回值: @return
	 */
	SysListResponseVO getWorkFlowNodeByProductId(UserInfoDTO user, Long productId);
	
	/**
	 * 
	* @Description:（获取所有的外部数据接口） 
	* 方法返回值: @param user
	* 方法返回值: @param page
	* 方法返回值: @return
	 */
	Page getAllOutInterface(UserInfoDTO user, RulePage page);
	
	
	
	/**
	 * 
	* @Description:（外部接口关联关系管理） 
	* 方法返回值: @param user
	* 方法返回值: @param interfaceId
	* 方法返回值: @param productId
	* 方法返回值: @param nodeId
	* 方法返回值: @return
	 */
	SysResponseVO enableOrStopInterface(UserInfoDTO user, Long interfaceId, Long productId, Long nodeId);

}

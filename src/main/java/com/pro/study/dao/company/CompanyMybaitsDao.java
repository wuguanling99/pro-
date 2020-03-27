package com.pro.study.dao.company;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.pro.study.dto.company.CompanyLoanerLocationDto;
import com.pro.study.dto.company.ProductDetailDTO;
import com.pro.study.dto.company.ProductDto;
import com.pro.study.dto.sys.LimitDto;
import com.pro.study.dto.workflow.NodeDTO;
import com.pro.study.dto.workflow.RuleDTO;
import com.pro.study.dto.workflow.RuleFieldAndDicDTO;
import com.pro.study.dto.workflow.RuleLinkDTO;
import com.pro.study.dto.workflow.RuleUpdateDTO;
import com.pro.study.dto.workflow.WorkFlowDTO;
import com.pro.study.vo.request.product.ProductRequestVO;
import com.pro.study.vo.request.workflow.RulePage;

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
	
	/**
	 * 
	* @Description:（根据公司id获取产品列表） 
	* 方法返回值: @param companyId
	* 方法返回值: @return
	 */
	public List<ProductDto> getProductByCompanyId(@Param("companyId")Long companyId);
	
	/**
	 * 
	* @Description:（分页获取产品详情） 
	* 方法返回值: @param companyId
	* 方法返回值: @param limit
	* 方法返回值: @return
	 */
	public List<ProductDetailDTO> getProductDetailByPage(@Param("companyId")Long companyId, @Param("page")LimitDto limit);
	
	/**
	 * 获取产品详情 --- 获取总条数
	* @Description:（方法功能描述） 
	* 方法返回值: @param companyId
	* 方法返回值: @return
	 */
	public Integer getAllProductSize(@Param("companyId")Long companyId);
	
	/**
	 * 
	* @Description:（修改产品信息） 
	* 方法返回值: @param product
	* 方法返回值: @param companyId
	 */
	public void updateProductInfo(@Param("product")ProductRequestVO product,@Param("companyId") Long companyId);
	
	/**
	 * 
	* @param productId 
	 * @Description:（获取产品下的规则字段和所有的规则字段和对应的字典的方法） 
	* 方法返回值: @param companyId
	* 方法返回值: @param productId
	* 方法返回值: @return
	 */
	public List<RuleFieldAndDicDTO> getRuleField(@Param("companyId")Long companyId,@Param("productId") Long productId);
	
	/**
	 * 
	* @Description:（分页获取规则） 
	* 方法返回值: @param companyId
	* 方法返回值: @param page
	* 方法返回值: @return
	 */
	public List<RuleDTO> getRuleByPage(@Param("companyId")Long companyId,@Param("page") LimitDto page);
	
	/**
	 * 
	* @Description:（查询规则总条数） 
	* 方法返回值: @param companyId
	* 方法返回值: @return
	 */
	public Integer countAllRule(@Param("companyId") Long companyId);
	
	/**
	 * 
	* @Description:（修改规则） 
	* 方法返回值: @param rule
	* 方法返回值: @param companyId
	 */
	public void updateRuleInfo(@Param("rule")RuleUpdateDTO rule);
	
	/**
	 * 
	* @Description:（删除规则） 
	* 方法返回值: @param id
	 */
	public void deleteRule(@Param("id")Long id);	

	/**
	 * 
	* @Description:（根据产品id查询对应的工作流的方法） 
	* 方法返回值: @param productId
	* 方法返回值: @param code
	* 方法返回值: @return
	 */
	public List<WorkFlowDTO> findWorkFlowByProductId(@Param("productId")Long productId, @Param("deleteFlag")Integer code);

	/**
	 * 
	* @Description:（根据工作流Id查询对应的节点）
	* 方法返回值: @param id
	* 方法返回值: @return
	 */
	public List<NodeDTO> findNodeListByWorkFlowId(@Param("workFlowId")Long id);
	
	/**
	 * 
	* @Description:（获取所有规则的方法） 
	* 方法返回值: @param productId
	* 方法返回值: @param workFlowId
	* 方法返回值: @return
	 */
	public List<RuleLinkDTO> getAllRuleLinkInfo(@Param("productId")Long productId, 
			@Param("workflowId")Long workflowId, 
			@Param("limitStart")Integer limitStart, 
			@Param("limitEnd")Integer limitEnd);
	
	/**
	 * 
	* @Description:（统计规则的条数） 
	* 方法返回值: @param productId
	* 方法返回值: @param workflowId
	* 方法返回值: @return
	 */
	public Integer countRuleByProductIdAndWorkFlowId(@Param("productId")Long productId, @Param("workflowId")Long workflowId);
	
	
}

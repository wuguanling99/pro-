package com.pro.study.serviceimpl.rule;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pro.study.dao.company.CompanyMybaitsDao;
import com.pro.study.dao.workflow.RuleRepository;
import com.pro.study.dto.sys.LimitDto;
import com.pro.study.dto.user.UserInfoDTO;
import com.pro.study.dto.workflow.RuleDTO;
import com.pro.study.dto.workflow.RuleFieldAndDicDTO;
import com.pro.study.dto.workflow.RuleUpdateDTO;
import com.pro.study.enums.SysDicEnum;
import com.pro.study.po.workflow.Rule;
import com.pro.study.service.rule.RuleService;
import com.pro.study.utils.JsonUtil;
import com.pro.study.vo.request.sys.PageInfo;
import com.pro.study.vo.request.workflow.BodyRequestVO;
import com.pro.study.vo.request.workflow.RuleAndBodyRequestVO;
import com.pro.study.vo.response.company.RuleDicReponseVO;
import com.pro.study.vo.response.company.RuleFieldAndDicReponseVO;
import com.pro.study.vo.response.sys.Page;
import com.pro.study.vo.response.sys.SysListResponseVO;
import com.pro.study.vo.response.sys.SysResponseVO;
import com.pro.study.vo.response.workflow.RuleInfoResponseVO;

/** 
* @author: wgl
* @date: 2020年3月26日上午10:32:10 
* @version:1.0
* @Description: 
*/
@Service
public class RuleServiceImpl implements RuleService {

	@Autowired
	private CompanyMybaitsDao companyDao;
	
	@Autowired
	private RuleRepository ruleRepository;
	
	/**
	 * 获取规则字段和规则字典
	 */
	@Override
	public SysListResponseVO<RuleFieldAndDicReponseVO> getAllRuleField(UserInfoDTO user) {
		try {
			List<RuleFieldAndDicDTO> ruleFieldDTO =  companyDao.getRuleField(user.getCompanyId());
			Set<Long> collect = ruleFieldDTO.stream().map(RuleFieldAndDicDTO :: getFieldId).collect(Collectors.toSet());
			List<RuleFieldAndDicReponseVO> data = new ArrayList<RuleFieldAndDicReponseVO>();
			for(Long index : collect) {
				RuleFieldAndDicReponseVO ruleField = new RuleFieldAndDicReponseVO();
				List<RuleDicReponseVO> dicList = new ArrayList<RuleDicReponseVO>();
				for(RuleFieldAndDicDTO ruleFieldIndex : ruleFieldDTO) {
					ruleField.setFielId(index);
					if(ruleFieldIndex.getFieldId()==index) {
						ruleField.setFieldName(ruleFieldIndex.getFieldName());
						RuleDicReponseVO dic = new RuleDicReponseVO();
						dic.setFieldId(ruleFieldIndex.getFieldDicId());
						dic.setFieldName(ruleFieldIndex.getFieldDicName());
						dicList.add(dic);
					}
				}
				ruleField.setDicData(dicList);
				data.add(ruleField);
			}
			return new SysListResponseVO(SysDicEnum.SUCCESS.getCode(),"数据获取成功",data);
		}catch (Exception e) {
			e.printStackTrace();
			return new SysListResponseVO(SysDicEnum.ERROR.getCode(),"数据获取失败",null); 
		}
	}
	
	
	/**
	 * 添加规则
	 */
	@Override
	public SysResponseVO createRule(UserInfoDTO user, RuleAndBodyRequestVO ruleVO) {
		try {
			Rule rule = new Rule();
			rule.setRuleDescribe(ruleVO.getRuleDescribe());
			rule.setRuleName(ruleVO.getRuleName());
			rule.setRuleBody(JsonUtil.objectToJson(ruleVO.getRuleBody()));
			rule.setCompanyId(user.getCompanyId());
			ruleRepository.save(rule);
			return new SysResponseVO(SysDicEnum.SUCCESS.getCode(),"规则添加成功");
		}catch (Exception e) {
			e.printStackTrace();
			return new SysResponseVO(SysDicEnum.ERROR.getCode(),"规则添加失败");
		}
	}

	/**
	 * 分页获取规则
	 */
	@Override
	public Page getRuleByPage(UserInfoDTO user, PageInfo page) {
		try {
			LimitDto limit = Page.getLimit(page.getPageNum(), page.getPageSize());
			List<RuleDTO> rule = companyDao.getRuleByPage(user.getCompanyId(),limit);
			Integer total = companyDao.countAllRule(user.getCompanyId());
			Integer totalPageNo = Page.getTotalPageNo(total, page.getPageSize());
			return new Page(SysDicEnum.SUCCESS.getCode(),"规则数据获取成功",page.getPageNum(),page.getPageSize(),totalPageNo,total,rule);
		}catch (Exception e) {
			e.printStackTrace();
			return Page.fail();
		}
	}

	/**
	 * 获取规则信息
	 */
	@Override
	public RuleInfoResponseVO getRuleInfo(UserInfoDTO user, Long id) {
		try {
			RuleInfoResponseVO result = new RuleInfoResponseVO(SysDicEnum.SUCCESS.getCode(),"数据获取成功");
			Rule data = ruleRepository.findByIdAndDeleteFlag(id,SysDicEnum.SYS_VALID.getCode());
			result.setId(data.getId());
			result.setRuleBody(JsonUtil.jsonToPojo(data.getRuleBody(),List.class));
			result.setRuleDescribe(data.getRuleDescribe());
			result.setRuleName(data.getRuleName());
			return result;
		}catch (Exception e) {
			e.printStackTrace();
			return new RuleInfoResponseVO(SysDicEnum.ERROR.getCode(),"数据获取失败");
		}
	}

	/**
	 * 修改规则
	 */
	@Override
	public SysResponseVO updateRule(UserInfoDTO user, RuleAndBodyRequestVO rule) {
		try {
			RuleUpdateDTO ruleDTO = new RuleUpdateDTO();
			String ruleBody = JsonUtil.objectToJson(rule.getRuleBody());
			ruleDTO.setId(rule.getId());
			ruleDTO.setBody(ruleBody);
			ruleDTO.setCompanyId(user.getCompanyId());
			ruleDTO.setRuleName(rule.getRuleName());
			ruleDTO.setDescribe(rule.getRuleDescribe());
			companyDao.updateRuleInfo(ruleDTO);
			return new SysResponseVO(SysDicEnum.SUCCESS.getCode(),"规则修改成功");
		}catch (Exception e) {
			return new SysResponseVO(SysDicEnum.ERROR.getCode(),"规则修改失败");
		}
	}

	/**
	 * 删除规则
	 */
	@Override
	public SysResponseVO deleteRule(UserInfoDTO user, Long id) {
		try {
			companyDao.deleteRule(id);
			return new SysResponseVO(SysDicEnum.SUCCESS.getCode(),"规则删除成功");
		}catch (Exception e) {
			return new SysResponseVO(SysDicEnum.ERROR.getCode(),"规则删除失败");
		}
	}

}

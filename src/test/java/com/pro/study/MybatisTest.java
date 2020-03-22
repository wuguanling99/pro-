package com.pro.study;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.alibaba.druid.support.json.JSONUtils;
import com.pro.study.dao.company.CompanyMybaitsDao;
import com.pro.study.dao.loan_apply.LoanApplyMybatisDao;
import com.pro.study.dto.company.CompanyLoanerLocationDto;
import com.pro.study.dto.sys.LimitDto;
import com.pro.study.dto.sys.LoanApplyOrderSearchDTO;
import com.pro.study.vo.response.sys.Page;

/**
 * 
* @author: wgl
* @date: 2020年3月1日下午8:55:41 
* @version:1.0
* @Description:角色单元测试
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ProApiTest.class)
public class MybatisTest {
	
	@Autowired
	private CompanyMybaitsDao companyDao;
	
	@Autowired
	private LoanApplyMybatisDao loanApplyDao; 
	
    @Test
    public void test1() {
    	List<CompanyLoanerLocationDto> data = companyDao.getLonerLocationMapByCompanyId(1l);
    	System.out.println(data);
    }
    
    @Test
    public void testLoanApply() {
//    	List<Map> allAuditedList = loanApplyDao.getAllAuditedList(1l, 10, 10, 1l, SysDicEnum.SYS_VALID.getCode());
//    	Integer total = loanApplyDao.getTotalSize(1l,1l,SysDicEnum.SYS_VALID.getCode());
//    	Integer totalPageNo = Page.getTotalPageNo(total,10);
//    	System.out.println(totalPageNo);
//    	System.out.println(total);
//    	System.out.println(JSONUtils.toJSONString(allAuditedList));
    	LimitDto limit = Page.getLimit(1,10);
		LoanApplyOrderSearchDTO searchAndPageInfo = new LoanApplyOrderSearchDTO();
		searchAndPageInfo.setCompanyName("开元");
		searchAndPageInfo.setOrderType(1);
		searchAndPageInfo.setProductName("消费");
		searchAndPageInfo.setLimitStart(limit.getLimitStart());
		searchAndPageInfo.setLimitEnd(limit.getLimitEnd());
		searchAndPageInfo.setUserId(1l);
		List<Map> data = loanApplyDao.searchPageLoanOrderByUserId(searchAndPageInfo);
		System.out.println(JSONUtils.toJSONString(searchAndPageInfo));
    }
}
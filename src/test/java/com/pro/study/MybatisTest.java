package com.pro.study;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.pro.study.dao.company.CompanyMybaitsDao;
import com.pro.study.dto.company.CompanyLoanerLocationDto;

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
    @Test
    public void test1() {
    	List<CompanyLoanerLocationDto> data = companyDao.getLonerLocationMapByCompanyId(1l);
    	System.out.println(data);
    }
}
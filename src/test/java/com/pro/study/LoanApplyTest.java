package com.pro.study;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.alibaba.druid.support.json.JSONUtils;
import com.pro.study.dao.loan_apply.LinkPerMybatisDao;
import com.pro.study.dao.loan_apply.LoanApplyMybatisDao;
import com.pro.study.dao.loan_apply.LoanApplyOrderMybatisDao;
import com.pro.study.dao.loan_apply.LoanBankMybatisDao;
import com.pro.study.dto.loanApply.LinkPerDTO;
import com.pro.study.utils.JsonUtil;
import com.pro.study.vo.request.loan_apply.BankCardInfo;
import com.pro.study.vo.request.loan_apply.CreditCardInfo;
import com.pro.study.vo.request.loan_apply.LinkPerInfo;
import com.pro.study.vo.request.loan_apply.LoanApplyTableRequestVO;
import com.pro.study.vo.request.loan_apply.LoanInfoVO;
import com.pro.study.vo.request.loan_apply.PerInfoVO;

/**
 * 
* @author: wgl
* @date: 2020年3月20日下午11:02:02 
* @version:1.0
* @Description:贷款申请表测试类
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ProApi.class)
public class LoanApplyTest {
	
	@Autowired
	private LoanApplyOrderMybatisDao loanOrderDao;
	
	@Autowired
	private LoanApplyMybatisDao loanApplyDao;
	
	@Autowired
	private LoanBankMybatisDao bankDao;
	
	@Autowired
	private LinkPerMybatisDao linkPerDao;
	

	@Test
	public void testCreateLoanApply() throws Exception {
		LoanApplyTableRequestVO loanApplyTable = new LoanApplyTableRequestVO();
		LoanInfoVO loanInfoVO = new LoanInfoVO();
		loanInfoVO.setAmount(50000);
		loanInfoVO.setCompanyId(1l);
		loanInfoVO.setLoanUseType(1);
		loanInfoVO.setProductId(1l);
		loanInfoVO.setRepayment(50000);
		loanInfoVO.setRepayType(1);
		loanApplyTable.setLoanInfo(loanInfoVO);
		PerInfoVO perInfoVO = new PerInfoVO();
		perInfoVO.setApplicantName("张三");
		perInfoVO.setDownImage("1.key");
		perInfoVO.setEdu(1);
		perInfoVO.setEMail("w50638957@163.com");
		perInfoVO.setHouseType(1);
		perInfoVO.setIdCard("430203199206251018");
		perInfoVO.setIdCardLocation("株洲");
		perInfoVO.setMarryInfo(1);
		perInfoVO.setNativeArea("石峰区");
		perInfoVO.setNativeCity("株洲");
		perInfoVO.setNativeProvince("湖南");
		perInfoVO.setNowLocation("株洲现居地");
		perInfoVO.setPhoneNum("15811170776");
		perInfoVO.setPostalCode("xxxxpostalCode");
		perInfoVO.setSex(1);
		perInfoVO.setSocialNum("社保号");
		perInfoVO.setSupportNum(2);
		perInfoVO.setUpImage("2.key");
		perInfoVO.setWeChatCode("wechatcode");
		loanApplyTable.setPerinfo(perInfoVO);
		PerInfoVO perinfo = loanApplyTable.getPerinfo();
		List<BankCardInfo> bankList = new ArrayList<>();
		bankList.add(new BankCardInfo("银行卡号1","招商银行1","11up.key","11down.key"));
		bankList.add(new BankCardInfo("银行卡号2","招商银行2","22up.key","22down.key"));
		loanApplyTable.setBankCardList(bankList);
		List<CreditCardInfo> creditCardList = new ArrayList<>();
		creditCardList.add(new CreditCardInfo("信用卡号1","建设银行1","11up.key","11down.key"));
		creditCardList.add(new CreditCardInfo("信用卡号2","建设银行2","22up.key","22down.key"));
		loanApplyTable.setCreditCardList(creditCardList);
		List<CreditCardInfo> creditList = loanApplyTable.getCreditCardList();
		List<LinkPerInfo> linkPerData = new ArrayList<>();
		linkPerData.add(new LinkPerInfo("李四","1501117077x","湖南株洲1",1));
		linkPerData.add(new LinkPerInfo("王五","1501117077x","湖南株洲2",2));
		linkPerData.add(new LinkPerInfo("陈六","1501117077x","湖南株洲3",3));
		loanApplyTable.setLinkPerInfoList(linkPerData);
		List<LinkPerInfo> linkPerInfoList = loanApplyTable.getLinkPerInfoList();
		System.out.println(JsonUtil.objectToJson(loanApplyTable));
//		LoanInfoVO loanInfo = loanApplyTable.getLoanInfo();
//		LoanApplyOrderDTO order = new LoanApplyOrderDTO();
//		order.setCompanyId(loanInfo.getCompanyId());
//		order.setOrderType(RiskCheckEnum.CHECK_TO_BE_AUDITED.getCode());
//		order.setProductId(loanInfo.getProductId());
//		order.setRepayment(loanInfo.getRepayment());
//		order.setRepayType(loanInfo.getRepayType());
//		order.setUserId(1l);
//		order.setUseType(loanInfo.getLoanUseType());
//		Long id = loanOrderDao.insertLoanOrder(order);
//		System.out.println(order.getId());
//		PerInfoDTO perInfoDTO = new PerInfoDTO();
//		perInfoDTO.setAmount(loanInfoVO.getAmount());
//		perInfoDTO.setArea(perinfo.getNativeArea());
//		perInfoDTO.setCity(perinfo.getNativeCity());
//		perInfoDTO.setProvince(perinfo.getNativeProvince());
//		perInfoDTO.setDownImage(perinfo.getDownImage());
//		perInfoDTO.setEdu(perinfo.getEdu());
//		perInfoDTO.setEmail(perinfo.getEMail());
//		perInfoDTO.setIdCard(perinfo.getIdCard());
//		perInfoDTO.setIdCardLocation(perinfo.getIdCardLocation());
//		perInfoDTO.setLocation(perinfo.getNowLocation());
//		perInfoDTO.setMarryInfo(perinfo.getMarryInfo());
//		perInfoDTO.setName(perinfo.getApplicantName());
//		perInfoDTO.setOrderId(1l);
//		perInfoDTO.setPhoneNumber(perinfo.getPhoneNum());
//		perInfoDTO.setPostalCode(perinfo.getPostalCode());
//		perInfoDTO.setSex(perinfo.getSex());
//		perInfoDTO.setSocialNum(perinfo.getSocialNum());
//		perInfoDTO.setSupportNum(perinfo.getSupportNum());
//		perInfoDTO.setUpImage(perinfo.getUpImage());
//		perInfoDTO.setWechatCode(perinfo.getWeChatCode());
//		loanApplyDao.insertPerInfo(perInfoDTO);
//		List<BankCardInfo> bankCardList = loanApplyTable.getBankCardList();
//		List<LoanBankDTO> bankInfo = new ArrayList<LoanBankDTO>();
//		for(BankCardInfo bankIndex :bankCardList) {
//			LoanBankDTO bankDTO = new LoanBankDTO();
//			bankDTO.setBankName(bankIndex.getBankName());
//			bankDTO.setCode(bankIndex.getBankCardCode());
//			bankDTO.setDownImage(bankIndex.getBankCardDownImage());
//			bankDTO.setOrderId(1l);
//			bankDTO.setUpImage(bankIndex.getBankCardUpImage());
//			bankInfo.add(bankDTO);
//		}
//		bankDao.addBank(bankInfo);
//		List<LoanBankDTO> creditCardInfo = new ArrayList<LoanBankDTO>();
//		for(CreditCardInfo creditCard : creditList) {
//			LoanBankDTO bankDTO = new LoanBankDTO();
//			bankDTO.setBankName(creditCard.getCreditName());
//			bankDTO.setCode(creditCard.getCreditCardCode());
//			bankDTO.setDownImage(creditCard.getCreditCardDownImage());
//			bankDTO.setOrderId(1l);
//			bankDTO.setUpImage(creditCard.getCreditCardUpImage());
//			creditCardInfo.add(bankDTO);
//		}
//		bankDao.addCreditCard(creditCardInfo);
//		List<LinkPerDTO> linkPerList = new ArrayList<LinkPerDTO>();
//		for (LinkPerInfo linkPer : linkPerInfoList) {
//			LinkPerDTO linkPerDTO = new LinkPerDTO();
//			linkPerDTO.setLocation(linkPer.getLinkPerLocation());
//			linkPerDTO.setName(linkPer.getLinkPerName());
//			linkPerDTO.setPhoneNumber(linkPer.getLinkPerPhoneNumber());
//			linkPerDTO.setRelationship(linkPer.getLinkPerType());
//			linkPerDTO.setOrderId(1l);
//			linkPerList.add(linkPerDTO);
//		}
//		linkPerDao.addLinker(linkPerList);
	}
}

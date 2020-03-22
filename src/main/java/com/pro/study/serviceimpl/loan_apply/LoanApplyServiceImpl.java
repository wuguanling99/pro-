package com.pro.study.serviceimpl.loan_apply;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.pro.study.dao.company.CompanyProductLinkRepository;
import com.pro.study.dao.company.CompanyRepository;
import com.pro.study.dao.loan_apply.LinkPerMybatisDao;
import com.pro.study.dao.loan_apply.LoanApplicantRepository;
import com.pro.study.dao.loan_apply.LoanApplyMybatisDao;
import com.pro.study.dao.loan_apply.LoanApplyOrderMybatisDao;
import com.pro.study.dao.loan_apply.LoanApplyOrderRepository;
import com.pro.study.dao.loan_apply.LoanBankInfoRepository;
import com.pro.study.dao.loan_apply.LoanBankMybatisDao;
import com.pro.study.dao.loan_apply.LoanCreditCardRepository;
import com.pro.study.dao.loan_apply.LoanLinkPerRepository;
import com.pro.study.dao.product.ProductRepository;
import com.pro.study.dto.loanApply.LinkPerDTO;
import com.pro.study.dto.loanApply.LoanApplyOrderDTO;
import com.pro.study.dto.loanApply.LoanBankDTO;
import com.pro.study.dto.loanApply.PerInfoDTO;
import com.pro.study.dto.sys.LimitDto;
import com.pro.study.dto.sys.LoanApplyOrderSearchDTO;
import com.pro.study.dto.user.UserInfoDTO;
import com.pro.study.enums.RiskCheckEnum;
import com.pro.study.enums.SysDicEnum;
import com.pro.study.po.company.Company;
import com.pro.study.po.company.CompanyProductLink;
import com.pro.study.po.loan.LoanApplicantPerInfo;
import com.pro.study.po.loan.LoanApplyOrder;
import com.pro.study.service.loan_aypply.LoanApplyService;
import com.pro.study.utils.OSSClientUtil;
import com.pro.study.utils.UserUtils;
import com.pro.study.vo.request.loan_apply.BankCardInfo;
import com.pro.study.vo.request.loan_apply.CreditCardInfo;
import com.pro.study.vo.request.loan_apply.LinkPerInfo;
import com.pro.study.vo.request.loan_apply.LoanApplyTableRequestVO;
import com.pro.study.vo.request.loan_apply.LoanInfoVO;
import com.pro.study.vo.request.loan_apply.PerInfoVO;
import com.pro.study.vo.request.sys.PageInfo;
import com.pro.study.vo.request.sys.SearchPageInfoRequestVO;
import com.pro.study.vo.response.loan_apply.CreateLoanApplyTableResponseVO;
import com.pro.study.vo.response.loan_apply.ImageResponseVO;
import com.pro.study.vo.response.loan_apply.LoanApplyFromResponseVo;
import com.pro.study.vo.response.sys.ImageReponseVO;
import com.pro.study.vo.response.sys.Page;
import com.pro.study.vo.response.sys.SysListResponseVO;

/** 
* @author: wgl
* @date: 2020年3月3日下午5:59:53 
* @version:1.0
* @Description: 贷款申请业务实现
*/
@Service
public class LoanApplyServiceImpl implements LoanApplyService{
	
	@Autowired
	private LoanApplyOrderRepository orderRepository;
	
	@Autowired
	private LoanApplicantRepository loanApplicantRepository;
	
	@Autowired
	private CompanyProductLinkRepository companyProductLinkRepository;
	
	@Autowired
	private CompanyRepository companyRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private LoanBankInfoRepository loanBankCardRepository;
	
	@Autowired
	private LoanCreditCardRepository loanCreditCardRepository;
	
	@Autowired
	private LoanLinkPerRepository loanLinkRepository;
	
	
	@Autowired
	private LoanApplyMybatisDao loanApplyDao;
	
	@Autowired
	private LoanApplyOrderMybatisDao loanOrderDao;
	
	@Autowired
	private LoanBankMybatisDao bankDao;
	
	@Autowired
	private LinkPerMybatisDao linkPerDao;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	/**
	 * 创建用户贷款申请表
	 */
	@Override
	public CreateLoanApplyTableResponseVO createLoanApplyTable(LoanApplyTableRequestVO loanApplyTable,
			HttpServletRequest request) {
		try {
			UserInfoDTO user = UserUtils.getUser(request);
			//保存贷款申请信息---贷款基本信息
			LoanInfoVO loanInfo = loanApplyTable.getLoanInfo();
			//保存贷款申请信息---个人基本信息
			PerInfoVO perinfo = loanApplyTable.getPerinfo();
			//保存贷款申请信息---银行卡信息
			List<BankCardInfo> bankCardList = loanApplyTable.getBankCardList();
			//保存贷款申请信息---信用卡信息
			List<CreditCardInfo> creditCardList = loanApplyTable.getCreditCardList();
			//保存贷款申请信息---联系人信息
			List<LinkPerInfo> linkPerInfoList = loanApplyTable.getLinkPerInfoList();
			//保存订单信息
			LoanApplyOrderDTO order = new LoanApplyOrderDTO();
			order.setCompanyId(loanInfo.getCompanyId());
			order.setOrderType(RiskCheckEnum.CHECK_TO_BE_AUDITED.getCode());
			order.setProductId(loanInfo.getProductId());
			order.setRepayment(loanInfo.getRepayment());
			order.setRepayType(loanInfo.getRepayType());
			order.setUserId(user.getUserId());
			order.setUseType(loanInfo.getLoanUseType());
			loanOrderDao.insertLoanOrder(order);
			Long orderId = order.getId();
			//保存个人基本信息
			PerInfoDTO perInfoDTO = new PerInfoDTO();
			perInfoDTO.setAmount(loanInfo.getAmount());
			perInfoDTO.setArea(perinfo.getNativeArea());
			perInfoDTO.setCity(perinfo.getNativeCity());
			perInfoDTO.setProvince(perinfo.getNativeProvince());
			perInfoDTO.setDownImage(perinfo.getDownImage());
			perInfoDTO.setEdu(perinfo.getEdu());
			perInfoDTO.setEmail(perinfo.getEMail());
			perInfoDTO.setIdCard(perinfo.getIdCard());
			perInfoDTO.setIdCardLocation(perinfo.getIdCardLocation());
			perInfoDTO.setLocation(perinfo.getNowLocation());
			perInfoDTO.setMarryInfo(perinfo.getMarryInfo());
			perInfoDTO.setName(perinfo.getApplicantName());
			perInfoDTO.setOrderId(orderId);
			perInfoDTO.setPhoneNumber(perinfo.getPhoneNum());
			perInfoDTO.setPostalCode(perinfo.getPostalCode());
			perInfoDTO.setSex(perinfo.getSex());
			perInfoDTO.setSocialNum(perinfo.getSocialNum());
			perInfoDTO.setSupportNum(perinfo.getSupportNum());
			perInfoDTO.setUpImage(perinfo.getUpImage());
			perInfoDTO.setWechatCode(perinfo.getWeChatCode());
			loanApplyDao.insertPerInfo(perInfoDTO);
			//添加银行卡信息
			List<LoanBankDTO> bankInfo = new ArrayList<LoanBankDTO>();
			for(BankCardInfo bankIndex :bankCardList) {
				LoanBankDTO bankDTO = new LoanBankDTO();
				bankDTO.setBankName(bankIndex.getBankName());
				bankDTO.setCode(bankIndex.getBankCardCode());
				bankDTO.setDownImage(bankIndex.getBankCardDownImage());
				bankDTO.setOrderId(orderId);
				bankDTO.setUpImage(bankIndex.getBankCardUpImage());
				bankInfo.add(bankDTO);
			}
			bankDao.addBank(bankInfo);
			//添加信号卡信息
			List<LoanBankDTO> creditCardInfo = new ArrayList<LoanBankDTO>();
			for(CreditCardInfo creditCard : creditCardList) {
				LoanBankDTO bankDTO = new LoanBankDTO();
				bankDTO.setBankName(creditCard.getCreditName());
				bankDTO.setCode(creditCard.getCreditCardCode());
				bankDTO.setDownImage(creditCard.getCreditCardDownImage());
				bankDTO.setOrderId(orderId);
				bankDTO.setUpImage(creditCard.getCreditCardUpImage());
				creditCardInfo.add(bankDTO);
			}
			bankDao.addCreditCard(creditCardInfo);
			List<LinkPerDTO> linkPerList = new ArrayList<LinkPerDTO>();
			for (LinkPerInfo linkPer : linkPerInfoList) {
				LinkPerDTO linkPerDTO = new LinkPerDTO();
				linkPerDTO.setLocation(linkPer.getLinkPerLocation());
				linkPerDTO.setName(linkPer.getLinkPerName());
				linkPerDTO.setPhoneNumber(linkPer.getLinkPerPhoneNumber());
				linkPerDTO.setRelationship(linkPer.getLinkPerType());
				linkPerDTO.setOrderId(orderId);
				linkPerList.add(linkPerDTO);
			}
			linkPerDao.addLinker(linkPerList);
			return new CreateLoanApplyTableResponseVO(SysDicEnum.SUCCESS.getCode(),SysDicEnum.SUCCESS.getMessage());
		}catch (Exception e) {
			return new CreateLoanApplyTableResponseVO(SysDicEnum.ERROR.getCode(),SysDicEnum.ERROR.getMessage());
		}
	}
	
	/**
	 * 图片上传
	 * 将图片上传到oss
	 * 返回对应的url给前端
	 */
	@Override
	public ImageResponseVO uploadImage(MultipartFile file) {
		OSSClientUtil ossClient = new OSSClientUtil();
//        String name = ossClient.uploadImg2Oss(file,1L);
//        String path = ossClient.getImageUrl(name);
        ImageResponseVO result = new ImageResponseVO();
//        result.setImageUrl(path);
//        result.setCode(HttpStatus.OK.value());
		return result;
	}
	
	/**
	 * 根据用户获取贷款申请列表
	 */
	@Override
	public List<LoanApplyFromResponseVo> getLoanApplyTableListByUser(UserInfoDTO user,PageInfo page) {
		List<LoanApplyFromResponseVo> result = new ArrayList<LoanApplyFromResponseVo>();
		//首先获取所有的订单
		Long userId = user.getUserId();
		List<LoanApplyOrder> orderList = orderRepository.findByUserIdAndDeleteFlag(userId, SysDicEnum.SYS_VALID.getCode());
//		List<LoanInfoVO> findMyToBeAuuditedByPage = loanApplyDao.findMyToBeAuuditedByPage(page.getPageNum(), page.getPageSize());
		for (LoanApplyOrder loanApplyOrder : orderList) {
			//根据订单id获取订单信息
			Long productId = loanApplyOrder.getProductId();
			Long orderId = loanApplyOrder.getId();
			//根据订单Id获取订单信息
			LoanApplicantPerInfo loanApplicant = loanApplicantRepository.findByOrderIdAndDeleteFlag(orderId,SysDicEnum.SYS_VALID.getCode());
			//根据数据封装数据
			LoanApplyFromResponseVo loanApplyFromResponseVo = new LoanApplyFromResponseVo();
			loanApplyFromResponseVo.setName(loanApplicant.getApplicantName());
			loanApplyFromResponseVo.setUserId(userId);
			loanApplyFromResponseVo.setOrderId(orderId);
			loanApplyFromResponseVo.setApplyAmount(loanApplicant.getApplyAmount());
			//根据产品id获取对应的公司信息
			CompanyProductLink companyLink = companyProductLinkRepository.findByProductId(productId);
			//根据公司id获取公司信息
			Company company = companyRepository.findById(companyLink.getCompanyId()).get();
			loanApplyFromResponseVo.setCompanyId(company.getId());
			loanApplyFromResponseVo.setCompanyNmae(company.getCompanyName());
			loanApplyFromResponseVo.setCreateDate(sdf.format(loanApplicant.getCreateTime()));
			loanApplyFromResponseVo.setLoanType(RiskCheckEnum.getMessageByCode(loanApplyOrder.getOrderType()));
			loanApplyFromResponseVo.setProductId(productId);
			loanApplyFromResponseVo.setProductName(productRepository.findById(productId).get().getProductName());
			result.add(loanApplyFromResponseVo);
		}
		return result;
	}
	
	/**
	 * 搜索贷款申请订单列表
	 */
	@Override
	public SysListResponseVO searchLoanTable(UserInfoDTO user, SearchPageInfoRequestVO searchPageInfo) {
		try {
			SysListResponseVO result = new SysListResponseVO();
			LimitDto limit = Page.getLimit(searchPageInfo.getPageNum(), searchPageInfo.getPageSize());
			LoanApplyOrderSearchDTO searchAndPageInfo = new LoanApplyOrderSearchDTO();
			searchAndPageInfo.setCompanyName(searchPageInfo.getCompanyName());
			searchAndPageInfo.setOrderType(searchPageInfo.getOrderType());
			searchAndPageInfo.setProductName(searchPageInfo.getProductName());
			searchAndPageInfo.setLimitStart(limit.getLimitStart());
			searchAndPageInfo.setLimitEnd(limit.getLimitEnd());
			searchAndPageInfo.setUserId(user.getUserId());
			List<Map> data = loanApplyDao.searchPageLoanOrderByUserId(searchAndPageInfo);
			result.setCode(SysDicEnum.SUCCESS.getCode());
			result.setData(data);
			result.setMessage("数据查询成功");
			return result;
		}catch (Exception e) {
			return new SysListResponseVO(SysDicEnum.ERROR.getCode(),"数据查询失败",null);
		}
	}
	
	/**
	 * 身份证正反面上传
	 */
	@Override
	public ImageReponseVO uploadPerIdCardImage(UserInfoDTO user, Integer face, MultipartFile file) {
		try {
			OSSClientUtil ossClientUtil = new OSSClientUtil();
			String key = ossClientUtil.uploadImgPerIdCard(file,face);
			String url = ossClientUtil.getHeadImageUrl(key);
			return new ImageReponseVO(SysDicEnum.SUCCESS.getCode(),"图片上传成功",url,key);
		}catch (Exception e) {
			return new ImageReponseVO(SysDicEnum.ERROR.getCode(),"图片上传失败");
		}
	}
	
	/**
	 * 上传银行卡正反面
	 */
	@Override
	public ImageReponseVO uploadBankCardImage(UserInfoDTO user, Integer face, MultipartFile file) {
		try {
			OSSClientUtil ossClientUtil = new OSSClientUtil();
			String key = ossClientUtil.uploadBankCard(file,face);
			String url = ossClientUtil.getHeadImageUrl(key);
			return new ImageReponseVO(SysDicEnum.SUCCESS.getCode(),"图片上传成功",url,key);
		}catch (Exception e) {
			return new ImageReponseVO(SysDicEnum.ERROR.getCode(),"图片上传失败");
		}
	}
	
	@Override
	public ImageReponseVO uploadCreditCardImage(UserInfoDTO user, Integer face, MultipartFile file) {
		try {
			OSSClientUtil ossClientUtil = new OSSClientUtil();
			String key = ossClientUtil.uploadCreditCard(file,face);
			String url = ossClientUtil.getHeadImageUrl(key);
			return new ImageReponseVO(SysDicEnum.SUCCESS.getCode(),"图片上传成功",url,key);
		}catch (Exception e) {
			return new ImageReponseVO(SysDicEnum.ERROR.getCode(),"图片上传失败");
		}
	}
	
}

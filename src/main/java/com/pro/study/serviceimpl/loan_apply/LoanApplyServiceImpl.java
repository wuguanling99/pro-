package com.pro.study.serviceimpl.loan_apply;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.pro.study.dao.company.CompanyProductLinkRepository;
import com.pro.study.dao.company.CompanyRepository;
import com.pro.study.dao.loan_apply.LoanApplicantRepository;
import com.pro.study.dao.loan_apply.LoanApplyMybatisDao;
import com.pro.study.dao.loan_apply.LoanApplyOrderRepository;
import com.pro.study.dao.loan_apply.LoanBankInfoRepository;
import com.pro.study.dao.loan_apply.LoanCreditCardRepository;
import com.pro.study.dao.loan_apply.LoanLinkPerRepository;
import com.pro.study.dao.product.ProductRepository;
import com.pro.study.dto.user.UserInfoDTO;
import com.pro.study.enums.RiskCheckEnum;
import com.pro.study.enums.SysDicEnum;
import com.pro.study.po.company.Company;
import com.pro.study.po.company.CompanyProductLink;
import com.pro.study.po.loan.LoanApplicantBankCardInfo;
import com.pro.study.po.loan.LoanApplicantCreditCardInfo;
import com.pro.study.po.loan.LoanApplicantLinkInfo;
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
import com.pro.study.vo.response.loan_apply.CreateLoanApplyTableResponseVO;
import com.pro.study.vo.response.loan_apply.ImageResponseVO;
import com.pro.study.vo.response.loan_apply.LoanApplyFromResponseVo;

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
			//数据入库
			LoanApplyOrder loanApplyOrder = new LoanApplyOrder();
			//保存订单信息
			BeanUtils.copyProperties(loanInfo,loanApplyOrder);
			//封装userId
			loanApplyOrder.setUserId(user.getUserId());
			//添加审核默认状态--待审核
			loanApplyOrder.setOrderType(RiskCheckEnum.CHECK_TO_BE_AUDITED.getCode());
			LoanApplyOrder save = orderRepository.save(loanApplyOrder);
			//拿到订单id
			Long orderId = save.getId();
			//保存个人基本信息
			LoanApplicantPerInfo loanApplicantPerInfo = new LoanApplicantPerInfo();
			BeanUtils.copyProperties(perinfo,loanApplicantPerInfo);
			loanApplicantPerInfo.setOrderId(orderId);
			loanApplicantRepository.save(loanApplicantPerInfo);
			//保存联系人信息
			List<LoanApplicantLinkInfo> linkPerList = new ArrayList<LoanApplicantLinkInfo>();
			for(BankCardInfo index : bankCardList) {
				LoanApplicantLinkInfo loanApplicantLinkInfo = new LoanApplicantLinkInfo();
				BeanUtils.copyProperties(index,loanApplicantLinkInfo );
				loanApplicantLinkInfo.setOrderId(orderId);
				linkPerList.add(loanApplicantLinkInfo);
			}
			loanLinkRepository.saveAll(linkPerList);
			//保存银行卡信息
			List<LoanApplicantBankCardInfo> bankInfoList = new ArrayList<LoanApplicantBankCardInfo>();
			for(BankCardInfo index : bankCardList){
				LoanApplicantBankCardInfo bankInfo = new LoanApplicantBankCardInfo();
				BeanUtils.copyProperties(index, bankInfo);
				bankInfo.setOrderId(orderId);
				bankInfoList.add(bankInfo);
			}
			loanBankCardRepository.saveAll(bankInfoList);
			//保存信用卡信息
			List<LoanApplicantCreditCardInfo> creditCardInfoList = new ArrayList<LoanApplicantCreditCardInfo>();
			for(CreditCardInfo index :creditCardList) {
				LoanApplicantCreditCardInfo creditCard = new LoanApplicantCreditCardInfo();
				BeanUtils.copyProperties(index, creditCard);
				creditCard.setOrderId(orderId);
				creditCardInfoList.add(creditCard);
			}
			loanCreditCardRepository.saveAll(creditCardInfoList);
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
        String name = ossClient.uploadImg2Oss(file,1L);
        String path = ossClient.getImageUrl(name);
        ImageResponseVO result = new ImageResponseVO();
        result.setImageUrl(path);
        result.setCode(HttpStatus.OK.value());
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

}

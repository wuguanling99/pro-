package com.pro.study.serviceimpl.loan_apply;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.pro.study.dto.user.UserInfoDTO;
import com.pro.study.service.loan_aypply.LoanApplyService;
import com.pro.study.utils.OSSClientUtil;
import com.pro.study.utils.UserUtils;
import com.pro.study.vo.request.loan_apply.LoanApplyTableRequestVO;
import com.pro.study.vo.response.loan_apply.CreateLoanApplyTableResponseVO;
import com.pro.study.vo.response.loan_apply.ImageResponseVO;

/** 
* @author: wgl
* @date: 2020年3月3日下午5:59:53 
* @version:1.0
* @Description: 贷款申请业务实现
*/
@Service
public class LoanApplyServiceImpl implements LoanApplyService{
	
	/**
	 * 创建用户贷款申请表
	 */
	@Override
	public CreateLoanApplyTableResponseVO createLoanApplyTable(LoanApplyTableRequestVO loanApplyTable,
			HttpServletRequest request) {
		UserInfoDTO user = UserUtils.getUser(request);
		//根据用户信息添加贷款申请表
		return null;
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

}

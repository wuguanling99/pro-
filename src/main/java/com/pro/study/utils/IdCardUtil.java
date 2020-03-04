package com.pro.study.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.pro.study.enums.SysDicEnum;
import com.pro.study.enums.SysLoanApplyTableEnum;
import com.pro.study.exception.IdCardRuntimeException;

/**
 * 
* @author: wgl
* @date: 2020年3月3日下午6:21:56 
* @version:1.0
* @Description:身份证号工具类
 */
public class IdCardUtil {
	
	 private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	/**
	 * 
	* @throws ParseException 
	 * @Description:（根据身份证号获取年龄） 
	* 方法返回值:
	 */
	public static Integer getAge(String idCard) throws ParseException {
		try {
		if(idCard.length()==SysLoanApplyTableEnum.LENGTHBY18_IDCARD.getCode()) {
			//采用18位的处理办法430203199206251018
			String year = idCard.substring(6,10);
	        // 得到月份
	        String month = idCard.substring(10,12);
	        //得到日
	        String day = idCard.substring(12,14);
	        //搞糟生日
	        return getAgeByBirthday(year,month,day);
		}else if(idCard.length()==SysLoanApplyTableEnum.LENGTHBY15_IDCARD.getCode()) {
			//采用15位的处理办法 130503 670401 001的含义; 13为河北，05为邢台，03为桥西区，出生日期为1967年4月1日
			String year = idCard.substring(6,8);
	        // 得到月份
	        String month = idCard.substring(8,10);
	        //得到日
	        String day = idCard.substring(10,12);
	        //搞糟生日
	        year = "19"+year;
	        return getAgeByBirthday(year,month,day);
			
		}else {
			throw new IdCardRuntimeException();
		}}catch (Exception e) {
			throw new IdCardRuntimeException();
		}
	} 
	
	/**
	 * 
	* @Description:（根据年月日获取年龄） 
	* 方法返回值: @param year
	* 方法返回值: @param month
	* 方法返回值: @param day
	* 方法返回值: @return
	* 方法返回值: @throws ParseException
	 */
	private static Integer getAgeByBirthday(String year,String month,String day) throws ParseException {
		Date birthday = sdf.parse(year+"-"+month+"-"+day);
        Calendar cal = Calendar.getInstance();
        Calendar birthdayCale = Calendar.getInstance();
        birthdayCale.setTime(birthday);
        int iCurrYear = cal.get(Calendar.YEAR);
        Integer age = iCurrYear - birthdayCale.get(Calendar.YEAR);
        return age;
	}
	/**
	 * 
	* @Description:（根据身份证号获取性别） 
	* 方法返回值: @param idCard
	* 方法返回值: @return
	 */
	public static SysLoanApplyTableEnum getSex(String idCard) {
		try {
			if(idCard.length()==SysLoanApplyTableEnum.LENGTHBY18_IDCARD.getCode()) {
				//采用18位的处理办法430203199206251018
				//第17位代表性别，奇数为男，偶数为女
				String num = idCard.substring(16,17);
				Integer sexNumber = Integer.valueOf(num);
				return sexNumber % 2 == 0? SysLoanApplyTableEnum.WOMAN:SysLoanApplyTableEnum.MAN;
			}else if(idCard.length()==SysLoanApplyTableEnum.LENGTHBY15_IDCARD.getCode()) {
				//采用15位的处理办法 130503 670401 001的含义; 13为河北，05为邢台，03为桥西区，出生日期为1967年4月1日
				//最末一位数是奇数的分配给男性，偶数分配给女性
				String num = idCard.substring(idCard.length()-1,idCard.length());
				Integer sexNumber = Integer.valueOf(num);
				return sexNumber % 2 == 0? SysLoanApplyTableEnum.WOMAN:SysLoanApplyTableEnum.MAN;
			}else {
				throw new IdCardRuntimeException();
			}
			}catch (Exception e) {
				throw new IdCardRuntimeException();
			}
	}
	
	public static void main(String[] args) throws ParseException {
		String idCard = "430203199206251018";
		System.out.println(getSex(idCard).getMessage());
	}
}

package com.pro.study.utils;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSException;
import com.aliyun.oss.model.BucketInfo;
import com.aliyun.oss.model.OSSObject;
import com.aliyun.oss.model.OSSObjectSummary;
import com.aliyun.oss.model.ObjectListing;
import com.pro.study.dto.oss.OssBucketInfoDto;
import com.pro.study.dto.oss.SaveObjectDto;
import com.pro.study.enums.SysDicEnum;

/**
 * @author: wgl
 * @date: 2020年3月6日上午12:54:26
 * @version:1.0
 * @Description:
 */
@Component
public class OSSClientUtils {

//	@Value("endpoint")
//	private static String endpoint;
//
//	@Value("accessKeyId")
//	private static String accessKeyId;
//
//	@Value("accessKeySecret")
//	private static String accessKeySecret;
//
//	@Value("bucketName")
//	private static String bucketName;
//
//	private static String firstKey = "my-first-key";
//
//	/**
//	 * 
//	 * @Description:（获取OssClient） 方法返回值: @return 方法返回值: @throws Exception
//	 */
//	private static OSSClient getClient() throws Exception {
//		OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
//		if (ossClient.doesBucketExist(bucketName)) {
//			System.out.println("您已经创建Bucket：" + bucketName + "。");
//		} else {
//			System.out.println("您的Bucket不存在，创建Bucket：" + bucketName + "。");
//			ossClient.createBucket(bucketName);
//		}
//		return ossClient;
//	}
//
//	/**
//	 * 
//	 * @Description:（关闭ossclient连接） 方法返回值: @param ossclient 方法返回值: @return
//	 */
//	private static void closeClient(OSSClient ossclient) {
//		ossclient.shutdown();
//	}
//
//	/**
//	 * 
//	 * @Description:（获取Bucket信息） 方法返回值: @return 方法返回值: @throws Exception
//	 */
//	public static OssBucketInfoDto getBucketInfo() throws Exception {
//		OssBucketInfoDto ossBucketInfoDto = new OssBucketInfoDto();
//		OSSClient ossClient = getClient();
//		try {
//			BucketInfo info = ossClient.getBucketInfo(bucketName);
//			ossBucketInfoDto.setBucketName(bucketName);
//			ossBucketInfoDto.setCreateDate(info.getBucket().getCreationDate());
//			ossBucketInfoDto.setLocation(info.getBucket().getLocation());
//			ossBucketInfoDto.setOwner(info.getBucket().getOwner());
//		} catch (Exception e) {
//			throw new Exception();
//		} finally {
//			closeClient(ossClient);
//		}
//		return ossBucketInfoDto;
//	}
//
//	/**
//	 * 
//	 * @throws Exception
//	 * @Description:（字符串上传)
//	 */
//	public static SaveObjectDto uploadString(String data, String key) throws Exception {
//
//		OSSClient ossClient = getClient();
//		try {
//			InputStream is = new ByteArrayInputStream(data.getBytes());
//			ossClient.putObject(bucketName, firstKey, is);
//			System.out.println("Object：" + firstKey + "存入OSS成功。");
//			return new SaveObjectDto(SysDicEnum.OSS_UPLOAD_SUCCESS);
//		} catch (Exception e) {
//			throw new Exception();
//		} finally {
//			closeClient(ossClient);
//			return new SaveObjectDto(SysDicEnum.OSS_UPLOAD_FAILD);
//		}
//	}
//
//	/**
//	 * 
//	 * @Description:（根据key获取字符串） 方法返回值:
//	 */
//	public static String getStringByKey() throws Exception {
//		OSSClient ossClient = getClient();
//		try {
//			OSSObject ossObject = ossClient.getObject(bucketName, firstKey);
//			InputStream inputStream = ossObject.getObjectContent();
//			StringBuilder objectContent = new StringBuilder();
//			BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
//			while (true) {
//				String line = reader.readLine();
//				if (line == null)
//					break;
//				objectContent.append(line);
//			}
//			inputStream.close();
//			System.out.println("Object：" + firstKey + "的内容是：" + objectContent);
//			return objectContent.toString();
//		} catch (Exception e) {
//			throw new Exception();
//		} finally {
//			closeClient(ossClient);
//		}
//	}
//
//	/**
//	 * 
//	 * @Description:（OSS文件上传） 方法返回值: @return 方法返回值: @throws Exception
//	 */
//	public static SaveObjectDto saveFile() throws Exception {
//		OSSClient ossClient = getClient();
//		try {
//			String fileKey = "README.md";
//			ossClient.putObject(bucketName, fileKey, new File("README.md"));
//			System.out.println("Object：" + fileKey + "存入OSS成功。");
//		} catch (Exception e) {
//			throw new Exception();
//		} finally {
//			closeClient(ossClient);
//			return new SaveObjectDto(SysDicEnum.OSS_UPLOAD_SUCCESS);
//		}
//	}
//
//	/**
//	 * 
//	 * @throws Exception 
//	 * @Description:（方法功能描述） 方法返回值:
//	 */
//	public static List<String> listObject() throws Exception {
//		OSSClient ossClient = getClient();
//		List<String> result = new ArrayList<String>();
//		try {
//			ObjectListing objectListing = ossClient.listObjects(bucketName);
//			List<OSSObjectSummary> objectSummary = objectListing.getObjectSummaries();
//			System.out.println("您有以下Object：");
//			for (OSSObjectSummary object : objectSummary) {
//				result.add(object.getKey());
//			}
//			return result;
//		} catch (Exception e) {
//			throw new Exception();
//		} finally {
//			closeClient(ossClient);
//			return null;
//		}
//	}
}

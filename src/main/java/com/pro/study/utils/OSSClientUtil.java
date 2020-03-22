package com.pro.study.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.ObjectMetadata;
import com.aliyun.oss.model.PutObjectResult;
import com.pro.study.enums.SysDicEnum;
import com.pro.study.exception.OSSException;

/**
 * @ClassName: OSSClientUtil
 * @Description: TODO
 * @Author: lujinshan
 * @Date: 2019/9/22 11:20
 * @Version: 1.0.0
 */
public class OSSClientUtil {

    public static final Logger logger = LoggerFactory.getLogger(OSSClientUtil.class);


    private String endpoint = "oss-cn-shenzhen.aliyuncs.com";
    /**
     * accessKey
     */
    private String accessKeyId = "LTAITQG8dZD99UEo";
    /**
     * accessKeySecret
     */
    private String accessKeySecret = "bEhhvZ4fJ4mO6twvFBkiMgUzMlGR1Y";
    /**
     * 空间
     */
    private String bucketName = "pro-risk-control";
    /**
     * 文件存储目录
     */
    private String filedir = "head_image/";
    
    private String idCardUpImage = "per_id_card_upimage/";
    
    private String idCardDownImage = "per_id_card_downimage/";
    
    private String headImage = "head_image";
    
    private String bankCardUpImage = "bank_card_upimage/";
    
    private String bankCardDownImage = "bank_card_downimage/";
    
    private String creditCardUpImage = "credit_card_upimage/";
    
    private String creditCardDownImage = "credit_card_downimage/";

    private OSS ossClient;

    /**
     * 设置文件的大小
     */
    private static final Integer MAX_SIZE = 1024 * 1024 * 10;


    public OSSClientUtil(String endpoint, String accessKeyId, String accessKeySecret, String bucketName, String filedir) {
        ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
        this.bucketName = bucketName;
        this.filedir = filedir;

    }

    public OSSClientUtil() {
        ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

    }

    /**
     * 初始化
     */
    public void init() {
        ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
    }

    /**
     * 销毁
     */
    public void destory() {
        ossClient.shutdown();
    }
    
    /**
     * 
    * @Description:（上传身份证照正反面） 
    * 方法返回值: @param file
    * 方法返回值: @param uuid
    * 方法返回值: @param faceFlag
    * 方法返回值: @return
     */
    public String uploadImgPerIdCard(MultipartFile file,Integer faceFlag) {
    	if (file.getSize() > MAX_SIZE) {
            throw new OSSException(SysDicEnum.OSS_UPLOAD_FAILD);
        }
        //获取文件名
        String originalFilename = file.getOriginalFilename();
        //获取文件后缀名
        String substring = originalFilename.substring(originalFilename.lastIndexOf(".")).toLowerCase();
        //判断图片格式是否正确
        if (!substring.equals(".jpg") && !substring.equals(".jpeg") && !substring.equals(".png")) {
            throw new OSSException(SysDicEnum.OSS_UPLOAD_FAILD);
        }
        //设置文件名
        String uuid = UUID.randomUUID().toString();
        String name = uuid + substring;
        try {
            InputStream inputStream = file.getInputStream();
            //上传文件
            String dir = faceFlag == SysDicEnum.UP_FACE.getCode()? idCardUpImage:idCardDownImage;
            this.uploadImage(inputStream, name,dir);
            return name;
        } catch (Exception e) {
            throw new OSSException(SysDicEnum.OSS_UPLOAD_FAILD);
        }
    }
    
	/**
	 * 指定文件名为Id
	 */
    public String uploadImgHeadImage(MultipartFile file, Long id) {

        if (file.getSize() > MAX_SIZE) {
            throw new OSSException(SysDicEnum.OSS_UPLOAD_FAILD);
        }
        //获取文件名
        String originalFilename = file.getOriginalFilename();
        //获取文件后缀名
        String substring = originalFilename.substring(originalFilename.lastIndexOf(".")).toLowerCase();
        //判断图片格式是否正确
        if (!substring.equals(".jpg") && !substring.equals(".jpeg") && !substring.equals(".png")) {
            throw new OSSException(SysDicEnum.OSS_UPLOAD_FAILD);
        }
        //设置文件名
        String name = id + substring;
        try {
            InputStream inputStream = file.getInputStream();
            //上传文件
            this.uploadImage(inputStream, name,headImage);
            return name;
        } catch (Exception e) {
            throw new OSSException(SysDicEnum.OSS_UPLOAD_FAILD);
        }
    }

    /**
     * 手动拼接访问路径
     * @param name
     * @return
     */
    public String getImageUrl(String name) {
        return "https://" + bucketName + "." + endpoint + "/" + filedir + name;
    }
    /**
     * 
    * @Description:（上传头像） 
    * 方法返回值: @param file
    * 方法返回值: @return
    * 方法返回值: @throws Exception
     */
    public String uploadImgHeadImage(MultipartFile file) throws Exception {
        if (file.getSize() > 1024 * 1024 * 10) {
            throw new Exception("上传图片大小不能超过10M！");
        }
        String originalFilename = file.getOriginalFilename();
        String substring = originalFilename.substring(originalFilename.lastIndexOf(".")).toLowerCase();
        Random random = new Random();
        String name = random.nextInt(10000) + System.currentTimeMillis() + substring;
        try {
            InputStream inputStream = file.getInputStream();
            this.uploadImage(inputStream, name,headImage);
            return name;
        } catch (Exception e) {
            throw new Exception("图片上传失败02");
        }
    }

    /**
     * 获得图片路径
     *
     * @param fileUrl
     * @return
     */
    public String getImgUrl(String fileUrl) {
        if (!StringUtils.isEmpty(fileUrl)) {
            String[] split = fileUrl.split("/");
            return this.getUrl(this.filedir + split[split.length - 1]);
        }
        return null;
    }

    /**
     * 上传到OSS服务器  如果同名文件会覆盖服务器上的
     *
     * @param instream 文件流
     * @param fileName 文件名称 包括后缀名
     * @return 出错返回"" ,唯一MD5数字签名
     */
    public String uploadImage(InputStream instream, String fileName,String dir) {
        String ret = "";
        try {
            //创建上传Object的Metadata
            ObjectMetadata objectMetadata = new ObjectMetadata();
            objectMetadata.setContentLength(instream.available());
            objectMetadata.setCacheControl("no-cache");
            objectMetadata.setHeader("Pragma", "no-cache");
            objectMetadata.setContentType(getContentType(fileName.substring(fileName.lastIndexOf("."))));
            objectMetadata.setContentDisposition("inline;filename=" + fileName);
            //上传文件
            PutObjectResult putResult = ossClient.putObject(bucketName, dir + fileName, instream, objectMetadata);
            ret = putResult.getETag();
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        } finally {
            try {
                if (instream != null) {
                    instream.close();
                }
            } catch (IOException e) {
                throw new OSSException(SysDicEnum.OSS_UPLOAD_FAILD);
            }
        }
        return ret;
    }

    /**
     * Description: 判断OSS服务文件上传时文件的contentType
     *
     * @param FilenameExtension 文件后缀
     * @return String
     */
    public static String getContentType(String FilenameExtension) {
        if (FilenameExtension.equalsIgnoreCase(".bmp")) {
            return "image/bmp";
        }
        if (FilenameExtension.equalsIgnoreCase(".gif")) {
            return "image/gif";
        }
        if (FilenameExtension.equalsIgnoreCase(".jpeg") ||
                FilenameExtension.equalsIgnoreCase(".jpg") ||
                FilenameExtension.equalsIgnoreCase(".png")) {
            return "image/jpeg";
        }
        if (FilenameExtension.equalsIgnoreCase(".html")) {
            return "text/html";
        }
        if (FilenameExtension.equalsIgnoreCase(".txt")) {
            return "text/plain";
        }
        if (FilenameExtension.equalsIgnoreCase(".vsd")) {
            return "application/vnd.visio";
        }
        if (FilenameExtension.equalsIgnoreCase(".pptx") ||
                FilenameExtension.equalsIgnoreCase(".ppt")) {
            return "application/vnd.ms-powerpoint";
        }
        if (FilenameExtension.equalsIgnoreCase(".docx") ||
                FilenameExtension.equalsIgnoreCase(".doc")) {
            return "application/msword";
        }
        if (FilenameExtension.equalsIgnoreCase(".xml")) {
            return "text/xml";
        }
        return "image/jpeg";
    }

    /**
     * 获得url链接
     *
     * @param key
     * @return
     */
    public String getUrl(String key) {
        // 设置URL过期时间为10年  3600l* 1000*24*365*10
        Date expiration = new Date(System.currentTimeMillis() + 3600L * 1000 * 24 * 365 * 10);
        // 生成URL
        URL url = ossClient.generatePresignedUrl(bucketName, key, expiration);
        if (url != null) {
            return url.toString();
        }
        return null;
    }
    
    /**
     * 
    * @Description:（获取头像url） 
       * 方法返回值: @param upload
     */
	public String getHeadImageUrl(String upload) {
		OSSClientUtil ossClientUtil = new OSSClientUtil();
		String key = ossClientUtil.filedir+upload;
    	String imageUrl = ossClientUtil.getUrl(key);	
    	return imageUrl;
	}
	
	/**
	 * 
	* @Description:（上传银行卡正反面） 
	* 方法返回值: @param file
	* 方法返回值: @param face
	* 方法返回值: @return
	 */
	public String uploadBankCard(MultipartFile file, Integer faceFlag) {
		if (file.getSize() > MAX_SIZE) {
            throw new OSSException(SysDicEnum.OSS_UPLOAD_FAILD);
        }
        //获取文件名
        String originalFilename = file.getOriginalFilename();
        //获取文件后缀名
        String substring = originalFilename.substring(originalFilename.lastIndexOf(".")).toLowerCase();
        //判断图片格式是否正确
        if (!substring.equals(".jpg") && !substring.equals(".jpeg") && !substring.equals(".png")) {
            throw new OSSException(SysDicEnum.OSS_UPLOAD_FAILD);
        }
        //设置文件名
        String uuid = UUID.randomUUID().toString();
        String name = uuid + substring;
        try {
            InputStream inputStream = file.getInputStream();
            //上传文件
            String dir = faceFlag == SysDicEnum.UP_FACE.getCode()? bankCardUpImage:bankCardDownImage;
            this.uploadImage(inputStream, name,dir);
            return name;
        } catch (Exception e) {
            throw new OSSException(SysDicEnum.OSS_UPLOAD_FAILD);
        }
	}

	/**
	 * 
	* @Description:（上传信用卡正反面） 
	* 方法返回值: @param file
	* 方法返回值: @param faceFlag
	* 方法返回值: @return
	 */
	public String uploadCreditCard(MultipartFile file, Integer faceFlag) {
		if (file.getSize() > MAX_SIZE) {
            throw new OSSException(SysDicEnum.OSS_UPLOAD_FAILD);
        }
        //获取文件名
        String originalFilename = file.getOriginalFilename();
        //获取文件后缀名
        String substring = originalFilename.substring(originalFilename.lastIndexOf(".")).toLowerCase();
        //判断图片格式是否正确
        if (!substring.equals(".jpg") && !substring.equals(".jpeg") && !substring.equals(".png")) {
            throw new OSSException(SysDicEnum.OSS_UPLOAD_FAILD);
        }
        //设置文件名
        String uuid = UUID.randomUUID().toString();
        String name = uuid + substring;
        try {
            InputStream inputStream = file.getInputStream();
            //上传文件
            String dir = faceFlag == SysDicEnum.UP_FACE.getCode()? creditCardUpImage:creditCardDownImage;
            this.uploadImage(inputStream, name,dir);
            return name;
        } catch (Exception e) {
            throw new OSSException(SysDicEnum.OSS_UPLOAD_FAILD);
        }
	}
}
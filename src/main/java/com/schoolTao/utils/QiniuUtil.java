package com.schoolTao.utils;

import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.Configuration;
import com.qiniu.util.Auth;

public class QiniuUtil {

	// 在七牛注册后获得的accessKey和secretKey（改为自己的）
	//private static String accessKey = "ttDj7eFji3ChITOuWcrSFadGodP4gPVhVZkUABKP";
	//private static String secretKey = "S0qoo2Ctc9kt3QNGDc33ByA2ARHESyc4H_TYsMvx";
	//private static String bucket = "schooltao"; // 七牛空间名（改为自己的）
	
	private static String accessKey = "yuRzKm9gBxSwnwFEt5rDxTJfhZL-HG8_-5XIVQnU";
	private static String secretKey = "yT1sBtt9FSUKm3KF_GAtY1c8k_y8I2PVx5B7Z5vs";
	private static String bucket = "schooltao1"; // 七牛空间名（改为自己的）
	// 获取覆盖同名文件的上传凭证
	public static String getToken(String key) {
		Auth auth = Auth.create(accessKey, secretKey);
		String upToken = auth.uploadToken(bucket, key, 3600, null, true); // 生成覆盖相同key文件的上传Token
		return upToken;
	}

	// 删除七牛中指定key的文件
	public static void delFile(String key) {
		// 构造一个带指定Zone对象的配置类
		String[] path = key.split("/");
		key = path[3];
		//System.out.println(key);
		Configuration cfg = new Configuration(Zone.autoZone());
		Auth auth = Auth.create(accessKey, secretKey);
		BucketManager bucketManager = new BucketManager(auth, cfg);
		try {
			bucketManager.delete(bucket, key);
		} catch (QiniuException ex) {
			// 如果遇到异常，说明删除失败
			System.err.println(ex.code());
			System.err.println(ex.response.toString());
		}
	}

}

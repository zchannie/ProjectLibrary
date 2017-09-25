package cn.csbe.web.cms.common;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.springframework.util.DigestUtils;

/**
 * 智创基类，封装数据的加解密方法
 * @author e
 *
 */
public class CSBE {
	// 返回码 说明
    public final static Integer OK = 1000;// 请求成功
    public final static Integer ERROR = 9999;// 通用错误
    public final static Integer INVALID_FILE_TYPE = 1004;// 不合法的文件类型
    public final static Integer INVALID_FILE_SIZE = 1005;// 不合法的文件大小
    public final static Integer UPLOAD_FILE_ERR = 1006;// 上传文件异常
    
	public static String file_server = ConfigUtil.getInstance().getValue("fileserver");
    
    public static String htmlPath = ConfigUtil.getInstance().getValue("htmlPath");
    
    public static String ueditorImg=ConfigUtil.getInstance().getValue("ueditorImg");
    
    public static String localStr=ConfigUtil.getInstance().getValue("localStr");
    
    public static String addlocalStr=ConfigUtil.getInstance().getValue("addlocalStr");
    
	
	 public static int getRandomNum() {
        int x;//定义两变量
        Random ne=new Random();//实例化一个random的对象ne
        x=ne.nextInt(999999-100000+1)+100000;//为变量赋随机值1000-9999
        return x;
    }

	/**
	 * 数据加密
	 * @return
	 */
	public static Object encryption(Object object)throws Exception{
		return object;
		/*byte [] bytes = JSONObject.fromObject(object).toString().getBytes("utf-8");
		ObjectIdentifier identifier = ObjectIdentifier.newInternal(new int[246810]);
		return MD5withRSA.encodeSignature(identifier, bytes);*/
	}
	
	/**
	 * 数据解密
	 * @return
	 */
	public static String decryption(String data){
		return data;
	}
	
	/**利用MD5+时间戳进行加密
	 　　* @param str  待加密的字符串
	　　* @return  加密后的字符串
	　　* @throws NoSuchAlgorithmException  没有这种产生消息摘要的算法
	　　 * @throws UnsupportedEncodingException  
	　　*/
	public static String EncoderByMd5(String str){
		
		return DigestUtils.md5DigestAsHex(str.getBytes());
	}
	
	public static void main(String[] args)throws Exception {
		System.out.println(EncoderByMd5("admin"));
	}
	
}

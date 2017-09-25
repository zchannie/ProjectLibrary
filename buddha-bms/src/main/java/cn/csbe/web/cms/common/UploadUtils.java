package cn.csbe.web.cms.common;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;

import net.coobird.thumbnailator.Thumbnails;
import net.sf.json.JSONObject;

import org.springframework.web.multipart.commons.CommonsMultipartFile;


/**
 * 文件上传，工具类
 * @author e
 *
 */
public class UploadUtils{

	//
	private final static String BASE_DIR_PATH = ConfigUtil.getInstance().getValue("uploadPath");//"home/wwwroot/user_data/image/";

	/**
	 * 上传文件工具类
	* @Title: upload 
	* @param  request	用来获取绝对路径
	* @param  mFile	上传控件的属性name的值
	* @param  dirs	上传目录
	* @param 		相对路劲
	 */
	public static UploadResult upload(HttpServletRequest request,CommonsMultipartFile mFile,String dirs){ // 请求参数一定要与form中的参数名对应
		return UploadUtils.upload(request, mFile, dirs, null);
	}
	/**
	 * 上传文件工具类
	* @Title: upload 
	* @param  request	用来获取绝对路径
	* @param  mFile	上传控件的属性name的值
	* @param  dirs	上传目录
	* @param maxSize 最大限制  单位字节
	* @param @return		相对路径
	 */
	public static UploadResult upload(HttpServletRequest request,CommonsMultipartFile mFile,String dirs,Long maxSize){ // 请求参数一定要与form中的参数名对应
		
		UploadResult result = new UploadResult();
		
		if(maxSize != null){
			if(mFile.getSize() > maxSize){
				result.setStatus(CSBE.INVALID_FILE_SIZE);
				result.setValue("文件超出大小");
				return result;//JSONObject.fromObject(result).toString();
			}
		}
		
		if(dirs != null && dirs.trim() != "")
		{
			int beginIndex = 0;
			int endIndex = dirs.length();
			if(dirs.charAt(0) == '/')
			{
				beginIndex = 1;
			}
			
			if(dirs.charAt(dirs.length()-1) == '/')
			{
				endIndex = dirs.length()-1;
			}
			
			dirs = dirs.substring(beginIndex, endIndex);
		}
		if (!mFile.isEmpty()) {
			String realPath = request.getSession().getServletContext().getRealPath("/"); // 获取本地存储路径
			//2.获取文件的总大小
			//Long fileSize = mFile.getSize();
			//3.获取文件名
			String fileName = mFile.getOriginalFilename();//path.substring(path.lastIndexOf("\\")+1);
			//4.获取文件扩展名 ps：没有扩展名 将得到全名
			String extName = fileName.substring(fileName.lastIndexOf('.')+1);
			//5.根据系统时间 生成保存到服务器的文件名
			String prefix = String.valueOf(Calendar.getInstance().getTimeInMillis());
			//6.新文件名称
			String newFileName = prefix +'.'+ extName;
			//7.拼接目录路径
			String dirPath = BASE_DIR_PATH +'/'+ dirs;
			//7.拼接最终目录结构
			String finalRealPath = realPath + dirPath;//D:\apache-tomcat-7.0.75\webapps\buddha-bms\//images/wallpager
			File dir = new File(finalRealPath);
			if(!dir.exists())
			{
				dir.mkdirs();
			}
			//8.保存文件
			File file = new File(dir,newFileName); //把图片保存在dir路径中
			
			try {
				mFile.getFileItem().write(file); // 将上传的文件写入新建的文件中
				result.setStatus(CSBE.OK);//result = "{\"status\":0,\"value\":"+newFileName+"}";
				String filePath = dirs + "/" + newFileName; 
				result.setValue(filePath);
				//缩略图
				if(dirs.equals("images/wallpager")){
					File fromPic=new File(finalRealPath+"/"+newFileName); 
			        File toPic=new File(finalRealPath+"/"+prefix +"_thum."+ extName);
			        Thumbnails.of(fromPic).size(358,636).keepAspectRatio(false).outputQuality(0.3f).toFile(toPic); 
				}
				
			} catch (Exception e) {
				result.setStatus(CSBE.UPLOAD_FILE_ERR);
				result.setValue(e.toString());
				e.printStackTrace();
			}
		}
		return result;
	}
	
	
public static String upload(HttpServletRequest request,CommonsMultipartFile mFile,String dirs,String extName,Long maxSize){ // 请求参数一定要与form中的参数名对应
		
		UploadResult result = new UploadResult();
		
		if(maxSize != null){
			if(mFile.getSize() > maxSize){
				result.setStatus(1);
				result.setValue("文件超出大小");
				return JSONObject.fromObject(result).toString();
			}
		}
		
		if(dirs != null && dirs.trim() != "")
		{
			int beginIndex = 0;
			int endIndex = dirs.length();
			if(dirs.charAt(0) == '/')
			{
				beginIndex = 1;
			}
			
			if(dirs.charAt(dirs.length()-1) == '/')
			{
				endIndex = dirs.length()-1;
			}
			
			dirs = dirs.substring(beginIndex, endIndex);
		}
		//String result = "";
		if (!mFile.isEmpty()) {
			String realPath = request.getSession().getServletContext().getRealPath("/"); // 获取本地存储路径
		    //1.获取文件的完整路径
			//String path = mFile.getOriginalFilename();
			//2.获取文件的总大小
			//Long fileSize = mFile.getSize();
			//3.获取文件名
			//String fileName = mFile.getOriginalFilename();//path.substring(path.lastIndexOf("\\")+1);
			
			//5.根据系统时间 生成保存到服务器的文件名
			String prefix = String.valueOf(Calendar.getInstance().getTimeInMillis());
			//6.新文件名称
			String newFileName = prefix +'.'+ extName;
			//7.拼接目录路径
			String dirPath = BASE_DIR_PATH +'/'+ dirs;
			//7.拼接最终目录结构
			String finalRealPath = realPath + dirPath;
			File dir = new File(finalRealPath);
			if(!dir.exists())
			{
				dir.mkdirs();
			}
			//8.保存文件
			File file = new File(dir,newFileName); // 新建一个文件
			
			try {
				mFile.getFileItem().write(file); // 将上传的文件写入新建的文件中
				result.setStatus(0);//result = "{\"status\":0,\"value\":"+newFileName+"}";
				String filePath = dirs + "/" + newFileName; 
				result.setValue(filePath);
			} catch (Exception e) {
				//result = "{\"status\":1,\"value\":"+e.getMessage()+"}";
				result.setStatus(1);
				result.setValue(e.toString());
				e.printStackTrace();
			}
		}
		return JSONObject.fromObject(result).toString();
	}

	/** 
	 * 上传文件，生成缩略图 
	 * @param file  上传的文件 
	 * @param uploadPath    上传路径相对路径 
	 * @param realUploadPath    原图实际路径 
	 * @return 
	 */  
	public static String thumbnailUploadImage(CommonsMultipartFile file,int width,int height,String uploadPath,String realUploadPath){  
	    String des = realUploadPath + "/thum"+file.getOriginalFilename();//缩略图实际存储路径  
	    try {  
	        Thumbnails.of(file.getInputStream()).size(width, height).toFile(des);  
	    } catch (IOException e) {  
	        e.printStackTrace();  
	    }  
	      
	      
	    return uploadPath + "/thum"+file.getOriginalFilename();  
	}  

}


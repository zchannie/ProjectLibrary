package cn.csbe.web.cms.common;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserTest {
	
	private static String URL = "http://localhost:8080/buddha-bms/idnex.2html";

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		system.out.println("===fdsafasfdsafs");

		//发送 GET 请求
//        String s=HttpRequest.sendGet("http://localhost:8080/buddha-bms/idnex.2html",
//        		"fileName=model");
////        String s=HttpRequest.sendGet("http://localhost:8080/csbe-api/wall/list", "pid=1");
//		System.out.println(s);

		//发送 POST 请求
//        String sr=HttpRequest.sendPost("http://localhost:6144/Home/RequestPostString", "key=123&v=456");
//        System.out.println(sr);
		
//		String str="http://60.205.152.224:8091/buddha-api/model/news/976562.html";
//		System.out.println(str.substring(49, 55));
		
//		String mm=DigestUtils.md5DigestAsHex(("123456"+"/csbe!@#%$^ASD").getBytes());
//		System.out.println(mm);
		
		//创建图片文件(此处为1024×768px的图片)和处理后的图片文件  
//        File fromPic=new File("C:\\Users\\Qi\\Pictures\\64380.jpg");  
//        File toPic=new File("C:\\Users\\Qi\\Pictures\\64380_thum_center.jpg");
//        File waterPic=new File("picture/水印图片.jpg");//作为水印的图片
//    	
//      try {
    	  //根据大小进行缩放
//    	  Thumbnails.of(fromPic).size(300,300).keepAspectRatio(false).toFile(toPic); 
    	  
//    	  InputStream is = null;  
//          BufferedImage src = null;  
//          int ret = -1;  
//          is = new FileInputStream(fromPic);  
//          src = javax.imageio.ImageIO.read(is);  
//          ret = src.getHeight(null); // 得到源图高  
//          is.close();  
//    	  System.out.println(ret);
    	//图片中心400*400的区域
    	  
//    	Thumbnails.of(fromPic).sourceRegion(Positions.CENTER,400,400).size(200,200).keepAspectRatio(false).toFile(toPic);
        
    	//图片右下400*400的区域
//    	Thumbnails.of("images/a380_1280x1024.jpg").sourceRegion(Positions.BOTTOM_RIGHT,400,400).size(200,200).keepAspectRatio(false).toFile("c:/a380_region_bootom_right.jpg");
//	  } catch (IOException e) {
//		  e.printStackTrace();
//	  } 
     
//		Pattern pattern = Pattern.compile("\\d+");  
		
		
		
	}
	
//	// 判断一个字符串是否都为数字  
//	public boolean isDigit(String strNum) {  
//	    return strNum.matches("[0-9]{1,}");  
//	}  
	  
	// 判断一个字符串是否都为数字  
//	public boolean isDigit(String strNum) {  
//	    Pattern pattern = Pattern.compile("[0-9]");  
//	    Matcher matcher = pattern.matcher((CharSequence) strNum);  
//	    return matcher.matches();  
//	}
//	//截取数字  
//	public static String getNumbers(String content) {  
//	    Pattern pattern = Pattern.compile("\\d+");  
//	    Matcher matcher = pattern.matcher(content);  
//	    while (matcher.find()) {  
//	       return matcher.group(0);  
//	    }  
//	    return "";  
//	}

	
	
		
}

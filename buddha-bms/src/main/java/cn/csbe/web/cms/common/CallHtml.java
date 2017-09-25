package cn.csbe.web.cms.common;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

/**
 * 调用动态jsp生成html文件的方法
 * @author chZhou
 * 创建时间：2017-6-28上午9:49:37
 * 描述：
 */
public class CallHtml {
	
	/**
	 * @param fileName   访问的jsp文件
	 * @param path          访问的jsp文件路径
	 * @param realName  要保存的文件名
	 * @param realPath    要保存的文件路径
	 */
	public static void callOnePage(String fileName, String path, 
			String realName, String realPath) { 
			try { 
				String str = "http://localhost:8080/buddha-bms/toHtmlPath?file_name=" 
				+ fileName + "&&path=" + path + "&&realName=" + realName 
				+ "&&realPath=" + realPath; 
				int httpResult; 
				URL url = new URL(str); 
				URLConnection connection = url.openConnection(); 
				connection.connect(); 
				HttpURLConnection httpURLConnection = (HttpURLConnection) connection; 
				httpResult = httpURLConnection.getResponseCode(); 
				if (httpResult != HttpURLConnection.HTTP_OK) { 
					System.out.println("没有连接成功"); 
				} else { 
					System.out.println("连接成功了　"); 
				} 
			} catch (Exception e) { 
			// TODO: handle exception 
			} 
	 }

	 //这个方法适当重载，就可以省去一些参数传递。

}

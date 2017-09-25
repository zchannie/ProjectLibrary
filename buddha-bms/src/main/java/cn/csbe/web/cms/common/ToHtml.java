package cn.csbe.web.cms.common;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.WriteListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * 动态jsp生成html文件
 * @author chZhou
 * 创建时间：2017-6-28上午9:50:03
 * 描述：
 */
public class ToHtml {
	  
	  /**
	 * 
	 */
    
	/**
	 * @param fileName 模板名称
	 * @param htmlUrl   生成html链接+文件名，如：/model/html/xxx  
	 * @param title   参数
	 * @param time  参数
	 * @param num  参数
	 * @param content  参数
	 * @throws ServletException
	 * @throws IOException
	 */
	public static void service(String fileName,String htmlUrl,int rand,String title,String time,int num,String content) throws ServletException, IOException { 
//		HttpServletRequest request = ServletActionContext.getRequest(); 
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest(); 
		HttpServletResponse response = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getResponse(); 
		
		ServletContext sc = request.getServletContext();//为你的应用的上下文路径
		
	        request.setCharacterEncoding("utf-8");
	        request.setAttribute("title", title);
	        request.setAttribute("time", time);
	        request.setAttribute("num", num);
	        request.setAttribute("content", content);
	        
	        // 则你访问这个servlet时加参数.如http://localhost/test/toHtml?fileName=index  
	        String url = "/model/" + fileName + ".jsp";// 你要生成的页面的文件名。扩展名为jsp
	        String htmlPath=sc.getRealPath("/").replace("buddha-bms", "buddha-img");
	        String name = htmlPath + htmlUrl+rand+ ".html";// 这是生成的html文件名  
	        File files=new File(htmlPath+htmlUrl);
	        if(!files.exists()){
	        	files.mkdirs();
	        }
	        RequestDispatcher rd = sc.getRequestDispatcher(url); 
	  
	        final ByteArrayOutputStream os = new ByteArrayOutputStream();  
	        final ServletOutputStream stream = new ServletOutputStream() {  
	            public void write(byte[] data, int offset, int length) {  
	                os.write(data, offset, length);  
	            }  
	            public void write(int b) throws IOException {  
	                os.write(b);  
	            }
				@Override
				public boolean isReady() {
					// TODO Auto-generated method stub
					return false;
				}
				@Override
				public void setWriteListener(WriteListener arg0) {
					// TODO Auto-generated method stub
					
				}  
	        };  
	  
	        final PrintWriter pw = new PrintWriter(new OutputStreamWriter(os));  
	  
	        HttpServletResponse rep = new HttpServletResponseWrapper(response) {  
	            public ServletOutputStream getOutputStream() {  
	                return stream;  
	            }  
	  
	            public PrintWriter getWriter() {  
	                return pw;  
	            }  
	        };  
	        rd.include(request, rep);  
	        pw.flush();  
	          
	        FileOutputStream fos = new FileOutputStream(name); // 把jsp 输出的内容写到xxx.html  
	        os.writeTo(fos);  
	        fos.close();
	    }  
	}  
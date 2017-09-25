package cn.csbe.web.cms.common;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.beanutils.Converter;
  
public class DateConvert implements Converter {  

	public Object convert(@SuppressWarnings("rawtypes") Class arg0, Object arg1) { 
    	if(ObjectUtil.isEmpty(arg1))
    		return null;
    	if(arg1 instanceof Date){
    		return arg1;
    		//return DateUtil.DateToString((Date)arg1, DateUtil.simple);
    	}else{
	        String p = (String)arg1;  
	        if(p== null || p.trim().length()==0){  
	            return null;  
	        }     
	        try{  
	        	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	            return df.parse(p.trim());  
	        }  
	        catch(Exception e){  
	        	return null; 
	        }
	    }  
    }


}
package cn.csbe.web.cms.common;

import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;  
import org.apache.commons.beanutils.BeanUtils;  
import org.apache.commons.beanutils.ConvertUtils; 
import org.apache.commons.beanutils.PropertyUtils;

public class BeanUtilsEx {
    static {  
		ConvertUtils.register(new DateConvert(), java.util.Date.class);  
        ConvertUtils.register(new DateConvert(), java.sql.Date.class);  
    }  
  
    public static void copyProperties(Object dest, Object orig) {  
        try {  
            BeanUtils.copyProperties(dest, orig);  
        } catch (IllegalAccessException ex) {  
            ex.printStackTrace();  
        } catch (InvocationTargetException ex) {  
            ex.printStackTrace();  
        }  
    }  
    
    public static void proCopyPerties(Object dest, Object orig) {  
		try {
			PropertyUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
    }
    
    /**
     * 
    * @Title: getObjToString 
    * @Description: log用bean转string
    * @param @param dest
    * @param @return    设定文件 
    * @return String    返回类型 
    * @throws
     */
    public static String getObjToString(Object dest) {  
        StringBuffer log = new StringBuffer();
		try {
			PropertyDescriptor[] props = Introspector.getBeanInfo(dest.getClass(), Object.class)
	                     .getPropertyDescriptors();

	         if (props != null) {
	             for (int i = 0; i < props.length; i++) {
	                 try {
	                    String name = props[i].getName();//获取bean中的属性
	                    //Object object = props[i].getPropertyType();//获取属性的类型
	                    Object vl = PropertyUtils.getProperty(dest, name);
	                    log.append(" ["+name+":"+vl+"]");
	                    } catch (Exception e) {
	                 }
	             }
	         }
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return log.toString();
    }
}

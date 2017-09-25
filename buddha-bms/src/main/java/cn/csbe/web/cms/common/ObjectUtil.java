package cn.csbe.web.cms.common;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import java.util.regex.Pattern;

public class ObjectUtil {
	/**
	 * 判断Map<String,Object>里指定key的value值是否为空
	 * 
	 * @return boolean -true:表示value为空;false:表示value为非空
	 */
	public static boolean isEmpty(Map<String, Object> params, String key) {
		if (isEmpty(params))
			return true;
		else {
			if (params.containsKey(key) && !isEmpty(params.get(key)))
				return false;
			return true;
		}
	}

	/**
	 * 判断是否为数字
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNumeric(String str) {
		for (int i = str.length(); --i >= 0;) {
			if (!Character.isDigit(str.charAt(i))) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 判断对象是否为空
	 * 
	 * @param obj
	 *            -参数对象
	 * @return boolean -true:表示对象为空;false:表示对象为非空
	 */
	public static boolean isEmpty(Object obj) {
		return obj == null || obj.toString().equalsIgnoreCase("null") || obj.toString().length() == 0
				|| obj.toString().trim() == "";
	}

	/**
	 * 判断非空
	 * 
	 * @param obj
	 * @return
	 */
	public static boolean isNotEmpty(Object obj) {
		return !isEmpty(obj);
	}

	public static final Object NULL = new Serializable() {
		private static final long serialVersionUID = 7092611880189329093L;

		private Object readResolve() {
			return NULL;
		}
	};

	public static Object defaultIfNull(Object object, Object defaultValue) {
		return (object != null) ? object : defaultValue;
	}

	public static boolean equals(Object object1, Object object2) {
		return ArrayUtil.equals(object1, object2);
	}

	public static int hashCode(Object object) {
		return ArrayUtil.hashCode(object);
	}

	public static int identityHashCode(Object object) {
		return (object == null) ? 0 : System.identityHashCode(object);
	}

	public static Object clone(Object array) throws CloneNotSupportedException {
		if (array == null) {
			return null;
		}

		// 对数组特殊处理
		if (array instanceof Object[]) {
			return ArrayUtil.clone((Object[]) array);
		}

		if (array instanceof long[]) {
			return ArrayUtil.clone((long[]) array);
		}

		if (array instanceof int[]) {
			return ArrayUtil.clone((int[]) array);
		}

		if (array instanceof short[]) {
			return ArrayUtil.clone((short[]) array);
		}

		if (array instanceof byte[]) {
			return ArrayUtil.clone((byte[]) array);
		}

		if (array instanceof double[]) {
			return ArrayUtil.clone((double[]) array);
		}

		if (array instanceof float[]) {
			return ArrayUtil.clone((float[]) array);
		}

		if (array instanceof boolean[]) {
			return ArrayUtil.clone((boolean[]) array);
		}

		if (array instanceof char[]) {
			return ArrayUtil.clone((char[]) array);
		}

		// Not cloneable
		if (!(array instanceof Cloneable)) {
			throw new CloneNotSupportedException("Object of class " + array.getClass().getName() + " is not Cloneable");
		}

		// 用reflection调用clone方法
		Class<? extends Object> clazz = array.getClass();

		try {
			Method cloneMethod = clazz.getMethod("clone", ArrayUtil.EMPTY_CLASS_ARRAY);

			return cloneMethod.invoke(array, ArrayUtil.EMPTY_OBJECT_ARRAY);
		} catch (NoSuchMethodException e) {
			throw new CloneNotSupportedException(e + "");
		} catch (IllegalArgumentException e) {
			throw new CloneNotSupportedException(e + "");
		} catch (IllegalAccessException e) {
			throw new CloneNotSupportedException(e + "");
		} catch (InvocationTargetException e) {
			throw new CloneNotSupportedException(e + "");
		}
	}

	public static boolean isSameType(Object object1, Object object2) {
		if ((object1 == null) || (object2 == null)) {
			return true;
		}

		return object1.getClass().equals(object2.getClass());
	}

	public static String toString(Object object) {
		return (object == null) ? StringUtil.EMPTY_STRING
				: (object.getClass().isArray() ? ArrayUtil.toString(object) : object.toString());
	}

	public static String toString(Object object, String nullStr) {
		return (object == null) ? nullStr
				: (object.getClass().isArray() ? ArrayUtil.toString(object) : object.toString());
	}

	public static boolean isIdCard(String idCard) {
		return Pattern.matches("(\\d{14}[0-9a-zA-Z])|(\\d{17}[0-9a-zA-Z])", idCard);
	}

	/**
	 * SHA1算法签名字符串
	 */
	public static String buildSHA1HexSign(String data) {
		char[] DIGITS = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
		byte[] algorithmData = null;
		try {
			algorithmData = MessageDigest.getInstance("SHA1").digest(data.getBytes("UTF-8"));
		} catch (NoSuchAlgorithmException e) {
			return "遇到NoSuchAlgorithmException异常-->[" + e.getMessage() + "]";
		} catch (UnsupportedEncodingException e) {
			return "遇到UnsupportedEncodingException异常-->[" + e.getMessage() + "]";
		}
		char[] respData = new char[algorithmData.length << 1];
		for (int i = 0, j = 0; i < algorithmData.length; i++) {
			respData[j++] = DIGITS[(0xF0 & algorithmData[i]) >>> 4];
			respData[j++] = DIGITS[0x0F & algorithmData[i]];
		}
		return new String(respData);
	}
}
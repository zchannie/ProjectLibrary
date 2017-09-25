package cn.csbe.web.cms.common;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.log4j.Logger;

/**
 * 操作日期的一个工具类
 * 
 * @author xiaoQiang
 *
 */
public class DateUtils {

	private static Logger log = Logger.getLogger(DateUtils.class);
	public static final String dtLong = "yyyyMMddHHmmss";

	/**
	 * 获取格式
	 *
	 * @param format
	 * @return
	 */
	public static final DateFormat getFormat(String format) {
		return new SimpleDateFormat(format);
	}

	/**
	 * 返回长日期格式（yyyyMMddHHmmss格式）
	 *
	 * @param stringDate
	 *
	 * @return
	 *
	 * @throws ParseException
	 */
	public static final String longDate(Date Date) {
		if (Date == null) {
			return null;
		}
		return getFormat(dtLong).format(Date);
	}

	/**
	 * 获取当前时间
	 * 
	 * @return 返回当前日期时间
	 */
	public static Timestamp getCurrentDateTime() {
		return new Timestamp(Calendar.getInstance().getTimeInMillis());
	}

	/**
	 * 获取指定时间
	 * 
	 * @param datetimeStr
	 *            字符串格式的 日期时间
	 * @return 返回指定日期时间
	 */
	public static Timestamp getCustomDateTime(String datetimeStr) {
		return Timestamp.valueOf(datetimeStr);
	}

	/**
	 * 获取日期字符串
	 * 
	 * @param date
	 *            要转换的日期
	 * @param pattern
	 *            转换的模式
	 * @return 日期字符串
	 */
	public static String getDateTimeStr(Date date, String pattern) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
		if (date == null)
			return "";

		return dateFormat.format(date);
	}

	/**
	 * 获取日期字符串
	 * 
	 * @param date
	 *            要转换的日期
	 * @return 默认的日期字符串(yyyy-MM-dd HH:mm:ss)
	 */
	public static String getDateTimeStr(Date date) {
		return DateUtils.getDateTimeStr(date, "yyyy-MM-dd HH:mm:ss");
	}

	/**
	 * 获取日期字符串
	 * 
	 * @param pattern
	 *            转换的模式
	 * @return 当前日期字符串
	 */
	public static String getDateTimeStr(String pattern) {
		return getDateTimeStr(DateUtils.getCurrentDateTime(), pattern);
	}

	/**
	 * 获取日期字符串
	 * 
	 * @return 默认的当前日期字符串(yyyy-MM-dd HH:mm:ss)
	 */
	public static String getDateTimeStr() {
		return getDateTimeStr("yyyy-MM-dd HH:mm:ss");
	}

	public static int calcAge(String datestr) {
		try {
			if (datestr == null)
				return -1;

			log.debug(datestr);
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			if (datestr.length() > 10) {
				datestr = datestr.substring(0, 10);
			}
			Date dt = dateFormat.parse(datestr);
			Date now = new Date();

			return now.getYear() - dt.getYear();
		} catch (Exception e) {
			return -1;
		}
	}

	/**
	 * 判断两个时间是否是同一天
	 * 
	 * @param day1
	 * @param day2
	 * @return
	 */
	public static boolean isSameDay(Date day1, Date day2) {
		if (day1 == null || day2 == null) {
			return false;
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String ds1 = sdf.format(day1);
		String ds2 = sdf.format(day2);
		if (ds1.equals(ds2)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 判断是否是今天
	 * 
	 * @param day1
	 * @param day2
	 * @return
	 */
	public static boolean isToDay(Date day1) {
		Timestamp day2 = new Timestamp(Calendar.getInstance().getTimeInMillis());
		return isSameDay(day1, day2);
	}

	public static void main(String argv[]) {
		Date now = new Date();
		System.out.println(getDateTimeStr(now));

		System.out.println(getDateTimeStr(new Timestamp(now.getTime())));

		System.out.println(getDateTimeStr(new java.sql.Date(now.getTime())));
	}

}

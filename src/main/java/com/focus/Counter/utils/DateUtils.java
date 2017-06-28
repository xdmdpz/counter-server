package com.focus.Counter.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 时间转换助手
 * @author licher
 *
 */
public class DateUtils {
	/**
	 * 将时间字符串转化为日期类型
	 * @param dateStr
	 * @return
	 */
	public static Date convertStrToDate(String dateStr){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = null;
		try {
			date = sdf.parse(dateStr);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;
		
	}
	/**
	 * 将日期类型转化为时间字符串
	 * @param date
	 * @return
	 */
	public static String convertDateToStr(Date date){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(date);
	}
	/**
	 * 根据指定格式将日期类型转化为时间字符串
	 * @param date
	 * @param pattern
	 * @return
	 */
	public static String convertDateToStr(Date date, String pattern){
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.format(date);
	}
}

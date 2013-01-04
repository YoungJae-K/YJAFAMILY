package com.yja.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.yja.constant.YJACommonConst;

/**
 * This class provides the utilities for date.
 * 
 * @author YOUNGJAE KIM
 *
 */
public class YJADateUtil {

	public static final String DATE_YYYYMMDD_SLASH = "yyyy/MM/dd";
	public static final String DATE_YYYYMMDD_HYPEN = "yyyy-MM-dd";
	public static final String DATE_MMDDYYYY_HYPEN = "MM-dd-yyyy";
	public static final String DATE_YYYYMMDD = "yyyyMMdd";
	public static final String TIME_HHMMSS = "hh:mm:ss";

	/**
	 * Returns the string of the current date with time.
	 * (yyyy-MM-dd hh:mm:ss)
	 * 
	 * @return String of the current date
	 * @throws Exception
	 */
	public static String getCurrentDayWithTime() throws Exception {
		return getCurrentDay(DATE_YYYYMMDD_HYPEN + TIME_HHMMSS);
	}

	/**
	 * Returns the string of the current date without time
	 * (yyyy-MM-dd)
	 * 
	 * @return String of the current date
	 * @throws Exception
	 */
	public static String getCurrentDay_YYYYMMDD_HYPEN() throws Exception {
		return getCurrentDay(DATE_YYYYMMDD_HYPEN);
	}

	/**
	 * Returns the string of the current date
	 * (yyyyMMdd)
	 * 
	 * @return String of the current date
	 * @throws Exception
	 */
	public static String getCurrentDayYYYYMMDD() throws Exception {
		return getCurrentDay(DATE_YYYYMMDD);
	}

	/**
	 * Returns the string of the current date
	 * (MMddyyyy)
	 * 
	 * @return String of the current date
	 * @throws Exception
	 */
	public static String getCurrentDay_MMDDYYYY() throws Exception {
		return getCurrentDay(DATE_MMDDYYYY_HYPEN);
	}

	/**
	 *  Returns the string of the current date with the specified format
	 *  
	 * @param Date format converting
	 * @return String of the current date
	 * @throws Exception
	 */
	public static String getCurrentDay(String dateFormatStr) throws Exception {
		SimpleDateFormat dateFormat = new SimpleDateFormat(dateFormatStr);
		Date date = new Date();
		return dateFormat.format(date);
	}

	/**
	 * Converts Date to the string with the specified format
	 * 
	 * @param Date format converting
	 * @param Date converting 
	 * @return String of the date converted
	 * @throws Exception
	 */
	public static String getStringFromDate(String format, Date date)
			throws Exception {
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		return dateFormat.format(date);
	}

	/**
	 * Returns Date to add the specified day
	 * 
	 * @param String of Date
	 * @param Specified day to add
	 * @return String of the date
	 * @throws Exception
	 */
	public static Date getDatePlusDay(String dateStr, int plusDay)
			throws Exception {
		SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_YYYYMMDD_HYPEN);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(dateFormat.parse(dateStr));
		calendar.roll(Calendar.DAY_OF_MONTH, plusDay);

		return calendar.getTime();
	}

	/**
	 * Returns String of the date to add the specified day
	 * 
	 * @param String of Date
	 * @param Specified day to add
	 * @return String of the date
	 * @throws Exception
	 */
	public static String getDatePlusDayStr(String dateStr, int plusDay)
			throws Exception {
		Date date = getDatePlusDay(dateStr, plusDay);
		return getStringFromDate(DATE_YYYYMMDD_HYPEN, date);
	}

	/**
	 * Converts the string of date with format (yyyy-MM-dd hh:mm:ss) to Date 
	 * 
	 * @param String of date with format
	 * @return Date converted
	 * @throws Exception
	 */
	public static Date getDateFromString(String dateStr) throws Exception {
		SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_YYYYMMDD_HYPEN
				+ TIME_HHMMSS);
		return dateFormat.parse(dateStr);
	}

	/**
	 * Converts the string of date with format (yyyy-MM-dd) to Date 
	 * 
	 * @param String of date with format
	 * @return Date converted
	 * @throws Exception
	 */
	public static Date getCurrentMinDate() throws Exception {
		SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_YYYYMMDD_HYPEN);
		Date date = new Date();
		return dateFormat.parse(dateFormat.format(date) + YJACommonConst.ZERO_HHMMSS);
	}

	/**
	 * Returns the max date of the current date.
	 * 
	 * @return The max date
	 * @throws Exception
	 */
	public static Date getCurrentMaxDate() throws Exception {
		SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_YYYYMMDD_HYPEN);
		Date date = new Date();
		return dateFormat.parse(dateFormat.format(date) + YJACommonConst.LAST_HHMMSS);
	}
}

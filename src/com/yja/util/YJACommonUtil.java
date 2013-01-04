package com.yja.util;

/**
 * This class provides the general utilities.
 * 
 * @author YOUNGJAE KIM
 *
 */
public class YJACommonUtil {
	
	/**
	 * <p>Performs to convert integer to string with zero.</p>
	 * <p>Zeros are filled at the beginning of the string as many as the specified size.</p>
	 * 
	 * @param Size to fill zero
	 * @param Integer value converting
	 * @return String with zero
	 * @throws Exception
	 */
	public static String getZeroFillString(int size, int value) throws Exception {		
		String zeroFillStr = String.valueOf(value);		
		for(int i = size; i > String.valueOf(value).length(); i--) {			
			zeroFillStr = "0" + zeroFillStr;
		}		
		return zeroFillStr;
	}
	
	/**
	 * Converts double value to string.
	 * 
	 * @param Double value converting
	 * @return String converted
	 * @throws Exception
	 */
	public static String getStrFromDouble(double value) throws Exception {
		return String.format("%.2f", value);
	}
}

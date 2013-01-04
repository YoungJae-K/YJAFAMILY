package com.yja.vo;

/**
 * The VO class for storing the key and value of Master.
 * (For reservation and service type.)
 * 
 * @author YOUNGJAE KIM
 *
 */
public class YJASelectTagVO {

	private String key;  
	private String value;
	
	public YJASelectTagVO(String key, String value) {
		this.key = key;
		this.value = value;
	}
	
	/**
	 * @return the key
	 */
	public String getKey() {
		return key;
	}
	/**
	 * @param key the key to set
	 */
	public void setKey(String key) {
		this.key = key;
	}
	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}
	/**
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	} 
	
	
}

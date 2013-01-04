package com.yja.action.model;

/**
 * The Model class for the screen, which is related to login. 
 * (Login screen, Screen to add new user)
 * 
 * @author YOUNGJAE KIM
 * 
 */
public class YJAS008ActionModel extends YJASCommonActionModel {

	private static final long serialVersionUID = -1706882909723153659L;

	private String userPassword;
	private String reUserPassword;

	/**
	 * @return the userPassword
	 */
	public String getUserPassword() {
		return userPassword;
	}

	/**
	 * @param userPassword
	 *            the userPassword to set
	 */
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	/**
	 * @return the reUserPassword
	 */
	public String getReUserPassword() {
		return reUserPassword;
	}

	/**
	 * @param reUserPassword
	 *            the reUserPassword to set
	 */
	public void setReUserPassword(String reUserPassword) {
		this.reUserPassword = reUserPassword;
	}

}

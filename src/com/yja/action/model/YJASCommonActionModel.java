package com.yja.action.model;

/**
 * The most common Model class, which is used by all the screens commonly 
 * 
 * @author YOUNGJAE KIM
 * 
 */
public class YJASCommonActionModel implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private boolean isDisplayMenu = true;
	private boolean isLogin = false;
	private boolean isLoginBtn = true;
	private String userId;
	private String userFName = "";
	private String userLName = "";
	private String userAddr;
	private String userCity;
	private String userProv;
	private String userPost;
	private String userFullName;
	private String previousScreen;
	private String currentScreen;
	private int campMapId;

	/**
	 * @return the campMapId
	 */
	public int getCampMapId() {
		return campMapId;
	}

	/**
	 * @param campMapId
	 *            the campMapId to set
	 */
	public void setCampMapId(int campMapId) {
		this.campMapId = campMapId;
	}

	/**
	 * @return the currentScreen
	 */
	public String getCurrentScreen() {
		return currentScreen;
	}

	/**
	 * @param currentScreen
	 *            the currentScreen to set
	 */
	public void setCurrentScreen(String currentScreen) {
		this.currentScreen = currentScreen;
	}

	/**
	 * @return the isLoginBtn
	 */
	public boolean isLoginBtn() {
		return isLoginBtn;
	}

	/**
	 * @param isLoginBtn
	 *            the isLoginBtn to set
	 */
	public void setLoginBtn(boolean isLoginBtn) {
		this.isLoginBtn = isLoginBtn;
	}

	/**
	 * @return the userFullName
	 */
	public String getUserFullName() {

		if (userFullName == null || "".equals(userFullName)) {
			return userFName + " " + userLName;
		}
		return userFullName;
	}

	/**
	 * @param userFullName
	 *            the userFullName to set
	 */
	public void setUserFullName(String userFullName) {
		this.userFullName = userFullName;
	}

	/**
	 * @return the previousScreen
	 */
	public String getPreviousScreen() {
		return previousScreen;
	}

	/**
	 * @param previousScreen
	 *            the previousScreen to set
	 */
	public void setPreviousScreen(String previousScreen) {
		this.previousScreen = previousScreen;
	}

	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId
	 *            the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * @return the userFName
	 */
	public String getUserFName() {
		return userFName;
	}

	/**
	 * @param userFName
	 *            the userFName to set
	 */
	public void setUserFName(String userFName) {
		this.userFName = userFName;
	}

	/**
	 * @return the userLName
	 */
	public String getUserLName() {
		return userLName;
	}

	/**
	 * @param userLName
	 *            the userLName to set
	 */
	public void setUserLName(String userLName) {
		this.userLName = userLName;
	}

	/**
	 * @return the isDisplayMenu
	 */
	public boolean isDisplayMenu() {
		return isDisplayMenu;
	}

	/**
	 * @param isDisplayMenu
	 *            the isDisplayMenu to set
	 */
	public void setDisplayMenu(boolean isDisplayMenu) {
		this.isDisplayMenu = isDisplayMenu;
	}

	/**
	 * @return the isLogin
	 */
	public boolean isLogin() {
		return isLogin;
	}

	/**
	 * @param isLogin
	 *            the isLogin to set
	 */
	public void setLogin(boolean isLogin) {
		this.isLogin = isLogin;
	}

	/**
	 * @return the userAddr
	 */
	public String getUserAddr() {
		return userAddr;
	}

	/**
	 * @param userAddr
	 *            the userAddr to set
	 */
	public void setUserAddr(String userAddr) {
		this.userAddr = userAddr;
	}

	/**
	 * @return the userCity
	 */
	public String getUserCity() {
		return userCity;
	}

	/**
	 * @param userCity
	 *            the userCity to set
	 */
	public void setUserCity(String userCity) {
		this.userCity = userCity;
	}

	/**
	 * @return the userProv
	 */
	public String getUserProv() {
		return userProv;
	}

	/**
	 * @param userProv
	 *            the userProv to set
	 */
	public void setUserProv(String userProv) {
		this.userProv = userProv;
	}

	/**
	 * @return the userPost
	 */
	public String getUserPost() {
		return userPost;
	}

	/**
	 * @param userPost
	 *            the userPost to set
	 */
	public void setUserPost(String userPost) {
		this.userPost = userPost;
	}

}

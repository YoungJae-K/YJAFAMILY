package com.yja.dao.model;

import java.io.Serializable;
import java.util.Date;

/**
 * @author YOUNGJAE KIM
 * 
 */
public class UserInfo implements Serializable {

	private static final long serialVersionUID = 3579871098180734616L;
	private String userId;
	private String userPassword;
	private String userFName;
	private String userLName;
	private String userAddr;
	private String userCity;
	private String userProv;
	private String userPost;
	private String deleteFlg;
	private String userAuthority;
	private Date insertDate;
	private Date updateDate;

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

	/**
	 * @return the deleteFlg
	 */
	public String getDeleteFlg() {
		return deleteFlg;
	}

	/**
	 * @param deleteFlg
	 *            the deleteFlg to set
	 */
	public void setDeleteFlg(String deleteFlg) {
		this.deleteFlg = deleteFlg;
	}

	/**
	 * @return the userAuthority
	 */
	public String getUserAuthority() {
		return userAuthority;
	}

	/**
	 * @param userAuthority
	 *            the userAuthority to set
	 */
	public void setUserAuthority(String userAuthority) {
		this.userAuthority = userAuthority;
	}

	/**
	 * @return the insertDate
	 */
	public Date getInsertDate() {
		return insertDate;
	}

	/**
	 * @param insertDate
	 *            the insertDate to set
	 */
	public void setInsertDate(Date insertDate) {
		this.insertDate = insertDate;
	}

	/**
	 * @return the updateDate
	 */
	public Date getUpdateDate() {
		return updateDate;
	}

	/**
	 * @param updateDate
	 *            the updateDate to set
	 */
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

}

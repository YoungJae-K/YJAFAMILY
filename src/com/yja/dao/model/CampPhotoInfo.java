package com.yja.dao.model;

import java.io.Serializable;
import java.util.Date;

public class CampPhotoInfo implements Serializable {

	private static final long serialVersionUID = 8269399574507065160L;
	private int campPhotId;
	private int campMapID;
	private int siteNo;
	private String campPhotoImage;
	private Date insertDate;
	private Date updateDate;

	/**
	 * @return the campMapID
	 */
	public int getCampMapID() {
		return campMapID;
	}

	/**
	 * @param campMapID
	 *            the campMapID to set
	 */
	public void setCampMapID(int campMapID) {
		this.campMapID = campMapID;
	}

	/**
	 * @return the campPhotoImage
	 */
	public String getCampPhotoImage() {
		return campPhotoImage;
	}

	/**
	 * @param campPhotoImage
	 *            the campPhotoImage to set
	 */
	public void setCampPhotoImage(String campPhotoImage) {
		this.campPhotoImage = campPhotoImage;
	}

	/**
	 * @return the campPhotId
	 */
	public int getCampPhotId() {
		return campPhotId;
	}

	/**
	 * @param campPhotId
	 *            the campPhotId to set
	 */
	public void setCampPhotId(int campPhotId) {
		this.campPhotId = campPhotId;
	}

	/**
	 * @return the siteNo
	 */
	public int getSiteNo() {
		return siteNo;
	}

	/**
	 * @param siteNo
	 *            the siteNo to set
	 */
	public void setSiteNo(int siteNo) {
		this.siteNo = siteNo;
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

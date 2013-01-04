package com.yja.dao.model;

import java.io.Serializable;
import java.util.Date;

public class CampMapInfo implements Serializable {

	private static final long serialVersionUID = -6850082622820020083L;
	private int campMapID;
	private String campImage;
	private Date insertDate;
	private Date updateDate;
	private int campUseFlg;

	/**
	 * @return the campMapID
	 */
	public int getCampMapID() {
		return campMapID;
	}

	/**
	 * @return the campUseFlg
	 */
	public int getCampUseFlg() {
		return campUseFlg;
	}

	/**
	 * @param campUseFlg
	 *            the campUseFlg to set
	 */
	public void setCampUseFlg(int campUseFlg) {
		this.campUseFlg = campUseFlg;
	}

	/**
	 * @param campMapID
	 *            the campMapID to set
	 */
	public void setCampMapID(int campMapID) {
		this.campMapID = campMapID;
	}

	/**
	 * @return the campImage
	 */
	public String getCampImage() {
		return campImage;
	}

	/**
	 * @param campImage
	 *            the campImage to set
	 */
	public void setCampImage(String campImage) {
		this.campImage = campImage;
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

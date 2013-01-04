package com.yja.dao.model;

import java.io.Serializable;
import java.util.Date;

public class GalleryPoto implements Serializable {

	private static final long serialVersionUID = -4200639771558707730L;
	private int galleryPhotoId;
	private String galleryPhotoName;
	private Date insertDate;
	private Date updateDate;

	/**
	 * @return the galleryPhotoId
	 */
	public int getGalleryPhotoId() {
		return galleryPhotoId;
	}

	/**
	 * @param galleryPhotoId
	 *            the galleryPhotoId to set
	 */
	public void setGalleryPhotoId(int galleryPhotoId) {
		this.galleryPhotoId = galleryPhotoId;
	}

	/**
	 * @return the galleryPhotoName
	 */
	public String getGalleryPhotoName() {
		return galleryPhotoName;
	}

	/**
	 * @param galleryPhotoName
	 *            the galleryPhotoName to set
	 */
	public void setGalleryPhotoName(String galleryPhotoName) {
		this.galleryPhotoName = galleryPhotoName;
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

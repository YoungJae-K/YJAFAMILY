package com.yja.vo;

/**
 * The VO class for storing the images, which are BLOB type.
 * 
 * @author YOUNGJAE KIM
 *
 */
public class YJABlobImageVO {
	private byte[] imageSmInByte;
	private byte[] imagebgInByte;
	private int imageId;
	private int siteNo;

	/**
	 * @return the imageSmInByte
	 */
	public byte[] getImageSmInByte() {
		return imageSmInByte;
	}

	/**
	 * @param imageSmInByte
	 *            the imageSmInByte to set
	 */
	public void setImageSmInByte(byte[] imageSmInByte) {
		this.imageSmInByte = imageSmInByte;
	}

	/**
	 * @return the imagebgInByte
	 */
	public byte[] getImagebgInByte() {
		return imagebgInByte;
	}

	/**
	 * @param imagebgInByte
	 *            the imagebgInByte to set
	 */
	public void setImagebgInByte(byte[] imagebgInByte) {
		this.imagebgInByte = imagebgInByte;
	}

	/**
	 * @return the imageId
	 */
	public int getImageId() {
		return imageId;
	}

	/**
	 * @param imageId
	 *            the imageId to set
	 */
	public void setImageId(int imageId) {
		this.imageId = imageId;
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

}

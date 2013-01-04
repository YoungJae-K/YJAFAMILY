package com.yja.vo;

/**
 * The VO class for storing the location information of camp site.
 * 
 * @author YOUNGJAE KIM
 *
 */
public class YJACampSiteLocationInfoVO {
	private int siteNo;
	private int siteLeft;
	private int siteTop;

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
	 * @return the siteLeft
	 */
	public int getSiteLeft() {
		return siteLeft;
	}

	/**
	 * @param siteLeft
	 *            the siteLeft to set
	 */
	public void setSiteLeft(int siteLeft) {
		this.siteLeft = siteLeft;
	}

	/**
	 * @return the siteTop
	 */
	public int getSiteTop() {
		return siteTop;
	}

	/**
	 * @param siteTop
	 *            the siteTop to set
	 */
	public void setSiteTop(int siteTop) {
		this.siteTop = siteTop;
	}

}

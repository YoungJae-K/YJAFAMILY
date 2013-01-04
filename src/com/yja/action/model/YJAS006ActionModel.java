package com.yja.action.model;

/**
 * The Model class for the screen to send email to administrator.
 * 
 * @author YOUNGJAE KIM
 * 
 */
public class YJAS006ActionModel extends YJASCommonActionModel {

	private static final long serialVersionUID = -6789323300807762360L;
	private String comments;

	/**
	 * @return the comments
	 */
	public String getComments() {
		return comments;
	}

	/**
	 * @param comments
	 *            the comments to set
	 */
	public void setComments(String comments) {
		this.comments = comments;
	}

}

package com.yja.action.model;

import java.util.ArrayList;

/**
 * The Model class for the gallery screen.
 * 
 * @author YOUNGJAE KIM
 * 
 */
public class YJAS002ActionModel extends YJASCommonActionModel {

	private static final long serialVersionUID = 6960867163111824748L;
	private ArrayList<String> imageFullPathList;

	/**
	 * @return the imageFullPathList
	 */
	public ArrayList<String> getImageFullPathList() {
		return imageFullPathList;
	}

	/**
	 * @param imageFullPathList
	 *            the imageFullPathList to set
	 */
	public void setImageFullPathList(ArrayList<String> imageFullPathList) {
		this.imageFullPathList = imageFullPathList;
	}

}

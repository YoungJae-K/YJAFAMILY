package com.yja.action.image;

import java.util.List;
import java.util.Map;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.yja.constant.YJACommonConst;

/**
 * <p>
 *      This class provides implementation for displaying the images, 
 *      which is BLOB type, on the screen.
 * </p>
 * <p>Not using in this stage</p>
 * 
 * @author YOUNGJAE KIM
 *
 */
public class YJADisplayImgAction extends ActionSupport implements YJACommonConst{
	
	private static final long serialVersionUID = -3792517481381241367L;
	private String imageId;
	private String mapKey;	
	private String sizeType;	
	
	/**
	 * @return the imageId
	 */
	public String getImageId() {
		return imageId;
	}

	/**
	 * @return the mapKey
	 */
	public String getMapKey() {
		return mapKey;
	}

	/**
	 * @param mapKey the mapKey to set
	 */
	public void setMapKey(String mapKey) {
		this.mapKey = mapKey;
	}

	/**
	 * @return the sizeType
	 */
	public String getSizeType() {
		return sizeType;
	}

	/**
	 * @param sizeType the sizeType to set
	 */
	public void setSizeType(String sizeType) {
		this.sizeType = sizeType;
	}

	/**
	 * 
	 * @param imageId
	 */
	public void setImageId(String imageId) {
		this.imageId = imageId;
	} 
	
	/**
	 * @return the imageInByte
	 */
	@SuppressWarnings("unchecked")
	public byte[] getImageInByte() {
		
		Map<String, Object> session = ActionContext.getContext().getSession();
		byte[] imageByte = null;		
		
		if(IMAGE_CAMP_MAP.equals(imageId)) {
			Map<String, byte[]> imageByteMap = (Map<String, byte[]>)session.get(SESSION_CAMP_MAP_BYTE);			
			imageByte = imageByteMap.get(this.mapKey);
		} else {
			Map<String, List<byte[]>> imageByteMap = (Map<String,  List<byte[]>>)session.get(SESSION_SITE_PHOTO_BYTE);
			
			if("SM".equals(this.sizeType)) {
				imageByte = imageByteMap.get(this.mapKey).get(0);
			} else {
				imageByte = imageByteMap.get(this.mapKey).get(1);
			}			
		}		
		
		return imageByte;
	}	
	
	public String execute() throws Exception {	
		return SUCCESS;
	}	
}

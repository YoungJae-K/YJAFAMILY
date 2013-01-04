package com.yja.action.image;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.Result;

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
public class YJAImageBytesResult implements Result {

	private static final long serialVersionUID = -7642527708576370511L;

	@Override
	public void execute(ActionInvocation invocation) throws Exception {
		YJADisplayImgAction action = (YJADisplayImgAction) invocation.getAction();
		HttpServletResponse response = ServletActionContext.getResponse(); 
		response.setContentType("image/png");
		response.getOutputStream().write(action.getImageInByte());
		response.getOutputStream().flush();
	}

}

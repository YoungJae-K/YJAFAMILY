package com.yja.exception;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.ActionSupport;
import com.yja.constant.YJACommonConst;

/**
 * <p>This class provides the common implementations for YJAFamily exception</p>
 * <p>This class is called when the exception happens.</p>
 * <p>Writing the error logs.</p>
 * <p>Forwarding the error screen.</p>
 * 
 * @author YOUNGJAE KIM
 *
 */
public class YJAExceptionProcessor extends ActionSupport implements YJACommonConst {	
	private static final long serialVersionUID = -3474004446267967874L;
	private Exception exception;
	private static final Logger logger = Logger.getLogger(YJAExceptionProcessor.class);
	
	/*
	 * (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
    @Override
    public String execute() {
    	
    	//Creating error message.
    	String errMessage = "[" + this.exception.getClass() + "]";    	
    	if(this.exception.getMessage() != null && !"".equals(this.exception.getMessage())) {
    		errMessage += "  " + this.exception.getMessage();
    	}
    	
    	//Print out error log.
        logger.error(errMessage, this.exception);
        return FORWARD_ERROR;
    }
    
    public void setException(Exception exceptionHolder) {
        this.exception = exceptionHolder;
    }

    public Exception getException() {
        return exception;
    }
}

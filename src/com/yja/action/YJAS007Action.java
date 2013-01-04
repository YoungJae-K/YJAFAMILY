package com.yja.action;

import org.springframework.beans.factory.annotation.Qualifier;
import com.yja.action.model.YJAS008ActionModel;
import com.yja.service.AbsYJACommonService;

/**
 * This class provides implementation for the login screen.
 * 
 * @author YOUNGJAE KIM
 *
 */
public class YJAS007Action extends AbsYJACommonAction {

	private static final long serialVersionUID = 1L;
	
	public YJAS007Action() throws Exception {
		this.actionModel = new YJAS008ActionModel();
	}

	/*
	 * (non-Javadoc)
	 * @see com.yja.action.AbsYJACommonAction#setYjaService(com.yja.service.AbsYJACommonService)
	 */
	@Override
	@Qualifier("YJAS007Service")
	public void setYjaService(AbsYJACommonService yjaService) throws Exception {
		this.setService(yjaService);
	}	
	
	/* (non-Javadoc)
	 * @see com.yja.action.AbsYJACommonAction#initExecute()
	 */
	@Override
	public String initExecute() throws Exception {	
		return FORWARD_SUCCESS;
	}

	/**
	 * The operation to perform when the button [login] is pressed.
	 * 
	 * @return Forward string
	 * @throws Exception
	 */
	public String loginExecute() throws Exception {		
		String actionError = (String)yjaService.check(EXECUTE_FLG_LOGIN);		
		if(actionError == null) {
			return FORWARD_SUCCESS;
		} else {
			addActionError(getText(actionError));
			return FORWARD_INPUT;	
		}
	}	

	/**
	 * The operation to perform when the button [logout] is pressed.
	 * 
	 * @return Forward string
	 * @throws Exception
	 */
	public String logoutExecute() throws Exception {
		yjaService.modify(EXECUTE_FLG_LOGOUT);
		return FORWARD_SUCCESS;
	}
}

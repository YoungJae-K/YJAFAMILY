package com.yja.action;

import org.springframework.beans.factory.annotation.Qualifier;
import com.yja.action.model.YJAS006ActionModel;
import com.yja.service.AbsYJACommonService;

/**
 * <p>Contact Us</p>
 * <p>This class provides implementation for the screen to send email to administrator.</p>
 * 
 * @author YOUNGJAE KIM
 * 
 */
public class YJAS006Action extends AbsYJACommonAction {

	private static final long serialVersionUID = 2350235955543837699L;

	public YJAS006Action() throws Exception {
		this.actionModel = new YJAS006ActionModel();
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.yja.action.AbsYJACommonAction#setYjaService(com.yja.service.AbsYJACommonService)
	 */
	@Override
	@Qualifier("YJAS006Service")
	public void setYjaService(AbsYJACommonService yjaService) throws Exception {
		this.setService(yjaService);
	}		
	
	/* (non-Javadoc)
	 * @see com.yja.action.AbsYJACommonAction#initExecute()
	 */
	@Override
	public String initExecute() throws Exception {		
		yjaService.removeSessionInfo();
		return FORWARD_SUCCESS;
	}

	/**
	 * The operation to perform when the button [Send] is pressed.
	 * 
	 * @return Forward string
	 * @throws Exception
	 */
	public String sendExecute() throws Exception {		
		yjaService.modify(EXECUTE_FLG_EMAIL);
		return FORWARD_SUCCESS;
	}	


	/**
	 * The operation to perform when the button [Login] is pressed.
	 * 
	 * @return Forward string
	 * @throws Exception
	 */
	public String goLoginExecute() throws Exception {		
		yjaService.setInfoBeforeLogin();
		return FORWARD_SUCCESS;
	}

	/**
	 * The operation to perform when the screen is come back from another screen. 
	 * 
	 * @return Forward string
	 * @throws Exception
	 */
	public String backInitExecute() throws Exception {		
		//Obtains user information from session, then sets it to Model.
		yjaService.setUserInfoToModel(actionModel);
		return FORWARD_SUCCESS;
	}
	

}

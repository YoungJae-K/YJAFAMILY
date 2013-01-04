package com.yja.action;

import org.springframework.beans.factory.annotation.Qualifier;
import com.yja.action.model.YJAS004ActionModel;
import com.yja.service.AbsYJACommonService;

/**
 * This class provides implementation for the screen to confirm the reservation.
 * 
 * @author YOUNGJAE KIM
 *
 */
public class YJAS004Action extends AbsYJACommonAction {
	
	private static final long serialVersionUID = -7610913922691188936L;

	public YJAS004Action() throws Exception {		
		this.actionModel = new YJAS004ActionModel();
	}	

	/*
	 * (non-Javadoc)
	 * @see com.yja.action.AbsYJACommonAction#setYjaService(com.yja.service.AbsYJACommonService)
	 */
	@Override
	@Qualifier("YJAS004Service")
	public void setYjaService(AbsYJACommonService yjaService) throws Exception {
		this.setService(yjaService);
	}	
	
	/* (non-Javadoc)
	 * @see com.yja.action.AbsYJACommonAction#initExcute()
	 */
	@Override
	public String initExecute() throws Exception {		
		yjaService.view(EXECUTE_FLG_INIT);		
		return FORWARD_SUCCESS;
	}
	
	/**
	 * The operation to perform when the button [confirm] is pressed.
	 * 
	 * @return Forward string
	 * @throws Exception
	 */
	public String confirmExecute() throws Exception {		
		//Checking if camp sites entered was already reserved or not.
		yjaService.check(EXECUTE_FLG_INSERT);
		yjaService.modify(EXECUTE_FLG_INSERT);		
		return FORWARD_SUCCESS;
	}

	/**
	 * The operation to perform when the button [back] is pressed.
	 * 
	 * @return Forward string
	 * @throws Exception
	 */
	public String backExecute() throws Exception {				
		return FORWARD_SUCCESS;
	}

	/**
	 * The operation to perform when the button [login] is pressed.
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
		yjaService.view(EXECUTE_FLG_BACK_INIT);
		return FORWARD_SUCCESS;
	}
}

package com.yja.action;

import org.springframework.beans.factory.annotation.Qualifier;
import com.yja.action.model.YJAS005ActionModel;
import com.yja.service.AbsYJACommonService;

/**
 * This class provides implementation for the screen to display the list of the reservation,
 * and remove the reservation information.
 * 
 * @author YOUNGJAE KIM
 *
 */
public class YJAS005Action extends AbsYJACommonAction {

	private static final long serialVersionUID = -6181336721804417022L;
	
	public YJAS005Action() throws Exception {		
		this.actionModel = new YJAS005ActionModel();
	}

	/*
	 * (non-Javadoc)
	 * @see com.yja.action.AbsYJACommonAction#setYjaService(com.yja.service.AbsYJACommonService)
	 */
	@Override
	@Qualifier("YJAS005Service")
	public void setYjaService(AbsYJACommonService yjaService) throws Exception {
		this.setService(yjaService);
	}	
	
	/* (non-Javadoc)
	 * @see com.yja.action.AbsYJACommonAction#initExecute()
	 */
	@Override
	public String initExecute() throws Exception {		
		yjaService.removeSessionInfo();
		
		//If there is no error
		if(yjaService.check(EXECUTE_FLG_INPUT_CHECK) == null) {
			yjaService.view(EXECUTE_FLG_INIT);
		}
		
		return FORWARD_SUCCESS;
	}
	
	/**
	 * The operation to perform when the button [Delete] is pressed.
	 * 
	 * @return Forward string
	 * @throws Exception
	 */
	public String cancelExecute() throws Exception {
		yjaService.modify(EXECUTE_FLG_DELETE);	
		yjaService.view(EXECUTE_FLG_SEARCH);
		return FORWARD_SUCCESS;
	}

	/**
	 * The operation to perform when the button [Search] is pressed.
	 * 
	 * @return Forward string
	 * @throws Exception
	 */
	public String searchExecute() throws Exception {
		String errorId = (String)yjaService.check(EXECUTE_FLG_INPUT_CHECK);
		if( errorId == null) {
			yjaService.view(EXECUTE_FLG_SEARCH);
		} else {
			addActionError(getText(errorId));		
		}
		
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
		yjaService.view(EXECUTE_FLG_BACK_INIT);
		return FORWARD_SUCCESS;
	}
	
}

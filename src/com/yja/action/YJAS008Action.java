package com.yja.action;

import org.springframework.beans.factory.annotation.Qualifier;
import com.yja.action.model.YJAS008ActionModel;
import com.yja.service.AbsYJACommonService;

/**
 * This class provides implementation for the screen to add new user information.
 * 
 * @author YOUNGJAE KIM
 *
 */
public class YJAS008Action extends AbsYJACommonAction {
	
	private static final long serialVersionUID = 1L;
	
	public YJAS008Action() throws Exception {
		this.actionModel = new YJAS008ActionModel();
	}

	@Override
	@Qualifier("YJAS008Service")
	public void setYjaService(AbsYJACommonService yjaService) throws Exception {
		this.setService(yjaService);
	}	
	
	/* (non-Javadoc)
	 * @see com.yja.action.AbsYJACommonAction#execute()
	 */
	@Override
	public String initExecute() throws Exception {		
		return FORWARD_SUCCESS;
	}


	/**
	 * The operation to perform when the button [register] is pressed.
	 * 
	 * @return Forward string
	 * @throws Exception
	 */
	public String registerExecute() throws Exception {
		
		//Checking userId again
		String checkMessage = (String)yjaService.check(EXECUTE_FLG_USERID_CHECK);
		
		if(MESSAGE_USER_NO_AVAILABLE.equals(checkMessage)) {
			addActionMessage(getText(checkMessage));
			return FORWARD_INPUT;
		}
		
		yjaService.modify(EXECUTE_FLG_INSERT);		
		return FORWARD_SUCCESS;
	}
	

	/**
	 * The operation to perform when the button [check] is pressed.
	 * 
	 * @return Forward string
	 * @throws Exception
	 */
	public String userIdCheckExecute() throws Exception {			
		addActionMessage(getText((String)yjaService.check(EXECUTE_FLG_USERID_CHECK)));		
		return FORWARD_INPUT;
	}
}

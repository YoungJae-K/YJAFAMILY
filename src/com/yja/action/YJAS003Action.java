package com.yja.action;

import org.springframework.beans.factory.annotation.Qualifier;
import com.yja.action.model.YJAS003ActionModel;
import com.yja.service.AbsYJACommonService;

/**
 * This class provides implementation for the screen of new reservation of camp sites.
 * 
 * @author YOUNGJAE KIM
 *
 */
public class YJAS003Action extends AbsYJACommonAction {
	
	private static final long serialVersionUID = 3243241137341057423L;

	public YJAS003Action() throws Exception {		
		this.actionModel = new YJAS003ActionModel();
	}

	/*
	 * (non-Javadoc)
	 * @see com.yja.action.AbsYJACommonAction#setYjaService(com.yja.service.AbsYJACommonService)
	 */
	@Override
	@Qualifier("YJAS003Service")
	public void setYjaService(AbsYJACommonService yjaService) throws Exception {
		this.setService(yjaService);
	}	
	
	/* (non-Javadoc)
	 * @see com.yja.action.AbsYJACommonAction#InitExcute()
	 */
	@Override
	public String initExecute() throws Exception {		
		//Remove the unnecessary session information
		//Uses super view()
		yjaService.removeSessionInfo();		
		yjaService.view(EXECUTE_FLG_INIT);
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

	/**
	 * The operation to perform when the button [search] is pressed. 
	 * 
	 * @return Forward string
	 * @throws Exception
	 */
	public String searchExecute() throws Exception {
		yjaService.view(EXECUTE_FLG_SEARCH);		
		return FORWARD_SUCCESS;
	}

	/**
	 * <p>The operation to perform when the button [x] is pressed.</p>
	 * <p>Deletes a record selected</p> 
	 * 
	 * @return Forward string
	 * @throws Exception
	 */
	public String deleteExecute() throws Exception {	
		yjaService.modify(EXECUTE_FLG_DELETE);		
		return FORWARD_SUCCESS;
	}

	/**
	 * <p>The operation to perform when the button [DeleteAll] is pressed.</p>
	 * <p>Deletes all the records in session</p> 
	 * 
	 * @return Forward string
	 * @throws Exception
	 */
	public String deleteAllExecute() throws Exception {			
		yjaService.modify(EXECUTE_FLG_DELETE_ALL);		
		return FORWARD_SUCCESS;
	}

	/**
	 * The operation to perform when the button [detail] is pressed.
	 * 
	 * @return Forward string
	 * @throws Exception
	 */
	public String detailExecute() throws Exception {
		//Needs to check if the data selected is already existing in DB or not.
		//But for the future.
		return FORWARD_SUCCESS;
	}
	
	
}

package com.yja.action;

import org.springframework.beans.factory.annotation.Qualifier;
import com.yja.action.model.YJAP001ActionModel;
import com.yja.service.AbsYJACommonService;

/**
 * This class provides implementation for the pop-up dialog action 
 * showing the information of a camp site.
 * 
 * @author YOUNGJAE KIM
 *
 */
public class YJAP001Action extends AbsYJACommonAction {

	private static final long serialVersionUID = -4013045703244628813L;
	
	public YJAP001Action() throws Exception {
		this.actionModel = new YJAP001ActionModel();
	}

	/*
	 * (non-Javadoc)
	 * @see com.yja.action.AbsYJACommonAction#setYjaService(com.yja.service.AbsYJACommonService)
	 */
	@Override
	@Qualifier("YJAP001Service")
	public void setYjaService(AbsYJACommonService yjaService) throws Exception {
		this.setService(yjaService);
	}	
	
	/* (non-Javadoc)
	 * @see com.yja.action.AbsYJACommonAction#initExecute()
	 */
	@Override
	public String initExecute() throws Exception {
		yjaService.view(EXECUTE_FLG_INIT);	
		return FORWARD_SUCCESS;
	}
	
	/**
	 * The operation to perform when the button [select] is pressed.
	 * 
	 * @return Forward string
	 * @throws Exception
	 */
	public String selectExecute() throws Exception {		
		yjaService.modify(EXECUTE_FLG_SELECT);		
		return FORWARD_SUCCESS;
	}
}

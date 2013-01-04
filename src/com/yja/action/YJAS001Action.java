package com.yja.action;

//import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Qualifier;
import com.yja.action.model.YJAS008ActionModel;
import com.yja.service.AbsYJACommonService;

/**
 * This class provides implementation for the initial screen.
 * 
 * @author YOUNGJAE KIM
 *
 */
public class YJAS001Action extends AbsYJACommonAction {
	private static final long serialVersionUID = 8439074849396587853L;

	public YJAS001Action() throws Exception {
		this.actionModel = new YJAS008ActionModel();
	}

	/*
	 * (non-Javadoc)
	 * @see com.yja.action.AbsYJACommonAction#setYjaService(com.yja.service.AbsYJACommonService)
	 */
	@Override
	@Qualifier("YJAS001Service")
	public void setYjaService(AbsYJACommonService yjaService) throws Exception {
		this.setService(yjaService);
	}	
	
	/* (non-Javadoc)
	 * @see com.yja.action.AbsYJACommonAction#execute()
	 */
	@Override
	public String initExecute() throws Exception {		
		//Remove the unnecessary session information
		yjaService.removeSessionInfo();
		yjaService.view(null);
		return FORWARD_SUCCESS;
	}
}

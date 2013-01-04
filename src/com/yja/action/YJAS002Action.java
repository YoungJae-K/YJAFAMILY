package com.yja.action;

import org.springframework.beans.factory.annotation.Qualifier;
import com.yja.action.model.YJAS002ActionModel;
import com.yja.service.AbsYJACommonService;

/**
 * This class provides implementation for the gallery screen.
 * 
 * @author YOUNGJAE KIM
 *
 */
public class YJAS002Action extends AbsYJACommonAction {
	private static final long serialVersionUID = -2037792145302722127L;

	public YJAS002Action() throws Exception {		
		this.actionModel = new YJAS002ActionModel();
	}

	/*
	 * (non-Javadoc)
	 * @see com.yja.action.AbsYJACommonAction#setYjaService(com.yja.service.AbsYJACommonService)
	 */
	@Override			
	@Qualifier("YJAS002Service")
	public void setYjaService(AbsYJACommonService yjaService) throws Exception {
		this.setService(yjaService);
	}	
	
	/* (non-Javadoc)
	 * @see com.yja.action.AbsYJACommonAction#execute()
	 */
	@Override
	public String initExecute() throws Exception {
		yjaService.view(null);		
		return FORWARD_SUCCESS;
	}

}

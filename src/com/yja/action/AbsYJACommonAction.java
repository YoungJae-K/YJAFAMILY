package com.yja.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.yja.action.model.YJASCommonActionModel;
import com.yja.constant.YJACommonConst;
import com.yja.service.AbsYJACommonService;

/**
 * <p>This class provides default implementations for the YJAFaimly Action interface.</p>
 * <p>All the action class must extend this class.</p> 
 * 
 * @author YOUNGJAE KIM
 *
 */
public abstract class AbsYJACommonAction extends ActionSupport implements
		ModelDriven<Object>, YJACommonConst {

	private static final long serialVersionUID = -4017481322720908408L;	
	
	/** Instance of Model Driven class */
	protected YJASCommonActionModel actionModel;	
	/** Instance of Spring abstract bean class */
	protected AbsYJACommonService yjaService;
	
	public Object getModel() {		
		return actionModel;
	}

	/**
	 * <p>Performs the initialization for all the pages.</p>
	 * <p>The actual performance is implemented in the abstract method initExecute().</p>
	 * 
	 *  @return Forward string
	 *  @throws Exception 
	 */
	public String execute() throws Exception {		
		//Obtains user information from session, then sets it to Model.
		this.yjaService.setUserInfoToModel(actionModel);		
		return initExecute();		
	}	
	/**
	 * Performs the initialization for the screen.
	 * 
	 * @return Forward string
	 * @throws Exception 
	 */
	public abstract String initExecute() throws Exception;	
	
	/**
	 * Sets the instance of Spring Bean class, 
	 * which is in charge of business logic for the screen.
	 * 
	 * @param yjaService
	 * @throws Exception 
	 */
	public abstract void setYjaService(AbsYJACommonService yjaService) throws Exception;
	
	/**
	 * <p>Common method</p>
	 * <p>Sets the instance of Model, which is used on the corresponding screen.</p>
	 * 
	 * @param yjaService
	 * @throws Exception 
	 */
	protected void setService(AbsYJACommonService yjaService) throws Exception {
		this.yjaService = yjaService;
		this.yjaService.setInitialInfo(actionModel);
	}
	
}

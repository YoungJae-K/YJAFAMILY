package com.yja.service;

import org.springframework.beans.factory.annotation.Qualifier;
import com.yja.action.model.YJASCommonActionModel;
import com.yja.dao.AbsYJACommonDAO;

/**
 * This class provides the business logic for the main screen of YJAFamily.
 * 
 * @author YOUNGJAE KIM
 *
 */
public class YJAS001Service extends AbsYJACommonService {
	
	private YJASCommonActionModel actionModel;	

	/*
	 * (non-Javadoc)
	 * @see com.yja.service.AbsYJACommonService#setYjaDao(com.yja.dao.AbsYJACommonDAO)
	 */
	@Override
	@Qualifier("YJAS001DAO")
	public void setYjaDao(AbsYJACommonDAO yjaDao) throws Exception {
		this.yjaDao = yjaDao;		
	}

	/*
	 * (non-Javadoc)
	 * @see com.yja.service.AbsYJACommonService#setInitialInfo(com.yja.action.model.YJASCommonActionModel, java.util.Map)
	 */
	@Override
	public void setInitialInfo(YJASCommonActionModel actionModel) throws Exception {	
		this.actionModel = actionModel;
	}

	/* (non-Javadoc)
	 * @see com.yja.service.AbsYJACommonService#view()
	 */
	@Override
	public void view(String executeFlg) throws Exception {
		// Dose not use.
	}

	/* (non-Javadoc)
	 * @see com.yja.service.AbsYJACommonService#check()
	 */
	@Override
	public Object check(String executeFlg) throws Exception {
		// Dose not use.
		return null;
	}

	/* (non-Javadoc)
	 * @see com.yja.service.AbsYJACommonService#modify(java.lang.String)
	 */
	@Override
	public void modify(String executeFlg) throws Exception {
		// Dose not use.		
	}

}

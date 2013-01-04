package com.yja.service;

import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Qualifier;
import com.yja.action.model.YJAS008ActionModel;
import com.yja.action.model.YJASCommonActionModel;
import com.yja.dao.AbsYJACommonDAO;
import com.yja.dao.model.UserInfo;

/**
 * This class provides the business logic for the login screen.
 * 
 * @author YOUNGJAE KIM
 *
 */
public class YJAS007Service extends AbsYJACommonService {

	private YJAS008ActionModel actionModel;	

	/*
	 * (non-Javadoc)
	 * @see com.yja.service.AbsYJACommonService#setYjaDao(com.yja.dao.AbsYJACommonDAO)
	 */
	@Override
	@Qualifier("YJAS007DAO")
	public void setYjaDao(AbsYJACommonDAO yjaDao) throws Exception {
		this.yjaDao = yjaDao;		
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.yja.service.AbsYJACommonService#setInitialInfo(com.yja.action.model.YJASCommonActionModel)
	 */
	@Override
	public void setInitialInfo(YJASCommonActionModel actionModel) throws Exception {
		this.actionModel = (YJAS008ActionModel)actionModel;		
	}

	/*
	 * (non-Javadoc)
	 * @see com.yja.service.AbsYJACommonService#view(java.lang.String)
	 */
	@Override
	public void view(String executeFlg) throws Exception {		
		//Do not use
	}

	/*
	 * (non-Javadoc)
	 * @see com.yja.service.AbsYJACommonService#check(java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Object check(String executeFlg) throws Exception {
		
		String actionErrStr = null;
		
		//Creates the searching conditions for the selection of database.
		HashMap<String, Object> searchingConditionMap = new HashMap<String, Object>();		
		searchingConditionMap.put(HIBERNATE_USER_ID, this.actionModel.getUserId());
		searchingConditionMap.put(HIBERNATE_USER_PASSWORD, this.actionModel.getUserPassword());
		
		List<UserInfo> userInfoList = (List<UserInfo>) yjaDao.getList(EXECUTE_FLG_USERID_CHECK, searchingConditionMap);
		
		//If no user information exists. creates error message.
		if(userInfoList == null || userInfoList.size() == 0) {
			actionErrStr = ERROR_USER_NO_EXIST;
			
		} else { //If user information exists, stores it into Session.
			UserInfo userInfo = userInfoList.get(0);			
			this.actionModel.setUserId(userInfo.getUserId());
			this.actionModel.setUserFName(userInfo.getUserFName());
			this.actionModel.setUserLName(userInfo.getUserLName());
			this.actionModel.setUserAddr(userInfo.getUserAddr());
			this.actionModel.setUserCity(userInfo.getUserCity());
			this.actionModel.setUserProv(userInfo.getUserProv());
			this.actionModel.setUserPost(userInfo.getUserPost());
			this.actionModel.setLogin(true);			
			//Store the user information to session.
			getSession().put(SESSION_USERINFO, (YJAS008ActionModel)this.actionModel);
		}				
		return actionErrStr;
	}

	/*
	 * (non-Javadoc)
	 * @see com.yja.service.AbsYJACommonService#modify(java.lang.String)
	 */
	@Override
	public void modify(String executeFlg) throws Exception {
		//logout
		getSession().remove(SESSION_USERINFO);	
	}	
}

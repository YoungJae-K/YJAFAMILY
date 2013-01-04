package com.yja.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Qualifier;
import com.yja.action.model.YJAS008ActionModel;
import com.yja.action.model.YJASCommonActionModel;
import com.yja.dao.AbsYJACommonDAO;
import com.yja.dao.model.UserInfo;

/**
 * This class provides the business logic for the screen to create new user information.
 * 
 * @author YOUNGJAE KIM
 *
 */
public class YJAS008Service extends AbsYJACommonService {

	private YJAS008ActionModel actionModel;	
	
	/*
	 * (non-Javadoc)
	 * @see com.yja.service.AbsYJACommonService#setYjaDao(com.yja.dao.AbsYJACommonDAO)
	 */
	@Override
	@Qualifier("YJAS008DAO")
	public void setYjaDao(AbsYJACommonDAO yjaDao) throws Exception {
		this.yjaDao = yjaDao;		
	}
	
	/* (non-Javadoc)
	 * @see com.yja.service.AbsYJACommonService#setInitialInfo(com.yja.action.model.YJASCommonActionModel)
	 */
	@Override
	public void setInitialInfo(YJASCommonActionModel actionModel) throws Exception {
		this.actionModel = (YJAS008ActionModel)actionModel;
	}

	/* (non-Javadoc)
	 * @see com.yja.service.AbsYJACommonService#view(java.lang.String)
	 */
	@Override
	public void view(String executeFlg) throws Exception {
		// Do not use
	}

	/* (non-Javadoc)
	 * @see com.yja.service.AbsYJACommonService#check()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Object check(String executeFlg) throws Exception {
		
		String actionErrStr = MESSAGE_USER_AVAILABLE;		
	
		//Creates the searching condition for the selection of database.
		HashMap<String, Object> searchingConditionMap = new HashMap<String, Object>();		
		searchingConditionMap.put(HIBERNATE_USER_ID, this.actionModel.getUserId());		
		List<UserInfo> userInfoList = (List<UserInfo>) yjaDao.getList(EXECUTE_FLG_USERID_CHECK, searchingConditionMap);
		
		if(userInfoList != null && userInfoList.size() != 0) {
			actionErrStr = MESSAGE_USER_NO_AVAILABLE;	
		}
		
		return actionErrStr;
	}

	/* (non-Javadoc)
	 * @see com.yja.service.AbsYJACommonService#modify(java.lang.String)
	 */
	@Override
	public void modify(String executeFlg) throws Exception {
		//Performs the insertion of new user information into Database.
		UserInfo userInfo = new UserInfo();		
		userInfo.setUserId(this.actionModel.getUserId());
		userInfo.setUserFName(this.actionModel.getUserFName());
		userInfo.setUserLName(this.actionModel.getUserLName());
		userInfo.setUserPassword(this.actionModel.getUserPassword());
		userInfo.setUserAddr(this.actionModel.getUserAddr());
		userInfo.setUserCity(this.actionModel.getUserCity());
		userInfo.setUserProv(this.actionModel.getUserProv());
		userInfo.setUserPost(this.actionModel.getUserPost());
		userInfo.setInsertDate(new Date());
		userInfo.setUpdateDate(new Date());
		userInfo.setDeleteFlg("0");
		userInfo.setUserAuthority("1");		
		yjaDao.insert(EXECUTE_USER_INSERT, userInfo);
	}
}

package com.yja.service;

import java.util.Iterator;
import java.util.Map;
import com.opensymphony.xwork2.ActionContext;
import com.yja.action.model.YJAS008ActionModel;
import com.yja.action.model.YJASCommonActionModel;
import com.yja.constant.YJACommonConst;
import com.yja.constant.YJAHibernateConst;
import com.yja.dao.AbsYJACommonDAO;

/**
 * <p>This class provides default implementations for the YJAFaimly service interface.</p>
 * <p>All the service classes, which are in charge of business logic, must extend this class.</p> 
 * 
 * @author YOUNGJAE KIM
 *
 */
public abstract class AbsYJACommonService implements YJACommonConst, YJAHibernateConst {	
	
	private Map<String, Object> session;	
	protected AbsYJACommonDAO yjaDao;	
	protected String sitePhotoPath;	
	protected String campMapPath;
	protected String galleryPhotoPath;		

	/**
	 * <p>Sets the instance of the corresponding DAO class.</p>
	 * <p>The DAO class that is defined by the XML file of Spring Bean.</p>
	 * 
	 * @param yjaDao
	 * @throws Exception
	 */
	public abstract void setYjaDao(AbsYJACommonDAO yjaDao) throws Exception;
	
	/**
	 * Performs to set the instance of ActionModel class using.
	 * 
	 * @param actionModel
	 * @throws Exception
	 */
	public abstract void setInitialInfo(YJASCommonActionModel actionModel) throws Exception;
	
	/**
	 * <p>Performs the initialization for each screen if it is necessary.</P>
	 * 
	 * @param Flag to distinguish among the different process.
	 * @throws Exception
	 */
	public abstract void view(String executeFlg) throws Exception;
	
	/**
	 * <p>Performs the validation if it is necessary.</P>
	 * 
	 * @param Flag to distinguish among the different process.
	 * @throws Exception
	 */
	public abstract Object check(String executeFlg) throws Exception;
	
	
	/**
	 * <p>Performs to modify database information if it is necessary.</P>
	 * 
	 * @param Flag to distinguish among the different process.
	 * @throws Exception
	 */
	public abstract void modify(String executeFlg) throws Exception;	
	
	/**
	 * <p>
	 * Performs to set the information on the current screen before going to login screen
	 * so that the previous value inputed can be displayed when the current screen is redisplayed.
	 * </P>
	 * <p>This method is not mandatory.</p>
	 * 
	 * @throws Exception
	 */
	public void setInfoBeforeLogin() throws Exception { };
	
	/**
	 * The common method to remove all session information except user information(login info).
	 * 
	 * @throws Exception
	 */
	public void removeSessionInfo() throws Exception {
		
		Iterator<String> keyList = getSession().keySet().iterator();
		
		while(keyList.hasNext()) {
			String sessionKey = keyList.next();			
			//Do not remove login session until logout.
			if(SESSION_USERINFO.equals(sessionKey)) {
				continue;
			}			
			System.out.println("********* Remove Session - Session key : " + sessionKey);
			getSession().remove(sessionKey);
		}
	}

	/**
	 * The common method to set the user information, 
	 * which is stored in session, into the corresponding ActionModel.
	 * 
	 * @param commonModel
	 * @throws Exception
	 */
	public void setUserInfoToModel(YJASCommonActionModel commonModel) throws Exception {		
		//Initializes.
		if(getSession().get(SESSION_USERINFO) != null) {			
			YJAS008ActionModel sessionModel = (YJAS008ActionModel)getSession().get(SESSION_USERINFO);			
			commonModel.setLogin(true);
			commonModel.setUserFName(sessionModel.getUserFName());	
			commonModel.setUserLName(sessionModel.getUserLName());	
			commonModel.setUserId(sessionModel.getUserId());	
			commonModel.setUserAddr(sessionModel.getUserAddr());	
			commonModel.setUserCity(sessionModel.getUserCity());
			commonModel.setUserPost(sessionModel.getUserPost());
			commonModel.setUserProv(sessionModel.getUserProv());
		}			
	}
	
	/**
	 * Returns the instance of Session.
	 * 
	 * @return Session
	 * @throws Exception
	 */
	protected Map<String, Object> getSession() throws Exception {		
		if(this.session == null) {
			this.session = ActionContext.getContext().getSession();
		}		
		return this.session;
	}

	/**
	 * @return the galleryPhotoPath
	 */
	public String getGalleryPhotoPath() {
		return galleryPhotoPath;
	}

	/**
	 * @param galleryPhotoPath the galleryPhotoPath to set
	 */
	public void setGalleryPhotoPath(String galleryPhotoPath) {
		this.galleryPhotoPath = galleryPhotoPath;
	}

	/**
	 * @param campMapPath the campMapPath to set
	 */
	public void setCampMapPath(String campMapPath) {
		this.campMapPath = campMapPath;
	}

	/**
	 * @param sitePhotoPath the sitePhotoPath to set
	 */
	public void setSitePhotoPath(String sitePhotoPath) {
		this.sitePhotoPath = sitePhotoPath;
	}
}

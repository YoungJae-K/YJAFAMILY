package com.yja.dao;

import java.util.List;
import org.hibernate.Session;
import com.yja.dao.model.UserInfo;

/**
 * This class provides implementation to control database for the screen to create new user information.
 * 
 * @author  YOUNGJAE KIM
 *
 */
public class YJAS008DAO extends AbsYJACommonDAO {

	/*
	 * (non-Javadoc)
	 * @see com.yja.dao.AbsYJACommonDAO#insert(java.lang.String, java.lang.Object)
	 */
	@Override
	public Object insert(String executeFlg, Object insertInfo) throws Exception {
		Session session = getSession();
		try{
			session.beginTransaction();			
			session.save(insertInfo);
		} finally {
			session.getTransaction().commit();
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * @see com.yja.dao.AbsYJACommonDAO#getList(java.lang.String, java.lang.Object)
	 */
	@Override
	public List<?> getList(String executeFlg, Object conditions) throws Exception {
		//Obtains user information.
		if(EXECUTE_FLG_USERID_CHECK.equals(executeFlg)) {
			return this.getListOptionalEq(UserInfo.class, conditions);
		}		
		return null;
	}

	/*
	 * (non-Javadoc)
	 * @see com.yja.dao.AbsYJACommonDAO#update(java.lang.String, java.lang.Object)
	 */
	@Override
	public Object update(String executeFlg, Object updateInfo) throws Exception {
		//Not using
		return null;
	}

	/*
	 * (non-Javadoc)
	 * @see com.yja.dao.AbsYJACommonDAO#delete(java.lang.String, java.lang.Object)
	 */
	@Override
	public Object delete(String executeFlg, Object deleteInfo) throws Exception {
		//Not using
		return null;
	}
}

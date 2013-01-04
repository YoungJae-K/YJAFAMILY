package com.yja.dao;

import java.util.List;
import com.yja.dao.model.SiteInfo;

/**
 * This class provides implementation to control database for the pop-up dialog.
 * 
 * @author  YOUNGJAE KIM
 *
 */
public class YJAP001DAO extends AbsYJACommonDAO {

	/*
	 * (non-Javadoc)
	 * @see com.yja.dao.AbsYJACommonDAO#insert(java.lang.String, java.lang.Object)
	 */
	@Override
	public Object insert(String executeFlg, Object insertInfo) throws Exception {
		//Not using
		return null;
	}

	/*
	 * (non-Javadoc)
	 * @see com.yja.dao.AbsYJACommonDAO#getList(java.lang.String, java.lang.Object)
	 */
	@Override
	public List<?> getList(String executeFlg, Object conditions) throws Exception {	
		return this.getListOptionalEq(SiteInfo.class, conditions);
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
